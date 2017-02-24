package com.venjoy.socialogin.appinterface;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.venjoy.socialogin.model.SocialProfile;

import socialogin.venjoy.com.socialogin.R;

/**
 * Created by Vaibhav on 30-01-2017.
 * This is the Interface which will provide userProfile Information
 */

public interface SocialSite {

    /** Method will provide all the Object of class SocialProfile , which contains
        userInformation like userName and userEmail
     **/

    SocialProfile getUserProfile();

}
