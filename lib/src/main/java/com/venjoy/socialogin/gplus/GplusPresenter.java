package com.venjoy.socialogin.gplus;

import android.app.Activity;

/**
 * Created by lin on 13/2/17.
 */

public interface GplusPresenter {

    // Method used to initialize google for gplus login
    public void initGoogle(Activity mActivity);

    // Method called when user click on button to show login dialog
    public void performLogin(Activity mActivity);

}
