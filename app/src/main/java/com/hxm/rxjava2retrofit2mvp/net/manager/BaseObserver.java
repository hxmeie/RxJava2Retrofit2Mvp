package com.hxm.rxjava2retrofit2mvp.net.manager;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by hxm on 2018/3/11.
 * 描述：
 */
public abstract class BaseObserver<T> implements Observer<T> {
    private Disposable disposable;

    @Override
    public void onSubscribe(Disposable d) {
        disposable = d;
        disposable(d);
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
        disposable.dispose();
        onError(NetException.throwable(e));
    }

    @Override
    public void onComplete() {
        disposable.dispose();
    }

    /**
     * 该方法内调用BaseActivity的addDisposable()方法，防止内存泄漏
     *
     * @param d
     */
    public abstract void disposable(Disposable d);

    public abstract void onSuccess(T t);

    public abstract void onError(NetException.ResponseThrowable e);
}
