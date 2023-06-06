package io.renren.modules.demo.dao;

import io.renren.common.dao.BaseDao;
import io.renren.modules.demo.entity.EmployeesEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 员工管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-05-31
 */
@Mapper
public interface EmployeesDao extends BaseDao<EmployeesEntity> {
	
}