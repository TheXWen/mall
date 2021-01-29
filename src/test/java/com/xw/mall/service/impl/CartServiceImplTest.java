package com.xw.mall.service.impl;

import com.xw.mall.MallApplicationTests;
import com.xw.mall.form.CartAddForm;
import com.xw.mall.service.ICartService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CartServiceImplTest extends MallApplicationTests {

    @Autowired
    private ICartService cartService;

    @Test
    public void add() {
        CartAddForm form = new CartAddForm();
        form.setProductId(26);
        form.setSelected(true);
        cartService.add(1, form);
    }
}