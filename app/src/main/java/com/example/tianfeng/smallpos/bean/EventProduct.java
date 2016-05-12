package com.example.tianfeng.smallpos.bean;

import com.example.tianfeng.smallpos.base.ProductVO;

/**
 * Created by admin on 2016-05-12.
 */
public class EventProduct {

    private ProductVO productVO;

    public EventProduct(ProductVO productVO) {
        super();
        this.productVO = productVO;
    }

    public ProductVO getProductVO() {
        return productVO;
    }

    public void setProductVO(ProductVO productVO) {
        this.productVO = productVO;
    }

}

