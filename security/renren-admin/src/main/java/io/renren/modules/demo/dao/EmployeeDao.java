package io.renren.modules.demo.dao;

import io.renren.common.dao.BaseDao;
import io.renren.modules.demo.entity.EmployeeEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 工人管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-05-31
 */
@Mapper
public interface EmployeeDao extends BaseDao<EmployeeEntity> {
	
}