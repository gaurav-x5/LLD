package org.example.model;

import lombok.Getter;

@Getter
public abstract class LockerUser {
    private String userId;
    private String emailId;
    private String phoneNo;

    public LockerUser(String userId, String emailId, String phoneNo) {
        this.userId = userId;
        this.emailId = emailId;
        this.phoneNo = phoneNo;
    }
}
