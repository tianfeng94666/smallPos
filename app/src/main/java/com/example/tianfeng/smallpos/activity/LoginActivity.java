package com.example.tianfeng.smallpos.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tianfeng.smallpos.R;
import com.example.tianfeng.smallpos.base.BaseActivity;
import com.example.tianfeng.smallpos.bean.SessionId;
import com.example.tianfeng.smallpos.bean.UserSessionVO;
import com.example.tianfeng.smallpos.globaldata.HttpValue;
import com.example.tianfeng.smallpos.http.JsonParams;
import com.example.tianfeng.smallpos.http.JsonRPCAsyncTask;
import com.example.tianfeng.smallpos.http.Session;
import com.example.tianfeng.smallpos.utils.Const;
import com.example.tianfeng.smallpos.utils.DialogUtils;
import com.example.tianfeng.smallpos.utils.GsonUtil;
import com.example.tianfeng.smallpos.utils.NetWorkUtils;
import com.example.tianfeng.smallpos.utils.NumberFormatUtil;
import com.example.tianfeng.smallpos.utils.SharedPreferencesUtils;
import com.example.tianfeng.smallpos.utils.ToastUtils;
import com.example.tianfeng.smallpos.utils.UIProgressUtil;

import org.json.JSONException;

import java.util.List;

/**
 * Created by admin on 2016-05-09.
 */

public class LoginActivity extends BaseActivity {


    public TextView textView;

    public EditText usernameEdit;

    public EditText passwordEdit;

    public TextView textView2;

    public Button loginBut;
    /**
     * 用户id
     */
    private int uid = 0;
    /**
     * session 收银id 获取
     */

    private int SessionRequestCode = 2;
    public TextView changepasswordText;
    private SharedPreferences sp;

    private String cashName;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sp = getSharedPreferences("SP",
                Context.MODE_PRIVATE);

        init();

    }


    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == Const.loginCode) {

                String result = (String) msg.obj;
                if (null == result || "".equals(result)) {
                    DialogUtils.showDialog(LoginActivity.this,
                            "登陆失败，请检查您的登陆信息！");
                } else {
                    Log.e("登录：", result);
                    UserSessionVO.EntityUserVO entity = GsonUtil.jsonToBean(result,
                            UserSessionVO.EntityUserVO.class);
                    UserSessionVO user = entity.getResult();
                    String username = user.getUsername();
                    uid = NumberFormatUtil.ParseInt(user.getUid());
                    if (null == username || "null".equals(username)
                            || "".equals(username) || uid == 0) {
                        DialogUtils.showDialog(LoginActivity.this,
                                "登陆失败，请检查您的用户名！");
                    } else {
                        Log.i("登录成功！", "登录成功！");
                        ToastUtils.show(LoginActivity.this, "登陆用户："
                                + username);
                        SharedPreferencesUtils.saveObjToSp(sp,
                                Const.SP_USERNAME, username);
                        HttpValue.SP_USERID = uid;
//                        getLoginState();
                        Intent intent = new Intent(LoginActivity.this,
                                IndexActivity.class);
                        intent.putExtra(Const.SP_USERNAME, username);
                        startActivity(intent);
                    }
                }
                loginBut.setEnabled(true);
                UIProgressUtil.cancelProgress();
            }

            if (msg.what == SessionRequestCode) {
                String result = (String) msg.obj;
                Log.e("session获取id：", result);
                SessionId.RootResultSession rootResult = GsonUtil.jsonToBean(result,
                        SessionId.RootResultSession.class);
                if (rootResult.getResult().getLength() > 0) {
                    List<SessionId.Records> records = rootResult.getResult()
                            .getRecords();
                    int sessionid = records.get(0).getId();
                    int config_id = Integer.parseInt(records.get(0)
                            .getConfig_id().get(0));
                    // Log.e("已创建session id获取config_id：", config_id+"");
                    cashName = records.get(0).getName();
                    HttpValue.POS_SESSION_ID = sessionid;
                    HttpValue.SP_NAME = cashName;
//                    getStatement_id(sessionid, uid);// 获取会计收银id
//                    getWareHouseId(config_id, uid);// 根据配置获取仓库id
//                    userBeLongCompany(uid);// 用户属于哪个公司
                } else {// 收银未打开，获取默认收银session
//                    getDefaultSessionID();
                }
            }
        }
    };

    private void init() {
        loginBut = (Button) findViewById(R.id.login_but);
        loginBut.setOnClickListener(this);
        changepasswordText = (TextView) findViewById(R.id.changepassword_text);
        changepasswordText.setOnClickListener(this);
        usernameEdit = (EditText) findViewById(R.id.username_edit);

        passwordEdit = (EditText) findViewById(R.id.password_edit);

        // 设置保存的登陆名
        String et_name = (null == SharedPreferencesUtils.readObjFromSp(sp,
                Const.SP_USERNAME) ? "" : ""
                + SharedPreferencesUtils.readObjFromSp(sp, Const.SP_USERNAME));
        usernameEdit.setText(et_name);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.login_but:
                login();
                break;
            case R.id.changepassword_text:
                break;
        }
    }

    private void login() {
        if (NetWorkUtils.getNetConnecState(this)) {

        } else {
            Toast.makeText(LoginActivity.this, "请检查网络是否连接！", Toast.LENGTH_SHORT).show();
            loginBut.setEnabled(true);
            return;
        }
        // 将保存的设置信息取出
        setConfig();
    }

    private void setConfig() {
        String username = usernameEdit.getText().toString();
        String password = passwordEdit.getText().toString();
        if ("".equals(username) || "".equals(password)) {

            Toast.makeText(LoginActivity.this, "用户名和密码不能为空！", Toast.LENGTH_SHORT).show();
            loginBut.setEnabled(true);
            return;
        }
        Toast.makeText(LoginActivity.this, "加载中......", Toast.LENGTH_SHORT).show();
        new Session().login(username, password,
                LoginActivity.this, mHandler);
    }

    /**
     * 获取登录收银session id
     */
    public void getLoginState() {
        try {
            Log.e("session id:  ", JsonParams.setSessionData(uid) + "");
            JsonRPCAsyncTask jsonRPCAsyncTask = (JsonRPCAsyncTask) new JsonRPCAsyncTask(
                    LoginActivity.this, mHandler, SessionRequestCode,
                    HttpValue.getHttp() + Const.SESSION_ID, "call",
                    JsonParams.setSessionData(uid)).execute();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
