package com.venjoy.socialogin.util;

/**
 * Created by lin on 8/2/17.
 */

public class SocialAuth {


    private String mAuthJson;

    public SocialAuth() {
    }

    public SocialAuth(String mAuthJson) {
        this.mAuthJson = mAuthJson;
    }

    public void authenticate(String mSocailAccount) {

        switch (mSocailAccount) {

            case Constants.G_PLUS:
                break;
            case Constants.FACEBOOK:
                break;
            case Constants.TWITTER:
                break;

        }

    }

}
