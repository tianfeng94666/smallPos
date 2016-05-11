package com.example.tianfeng.smallpos.bean;

import java.io.Serializable;

public class UserSessionVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String username; // 用户名
	private UserContext user_context; // 语言
	private String db; // 数据库
	private String uid; // UId
	private String session_id; // session

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserContext getUser_context() {
		return user_context;
	}

	public void setUser_context(UserContext user_context) {
		this.user_context = user_context;
	}

	public String getDb() {
		return db;
	}

	public void setDb(String db) {
		this.db = db;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getSession_id() {
		return session_id;
	}

	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}

	public class UserContext implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String lang; // 语言
		private String tz; // 地区
		private String uid; // id

		public String getLang() {
			return lang;
		}

		public void setLang(String lang) {
			this.lang = lang;
		}

		public String getTz() {
			return tz;
		}

		public void setTz(String tz) {
			this.tz = tz;
		}

		public String getUid() {
			return uid;
		}

		public void setUid(String uid) {
			this.uid = uid;
		}

	}

	public static class EntityUserVO implements Serializable {
		private static final long serialVersionUID = 1L;

		private String id;// 请求ID

		private String jsonrpc;// jsonrpc版本

		private UserSessionVO result;// 返回对象

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getJsonrpc() {
			return jsonrpc;
		}

		public void setJsonrpc(String jsonrpc) {
			this.jsonrpc = jsonrpc;
		}

		public UserSessionVO getResult() {
			return result;
		}

		public void setResult(UserSessionVO result) {
			this.result = result;
		}

	}
}
