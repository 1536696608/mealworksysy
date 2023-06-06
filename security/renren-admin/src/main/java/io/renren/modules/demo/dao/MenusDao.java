package io.renren.modules.demo.dao;

import io.renren.common.dao.BaseDao;
import io.renren.modules.demo.entity.MenusEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-05-30
 */
@Mapper
public interface MenusDao extends BaseDao<MenusEntity> {
	
}