package com.ducanh.duan.controller.vm;

public class CreateCommentOfPostVM {

    private int postId;

    private String commentContent;

    public CreateCommentOfPostVM() {
    }

    public CreateCommentOfPostVM(int postId, String commentContent) {
        this.postId = postId;
        this.commentContent = commentContent;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
}
