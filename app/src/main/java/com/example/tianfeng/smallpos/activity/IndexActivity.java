package com.example.tianfeng.smallpos.activity;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tianfeng.smallpos.R;
import com.example.tianfeng.smallpos.base.BaseActivity;
import com.example.tianfeng.smallpos.fragment.ProductFragment;
import com.example.tianfeng.smallpos.fragment.ProductInfoFragment;
import com.example.tianfeng.smallpos.http.HttpRequestXutils;
import com.example.tianfeng.smallpos.utils.Const;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.text.SimpleDateFormat;
import java.util.Date;

@ContentView(R.layout.activity_index)
public class IndexActivity extends BaseActivity {

    @ViewInject(R.id.log_image)
    private ImageView log_image;
    @ViewInject(R.id.mypic_imageview)
    private ImageView mypic_iImageView;
    @ViewInject(R.id.MerchantManagement_textview)
    private TextView merchantManagement_textview;
    @ViewInject(R.id.username_text)
    private TextView username_text;
    @ViewInject(R.id.btn_product_order_time)
    private TextView btn_product_order_time;

    FragmentManager fragmentManager = getFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);

        initlayout();


    }


    private void initlayout() {
        //商户管理
        merchantManagement_textview.setOnClickListener(this);
        log_image.setOnClickListener(this);
        username_text.setText(getIntent().getStringExtra(Const.SP_USERNAME));
        initproductfragment();
        initproductinfofragment();
        //设置订单时间
        btn_product_order_time.setText(""
                + new SimpleDateFormat("HH:mm:ss").format(new Date()));
    }

    private void initproductinfofragment() {
        ProductInfoFragment productFragmentInfo = new ProductInfoFragment();
        fragmentManager.beginTransaction().replace(R.id.fragment_product_info, productFragmentInfo).commit();
    }

    private void initproductfragment() {
        ProductFragment productFragment = new ProductFragment();
        fragmentManager.beginTransaction().replace(R.id.fragment_product, productFragment).commit();

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.MerchantManagement_textview:
                Intent intent = new Intent();
                intent.setClass(IndexActivity.this, MerchantManagementActivity.class);
                startActivity(intent);
                break;
            case R.id.log_image:
                Toast.makeText(this, "okokok", Toast.LENGTH_LONG).show();
                new HttpRequestXutils().doget("http://192.168.1.253:8069/", this);
                break;
        }

    }


}
