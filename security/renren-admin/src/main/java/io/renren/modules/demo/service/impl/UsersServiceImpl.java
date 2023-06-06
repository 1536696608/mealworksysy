package io.renren.modules.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.common.service.impl.CrudServiceImpl;
import io.renren.modules.demo.dao.UsersDao;
import io.renren.modules.demo.dto.UsersDTO;
import io.renren.modules.demo.entity.UsersEntity;
import io.renren.modules.demo.service.UsersService;
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
public class UsersServiceImpl extends CrudServiceImpl<UsersDao, UsersEntity, UsersDTO> implements UsersService {

    @Override
    public QueryWrapper<UsersEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<UsersEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}