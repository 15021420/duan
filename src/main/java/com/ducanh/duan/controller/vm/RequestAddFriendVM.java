package com.ducanh.duan.controller.vm;

public class RequestAddFriendVM {
    private int accountIdRequest;

    public RequestAddFriendVM() {
    }

    public RequestAddFriendVM(int accountIdRequest) {
        this.accountIdRequest = accountIdRequest;
    }

    public int getAccountIdRequest() {
        return accountIdRequest;
    }

    public void setAccountIdRequest(int accountIdRequest) {
        this.accountIdRequest = accountIdRequest;
    }
}
