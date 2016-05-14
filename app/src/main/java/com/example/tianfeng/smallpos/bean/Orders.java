package com.example.tianfeng.smallpos.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by admin on 2016-05-14.
 * 订单类
 * 用于将订单参数传递给后台
 */
public class Orders implements Serializable {

    /**
     * amount_paid : 200
     * amount_return : 50
     * amount_tota : 150
     * lines : [{"price_unit":30,"product_id":1,"qty":5}]
     * name : testorde32321345
     * pos_session_id : session_id
     * statement_ids : [{"amount":150,"journal_id":8,"name":"2016-05-11 7:16:14","statement_id":240}]
     * terminal : QWERTYUI
     * user_id : 1
     */

    private List<OrdersBean> orders;

    public List<OrdersBean> getOrders() {
        return orders;
    }

    public void setOrders(List<OrdersBean> orders) {
        this.orders = orders;
    }

    public static class OrdersBean {
        private int amount_paid;
        private int amount_return;
        private int amount_tota;
        private String name;
        private String pos_session_id;
        private String terminal;
        private int user_id;
        /**
         * price_unit : 30
         * product_id : 1
         * qty : 5
         */

        private List<LinesBean> lines;
        /**
         * amount : 150
         * journal_id : 8
         * name : 2016-05-11 7:16:14
         * statement_id : 240
         */

        private List<StatementIdsBean> statement_ids;

        public int getAmount_paid() {
            return amount_paid;
        }

        public void setAmount_paid(int amount_paid) {
            this.amount_paid = amount_paid;
        }

        public int getAmount_return() {
            return amount_return;
        }

        public void setAmount_return(int amount_return) {
            this.amount_return = amount_return;
        }

        public int getAmount_tota() {
            return amount_tota;
        }

        public void setAmount_tota(int amount_tota) {
            this.amount_tota = amount_tota;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPos_session_id() {
            return pos_session_id;
        }

        public void setPos_session_id(String pos_session_id) {
            this.pos_session_id = pos_session_id;
        }

        public String getTerminal() {
            return terminal;
        }

        public void setTerminal(String terminal) {
            this.terminal = terminal;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public List<LinesBean> getLines() {
            return lines;
        }

        public void setLines(List<LinesBean> lines) {
            this.lines = lines;
        }

        public List<StatementIdsBean> getStatement_ids() {
            return statement_ids;
        }

        public void setStatement_ids(List<StatementIdsBean> statement_ids) {
            this.statement_ids = statement_ids;
        }

        public static class LinesBean {
            private int price_unit;
            private int product_id;
            private int qty;

            public int getPrice_unit() {
                return price_unit;
            }

            public void setPrice_unit(int price_unit) {
                this.price_unit = price_unit;
            }

            public int getProduct_id() {
                return product_id;
            }

            public void setProduct_id(int product_id) {
                this.product_id = product_id;
            }

            public int getQty() {
                return qty;
            }

            public void setQty(int qty) {
                this.qty = qty;
            }
        }

        public static class StatementIdsBean {
            private int amount;
            private int journal_id;
            private String name;
            private int statement_id;

            public int getAmount() {
                return amount;
            }

            public void setAmount(int amount) {
                this.amount = amount;
            }

            public int getJournal_id() {
                return journal_id;
            }

            public void setJournal_id(int journal_id) {
                this.journal_id = journal_id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getStatement_id() {
                return statement_id;
            }

            public void setStatement_id(int statement_id) {
                this.statement_id = statement_id;
            }
        }
    }
}
