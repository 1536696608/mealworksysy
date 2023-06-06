package io.renren.modules.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.common.service.impl.CrudServiceImpl;
import io.renren.modules.demo.dao.PaymentsDao;
import io.renren.modules.demo.dto.PaymentsDTO;
import io.renren.modules.demo.entity.PaymentsEntity;
import io.renren.modules.demo.service.PaymentsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 订单管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-06-01
 */
@Service
public class PaymentsServiceImpl extends CrudServiceImpl<PaymentsDao, PaymentsEntity, PaymentsDTO> implements PaymentsService {

    @Override
    public QueryWrapper<PaymentsEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<PaymentsEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}