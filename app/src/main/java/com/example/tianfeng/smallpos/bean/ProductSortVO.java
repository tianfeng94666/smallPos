package com.example.tianfeng.smallpos.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by admin on 2016-05-11.
 */
public class ProductSortVO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String id; // ID
    private String name; // 名称
    private Object parent_id; // 父ID
    private Object[] child_id; // 子ID
    private String image; // 图片
    private String squence;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getParent_id() {
        return parent_id;
    }

    public void setParent_id(Object parent_id) {
        this.parent_id = parent_id;
    }

    public Object[] getChild_id() {
        return child_id;
    }

    public void setChild_id(Object[] child_id) {
        this.child_id = child_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSquence() {
        return squence;
    }

    public void setSquence(String squence) {
        this.squence = squence;
    }



    // -----------------------------------以下是JSON_RPC返回的数据格式------------------------------------------------------//

    public static class EntityProductSortVO implements Serializable {
        private static final long serialVersionUID = 1L;

        private String id;// 请求ID

        private String jsonrpc;// jsonrpc版本

        private Result result;// 返回对象

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

        public Result getResult() {
            return result;
        }

        public void setResult(Result result) {
            this.result = result;
        }

    }

    public class Result implements Serializable {
        private static final long serialVersionUID = 1L;

        private ArrayList<ProductSortVO> records;

        public ArrayList<ProductSortVO> getRecords() {
            return records;
        }

        public void setRecords(ArrayList<ProductSortVO> records) {
            this.records = records;
        }

    }
}
