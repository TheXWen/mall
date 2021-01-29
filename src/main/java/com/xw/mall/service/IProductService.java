package com.xw.mall.service;

import com.github.pagehelper.PageInfo;
import com.xw.mall.vo.ProductDetailVo;
import com.xw.mall.vo.ResponseVo;

public interface IProductService {
    ResponseVo<PageInfo> list(Integer categoryId, Integer pageNum, Integer pageSize);

    ResponseVo<ProductDetailVo> detail(Integer productId);
}
