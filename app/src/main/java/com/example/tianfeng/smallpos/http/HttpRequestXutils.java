package com.example.tianfeng.smallpos.http;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.example.tianfeng.smallpos.globaldata.HttpValue;
import com.example.tianfeng.smallpos.utils.Const;
import com.example.tianfeng.smallpos.utils.MyCallBack;
import com.example.tianfeng.smallpos.utils.XUtil;

import org.xutils.common.Callback;
import org.xutils.x;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by admin on 2016-05-10.
 */
public class HttpRequestXutils {
    String result;
    private int _rid = 1;
    public void doget(String url, final Context context) {
        Map map = new HashMap();

        map.put("Accept",
                "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        map.put("Accept-Encoding",
                "gzip, deflate, br");
        map.put("Accept-Language",
                "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
        map.put("Connection", "keep-alive");
        map.put("Cookie", HttpValue.COOKIE);
        map.put("User-Agent",
                "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:45.0) Gecko/20100101 Firefox/45.0");

        XUtil.Get(url,map, new MyCallBack<String>(){
            @Override
            public void onSuccess(String result) {
                super.onSuccess(result);
                Toast.makeText(context,result,Toast.LENGTH_LONG).show();

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                super.onError(ex, isOnCallback);
            }

            @Override
            public void onCancelled(CancelledException cex) {
                super.onCancelled(cex);
            }

            @Override
            public void onFinished() {
                super.onFinished();
            }
        });

    }

    public String doPost(String url, Map<String, String> params)
            throws Exception {

		/* Translate parameter map to parameter date string */
        StringBuffer parameterBuffer = new StringBuffer();
        if (params != null) {
            Iterator iterator = params.keySet().iterator();
            String key = null;
            String value = null;
            while (iterator.hasNext()) {
                key = (String) iterator.next();
                if (params.get(key) != null) {
                    value = (String) params.get(key);
                } else {
                    value = "";
                }

                parameterBuffer.append(key).append("=").append(value);
                if (iterator.hasNext()) {
                    parameterBuffer.append("&");
                }
            }
        }

        System.out.println("----------POST parameter : "
                + parameterBuffer.toString());

        URL localURL = new URL(url);
        URLConnection connection = localURL.openConnection();
        HttpURLConnection httpURLConnection = (HttpURLConnection) connection;

        // 田丰2016-04-20
//		SSLTrustManager sslTrustManager = new SSLTrustManager();
//		HttpsURLConnection httpURLConnection = (HttpsURLConnection) sslTrustManager
//				.connect(url);

        httpURLConnection.setConnectTimeout(6000);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection
                .setRequestProperty("Accept",
                        "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        httpURLConnection.setRequestProperty("Cookie", HttpValue.COOKIE);
        httpURLConnection.setRequestProperty("Content-Type",
                "application/x-www-form-urlencoded");
        httpURLConnection.setRequestProperty("Content-Length",
                String.valueOf(parameterBuffer.length()));
        httpURLConnection.setInstanceFollowRedirects(false);

        Log.e("post send:", "" + HttpValue.COOKIE);
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader reader = null;
        StringBuffer resultBuffer = new StringBuffer();
        String tempLine = null;

        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStreamWriter = new OutputStreamWriter(outputStream);
            System.out.println(outputStream.toString());
            outputStreamWriter.write(parameterBuffer.toString());
            outputStreamWriter.flush();

            Log.e("ResponseCode:", "" + httpURLConnection.getResponseCode());

            reader = new BufferedReader(new InputStreamReader(
                    httpURLConnection.getInputStream()));
            // System.out.println("2222222222"+httpURLConnection.getOutputStream());
            while ((tempLine = reader.readLine()) != null) {
                resultBuffer.append(tempLine);
            }

        } finally {
            if (outputStreamWriter != null) {
                outputStreamWriter.close();
            }

            if (reader != null) {
                reader.close();
            }
        }

        return resultBuffer.toString();
    }

    public void login(String username,String password,Context context,Handler handler){
        new HttpRequestXutils().doget("http://192.168.1.253:8069/",context);
        // 登陆
        Map<String, String> dataMap = new HashMap<String, String>();
        dataMap.put("db", HttpValue.DBNAME);
        dataMap.put("login", username);
        dataMap.put("password", password);
        dataMap.put("redirect", HttpValue.getHttp()
                + Const.URL_DB_SELECTOR);

        try {
            doPost(HttpValue.getHttp() + Const.URL_LOGIN, dataMap);

        } catch (Exception e) {
            e.printStackTrace();
        }
        Map map = new HashMap();
        map.put("Cookie", HttpValue.COOKIE);
        map.put("json-rpc", "2.0");
        map.put("method", "call");
        map.put("params", null);
        map.put("id", "" + this._rid);
        XUtil.Post("http://192.168.1.253:8069/"+ Const.URL_GET_SESSION_INFO,map,new MyCallBack<Object>(){
            @Override
            public void onSuccess(Object result) {
                super.onSuccess(result);
                System.out.println(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                super.onError(ex, isOnCallback);
            }

            @Override
            public void onCancelled(CancelledException cex) {
                super.onCancelled(cex);
            }

            @Override
            public void onFinished() {
                super.onFinished();
            }
        });

    }



}
