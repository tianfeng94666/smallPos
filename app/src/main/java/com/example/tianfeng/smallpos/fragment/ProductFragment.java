package com.example.tianfeng.smallpos.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.tianfeng.smallpos.R;
import com.example.tianfeng.smallpos.activity.IndexActivity;
import com.example.tianfeng.smallpos.adapter.ProductMenuAdapter;
import com.example.tianfeng.smallpos.xlistview.XListView;

import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;

/**
 * Created by admin on 2016-05-06.
 */
public class ProductFragment extends Fragment {
    @ViewInject(R.id.productlist_xlist)
    private XListView productlist_xlist;

    private GridView menu_gridview;
    ArrayList<String> menus= new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.product_fragment,null);

        init(v);
        return v;
    }

    private void init(View view) {
        menus.add("所有");
        menus.add("所有");
        menus.add("所有");
        menus.add("所有");
        menus.add("所有");
        ProductMenuAdapter productMenuAdapter = new ProductMenuAdapter(getActivity(),menus);
        menu_gridview = (GridView) view.findViewById(R.id.menu_gridview);
        menu_gridview.setAdapter(productMenuAdapter);
        menu_gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(),position+"",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


}
