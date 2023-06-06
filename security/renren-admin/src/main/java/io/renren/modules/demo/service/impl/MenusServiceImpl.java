package io.renren.modules.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.common.service.impl.CrudServiceImpl;
import io.renren.modules.demo.dao.MenusDao;
import io.renren.modules.demo.dto.MenusDTO;
import io.renren.modules.demo.entity.MenusEntity;
import io.renren.modules.demo.service.MenusService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-05-30
 */
@Service
public class MenusServiceImpl extends CrudServiceImpl<MenusDao, MenusEntity, MenusDTO> implements MenusService {

    @Override
    public QueryWrapper<MenusEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<MenusEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}