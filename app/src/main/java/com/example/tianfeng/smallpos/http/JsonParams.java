package com.example.tianfeng.smallpos.http;

import android.util.Log;

import com.google.gson.JsonArray;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonParams {

	// /**
	// * 获取信息ID
	// * @return
	// * @throws JSONException
	// */
	// public static JSONObject getMyId() throws JSONException{
	// //
	// {"jsonrpc":"2.0","method":"call","params":{"model":"im.user","method":"get_my_id","args":[false],"kwargs"
	// // :{}},"id":849460551}
	//
	// JSONObject params = new JSONObject();
	// params.put("model", "im.user");
	// params.put("method", "get_my_id");
	// JSONArray args = new JSONArray();
	// args.put("false");
	// JSONObject kwargs = new JSONObject();
	// params.put("args", args);
	// params.put("kwargs", kwargs);
	// return params;
	// }
	//
	// /**
	// * 根据ID获取用户信息
	// * @param id
	// * @return
	// * @throws JSONException
	// */
	// public static JSONObject getUsers(String id) throws JSONException{
	// //
	// "jsonrpc":"2.0","method":"call","params":{"model":"im.user","method":"get_users","args":[[31]],"kwargs"
	// // :{}},"id":507707810}
	// JSONObject params = new JSONObject();
	// params.put("model", "im.user");
	// params.put("method", "get_users");
	// JSONArray args = new JSONArray();
	// JSONArray args1 = new JSONArray();
	// args1.put(id);
	// args.put(args1);
	// JSONObject kwargs = new JSONObject();
	//
	// params.put("args", args);
	// params.put("kwargs", kwargs);
	// return params;
	// }

	/**
	 * 获取参数：产品分类
	 * 
	 * @return
	 * @throws JSONException
	 */
	public static JSONObject getParams_ProductCategory(int uid)
			throws JSONException {

		String modelName = "product.public.category";

		JSONArray fields = new JSONArray();
		fields.put("id");
		fields.put("name");
		fields.put("parent_id");
		fields.put("child_id");
		fields.put("image");
		fields.put("squence");

		JSONObject context = new JSONObject();
		context.put("lang", "zh_CN");
		context.put("tz", "Asia/Hong_Kong");
		context.put("uid", uid);

		JSONObject params = getSearchReadParams(modelName, fields, 0, 0, null,
				null, context);

		return params;
	}

	/**
	 * 获取参数：产品
	 * 
	 * @return
	 * @throws JSONException
	 */
	public static JSONObject getParams_Products(int uid, int pricelist)
			throws JSONException {

		String modelName = "product.product";

		JSONArray fields = new JSONArray();
		fields.put("id");
		fields.put("name");
		fields.put("list_price");
		fields.put("public_categ_id");
		fields.put("uom_id");
		fields.put("price");
		fields.put("taxes_id");
		fields.put("ean13");
		fields.put("default_code");
		fields.put("to_weight");
		fields.put("uos_id");
		fields.put("uos_coeff");
		fields.put("mes_type");
		fields.put("description_sale");
		fields.put("description");
		fields.put("standard_price");
		fields.put("sales_quantity");

		JSONArray domain = new JSONArray();

		JSONArray array1 = new JSONArray();
		array1.put("sale_ok");
		array1.put("=");
		array1.put(true);

		JSONArray array2 = new JSONArray();
		array2.put("available_in_pos");
		array2.put("=");
		array2.put(true);

		// JSONArray array3 = new JSONArray();
		// array3.put("id");
		// array3.put("<");
		// array3.put(10);
		// domain.put(array3);

		domain.put(array1);
		domain.put(array2);

		JSONObject context = new JSONObject();
		context.put("lang", "zh_CN");
		context.put("tz", "Asia/Hong_Kong");
		context.put("uid", uid);
		context.put("pricelist", pricelist);

		JSONObject params = getSearchReadParams(modelName, fields, 0, 0,
				domain, null, context);

		return params;
	}

	/**
	 * 获取参数：产品
	 * 
	 ** 获取参数：产品优惠券
	 * 
	 * @return
	 * @throws JSONException
	 */
	public static JSONObject getParams_Discount(int uid) throws JSONException {

		String modelName = "product.discount";

		JSONArray fields = new JSONArray();
		fields.put("id");
		fields.put("name");
		fields.put("discount");
		fields.put("price");

		JSONObject context = new JSONObject();
		context.put("lang", "zh_CN");
		context.put("tz", "Asia/Hong_Kong");
		context.put("uid", uid);

		JSONObject params = getSearchReadParams(modelName, fields, 0, 0, null,
				null, context);

		return params;
	}

	/**
	 * @param member_Id
	 *            会员查询的值
	 * @return
	 * @throws JSONException
	 */
	public static JSONObject getParams_MemberInfo(String member_Id)
			throws JSONException {
		JSONObject args = new JSONObject();
		args.put("member_id", member_Id);
		JSONObject params = new JSONObject();
		params.put("args", args);

		return params;
	}

	/**
	 * @param telephone
	 *            会员查询的值
	 * @return
	 * @throws JSONException
	 */
	public static JSONObject getParams_MemberInfoPhone(String telephone)
			throws JSONException {
		JSONObject args = new JSONObject();
		args.put("telephone", telephone);
		JSONObject params = new JSONObject();
		params.put("args", args);
		return params;
	}

	public static JSONObject getParams_MemberBackcard(String member_id,
													  String validate_code) throws JSONException {
		JSONObject args = new JSONObject();
		args.put("member_id", member_id);
		args.put("validate_code", validate_code);
		JSONObject params = new JSONObject();
		params.put("args", args);
		return params;
	}

	public static JSONObject getParams_MemberCard_replacement(String member_id,
															  int ids) throws JSONException {
		
		
		 
		JSONObject args = new JSONObject();
		args.put("member_id", member_id);
		JSONObject params = new JSONObject();
		params.put("ids", ids);
		params.put("args", args);
		return params;
	
		 

	}

	/**
	 * 2015-12-29getParams_AddMember Administrator JSONObject
	 * 
	 * @param member_id
	 *            会员ID
	 * @param m_password
	 *            会员密码
	 * @param re_password
	 *            会员确认密码
	 * @param m_name
	 *            会员名字
	 * @param m_telephone
	 *            会员手机号
	 * @param m_email
	 *            会员email
	 * @param m_address
	 *            会员地址

	 * @return
	 * @throws JSONException
	 */
	public static JSONObject getParams_AddMember(String member_id,
												 String m_password, String re_password, String m_name,
												 String m_telephone/* ,String validate_code */, String m_email,
												 String m_address, String m_birthday, /* String m_level, */int m_sex)
			throws JSONException {
		JSONObject params = new JSONObject();
		try {
			JSONArray args = new JSONArray();
			JSONObject kwargs = new JSONObject();
			JSONObject vals = new JSONObject();
			vals.put("m_address", m_address);
			vals.put("m_birthdate", m_birthday);
			vals.put("m_email", m_email);
			// vals.put("validate_code", validate_code);
			vals.put("m_name", m_name);
			vals.put("m_password", m_password);
			vals.put("m_sex", m_sex);
			vals.put("m_telephone", m_telephone);
			vals.put("member_id", member_id);
			vals.put("re_password", re_password);
			params.put("kwargs", kwargs);
			params.put("args", args);
			kwargs.put("vals", vals);
			params.put("method", "create");
			params.put("model", "vip.member");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return params;
	}

	/**
	 * 2015-12-29getParams_UpdateMemberAdministratorJSONObject
	 * 
	 * @param member_id
	 *            会员id
	 * @param m_name
	 *            会员名

	 * @param m_address
	 *            地址
	 * @param m_birthday
	 *            生日

	 * @return
	 * @throws JSONException
	 */
	public static JSONObject getParams_UpdateMember(String member_id,
													String m_name, String m_telephone, String m_email,
													String m_address, String m_birthday, /* String m_level, */int m_sex,
													int ids) throws JSONException {
		JSONObject params = new JSONObject();
		try {
			JSONArray args = new JSONArray();
			JSONObject kwargs = new JSONObject();
			JSONObject vals = new JSONObject();
			vals.put("m_address", m_address);
			vals.put("m_birthdate", m_birthday);
			vals.put("m_email", m_email);
			// vals.put("m_level", m_level);
			vals.put("m_name", m_name);
			vals.put("m_sex", m_sex);
			vals.put("m_telephone", m_telephone);
			vals.put("member_id", member_id);

			params.put("kwargs", kwargs);
			params.put("args", args);
			kwargs.put("ids", ids);
			kwargs.put("vals", vals);

			params.put("method", "write");
			params.put("model", "vip.member");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return params;
	}

	/**
	 * 2015-12-getParams_MemberRecharge Administrator JSONObject
	 * 
	 * @param member_id
	 *            会员号
	 * @param moneys
	 * 充值金额
	 * @param recharge_code
	 *            支付方式
	 * @return
	 * @throws JSONException
	 */
	public static JSONObject getParams_MemberRecharge(String member_id,
													  String moneys, String recharge_code) throws JSONException {
		JSONObject params = new JSONObject();
		JSONArray args = new JSONArray();
		JSONObject vals = new JSONObject();
		vals.put("member_id", member_id);
		vals.put("moneys", moneys);
		vals.put("recharge_code", recharge_code);
		args.put(vals);
		params.put("args", args);

		JSONObject kwargs = new JSONObject();
		params.put("kwargs", kwargs);
		params.put("method", "save_charge_log");
		params.put("model", "vip.charge.log");

		return params;
	}

	/**
	 * 2016-1-22getParams_MemberRechargeBack Administrator JSONObject
	 * 
	 * @param recharge_order_id
	 *            充值单号
	 * @return
	 * @throws JSONException
	 */
	public static JSONObject getParams_MemberRechargeBack(
			String recharge_order_id) throws JSONException {
		JSONObject params = new JSONObject();
		JSONArray args = new JSONArray();

		params.put("args", args);

		JSONObject kwargs = new JSONObject();
		kwargs.put("recharge_order_id", recharge_order_id);

		params.put("kwargs", kwargs);
		params.put("method", "get_recharge_order");
		params.put("model", "vip.charge.log");

		return params;
	}

	/**
	 * 2016-1-23getParams_Send_Sms_Pwd 发送验证码 AdministratorJSONObject
	 * 
	 * @param member_id
	 * @return
	 * @throws JSONException
	 */
	public static JSONObject getParams_Send_Sms_Pwd(String member_id, String validate_code, String new_password)
			throws JSONException {
		JSONObject params = new JSONObject();
		JSONObject args = new JSONObject();

		params.put("args", args);
		args.put("member_id", member_id);
		args.put("validate_code", validate_code);
		args.put("new_password", new_password);

		return params;
	}

	public static JSONObject getParams_MemberRechargeBack(
			String charge_order_id, String liaison_order_id, String member_id,
			int member_update_before_level, double moneys, int presenter_money,
			String recharge_mode, String session, boolean status, String type)
			throws JSONException {
		JSONObject params = new JSONObject();
		try {
			JSONArray args = new JSONArray();
			JSONObject kwargs = new JSONObject();
			JSONObject vals = new JSONObject();
			vals.put("charge_order_id", charge_order_id);
			vals.put("liaison_order_id", liaison_order_id);
			vals.put("member_id", member_id);
			vals.put("member_update_before_level", member_update_before_level);
			vals.put("moneys", moneys);
			vals.put("presenter_money", presenter_money);
			vals.put("recharge_mode", recharge_mode);
			vals.put("session", session);
			vals.put("status", status);
			vals.put("type", type);

			params.put("kwargs", kwargs);
			params.put("args", args);
			kwargs.put("vals", vals);

			params.put("method", "save_rechargeback_order");
			params.put("model", "vip.charge.log");
			Log.e("退单参数：", params.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return params;
	}

	/**
	 * 2016-1-21getParams_MemberUpdatePwd 修改会员密码 李月梅 JSONObject
	 * 
	 * @param member_id
	 * @param passwd
	 * @return
	 * @throws JSONException
	 */
	public static JSONObject getParams_MemberUpdatePwd(String member_id,
													   String passwd) throws JSONException {
		JSONObject params = new JSONObject();
		JSONArray args = new JSONArray();

		params.put("args", args);

		JSONObject kwargs = new JSONObject();
		kwargs.put("member_id", member_id);
		kwargs.put("passwd", passwd);

		params.put("kwargs", kwargs);
		params.put("method", "set_new_password");
		params.put("model", "vip.member");

		return params;
	}

	/**
	 * 2016-1-21getParams_MemberUpdatePwd 修改会员密码 李月梅 JSONObject
	 * 
	 * @param member_id

	 * @return
	 * @throws JSONException
	 */
	public static JSONObject getParams_GetMemberPwd(String member_id)
			throws JSONException {
		JSONObject params = new JSONObject();
		JSONArray args = new JSONArray();

		params.put("args", args);

		JSONObject kwargs = new JSONObject();
		kwargs.put("member_id", member_id);

		params.put("kwargs", kwargs);
		params.put("method", "get_password_from_member_id");
		params.put("model", "vip.member");

		return params;
	}


	/**
	 * 2016-1-getParams_MemberLevel 李月梅 JSONObject 会员等级查询
	 * 
	 * @return
	 * @throws JSONException
	 */
	public static JSONObject getParams_MemberLevel() throws JSONException {

		String modelName = "vip.level";

		JSONArray fields = new JSONArray();
		fields.put("level_name");

		JSONObject context = new JSONObject();
		context.put("lang", "zh_CN");
		context.put("tz", "Asia/Hong_Kong");
		context.put("uid", "1");

		JSONObject params = getSearchReadParams(modelName, fields, 0, 0, null,
				null, context);

		return params;
	}

	/**
	 * 2016-1-4getParams_MemberRechangePay 李月梅 JSONObject 会员支付方式查询
	 * 
	 * @return
	 * @throws JSONException
	 */
	public static JSONObject getParams_MemberRechangePay(int uid)
			throws JSONException {

		String modelName = "vip.recharge.mode";

		JSONArray fields = new JSONArray();
		fields.put("recharge_mode");
		fields.put("recharge_code");

		JSONObject context = new JSONObject();
		context.put("lang", "zh_CN");
		context.put("tz", "Asia/Hong_Kong");
		context.put("uid", uid);

		JSONObject params = getSearchReadParams(modelName, fields, 0, 0, null,
				null, context);

		return params;
	}

	/**
	 * 包装Search_Read 接口的请求参数
	 * 
	 * @param model
	 * @param fields
	 * @param offset
	 * @param limit
	 * @param domain
	 * @param sort
	 * @param context
	 * @return
	 * @throws JSONException
	 */

	public static JSONObject getSearchReadParams(String model,
												 JSONArray fields, int offset, int limit, JSONArray domain,
												 String sort, JSONObject context) throws JSONException {

		JSONObject params = new JSONObject();
		params.put("model", model);
		if (fields != null) {
			params.put("fields", fields);
		} else {
			params.put("fields", new JsonArray());
		}

		if (offset != 0) {
			params.put("offset", offset);
		} else {
			params.put("offset", 0);
		}

		if (limit != 0) {
			params.put("limit", limit);
		} else {
			params.put("limit", false);
		}

		if (domain == null) {
			domain = new JSONArray();
		}
		params.put("domain", domain);

		if (sort != null) {
			params.put("sort", sort);
		} else {
			params.put("sort", "");
		}

		if (context == null) {
			context = new JSONObject();
		}
		params.put("context", context);

		return params;
	}



	/***
	 * 获取session id
	 * 
	 * @param uid
	 * @return
	 * @throws JSONException
	 */
	public static JSONObject setSessionData(int uid) throws JSONException {
		JSONArray fields = new JSONArray();
		fields.put("id");
		fields.put("journal_ids");
		fields.put("name");
		fields.put("user_id");
		fields.put("config_id");
		fields.put("start_at");
		fields.put("stop_at");
		String model = "pos.session";
		int offset = 0;
		int limit = 0;
		String sort = "";
		JSONArray domain = new JSONArray();
		JSONArray innerdomain1 = new JSONArray();
		JSONArray innerdomain2 = new JSONArray();
		innerdomain1.put("state");
		innerdomain1.put("=");
		innerdomain1.put("opened");
		domain.put(innerdomain1);
		innerdomain2.put("user_id");
		innerdomain2.put("=");
		innerdomain2.put(uid);
		domain.put(innerdomain2);
		JSONObject context = new JSONObject();
		context.put("lang", "zh_CN");
		context.put("tz", "Asia/Hong_Kong");
		context.put("uid", uid);
		JSONObject params = JsonParams.getSearchReadParams(model, fields,
				offset, limit, domain, sort, context);
		return params;

	}

	/***
	 * 查找默认收银session
	 * 
	 * @param uid
	 *            用户id
	 * @return
	 * @throws JSONException
	 */
	public static JSONObject getDefaultCashier(int uid) throws JSONException {
		JSONObject params = new JSONObject();
		params.put("model", "pos.session.opening");
		params.put("method", "default_get");
		JSONArray args = new JSONArray();
		JSONArray argsinner = new JSONArray();
		argsinner.put("pos_session_username");
		argsinner.put("pos_session_id");
		argsinner.put("show_config");
		argsinner.put("pos_session_name");
		argsinner.put("pos_config_id");
		argsinner.put("pos_state_str");
		argsinner.put("pos_state");
		args.put(argsinner);
		params.put("args", args);
		JSONObject context = new JSONObject();
		JSONObject kwargs = new JSONObject();
		context.put("lang", "zh_CN");
		context.put("tz", "Asia/Hong_Kong");
		context.put("uid", uid);
		kwargs.put("context", context);
		params.put("kwargs", kwargs);

		return params;
	}

	/**
	 * 创建收银
	 * 
	 * @param uid
	 * @param pos_config_id
	 * @return
	 * @throws JSONException
	 */
	public static JSONObject createCashier(int uid, int pos_config_id)
			throws JSONException {
		JSONObject params = new JSONObject();
		params.put("model", "pos.session.opening");
		params.put("method", "create");
		JSONArray args = new JSONArray();
		JSONObject argsObject = new JSONObject();
		argsObject.put("pos_config_id", pos_config_id);
		argsObject.put("pos_session_id", false);
		args.put(argsObject);
		params.put("args", args);
		JSONObject context = new JSONObject();
		JSONObject kwargs = new JSONObject();
		context.put("lang", "zh_CN");
		context.put("tz", "Asia/Hong_Kong");
		context.put("uid", uid);
		kwargs.put("context", context);
		params.put("kwargs", kwargs);
		return params;
	}

	/**
	 * 获取会计结账id
	 * 
	 * @param sessionId
	 * @param uid
	 * @return
	 * @throws JSONException
	 */
	public static JSONObject getStatementIdParams(int sessionId, int uid)
			throws JSONException {
		JSONObject params = new JSONObject();
		params.put("model", "account.bank.statement");
		JSONArray fields = new JSONArray();
		fields.put("account_id");
		fields.put("currency");
		fields.put("journal_id");
		fields.put("state");
		fields.put("name");
		fields.put("user_id");
		fields.put("pos_session_id");
		params.put("fields", fields);
		JSONArray innerDomain1 = new JSONArray();
		JSONArray innerDomain2 = new JSONArray();
		JSONArray domain = new JSONArray();
		innerDomain1.put("state");
		innerDomain1.put("=");
		innerDomain1.put("open");
		domain.put(innerDomain1);
		innerDomain2.put("pos_session_id");
		innerDomain2.put("=");
		innerDomain2.put(sessionId);
		domain.put(innerDomain2);
		params.put("domain", domain);
		JSONObject context = new JSONObject();
		context.put("lang", "zh_CN");
		context.put("tz", "Asia/Hong_Kong");
		context.put("uid", uid);
		params.put("context", context);
		params.put("offset", 0);
		params.put("limit", false);
		params.put("sort", "");
		return params;
	}

	/**
	 * 创建收银id
	 * 
	 * @param uid
	 * @param pos_config_id
	 * @return
	 */
	public static JSONObject createCashierId(int uid, int pos_config_id)
			throws JSONException {
		JSONObject params = new JSONObject();
		params.put("model", "pos.session");
		params.put("method", "create");
		JSONArray args = new JSONArray();
		JSONObject innerArgs = new JSONObject();
		innerArgs.put("user_id", uid);
		innerArgs.put("currency_id", false);
		innerArgs.put("config_id", pos_config_id);
		JSONArray array = new JSONArray();
		innerArgs.put("opening_details_ids", array);
		JSONArray array2 = new JSONArray();
		innerArgs.put("details_ids", array2);
		args.put(innerArgs);
		params.put("args", args);
		JSONObject kwargs = new JSONObject();
		JSONObject context = new JSONObject();
		context.put("lang", "zh_CN");
		context.put("tz", "Asia/Hong_Kong");
		context.put("uid", uid);
		kwargs.put("context", context);
		params.put("kwargs", kwargs);
		return params;
	}

	/***
	 * 检查关账
	 * 
	 * @param sessionId
	 *            收银id
	 * @return
	 */
	public static JSONObject checkOrder(int sessionId) throws JSONException {
		JSONObject params = new JSONObject();
		params.put("model", "pos.session");
		params.put("method", "pos_check_order");
		JSONArray args = new JSONArray();
		JSONArray inner = new JSONArray();
		inner.put(sessionId);
		args.put(inner);
		params.put("args", args);
		params.put("kwargs", new JSONObject());

		return params;
	}

	/***
	 * 关闭收银
	 * 
	 * @param sessionId
	 *            收银sessionId
	 * @param closemoney
	 *            关账money
	 * @return
	 * @throws JSONException
	 */
	public static JSONObject closeCashier(int sessionId, String closemoney)
			throws JSONException {
		JSONObject params = new JSONObject();
		params.put("model", "pos.session");
		params.put("method", "wkf_action_close");
		JSONArray args = new JSONArray();
		JSONArray innerArgs = new JSONArray();
		innerArgs.put(sessionId);
		args.put(innerArgs);
		args.put(closemoney);
		params.put("args", args);
		params.put("kwargs", new JSONObject());
		return params;
	}

	/**
	 * 获取仓库信息
	 * 
	 * @param warehouse_id
	 *            仓库id
	 * @param uid
	 * @return
	 */
	public static JSONObject getWareHouseMsg(int warehouse_id, int uid)
			throws JSONException {
		JSONObject params = new JSONObject();
		params.put("model", "stock.warehouse");
		params.put("fields", new JSONArray());
		JSONArray domain = new JSONArray();
		JSONArray inner = new JSONArray();
		inner.put("id");
		inner.put("=");
		inner.put(warehouse_id);
		domain.put(inner);
		params.put("domain", domain);
		JSONObject context = new JSONObject();
		context.put("lang", "zh_CN");
		context.put("tz", "Asia/Hong_Kong");
		context.put("uid", uid);
		params.put("context", context);
		params.put("offset", 0);
		params.put("limit", false);
		params.put("sort", "");
		return params;
	}

	/*
	 * {"jsonrpc":"2.0","method":"call","params":{"model":"res.users","fields":[
	 * "name","company_id"],
	 * "domain":[["id","=",1]],"context":{"lang":"zh_CN","tz"
	 * :"Asia/Hong_Kong","uid":1},
	 * "offset":0,"limit":false,"sort":""},"id":521799818} 这个获取到用户所属公司
	 */
	/***
	 * 获取用户属于哪个公司
	 * 
	 *
	 * @param uid
	 *            用户id
	 * @return
	 */
	public static JSONObject getBelongCompany(int uid) throws JSONException {
		JSONObject params = new JSONObject();
		params.put("model", "res.users");
		JSONArray fields = new JSONArray();
		fields.put("name");
		fields.put("company_id");
		params.put("fields", fields);
		JSONArray domain = new JSONArray();
		JSONArray inner = new JSONArray();
		inner.put("id");
		inner.put("=");
		inner.put(uid);
		domain.put(inner);
		params.put("domain", domain);
		JSONObject context = new JSONObject();
		context.put("lang", "zh_CN");
		context.put("tz", "Asia/Hong_Kong");
		context.put("uid", uid);
		params.put("context", context);
		params.put("offset", 0);
		params.put("limit", false);
		params.put("sort", "");
		return params;
	}

	/*
	 * {"jsonrpc":"2.0","method":"call","params":{"model":"res.company","fields":
	 * ["currency_id","email","website","company_registry","vat","name","phone",
	 * "partner_id",
	 * "paypal_account","street"],"domain":[["id","=",1]],"context":
	 * {"lang":"zh_CN","tz":"Asia/Hong_Kong","uid":1,"show_address_only":true},
	 * "offset":0,"limit":false,"sort":""},"id":537625199}
	 */

	/**
	 * 获取公司信息
	 * 
	 * @param company_id
	 * @param uid
	 * @return
	 */
	public static JSONObject getCompanyMsg(int company_id, int uid)
			throws JSONException {
		JSONObject params = new JSONObject();
		params.put("model", "res.company");
		JSONArray fields = new JSONArray();
		fields.put("currency_id");
		fields.put("email");
		fields.put("website");
		fields.put("company_registry");
		fields.put("vat");
		fields.put("name");
		fields.put("phone");
		fields.put("partner_id");
		fields.put("paypal_account");
		fields.put("street");
		params.put("fields", fields);
		JSONArray domain = new JSONArray();
		JSONArray inner = new JSONArray();
		inner.put("id");
		inner.put("=");
		inner.put(company_id);
		domain.put(inner);
		params.put("domain", domain);
		JSONObject context = new JSONObject();
		context.put("lang", "zh_CN");
		context.put("tz", "Asia/Hong_Kong");
		context.put("uid", uid);
		context.put("show_address_only", true);
		params.put("context", context);
		params.put("offset", 0);
		params.put("limit", false);
		params.put("sort", "");
		return params;
	}

	/*
	 * {"jsonrpc":"2.0","method":"call","params":{"model":"pos.config","method":
	 * "read","args":[[1],["iface_big_scrollbars"
	 * ,"currency_id","iface_electronic_scale"
	 * ,"proxy_ip","iface_vkeyboard","journal_id","iface_scan_via_proxy"
	 * ,"pos_number"
	 * ,"state","group_by","iface_invoicing","pricelist_id","journal_ids"
	 * ,"warehouse_id","sequence_id"
	 * ,"iface_print_auto","receipt_header","iface_cashdrawer"
	 * ,"name","receipt_footer","shop_num","iface_print_via_proxy"
	 * ,"display_name"
	 * ]],"kwargs":{"context":{"lang":"zh_CN","tz":"Asia/Hong_Kong"
	 * ,"uid":1,"bin_size":true,"future_display_name" :true}}},"id":379624445}
	 */
	/***
	 * 
	 * @param Pos_config_id
	 *            配置id
	 * @param uid
	 * @return
	 * @throws JSONException
	 */
	public static JSONObject getWareHouseId(int Pos_config_id, int uid)
			throws JSONException {
		JSONObject params = new JSONObject();
		params.put("model", "pos.config");
		params.put("method", "read");
		JSONArray args = new JSONArray();
		JSONArray argsInner = new JSONArray();
		argsInner.put(Pos_config_id);
		args.put(argsInner);
		JSONArray argsFields = new JSONArray();
		argsFields.put("iface_big_scrollbars");
		argsFields.put("currency_id");
		argsFields.put("iface_electronic_scale");
		argsFields.put("proxy_ip");
		argsFields.put("iface_vkeyboard");
		argsFields.put("journal_id");
		argsFields.put("iface_scan_via_proxy");
		argsFields.put("pos_number");
		argsFields.put("state");
		argsFields.put("group_by");
		argsFields.put("iface_invoicing");
		argsFields.put("pricelist_id");
		argsFields.put("journal_ids");
		argsFields.put("warehouse_id");
		argsFields.put("sequence_id");
		argsFields.put("iface_print_auto");
		argsFields.put("receipt_header");
		argsFields.put("iface_cashdrawer");
		argsFields.put("name");
		argsFields.put("receipt_footer");
		argsFields.put("shop_num");
		argsFields.put("iface_print_via_proxy");
		argsFields.put("display_name");
		args.put(argsFields);
		params.put("args", args);
		JSONObject kwargs = new JSONObject();
		JSONObject context = new JSONObject();
		context.put("lang", "zh_CN");
		context.put("tz", "Asia/Hong_Kong");
		context.put("uid", uid);
		context.put("bin_size", true);
		context.put("future_display_name", true);
		kwargs.put("context", context);
		params.put("kwargs", kwargs);
		return params;

	}



	// 将缓存订单提交
	public static JSONObject putJsonArray(JSONArray argsInnerArray) {
		JSONObject params = new JSONObject();
		try {

			JSONArray argsArray = new JSONArray();
			params.put("model", "pos.order");
			params.put("method", "create_from_ui");
			JSONObject json1 = new JSONObject();
			params.put("kwargs", json1);
			argsArray.put(argsInnerArray);
			params.put("args", argsArray);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return params;
	}

	// {"jsonrpc":"2.0","method":"call","params":{"order_id":"1453338521471"},"id":963375120}
	/** 退单 查询订单 */
	public static JSONObject getOrder(String orderId) throws JSONException {
		JSONObject params = new JSONObject();
		params.put("order_id", orderId);
		return params;
	}



}
