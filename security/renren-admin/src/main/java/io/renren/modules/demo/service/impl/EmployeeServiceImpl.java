package io.renren.modules.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.common.service.impl.CrudServiceImpl;
import io.renren.modules.demo.dao.EmployeeDao;
import io.renren.modules.demo.dto.EmployeeDTO;
import io.renren.modules.demo.entity.EmployeeEntity;
import io.renren.modules.demo.service.EmployeeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 工人管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-05-31
 */
@Service
public class EmployeeServiceImpl extends CrudServiceImpl<EmployeeDao, EmployeeEntity, EmployeeDTO> implements EmployeeService {

    @Override
    public QueryWrapper<EmployeeEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<EmployeeEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}