package com.ducanh.duan.controller.vm;

public class RemoveAddFriendVM {
    private int accountIdRequest;

    public RemoveAddFriendVM() {
    }

    public RemoveAddFriendVM(int accountIdRequest) {
        this.accountIdRequest = accountIdRequest;
    }

    public int getAccountIdRequest() {
        return accountIdRequest;
    }

    public void setAccountIdRequest(int accountIdRequest) {
        this.accountIdRequest = accountIdRequest;
    }
}
