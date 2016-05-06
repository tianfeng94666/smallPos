package com.example.tianfeng.smallpos.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tianfeng.smallpos.R;
import com.example.tianfeng.smallpos.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by admin on 2016-05-10.
 */
public class MerchantManagementActivity extends BaseActivity {

    @BindView(R.id.log_image)
    ImageView logImage;
    @BindView(R.id.tv_pengOrder_number)
    TextView tvPengOrderNumber;
    @BindView(R.id.btn_product_order_time)
    TextView btnProductOrderTime;
    @BindView(R.id.textView_cashierDesk)
    TextView textViewCashierDesk;
    @BindView(R.id.imageview_mypic)
    ImageView imageviewMypic;
    @BindView(R.id.fragment_content)
    FrameLayout fragmentContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchantmanagement);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.textView_cashierDesk, R.id.fragment_content})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.textView_cashierDesk:
                break;
            case R.id.fragment_content:
                break;
        }
    }
}
