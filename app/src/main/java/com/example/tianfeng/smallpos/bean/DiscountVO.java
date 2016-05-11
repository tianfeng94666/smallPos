package com.example.tianfeng.smallpos.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by admin on 2016-05-11.
 */
public class DiscountVO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String id; // ID
    private String name; // 名称
    private String discount; // 折扣值
    private String price; // 优惠价格

    public DiscountVO() {
        super();
    }

    public DiscountVO(String id, String name, String discount, String price) {
        super();
        this.id = id;
        this.name = name;
        this.discount = discount;
        this.price = price;
    }

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

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    public static class EntityDiscountVO implements Serializable {
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

        private ArrayList<DiscountVO> records;

        public ArrayList<DiscountVO> getRecords() {
            return records;
        }

        public void setRecords(ArrayList<DiscountVO> records) {
            this.records = records;
        }

    }

}

