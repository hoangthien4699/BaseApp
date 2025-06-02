package com.example.baseapp.model.vos;

import com.example.baseapp.model.vos.accountuser.AccountUser;

public class GlobalInfo {
    private static AccountUser sAccountUser;

    public static AccountUser getAccountUser() {
        return sAccountUser;
    }

    public static void setAccountUser(AccountUser accountUser) {
        sAccountUser = accountUser;
    }
}
