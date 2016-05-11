package com.example.tianfeng.smallpos.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tianfeng.smallpos.R;
import com.example.tianfeng.smallpos.bean.ProductSortVO;

import java.util.ArrayList;

/**
 * Created by admin on 2016-05-06.
 */
public class ProductMenuAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<ProductSortVO> menus;

    public ProductMenuAdapter(Context context, ArrayList<ProductSortVO> menus) {
        this.context = context;
        this.menus = menus;
    }

    @Override
    public int getCount() {
        return menus.size();
    }

    @Override
    public Object getItem(int position) {
        return menus.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHold viewHold = null;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.productmenus_item, null);
             viewHold = new ViewHold();
            viewHold.textView = (TextView) convertView.findViewById(R.id.productmenus_item_textview);
            convertView.setTag(viewHold);
        } else {
            viewHold = (ViewHold) convertView.getTag();
        }
        TextView textView = viewHold.textView;
        textView.setText(menus.get(position).getName());

        return convertView;
    }

    class ViewHold {
       public TextView textView;
    }
}
