package com.example.tianfeng.smallpos.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tianfeng.smallpos.R;
import com.example.tianfeng.smallpos.adapter.ProductInfoListAdapter;
import com.example.tianfeng.smallpos.bean.EventProduct;
import com.example.tianfeng.smallpos.bean.ProductInfoVO;
import com.example.tianfeng.smallpos.utils.NumberFormatUtil;

import java.util.ArrayList;

import de.greenrobot.event.EventBus;

/**
 * Created by admin on 2016-05-06.
 */
public class ProductInfoFragment extends Fragment implements View.OnClickListener {
    // 点单列表
    private ListView mLv_Products;
    private ProductInfoListAdapter mAdapter;
    private ArrayList<ProductInfoVO> mProductList = new ArrayList<ProductInfoVO>();
    /**
     * 按键
     */
    private Button btn_pos_one, btn_pos_two, btn_pos_three,
            btn_pos_four, btn_pos_five, btn_pos_six,
            btn_pos_seven, btn_pos_eight, btn_pos_nine, btn_pos_zero;
    //合计金额
    private double sumMoney;
    private TextView tv_total_price;
    private double weight = 1.5;
    private LinearLayout ll_total_info;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_product_info, null);
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
                if (info2.getSelect() == false) {
                    info2.setSelect(true);
                } else {
                    info2.setSelect(false);
                }

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

        setChangeView();
    }

    private void init(View view) {
        mLv_Products = (ListView) view.findViewById(R.id.lv_product_take_order);
        //1--0的but
        btn_pos_one = (Button) view.findViewById(R.id.btn_pos_one);
        btn_pos_two = (Button) view.findViewById(R.id.btn_pos_two);
        btn_pos_three = (Button) view.findViewById(R.id.btn_pos_three);
        btn_pos_four = (Button) view.findViewById(R.id.btn_pos_four);
        btn_pos_five = (Button) view.findViewById(R.id.btn_pos_five);
        btn_pos_six = (Button) view.findViewById(R.id.btn_pos_six);
        btn_pos_seven = (Button) view.findViewById(R.id.btn_pos_seven);
        btn_pos_eight = (Button) view.findViewById(R.id.btn_pos_eight);
        btn_pos_nine = (Button) view.findViewById(R.id.btn_pos_nine);
        btn_pos_zero = (Button) view.findViewById(R.id.btn_pos_zero);

        //合计金额
        tv_total_price = (TextView) view.findViewById(R.id.tv_total_price);
        ll_total_info = (LinearLayout) view.findViewById(R.id.ll_total_info);

        btn_pos_one.setOnClickListener(this);
        btn_pos_two.setOnClickListener(this);
        btn_pos_three.setOnClickListener(this);
        btn_pos_four.setOnClickListener(this);
        btn_pos_five.setOnClickListener(this);
        btn_pos_six.setOnClickListener(this);
        btn_pos_seven.setOnClickListener(this);
        btn_pos_eight.setOnClickListener(this);
        btn_pos_nine.setOnClickListener(this);
        btn_pos_zero.setOnClickListener(this);

        setlisten();
    }

    /**
     * mLv_Products 的item事件监听
     */
    private void setlisten() {
        mLv_Products.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "dianjie", Toast.LENGTH_SHORT).show();
                ProductInfoVO vo = (ProductInfoVO) mAdapter.getItem(position);
                for (ProductInfoVO info2 : mProductList) { // 若存在，修改select
                    if (vo.getProductVO().getId()
                            .equals(info2.getProductVO().getId())) {
                        info2.setSize(info2.getSize() + 1);
                        if (info2.getSelect() == false) {
                            info2.setSelect(true);
                        } else {
                            info2.setSelect(false);
                        }

                    }
                }
                mAdapter.notifyDataSetChanged();
                setChangeView();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_pos_one:

                break;
            case R.id.btn_pos_two:

                break;
            case R.id.btn_pos_three:

                break;
            case R.id.btn_pos_four:

                break;
            case R.id.btn_pos_five:

                break;
            case R.id.btn_pos_six:

                break;
            case R.id.btn_pos_seven:

                break;
            case R.id.btn_pos_eight:

                break;
            case R.id.btn_pos_nine:

                break;
            case R.id.btn_pos_zero:

                break;

            case R.id.btn_pos_delete:

            break;

            case R.id.btn_pos_cashpayment:

                break;
        }

    }

    /**
     * 设置改变后的界面
     */
    public void setChangeView() {

        if (mProductList.size() == 0) {
            ll_total_info.setVisibility(View.INVISIBLE);
        } else {
            ll_total_info.setVisibility(View.VISIBLE);
        }

        sumMoney = 0;
        for (ProductInfoVO info3 : mProductList) {
            if (info3.getSelect() == false) {
                sumMoney += weight
                        * NumberFormatUtil.formatToDouble1(info3.getProductVO()
                        .getList_price());
            }


        }
        tv_total_price.setText(sumMoney + "");
    }
}
