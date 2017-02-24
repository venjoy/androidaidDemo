package com.venjoy.socialogin.model;

/**
 * Created by Vaibhav on 06-02-2017.
 * This is a Model Class , it will provide you the userInformation
 * e.g UserName and userEmail from the social account user will login.
 */

public class SocialProfile extends Thread{

    private String mDisplayName ;
    private String mEmailAddress ;

    public String getmDisplayName() {
        return mDisplayName;
    }

    public void setmDisplayName(String mDisplayName) {
        this.mDisplayName = mDisplayName;
    }

    public String getmEmailAddress() {
        return mEmailAddress;
    }

    public void setmEmailAddress(String mEmailAddress) {
        this.mEmailAddress = mEmailAddress;
    }
}


