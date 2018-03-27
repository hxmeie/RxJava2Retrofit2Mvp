package com.hxm.rxjava2retrofit2mvp.mvpbase;

import android.os.Bundle;

/**
 * Created by hxm on 2018/3/5.
 * 描述：
 */
public interface IPresenter<V extends IBaseView> {
    void onAttachView(V v, Bundle savedInstanceState);

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onSavedInstanceState(Bundle savedInstanceState);

    void onDetachView(boolean retainInstance);

    void onDestroy();
}
