package com.hxm.rxjava2retrofit2mvp.mvpbase;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hxm.rxjava2retrofit2mvp.view.base.BaseFragment;

/**
 * Created by hxm on 2018/3/5.
 * 描述：
 */
@SuppressWarnings("unchecked")
public abstract class BaseMvpFragment<P extends IPresenter> extends BaseFragment implements IBaseView {

    protected P presenter;

    protected abstract P createPresenter();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        if (presenter == null) {
            throw new NullPointerException("IPresenter is null!");
        }
        presenter.onAttachView(this, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (presenter != null) {
            presenter.onStart();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (presenter != null) {
            presenter.onResume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (presenter != null) {
            presenter.onPause();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (presenter != null) {
            presenter.onStop();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.onDetachView(false);
            presenter.onDestroy();
        }
    }

    @Override
    public Context getContext() {
        return getActivity();
    }
}
