package com.example.tianfeng.smallpos.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListAdapter;
import android.widget.GridView;
import android.widget.Toast;

import com.example.tianfeng.smallpos.R;
import com.example.tianfeng.smallpos.adapter.GridViewAdapter;
import com.example.tianfeng.smallpos.adapter.ProductMenuAdapter;
import com.example.tianfeng.smallpos.base.ProductVO;
import com.example.tianfeng.smallpos.bean.ProductSortVO;
import com.example.tianfeng.smallpos.globaldata.HttpValue;
import com.example.tianfeng.smallpos.http.JsonParams;
import com.example.tianfeng.smallpos.http.JsonRPCAsyncTask;
import com.example.tianfeng.smallpos.utils.Const;
import com.example.tianfeng.smallpos.utils.GsonUtil;
import com.example.tianfeng.smallpos.utils.LogUtils;
import com.example.tianfeng.smallpos.utils.ToastUtils;
import com.example.tianfeng.smallpos.utils.UIProgressUtil;
import com.example.tianfeng.smallpos.xlistview.XListView;

import org.json.JSONException;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;

/**
 * Created by admin on 2016-05-06.
 */
public class ProductFragment extends Fragment {

    private GridView menu_gridview;
    private GridView mGridView;
    //产品的种类
    ArrayList<ProductSortVO> menus = new ArrayList<>();
    // 产品数据
    public ArrayList<ProductVO> mProductList = null;
    private ProductMenuAdapter productMenuAdapter;
    private int type = 0; // 0--图片格式； 1--无图格式
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_product, null);

        init(v);
        LoadData();
        return v;
    }

    private int categorycode = 1;
    private int productinfocode = 2;
    private GridViewAdapter mGridViewAdapter;
    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == categorycode) {
                // //1·xml-rpc的方式
                // ArrayList<Model> modelList = (ArrayList<Model>) msg.obj;
                // mProSortList = ProductSortVO.parse(modelList);

                // 2·json-rpc的方式
                String result = (String) msg.obj;
                Log.e("获取产品分类： ", result);
                if (GsonUtil.isError(result)) {
                    ToastUtils.show(getActivity(), "获取产品分类出错");
                    return;
                }

                ProductSortVO.EntityProductSortVO entity = GsonUtil.jsonToBean(result,
                        ProductSortVO.EntityProductSortVO.class);
                LogUtils.i("产品分类列表：", ""
                        + entity.getResult().getRecords().size());

                menus = entity.getResult().getRecords();
                productMenuAdapter = new ProductMenuAdapter(getActivity(), menus);
                menu_gridview.setAdapter(productMenuAdapter);

            }

            if (msg.what == productinfocode) {
                // //1·xml-rpc的方式
                // ArrayList<Model> modelList = (ArrayList<Model>) msg.obj;
                // mProductList = ProductVO.parse(modelList);

                // 2·json-rpc的方式
                String result = (String) msg.obj;
                Log.e("获取产品： ", result);
                if (GsonUtil.isError(result)) {
                    ToastUtils.show(getActivity(), "获取产品出错");
                    return;
                }

                ProductVO.EntityProductVO entity = GsonUtil.jsonToBean(result,
                        ProductVO.EntityProductVO.class);
                LogUtils.i("产品列表：", "" + entity.getResult().getRecords().size());

                mProductList = entity.getResult().getRecords();
                // if(type == 0){
                // mGridView.setNumColumns(4);
                // }else{
                // mGridView.setNumColumns(2);
                // }
                mGridViewAdapter = new GridViewAdapter(getActivity(),
                        mProductList, type);
                mGridView.setAdapter(mGridViewAdapter);
//                mGridViewAdapter.notifyDataSetChanged();

//                UIProgressUtil.cancelProgress();

//                MallposCashierApplication.instance.setmProductList(mProductList);
//                MinaSocketClient.getInstances().send(
//                        new EventSocket(Const.SOCKET_KEY_SHOWDISHES, MallposCashierApplication.instance.getmProductList()));


            }
        }

    };

    private void init(View view) {

        menu_gridview = (GridView) view.findViewById(R.id.menu_gridview);
        mGridView = (GridView) view.findViewById(R.id.gridview_productlist);
        menu_gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), position + "", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    /**
     * 加载数据
     */
    private void LoadData() {

        try {
            int uid = HttpValue.SP_USERID;
            int pricelist = HttpValue.PRICELIST;
            // json-rpc查询产品分类
            new JsonRPCAsyncTask(getActivity(), mHandler, categorycode,
                    HttpValue.getHttp() + Const.URL_SEARCH_READ, "call",
                    JsonParams.getParams_ProductCategory(uid)).execute();

            // json-rpc查询产品数据
            new JsonRPCAsyncTask(getActivity(), mHandler, productinfocode,
                    HttpValue.getHttp() + Const.URL_SEARCH_READ, "call",
                    JsonParams.getParams_Products(uid, pricelist)).execute();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
