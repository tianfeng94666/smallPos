package com.example.tianfeng.smallpos.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SessionId implements Serializable {
	public class Result {

		private int length;


		private List<Records> records ;


		public void setLength(int length){

			this.length = length;

		}

		public int getLength(){

			return this.length;

		}

		public void setRecords(List<Records> records){

			this.records = records;

		}

		public List<Records> getRecords(){

			return this.records;

		}

	}
	public class Records implements Serializable {

		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

		private ArrayList<String> config_id;

		private int id;

		private ArrayList<String> journal_ids;
		/**收银网点名字*/
		private String name;

		private String start_at;

		private boolean stop_at;

		private ArrayList<String> user_id;

		public ArrayList<String> getConfig_id() {
			return config_id;
		}

		public void setConfig_id(ArrayList<String> config_id) {
			this.config_id = config_id;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public ArrayList<String> getJournal_ids() {
			return journal_ids;
		}

		public void setJournal_ids(ArrayList<String> journal_ids) {
			this.journal_ids = journal_ids;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getStart_at() {
			return start_at;
		}

		public void setStart_at(String start_at) {
			this.start_at = start_at;
		}

		public boolean isStop_at() {
			return stop_at;
		}

		public void setStop_at(boolean stop_at) {
			this.stop_at = stop_at;
		}

		public ArrayList<String> getUser_id() {
			return user_id;
		}

		public void setUser_id(ArrayList<String> user_id) {
			this.user_id = user_id;
		}

	}

	public class RootResultSession {

		private String id;


		private String jsonrpc;


		private Result result;


		public void setId(String id){

			this.id = id;

		}

		public String getId(){

			return this.id;

		}

		public void setJsonrpc(String jsonrpc){

			this.jsonrpc = jsonrpc;

		}

		public String getJsonrpc(){

			return this.jsonrpc;

		}

		public void setResult(Result result){

			this.result = result;

		}

		public Result getResult(){

			return this.result;

		}

	}

}
