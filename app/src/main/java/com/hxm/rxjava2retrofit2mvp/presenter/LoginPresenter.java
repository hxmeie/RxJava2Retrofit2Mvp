package com.hxm.rxjava2retrofit2mvp.presenter;

import com.hxm.rxjava2retrofit2mvp.mvpbase.BasePresenter;
import com.hxm.rxjava2retrofit2mvp.net.manager.BaseObserver;
import com.hxm.rxjava2retrofit2mvp.net.manager.NetException;
import com.hxm.rxjava2retrofit2mvp.presenter.contract.LoginContract;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * Created by hxm on 2018/3/27.
 * 描述：
 */
public class LoginPresenter extends BasePresenter<LoginContract.LoginView> implements LoginContract.LoginPresenter {
    @Override
    public void doLogin(String username, String pw) {
        if (isViewAttached()) {
            Observable.timer(2, TimeUnit.SECONDS)
                    .doOnSubscribe(new Consumer<Disposable>() {
                        @Override
                        public void accept(Disposable disposable) throws Exception {
                            getView().showLoginDialog();
                        }
                    })
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnTerminate(new Action() {
                        @Override
                        public void run() throws Exception {
                            getView().dismissDialog();
                        }
                    })
                    .subscribe(new BaseObserver<Long>() {
                        @Override
                        public void disposable(Disposable d) {
                            addDisposable(d);
                        }

                        @Override
                        public void onSuccess(Long aLong) {
                            getView().onLoginSuccess("登录成功");
                        }

                        @Override
                        public void onError(NetException.ResponseThrowable e) {
                            getView().onLoginFailed("登录失败");
                        }
                    });
        }
    }
}
