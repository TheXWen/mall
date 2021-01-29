package com.xw.mall.service.impl;

import com.xw.mall.MallApplicationTests;
import com.xw.mall.service.IProductService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductServiceImplTest extends MallApplicationTests {

    @Autowired
    private IProductService productService;

    @Test
    public void list() {
        productService.list(null, 1, 1);
    }
}