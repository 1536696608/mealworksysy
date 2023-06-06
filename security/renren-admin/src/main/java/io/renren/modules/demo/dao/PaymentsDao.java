package io.renren.modules.demo.dao;

import io.renren.common.dao.BaseDao;
import io.renren.modules.demo.entity.PaymentsEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-06-01
 */
@Mapper
public interface PaymentsDao extends BaseDao<PaymentsEntity> {
	
}