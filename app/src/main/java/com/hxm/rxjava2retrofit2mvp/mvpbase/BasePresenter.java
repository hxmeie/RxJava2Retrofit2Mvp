package com.hxm.rxjava2retrofit2mvp.mvpbase;

import android.os.Bundle;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by hxm on 2018/3/5.
 * 描述：
 */
public class BasePresenter<V extends IBaseView> implements IPresenter<V> {
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private WeakReference<V> wr;

    protected V getView() {
        return wr.get();
    }

    protected boolean isViewAttached() {
        return wr != null && wr.get() != null;
    }

    private void _attach(V v, Bundle savedInstanceState) {
        wr = new WeakReference<>(v);
    }

    private void _detach(boolean retainInstance) {
        if (wr != null) {
            wr.clear();
            wr = null;
        }
    }

    @Override
    public void onAttachView(V v, Bundle savedInstanceState) {
        _attach(v, savedInstanceState);
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onSavedInstanceState(Bundle savedInstanceState) {

    }

    @Override
    public void onDetachView(boolean retainInstance) {
        _detach(retainInstance);
    }

    @Override
    public void onDestroy() {
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }

    protected void addDisposable(Disposable disposable) {
        if (compositeDisposable != null) {
            compositeDisposable.add(disposable);
        }
    }
}
