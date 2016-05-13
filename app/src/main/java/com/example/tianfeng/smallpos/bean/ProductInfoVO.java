package com.example.tianfeng.smallpos.bean;

import com.example.tianfeng.smallpos.base.ProductVO;

import java.io.Serializable;

/**
 * Created by admin on 2016-05-06.
 */
public class ProductInfoVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private ProductVO productVO;

    private DiscountVO discountVO;

    private int size = 0;

    public ProductInfoVO() {
        super();
    }

    public DiscountVO getDiscountVO() {
        return discountVO;
    }

    public void setDiscountVO(DiscountVO discountVO) {
        this.discountVO = discountVO;
    }

    public ProductVO getProductVO() {
        return productVO;
    }

    public void setProductVO(ProductVO productVO) {
        this.productVO = productVO;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}

