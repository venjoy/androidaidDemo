package com.venjoy.socialogin.util;

import com.venjoy.socialogin.gplus.GplusPresenterImpl;

/**
 * Created by Vaibhav Jain on 24/2/17.
 * This is a factory class used to create an object of the desired classs
 */

public class Factory {

    private static GplusPresenterImpl mGplusImplementor;

    private Factory(String SocialPlatform) {

        switch (SocialPlatform) {
            case Constants.G_PLUS:
                mGplusImplementor = new GplusPresenterImpl();
                break;
        }
    }

    public static GplusPresenterImpl getGplusInstance() {
        if (mGplusImplementor == null)
            new Factory(Constants.G_PLUS);

        return mGplusImplementor;
    }

}
