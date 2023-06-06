package io.renren.modules.demo.service;

import io.renren.common.service.CrudService;
import io.renren.modules.demo.dto.GoodsDTO;
import io.renren.modules.demo.entity.GoodsEntity;

/**
 * 商品管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-05-31
 */
public interface GoodsService extends CrudService<GoodsEntity, GoodsDTO> {

}