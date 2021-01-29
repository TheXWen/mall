package com.xw.mall.service.impl;

import com.github.pagehelper.PageInfo;
import com.xw.mall.MallApplicationTests;
import com.xw.mall.enums.ResponseEnum;
import com.xw.mall.form.ShippingForm;
import com.xw.mall.service.IShippingService;
import com.xw.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Transactional
@Slf4j
public class ShippingServiceImplTest extends MallApplicationTests {

    @Autowired
    private IShippingService shippingService;

    private Integer uid = 1;

    private Integer shippingId;

    @Before
    public void add() {
        ShippingForm form = new ShippingForm();
        form.setReceiverName("hxw");
        form.setReceiverCity("广东省");
        form.setReceiverAddress("广州市");
        form.setReceiverPhone("13658987458");
        ResponseVo<Map<String, Integer>> responseVo = shippingService.add(uid, form);
        this.shippingId = responseVo.getData().get("shippingId");
        log.info("result={}", responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void delete() {
        ResponseVo responseVo = shippingService.delete(uid, shippingId);
        log.info("result={}", responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void update() {
    }

    @Test
    public void list() {
        ResponseVo<PageInfo> list = shippingService.list(uid, 1, 1);
        log.info("result={}", list);
    }
}