package com.ducanh.duan.service;

import com.ducanh.duan.controller.vm.CreateCommentOfPostVM;
import com.ducanh.duan.controller.vm.CreateNewPostVM;
import com.ducanh.duan.controller.vm.UpdateLikeOfPostVM;
import com.ducanh.duan.dto.GetAllPostOfUserDTO;
import com.ducanh.duan.dto.SinglePostOfUserDTO;
import com.ducanh.duan.model.*;
import com.ducanh.duan.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private ImagesRepository imagesRepository;

    @Autowired
    private PostImagesRepository postImagesRepository;

    @Autowired
    private CommentsRepository commentsRepository;

    @Autowired
    private UserLikeRepository likeRepository;

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

        if (postCreated.getPostId() != 0 && createNewPostVM.getImageFile().length != 0 && !createNewPostVM.getImageFile()[0].isEmpty()) {
            List<Integer> listImageId =  imageService.multiImageUpload(createNewPostVM.getImageFile());

            for(int imageId : listImageId) {
                postImagesRepository.save(new PostImages(imageId, postCreated.getPostId()));
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
            List<String> dataImage = new ArrayList<>();

            List<Object[]> listImageLocation = imagesRepository.findListImageLocationByPostId(itemPost.getPostId());

            for(Object[] dataLocation: listImageLocation) {
                dataImage.add("http://localhost:8080/images/get/" + String.valueOf(dataLocation[0]));
            }

            List<Comments> commentsList = commentsRepository.findByPostId(itemPost.getPostId());

            UserLike likedPost = likeRepository.findByAccountIdAndPostId(acc.getAccountId(), itemPost.getPostId());

            int countLikedPost = likeRepository.countByPostId(itemPost.getPostId());

            singlePostOfUserDTOS.add(new SinglePostOfUserDTO(itemPost.getPostId(), itemPost.getCreatedAt(), itemPost.getPostContent(), commentsList, dataImage, likedPost != null, countLikedPost));
        }
        GetAllPostOfUserDTO getAllPostOfUserDTO = new GetAllPostOfUserDTO();
        getAllPostOfUserDTO.setPostOfUserDTOList(singlePostOfUserDTOS);

        for(SinglePostOfUserDTO ss : getAllPostOfUserDTO.getPostOfUserDTOList()) {
            System.out.println(ss.getUrlImage().size());
        }

        return getAllPostOfUserDTO;
    }

    @Override
    public ResponseEntity<Object> createCommentOfPost(CreateCommentOfPostVM createCommentOfPostVM) {
        try {
            Account acc = accountRepository.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName());

            Comments commentsInsert = new Comments();
            commentsInsert.setAccountId(acc.getAccountId());
            commentsInsert.setContent(createCommentOfPostVM.getCommentContent());
            commentsInsert.setPostId(createCommentOfPostVM.getPostId());
            commentsInsert.setCreatedAt(new Date());
            commentsInsert.setUsername(acc.getUserName());

            commentsRepository.save(commentsInsert);

            return new ResponseEntity<>("success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("failed", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Object> updateLikeOfPost(UpdateLikeOfPostVM updateLikeOfPostVM) {
        Account acc = accountRepository.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName());

        try {
            if (updateLikeOfPostVM.isStatusLike()) {
                UserLike userLike = new UserLike();
                userLike.setAccountId(acc.getAccountId());
                userLike.setPostId(updateLikeOfPostVM.getPostId());
                userLike.setCreatedAt(new Date());
                likeRepository.save(userLike);
            } else {
                UserLike userLikeDelete = likeRepository.findByAccountIdAndPostId(acc.getAccountId(), updateLikeOfPostVM.getPostId());
                likeRepository.delete(userLikeDelete);
            }

            return new ResponseEntity<>("success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("failed", HttpStatus.BAD_REQUEST);
        }
    }
}
