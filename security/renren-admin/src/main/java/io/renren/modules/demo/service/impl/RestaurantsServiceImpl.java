package io.renren.modules.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.common.service.impl.CrudServiceImpl;
import io.renren.modules.demo.dao.RestaurantsDao;
import io.renren.modules.demo.dto.RestaurantsDTO;
import io.renren.modules.demo.entity.RestaurantsEntity;
import io.renren.modules.demo.service.RestaurantsService;
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
public class RestaurantsServiceImpl extends CrudServiceImpl<RestaurantsDao, RestaurantsEntity, RestaurantsDTO> implements RestaurantsService {

    @Override
    public QueryWrapper<RestaurantsEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<RestaurantsEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}