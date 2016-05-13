package com.example.tianfeng.smallpos.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.tianfeng.smallpos.R;
import com.example.tianfeng.smallpos.adapter.ProductInfoListAdapter;
import com.example.tianfeng.smallpos.bean.EventProduct;
import com.example.tianfeng.smallpos.bean.ProductInfoVO;

import java.util.ArrayList;

import de.greenrobot.event.EventBus;

/**
 * Created by admin on 2016-05-06.
 */
public class ProductInfoFragment extends Fragment {
    // 点单列表
    private ListView mLv_Products;
    private ProductInfoListAdapter mAdapter;
    private ArrayList<ProductInfoVO> mProductList = new ArrayList<ProductInfoVO>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_product_info,null);
        EventBus.getDefault().register(this);
        init(v);
        return v;
    }

    /**
     * EventBus 接收消息-点击商品
     *
     * @param event
     */
    public void onEventMainThread(EventProduct event) {
        boolean isExist = false;

        for (ProductInfoVO info2 : mProductList) { // 若存在，加1
            if (event.getProductVO().getId()
                    .equals(info2.getProductVO().getId())) {
                info2.setSize(info2.getSize() + 1);
                isExist = true;
            }
        }

        if (!isExist) { // 如果没有添加过，新增
            ProductInfoVO info = new ProductInfoVO();
            info.setProductVO(event.getProductVO());
            info.setSize(info.getSize() + 1);
            mProductList.add(info);
        }

        if (null == mAdapter) {
            mAdapter = new ProductInfoListAdapter(getActivity(), mProductList);
            mLv_Products.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }

//        setViewChange();

    }
    private void init(View view) {
        mLv_Products = (ListView) view.findViewById(R.id.lv_product_take_order);
    }
}
