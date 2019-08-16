package com.ducanh.duan.controller.vm;

public class UpdateLikeOfPostVM {
    private int postId;

    private boolean statusLike;

    public UpdateLikeOfPostVM() {
    }

    public UpdateLikeOfPostVM(int postId, boolean statusLike) {
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
