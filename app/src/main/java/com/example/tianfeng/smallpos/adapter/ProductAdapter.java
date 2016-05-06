package com.example.tianfeng.smallpos.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.tianfeng.smallpos.bean.ProductInfoVO;

import java.util.ArrayList;

/**
 * Created by admin on 2016-05-06.
 */
public class ProductAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<ProductInfoVO> products;
    public ProductAdapter(Context context, ArrayList<ProductInfoVO> products){
        this.context = context;
        this.products = products;
    }
    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){

        }
        return null;
    }
}
