package io.renren.modules.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.common.service.impl.CrudServiceImpl;
import io.renren.modules.demo.dao.EmployeesDao;
import io.renren.modules.demo.dto.EmployeesDTO;
import io.renren.modules.demo.entity.EmployeesEntity;
import io.renren.modules.demo.service.EmployeesService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 员工管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-05-31
 */
@Service
public class EmployeesServiceImpl extends CrudServiceImpl<EmployeesDao, EmployeesEntity, EmployeesDTO> implements EmployeesService {

    @Override
    public QueryWrapper<EmployeesEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<EmployeesEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}