package com.hxm.rxjava2retrofit2mvp.view;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.widget.TextView;

import com.hxm.rxjava2retrofit2mvp.R;
import com.hxm.rxjava2retrofit2mvp.mvpbase.BaseMvpActivity;
import com.hxm.rxjava2retrofit2mvp.presenter.LoginPresenter;
import com.hxm.rxjava2retrofit2mvp.presenter.contract.LoginContract;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseMvpActivity<LoginPresenter> implements LoginContract.LoginView {

    @BindView(R.id.textView)
    TextView textView;
    AlertDialog dialog;

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnLogin)
    void onLoginClick() {
        presenter.doLogin("laal", "1233333");
    }

    @Override
    public void onLoginSuccess(String msg) {
        textView.setText(msg);
    }

    @Override
    public void onLoginFailed(String msg) {
        textView.setText(msg);
    }

    @Override
    public void showLoginDialog() {
        textView.setText("正在登录。。。。。");
        if (dialog == null) {
            dialog = new AlertDialog.Builder(this)
                    .setMessage("登录中。。")
                    .create();
        }
        dialog.show();
    }

    @Override
    public void dismissDialog() {
        if (dialog != null && dialog.isShowing())
            dialog.dismiss();
    }
}
