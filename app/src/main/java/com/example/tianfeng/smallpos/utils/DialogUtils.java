package com.example.tianfeng.smallpos.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.example.tianfeng.smallpos.R;
import com.example.tianfeng.smallpos.bean.DiscountVO;

import java.util.ArrayList;

import de.greenrobot.event.EventBus;

/**
 * Created by admin on 2016-05-11.
 */
public class DialogUtils {

    public static void showDialog(Context ctx, String message) {
        final Dialog dialog = new Dialog(ctx, R.style.OrderDialog);
        View view = View.inflate(ctx, R.layout.dialog_hint, null);
        TextView tv = (TextView) view.findViewById(R.id.dialog_hint_title);
        Button bt = (Button) view.findViewById(R.id.dialog_hint_sure);
        tv.setText(message);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.setCancelable(false);// 不可以用“返回键”取消
        dialog.setContentView(view);
        dialog.show();
    }



    /**
     * 创建普通双按钮对话框
     *
     * @param ctx
     *            上下文 必填
     * @param iconId
     *            图标，如：R.drawable.icon[不想显示就写0] 必填
     * @param title
     *            标题 必填
     * @param message
     *            显示内容 必填
     * @param btnPositiveName
     *            第一个按钮名称 必填
     * @param listener_Positive
     *            第一个监听器，需实现android.content.DialogInterface.OnClickListener接口 必填
     * @param btnNegativeName
     *            第二个按钮名称 必填
     * @param listener_Negative
     *            第二个监听器，需实现android.content.DialogInterface.OnClickListener接口 必填
     * @return 对话框实例
     */
    public static Dialog createDialog(Context ctx, int iconId, String title, String message, String btnPositiveName,
                                      android.content.DialogInterface.OnClickListener listener_Positive, String btnNegativeName, android.content.DialogInterface.OnClickListener listener_Negative) {
        Dialog dialog = null;
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(ctx);
        // 设置对话框的图标
        builder.setIcon(iconId);
        // 设置对话框的标题
        builder.setTitle(title);
        // 设置对话框的显示内容
        builder.setMessage(message);
        // 添加按钮，android.content.DialogInterface.OnClickListener.OnClickListener
        builder.setPositiveButton(btnPositiveName, listener_Positive);
        // 添加按钮，android.content.DialogInterface.OnClickListener.OnClickListener
        builder.setNegativeButton(btnNegativeName, listener_Negative);
        // 创建一个普通对话框
        dialog = builder.create();
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        return dialog;
    }
}
