package com.ducanh.duan.service;

import com.ducanh.duan.controller.vm.CreateNewPostVM;
import com.ducanh.duan.dto.GetAllPostOfUserDTO;
import com.ducanh.duan.dto.SinglePostOfUserDTO;
import com.ducanh.duan.model.Account;
import com.ducanh.duan.model.Post;
import com.ducanh.duan.model.PostImages;
import com.ducanh.duan.repository.AccountRepository;
import com.ducanh.duan.repository.PostImagesRepository;
import com.ducanh.duan.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private Logger log = LoggerFactory.getLogger(PostServiceImpl.class);

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ImageService imageService;

    @Autowired
    private PostImagesRepository postImagesRepository;

    @Override
    public Post savePost(CreateNewPostVM createNewPostVM) throws IOException {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        Account acc = accountRepository.findByUserName(userName);

        int accountId = acc.getAccountId();

        Post postCreated = new Post();
        postCreated.setAccountId(accountId);
        postCreated.setPostContent(createNewPostVM.getPostContent());
        postCreated.setCreatedAt(new Date());

        postRepository.save(postCreated);

        if (postCreated.getPostId() != 0) {
            List<Integer> listImageId =  imageService.multiImageUpload(createNewPostVM.getImageFile());

            for(int imageId : listImageId) {
                postImagesRepository.save(new PostImages(postCreated.getPostId(), imageId));
            }
        }

        return postCreated;
    }

    @Override
    public List<Post> getAllPost(int userId) {
        return null;
    }

    @Override
    public Post getOnePost(int userId, int postId) {
        return null;
    }

    @Override
    public GetAllPostOfUserDTO getPostOfUser() {
        Account acc = accountRepository.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName());

        List<Post> userPost = postRepository.findByAccountId(acc.getAccountId());
        List<SinglePostOfUserDTO> singlePostOfUserDTOS = new ArrayList<>();
        for(Post itemPost : userPost) {
            singlePostOfUserDTOS.add(new SinglePostOfUserDTO(itemPost.getCreatedAt(), itemPost.getPostContent(), null));
        }
        GetAllPostOfUserDTO getAllPostOfUserDTO = new GetAllPostOfUserDTO();
        getAllPostOfUserDTO.setPostOfUserDTOList(singlePostOfUserDTOS);
        return getAllPostOfUserDTO;
    }
}
