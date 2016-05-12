package com.example.tianfeng.smallpos.utils;

/**
 * @author MY
 * 
 */
public interface Const {

	public String SP_IP = "IP"; // 服务器IP
	public String SP_DBNAME = "DBNAME"; // 数据库
	public String SP_SOCKET_IP = "SOCKET_IP"; // 客显IP
	public String SP_SOCKET_PORT = "SOCKET_PORT"; // 收银端设置连接客显端口
	public String SP_SERVER_PORT = "SOCKET_PORT"; // 客显服务器端口
	public String SP_USERNAME = "USERNAME"; // 用户名
	/*
	 * public String SP_USERID = "USERID"; // 用户名 public String
	 * SESSIONID="SESSIONID";//session id
	 * 
	 * public String SP_NAME="NAME";
	 */
	// public String SP_RECORDS="RECORDS";
	public String WAREHOUSE = "WAREHOUSE";// 仓库名字
	public String WEBSITE = "WEBSITE";// 网址
	public String ADRESS = "ADRESS";// 地址
	public String COMPANYNAME = "COMPANYNAME";// 公司名字
	public String PHONE = "PHONE";// 公司电话
	public String JSON = "OBJECT";
	public String INDEX = "INDEX";
	public String ORDERINFO = "ORDERINFO";// 订单
	public String DATAMODEL = "DATAMODEL";
	public String DATA = "DATA";
	public String LINES = "LINES";
	public String POS_DETAILS = "POS_DETAILS";
	public String PRODUCT_INFOS = "PRODUCT_INFOS";
	public String STATAMENT_IDS = "STATAMENT_IDS";

	public final static String TAG_ADD = "add";
	public final static String TAG_DELETE = "delete";
	public final static String TAG_SHOW = "show";
	public final static String TAG_REMOVE = "remove";

	public final static String TAG_PAYWAY = "PAYWAY"; // 支付方式
	public final static String TAG_PAY_CASH = "PAY_CASH"; // 现金支付
	public final static String TAG_PAY_MEMBER = "PAY_MEMBER"; // 会员卡
	/** 登录 */
	public static int loginCode = 0x109;

	/**
	 * URL 接口访问路径
	 */

	// 选择数据库
	public static String URL_DB_SELECTOR = "/web?db=";

	// 登陆
	public static String URL_LOGIN = "/pos/login";

	// 获取登陆用户信息
	public static String URL_GET_SESSION_INFO = "/web/session/get_session_info";

	// 调用search_read 接口
	public static String URL_SEARCH_READ = "/web/dataset/search_read";

	// 提交订单
	public static String CREATE_FROM_UI = "/web/dataset/call_kw/pos.order/create_from_ui";

	// 获取支付方式分类
	public static String PAYCLASSILY = "/web/dataset/search_read";

	// 支付方式
	public static String PAYWAY = "/web/dataset/search_read";

	// 会员支付消费情况 //
	public static String VIPPAY = "/vip_membership/member_sale_money_points";

	// 根据会员添加
	public static String URL_VIPMEMBER_CREATE = "/web/dataset/call_kw/vip.member/create";

	// 根据会员修改
	public static String URL_VIPMEMBER_WRITE = "/web/dataset/call_kw/vip.member/write";
	// 会员补卡
	public static String URL_MEMBER_REPLACEMENT_CARD = "/vip_membership/member_replacement_card";
	// 根据会员充值
	public static String URL_SAVE_CHARGE_LOG = "/web/dataset/call_kw/vip.charge.log/save_charge_log";
	// 通过会员Id 获取会员密码
	public static String URL_GET_PASSWORD_FROM_MEMBER_ID = "/web/dataset/call_kw/vip.member/get_password_from_member_id";
	// 修改会员密码
	public static String URL_SET_NEW_PASSWORD = "/web/dataset/call_kw/vip.member/set_new_password";
	// 根据条件查询会员
	public static String URL_GET_MEMBER_INFO = "/vip_membership/get_member_info";
	// 会员挂失
	public static String URL_SET_MEMBER_LOSS = "/vip_membership/set_member_loss";
	// 会员激活
	public static String URL_SET_MEMBER_NORMAL = "/vip_membership/set_member_normal";
	// 获取验证码
	public static String URL_GET_VALIDATE_CODE = "/vip_membership/send_get_validate_code";
	// 会员退卡
	public static String URL_SET_MEMBER_LOGOFF = "/vip_membership/set_member_logoff";
	// 查询充值订单
	public static String Url_GET_RECHARGE_ORDER = "/web/dataset/call_kw/vip.charge.log/get_recharge_order";
	// public static String Url_GET_RECHARGE_ORDER =
	// "get_recharge_order_android";
	// 充值退单
	public static String Url_SAVE_RECHARGEBACK_ORDER = "/web/dataset/call_kw/vip.charge.log/save_rechargeback_order";
	// 忘记密码时发送验证码
	//public static String URL_SEND_SMS_PWD = "/vip_membership/send_sms_pwd";
	public static String URL_SEND_FIND_PASSWORD = "/vip_membership/sms_find_password";
	// 获取session id
	public static String SESSION_ID = "/web/dataset/search_read";
	// 获取默认session
	public static String DEFAULT_GET = "/web/dataset/call_kw/pos.session.opening/default_get";

	// 创建收银
	public static String CREATE = "/web/dataset/call_kw/pos.session/create";
	// 读取会计收银id
	public static String READSTATEMENTID = "/web/dataset/search_read";
	/** 检查收银关账 */
	public static String POSCHECK_CHECK_ORDER = "/web/dataset/call_kw/pos.session/pos_check_order";
	/** 关账 **/
	public static String ACTIN_CLOSE = "/web/dataset/call_kw/pos.session/wkf_action_close";
	/** 获取仓库信息 */
	public static String STOCK_MAG = "/web/dataset/search_read";
	/** 获取用户属于哪个公司 **/
	public static String BELONG_COMPANY = "/web/dataset/search_read";
	/** 获取公司信息 */
	public static String COMPANYT_MSG = "/web/dataset/search_read";
	/** 获取配置信息 (仓库id) */
	public static String POS_CONFIG = "/web/dataset/call_kw/pos.config/read";
	/** 退单查询订单 */
	public static String GET_ORDER = "/pos/get_order";
	/** 发送短信验证 */
	public static String SENDMSG = "/vip_membership/get_validate_code";
	/**
	 * Socket 信息标记
	 * 
	 */
	public static String SOCKET_KEY_TAKEORDER = "TakeOrder"; // 点单的socket

	public static String SOCKET_KEY_PAY_SUCCESS = "Pay_Success"; // 结账成功

	public static int EVENT_SUB_ADD = 101;

	public String SOCKET_KEY_SHOWDISHES = "show_dishes"; // 菜单

}
