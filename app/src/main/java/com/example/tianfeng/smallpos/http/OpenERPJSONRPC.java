package com.example.tianfeng.smallpos.http;

import android.util.Log;

import com.example.tianfeng.smallpos.globaldata.HttpValue;
import com.example.tianfeng.smallpos.utils.LogUtils;
import com.github.kevinsawicki.http.HttpRequest;


import org.json.JSONException;
import org.json.JSONObject;

public class OpenERPJSONRPC {
	private int _rid = 1;

	/**结果
	 * JSONRPC 访问open服务器
	 * 
	 * @param url
	 *            路径
	 * @param method
	 *            方式：call
	 * @param params
	 *            参数：json格式
	 * @return
	 * @throws JSONException
	 */
	public HttpRequest JsonRpc(String url, String method, JSONObject params)
			throws JSONException {

		HttpRequest request = HttpRequest.post(url);
		 //针对单项证书给予忽略（注意，双向证书需要导入证书文件）  
	    request.trustAllCerts();  
	    //信任所有地址  
	    request.trustAllHosts();  

		LogUtils.e("Cookie", ""+ HttpValue.COOKIE);
		request.header("Cookie", HttpValue.COOKIE);

		JSONObject postData = new JSONObject();
		postData.put("json-rpc", "2.0");
		postData.put("method", method);
		postData.put("params", params);
		postData.put("id", "" + this._rid);
		LogUtils.d("id:"+this._rid);

		this._rid++;
		request.contentType("application/json");
		request.acceptJson();
		request.send(postData.toString());

		int statusCode = request.code();

		if (statusCode != 200) {
			LogUtils.e("statusCode:", ""+statusCode);
		}
		else{
			LogUtils.d("statusCode:", ""+statusCode);
		}
		return request;
	}

	/**
	 * 代理请求，得到响应结果
	 * 
	 * @param url
	 * @param method
	 * @param params
	 * @return JSON格式的数据
	 * @throws JSONException
	 */
	public String OEJsonRpc(String url, String method, JSONObject params)
			throws JSONException {

		//LogUtils.e("url：", ""+url);
		LogUtils.e("参数：", ""+params.toString());
		
		HttpRequest request = this.JsonRpc(url, method, params);
		//get data
		String result = request.body();
		Log.i("request.body", result);
		return result;
	}
	
	

//	/**
//	 * search_read 接口调用
//	 * @param model			//模型名称
//	 * @param fields		//字段名集合
//	 * @param offset		//起始位置
//	 * @param limit			//查询数量
//	 * @param domain		//约束条件
//	 * @param sort			//排序
//	 * @param context
//	 * @return
//	 * @throws JSONException
//	 */
//	public String modelSearchRead(String model, JSONArray fields, int offset,
//			int limit, JSONArray domain, String sort, JSONObject context)
//			throws JSONException {
//
//		JSONObject params = new JSONObject();
//		params.put("model", model);
//		if (fields != null) {
//			params.put("fields", fields);
//		}else{
//			params.put("fields", new JsonArray());
//		}
//		
//		if (offset != 0) {
//			params.put("offset", offset);
//		}else{
//			params.put("offset", 0);
//		}
//		
//		if (limit != 0) {
//			params.put("limit", limit);
//		}else{
//			params.put("limit", false);
//		}
//		
//		if (domain == null) {
//			domain = new JSONArray();
//		}
//		params.put("domain", domain);
//
//		if (sort != null) {
//			params.put("sort", sort);
//		}else{
//			params.put("sort", "");
//		}
//		
//		if (context == null) {
//			context = new JSONObject();
//		}
//		params.put("context", context);
//
//		String objects = this.OEJsonRpc(Const.URL_SEARCH_READ, "call", params);
//
//		return objects;
//	}
//
//	/**
//	 * load 接口调用
//	 * @param model
//	 * @param id
//	 * @param context
//	 * @return
//	 * @throws JSONException
//	 */
//	public String modelLoad(String model, long id, JSONObject context)
//			throws JSONException {
//		// we add only defined parameters to params object sent to server
//		JSONObject params = new JSONObject();
//		params.put("model", model);
//		params.put("id", id);
//		params.put("fields", new JSONArray()); // OpenERP expect fields
//												// parameter. But doesn't use it
//												// !!!!
//		if (context == null){
//			context = new JSONObject();
//		}
//		params.put("context", context);
//
//		String object = this.OEJsonRpc(Const.URL_LOAD, "call", params);
//		return object;
//	}
//
//	/**
//	 * call_kw 接口调用
//	 * 
//	 * @param model
//	 * @param method
//	 * @param args
//	 * @param kwargs
//	 * @param context
//	 * @return
//	 * @throws JSONException
//	 */
//	public Object modelCallKW(String model, String method, JSONArray args,
//			JSONObject kwargs, JSONObject context) throws JSONException {
//
//		JSONObject params = new JSONObject();
//		params.put("model", model);
//		params.put("method", method);
//
//		if (args == null) {
//			args = new JSONArray();
//		}
//		params.put("args", args);
//
//		if (kwargs == null) {
//			kwargs = new JSONObject();
//		}
//		params.put("kwargs", kwargs);
//
//		if (context == null) {
//			context = new JSONObject();
//		}
//		params.put("context", context);
//
//		Object response = this.OEJsonRpc(Const.URL_CALL_KW, "call", params);
//		return response;
//	}
//
//	/**
//	 * exec_workflow 接口调用
//	 * @param model
//	 * @param id
//	 * @param signal
//	 * @param context
//	 * @return
//	 * @throws JSONException
//	 */
//	public Object modelExecWorkflow(String model, long id, String signal,
//			JSONObject context) throws JSONException {
//
//		if (context == null) {
//			context = new JSONObject();
//		}
//
//		JSONObject params = new JSONObject();
//		params.put("model", model);
//		params.put("id", id);
//		params.put("signal", signal);
//		params.put("context", context);
//
//		Object response = this.OEJsonRpc(Const.URL_EXEC_WORKFLOW, "call",
//				params);
//		return response;
//	}
//
//	/**
//	 * 获取数据库列表
//	 * 
//	 * @param context
//	 * @return
//	 * @throws JSONException
//	 */
//	public ArrayList<String> databaseGetList(JSONObject context)
//			throws JSONException {
//
//		if (context == null)
//			context = new JSONObject();
//
//		JSONObject params = new JSONObject();
//		params.put("context", context);
//
//		Object jsonResult = this.OEJsonRpc(Const.URL_GET_LIST, "call", params);
//		if (!(jsonResult instanceof JSONArray)) {
//			return new ArrayList<String>();
//		}
//
//		ArrayList<String> dbList = new ArrayList<String>();
//		int i = 0;
//		while (i < ((JSONArray) jsonResult).length()) {
//			dbList.add(((JSONArray) jsonResult).getString(i));
//			i++;
//		}
//		return dbList;
//	}
}
