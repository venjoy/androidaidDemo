package com.venjoy.socialogin.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.venjoy.socialogin.gplus.GplusPresenterImpl;
import com.venjoy.socialogin.model.SocialProfile;
import com.venjoy.socialogin.util.Constants;

import socialogin.venjoy.com.socialogin.R;

/**
 * Created by Vaibhav on 30-01-2017.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mGPlus, mFacebook, mTwitter;
    private GplusPresenterImpl objGplusPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListner();

        objGplusPresenter = new GplusPresenterImpl();
        objGplusPresenter.initGoogle(this);

    }

    // set Listner for onClick
    private void setListner() {
        mGPlus.setOnClickListener(this);
        mFacebook.setOnClickListener(this);
        mTwitter.setOnClickListener(this);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Constants.G_PLUS_REQUESTCODE && resultCode == RESULT_OK) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            SocialProfile mSocialProfile = new SocialProfile();
            mSocialProfile.setmEmailAddress(result.getSignInAccount().getEmail());
            mSocialProfile.setmDisplayName(result.getSignInAccount().getDisplayName());
        }

    }

    @Override
    public void onClick(View v) {

    }
}
