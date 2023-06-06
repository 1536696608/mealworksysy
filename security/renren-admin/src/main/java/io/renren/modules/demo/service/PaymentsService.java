package io.renren.modules.demo.service;

import io.renren.common.service.CrudService;
import io.renren.modules.demo.dto.PaymentsDTO;
import io.renren.modules.demo.entity.PaymentsEntity;

/**
 * 订单管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-06-01
 */
public interface PaymentsService extends CrudService<PaymentsEntity, PaymentsDTO> {

}