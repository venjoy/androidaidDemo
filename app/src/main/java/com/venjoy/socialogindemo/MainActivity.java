package com.venjoy.socialogindemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.venjoy.socialogin.gplus.GplusPresenter;
import com.venjoy.socialogin.model.SocialProfile;
import com.venjoy.socialogin.util.Constants;
import com.venjoy.socialogin.util.Factory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mGPlus, mFacebook, mTwitter;
    private GplusPresenter objGplusPresenter;
    private TextView mGplusCredentials, mFacebookCredentials, mTwitterCredentials;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setListner();

        // Needs to be performed by user

        objGplusPresenter = Factory.getGplusInstance();
        objGplusPresenter.initGoogle(this);

    }

    // set Listner for onClick
    private void setListner() {
        mGPlus.setOnClickListener(this);
        mFacebook.setOnClickListener(this);
        mTwitter.setOnClickListener(this);
    }


    // Method used to initialize views
    private void initViews() {
        mGPlus = (Button) findViewById(R.id.btn_gplus);
        mFacebook = (Button) findViewById(R.id.btn_facebook);
        mTwitter = (Button) findViewById(R.id.btn_twitter);
        mGplusCredentials = (TextView) findViewById(R.id.gplus_credentials);
    }

    @Override
    public void onClick(View mView) {

        switch (mView.getId()) {
            case R.id.btn_gplus:
                // Needs to be performed by user
                objGplusPresenter.performLogin(this);
                break;
            case R.id.btn_facebook:
                break;
            case R.id.btn_twitter:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Constants.G_PLUS_REQUESTCODE && resultCode == RESULT_OK) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);

            // Needs to be performed by user
            SocialProfile mSocialProfile = new SocialProfile();
            mSocialProfile.setmEmailAddress(result.getSignInAccount().getEmail());
            mSocialProfile.setmDisplayName(result.getSignInAccount().getDisplayName());

            mGplusCredentials.setText(mSocialProfile.getmDisplayName() + "\n" + mSocialProfile.getmEmailAddress());
        }

    }
}

