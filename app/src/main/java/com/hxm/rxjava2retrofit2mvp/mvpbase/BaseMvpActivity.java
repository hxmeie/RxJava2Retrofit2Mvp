package com.hxm.rxjava2retrofit2mvp.mvpbase;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hxm.rxjava2retrofit2mvp.view.base.BaseActivity;


/**
 * Created by hxm on 2018/3/5.
 * 描述：
 */
@SuppressWarnings("unchecked")
public abstract class BaseMvpActivity<P extends IPresenter> extends BaseActivity implements IBaseView {

    protected P presenter;

    protected abstract P createPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        if (presenter == null) {
            throw new NullPointerException("IPresenter is null!");
        }
        presenter.onAttachView(this, savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (presenter != null) {
            presenter.onSavedInstanceState(outState);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (presenter != null) {
            presenter.onStart();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (presenter != null) {
            presenter.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (presenter != null) {
            presenter.onPause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (presenter != null) {
            presenter.onStop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.onDetachView(false);
            presenter.onDestroy();
        }
    }

    @Override
    public Context getContext() {
        return this;
    }
}
