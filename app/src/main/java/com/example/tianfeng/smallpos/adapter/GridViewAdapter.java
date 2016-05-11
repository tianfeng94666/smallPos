package com.example.tianfeng.smallpos.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tianfeng.smallpos.R;
import com.example.tianfeng.smallpos.base.ProductVO;
import com.example.tianfeng.smallpos.globaldata.HttpValue;
import com.example.tianfeng.smallpos.utils.ImageLoad;
import com.example.tianfeng.smallpos.utils.NumberFormatUtil;

import java.util.ArrayList;

/**
 * Created by admin on 2016-05-11.
 */
public class GridViewAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<ProductVO> mList;
    private int type;

    public GridViewAdapter(Context context, ArrayList<ProductVO> mList, int type) {
        super();
        this.context = context;
        this.mList = mList;
        this.type = type;
    }

    @Override
    public int getCount() {
        return (null == mList ? 0 : mList.size());
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        Log.v("position",mList.get(position)+"---------"+mList.size());
        if (convertView == null) {
            holder = new ViewHolder();
            if (type == 0) {
                convertView = LayoutInflater.from(context).inflate(
                        R.layout.item_gv_products, null);
            } else if (type == 1) {
                convertView = LayoutInflater.from(context).inflate(
                        R.layout.item_gv_products_no_picture, null);
            }

            holder.tv_name = (TextView) convertView
                    .findViewById(R.id.item_product_name);
            holder.tv_price = (TextView) convertView
                    .findViewById(R.id.item_product_price);
            holder.iv_image = (ImageView) convertView
                    .findViewById(R.id.item_product_image);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tv_name.setText("" + mList.get(position).getName());
        holder.tv_price.setText("￥"
                + NumberFormatUtil.formatToDouble1(mList.get(position)
                .getList_price()));


        // type == 0 时， 有图模式
        if (type == 0) {
            String url = HttpValue.getHttp()
                    + "/web/binary/image?model=product.product&field=image_medium&id="
                    + mList.get(position).getId();

//			ImageLoader.getInstance().displayImage(url, holder.iv_image,
//					DisplayOptionsUtil.getProductImageOptions());

            new ImageLoad(url, holder.iv_image).execute();
        }

        return convertView;
    }

    public ArrayList<ProductVO> getList() {
        return this.mList;
    }

    class ViewHolder {
        public TextView tv_name;
        public TextView tv_price;
        public ImageView iv_image;
    }
}
