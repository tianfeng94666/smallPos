package com.example.tianfeng.smallpos.globaldata;



import org.json.JSONArray;
public class HttpValue {

	// 配置信息(不变的)
	public static int PORT = 8069;
	public static String SOCKET_IP = "192.168.2.66"; //客显IP
	public static String IP; // 服务器IP
	public static String DBNAME; // 服务器数据库
	public static int SOCKET_PORT; // 收银连接客显的端口
	public static int SERVER_SOCKET_PORT; // 客显服务器端口
	// 登陆保存到的session
	public static String COOKIE = ""; // openERP的会话session
	public static int SP_USERID = 0; // 用户名
	public static int POS_SESSION_ID = 0;// 打开收银session id
	public static String SP_NAME = "";// 收银网点名字
//	public static ArrayList<Records> SP_RECORDS = null;
//	/** 支付方式 */
//	public static PayWayPrase payWay = null;
//	/**支付方式集合*/
//	public static ArrayList<PayWayPrase> payWayPrases=null;
//	/** data 数据保存 */
//	public static Data data;
//	/** 公共价格表 **/
	public static int PRICELIST = 0;
	public static JSONArray argsInnerArray = new JSONArray();

	/**
	 * 拼接地址
	 *
	 * @return
	 */
	public static String getHttp() {
		return "http://" + IP + ":" + PORT;
	}
}
