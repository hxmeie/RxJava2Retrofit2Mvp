package com.hxm.rxjava2retrofit2mvp.presenter.contract;

import com.hxm.rxjava2retrofit2mvp.mvpbase.IBaseView;
import com.hxm.rxjava2retrofit2mvp.mvpbase.IPresenter;

/**
 * Created by hxm on 2018/3/27.
 * 描述：
 */
public class LoginContract {

    public interface LoginView extends IBaseView {
        void onLoginSuccess(String msg);

        void onLoginFailed(String msg);

        void showLoginDialog();

        void dismissDialog();
    }

    public interface LoginPresenter extends IPresenter<LoginView> {
        void doLogin(String username, String pw);
    }
}
