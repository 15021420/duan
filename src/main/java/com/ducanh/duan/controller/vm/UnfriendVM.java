package com.ducanh.duan.controller.vm;

public class UnfriendVM {
    private int accountIdRequest;

    public UnfriendVM() {
    }

    public UnfriendVM(int accountIdRequest) {
        this.accountIdRequest = accountIdRequest;
    }

    public int getAccountIdRequest() {
        return accountIdRequest;
    }

    public void setAccountIdRequest(int accountIdRequest) {
        this.accountIdRequest = accountIdRequest;
    }
}
