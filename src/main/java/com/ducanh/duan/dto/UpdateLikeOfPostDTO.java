package com.ducanh.duan.dto;

public class UpdateLikeOfPostDTO {
    private int postId;

    private boolean statusLike;

    public UpdateLikeOfPostDTO() {
    }

    public UpdateLikeOfPostDTO(int postId, boolean statusLike) {
        this.postId = postId;
        this.statusLike = statusLike;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public boolean isStatusLike() {
        return statusLike;
    }

    public void setStatusLike(boolean statusLike) {
        this.statusLike = statusLike;
    }
}
