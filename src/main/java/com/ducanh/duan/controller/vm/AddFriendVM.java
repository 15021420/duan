package com.ducanh.duan.controller.vm;

public class AddFriendVM {
    private int accountIdFrom;

    public AddFriendVM() {
    }

    public AddFriendVM(int accountIdFrom) {
        this.accountIdFrom = accountIdFrom;
    }

    public int getAccountIdFrom() {
        return accountIdFrom;
    }

    public void setAccountIdFrom(int accountIdFrom) {
        this.accountIdFrom = accountIdFrom;
    }
}
