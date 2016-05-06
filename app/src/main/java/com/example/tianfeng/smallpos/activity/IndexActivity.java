package com.example.tianfeng.smallpos.activity;

import android.app.Activity;

import android.app.FragmentManager;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.tianfeng.smallpos.R;
import com.example.tianfeng.smallpos.fragment.ProductFragment;
import com.example.tianfeng.smallpos.fragment.ProductInfoFragment;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_index)
public class IndexActivity extends Activity {

    @ViewInject(R.id.log_image)
    private ImageView log_image;
    @ViewInject(R.id.mypic_imageview)
    private ImageView mypic_iImageView;

    FragmentManager fragmentManager = getFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);

        initlayout();


    }

    private void initlayout() {
        initproductfragment();
        initproductinfofragment();
    }

    private void initproductinfofragment() {
        ProductInfoFragment productFragmentInfo = new ProductInfoFragment();
        fragmentManager.beginTransaction().replace(R.id.fragment_product_info,productFragmentInfo).commit();
    }

    private void initproductfragment() {
        ProductFragment productFragment = new ProductFragment();
        fragmentManager.beginTransaction().replace(R.id.fragment_product,productFragment).commit();

    }

//    @Event(value = {R.id.log_image,R.id.all_textview,R.id.mypic_imageview},type = View.OnClickListener.class)
//    private void  imageviewonclicklisten(View view){
//        switch (view.getId()){
//            case R.id.log_image:
//                ImageOptions imageOptions = new ImageOptions.Builder()
//                        .setSize(DensityUtil.dip2px(192), DensityUtil.dip2px(120))//图片大小
//                        .setRadius(DensityUtil.dip2px(10))//ImageView圆角半径
//                        .setCrop(true)// 如果ImageView的大小不是定义为wrap_content, 不要crop.
//                        .setImageScaleType(ImageView.ScaleType.CENTER_CROP)
//                        .setLoadingDrawableId(R.mipmap.ic_launcher)//加载中默认显示图片
//                        .setFailureDrawableId(R.mipmap.ic_launcher)//加载失败后默认显示图片
//                        .build();
//                x.image().bind(log_image, "http://pic.baike.soso.com/p/20090711/20090711101754-314944703.jpg",imageOptions);
//                Toast.makeText(IndexActivity.this,"is ok",Toast.LENGTH_LONG).show();
//                break;
//            case R.id.all_textview:
////                Toast.makeText(IndexActivity.this,"all_textview",Toast.LENGTH_LONG).show();
//                RequestParams params = new RequestParams("https://www.baidu.com");
//                x.http().post(params, new Callback.CommonCallback<String>() {
//                    @Override
//                    public void onSuccess(String s) {
//                        Toast.makeText(getApplication(),"okok"+s,Toast.LENGTH_LONG).show();
//                    }
//
//                    @Override
//                    public void onError(Throwable throwable, boolean b) {
//                        Toast.makeText(getApplication(),"guile"+throwable.toString(),Toast.LENGTH_LONG).show();
//                    }
//
//                    @Override
//                    public void onCancelled(CancelledException e) {
//
//                    }
//
//                    @Override
//                    public void onFinished() {
//
//                    }
//                });
//                break;
//            case R.id.mypic_imageview:
//                ImageOptions options = new ImageOptions.Builder()
//                        .setSize(DensityUtil.dip2px(120),DensityUtil.dip2px(120))
//                        .setLoadingDrawableId(R.mipmap.ic_launcher)//加载中默认显示图片
//                        .setFailureDrawableId(R.mipmap.ic_launcher)//加载失败后默认显示图片
//                        .build();
//                x.image().bind(mypic_iImageView,"http://img2.imgtn.bdimg.com/it/u=1861292504,1719245226&fm=15&gp=0.jpg",options);
//
//
//        }
//    }



}
