package com.example.tianfeng.smallpos.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tianfeng.smallpos.R;
import com.example.tianfeng.smallpos.base.ProductVO;
import com.example.tianfeng.smallpos.bean.DiscountVO;
import com.example.tianfeng.smallpos.bean.ProductInfoVO;
import com.example.tianfeng.smallpos.utils.Const;
import com.example.tianfeng.smallpos.utils.NumberFormatUtil;

import java.util.ArrayList;

import de.greenrobot.event.EventBus;

/**
 * Created by admin on 2016-05-13.
 */
public class ProductInfoListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<ProductInfoVO> mList;
    private int mPosition = 0;

    public ProductInfoListAdapter(Context context,
                                  ArrayList<ProductInfoVO> mList) {
        super();
        this.context = context;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_product_info,null);
            holder.tv_name = (TextView) convertView.findViewById(R.id.item_product_name);
            holder.tv_price = (TextView) convertView.findViewById(R.id.item_product_price);
            holder.tv_weight = (TextView)convertView.findViewById(R.id.item_product_weight);
            holder.tv_money = (TextView) convertView.findViewById(R.id.item_product_money);
            holder.cb_select = (CheckBox) convertView.findViewById(R.id.item_product_select);
            convertView.setTag(holder);

        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        ProductInfoVO info = mList.get(position);
        DiscountVO discountVO = info.getDiscountVO();
        ProductVO productVO = info.getProductVO();
        holder.tv_name.setText(productVO.getName());
        holder.tv_price.setText(productVO.getPrice());
        if(holder.cb_select.isChecked() == false){
            holder.cb_select.setChecked(true);
        }else{
            holder.cb_select.setChecked(false);
        }

        return convertView;
    }

    public int getSelect() {
        return mPosition;
    }

    public void setPosition(int position) {
        this.mPosition = position;
    }

    class ViewHolder {

        public CheckBox cb_select;
        public TextView tv_name;
        public TextView tv_weight;
        public TextView tv_price;
        public TextView tv_money;





    }
}
