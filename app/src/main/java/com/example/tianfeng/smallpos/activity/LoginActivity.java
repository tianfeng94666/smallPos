package com.example.tianfeng.smallpos.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tianfeng.smallpos.R;
import com.example.tianfeng.smallpos.base.BaseActivity;
import com.example.tianfeng.smallpos.http.HttpRequestXutils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by admin on 2016-05-09.
 */

public class LoginActivity extends BaseActivity {


   public  TextView textView;

    public EditText usernameEdit;

    public EditText passwordEdit;

    public TextView textView2;

    public Button loginBut;

    public TextView changepasswordText;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();

    }

    private void init() {
        loginBut= (Button) findViewById(R.id.login_but);
        loginBut.setOnClickListener(this);
        changepasswordText = (TextView) findViewById(R.id.changepassword_text);
        changepasswordText.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.login_but:
                new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        new HttpRequestXutils().login("admin","0",LoginActivity.this,null);
                    }


                }.start();
                Toast.makeText(this,"------",Toast.LENGTH_LONG).show();

                break;
            case R.id.changepassword_text:
                Toast.makeText(this,"+++----",Toast.LENGTH_LONG).show();
                break;
        }
    }
}
