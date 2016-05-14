package com.example.tianfeng.smallpos.base;

import android.os.Bundle;
import android.view.View;

import com.example.tianfeng.smallpos.R;

/**
 * Created by admin on 2016-05-14.
 */
public class DialogActivity extends BaseActivity{
    @Override
    public void onClick(View v) {
        super.onClick(v);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cashpay);

    }
}
