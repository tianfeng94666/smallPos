package com.example.tianfeng.smallpos.http;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;

import com.example.tianfeng.smallpos.utils.LogUtils;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonRPCAsyncTask extends AsyncTask<String, String, String> {

	private OpenERPJSONRPC client;
	private Context context; // 上下文
	private Handler handler; // 通信handler
	private int requestCode; // 请求码， 区分请求

	private String url; // 接口路径
	private String method; // 方式
	private JSONObject params; // 参数

	public JsonRPCAsyncTask(Context context, Handler handler, int requestCode,
							String url, String method, JSONObject params) {
		super();
		this.context = context;
		this.handler = handler;
		this.requestCode = requestCode;
		this.url = url;
		this.params = params;
		this.method = method;
		client = new OpenERPJSONRPC();
	}

	@Override
	protected String doInBackground(String... args) {
		String result = null;
		try {
			result = client.OEJsonRpc(url, method, params);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		 LogUtils.i("request.body--返回结果：", "" + result);

		return result;
	}

	@Override
	protected void onPostExecute(String result) {
		Message msg = new Message();
		msg.what = requestCode;
		msg.obj = result;
		handler.sendMessage(msg);
	}
}
