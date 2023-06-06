package io.renren.modules.demo.service;

import io.renren.common.service.CrudService;
import io.renren.modules.demo.dto.EmployeeDTO;
import io.renren.modules.demo.entity.EmployeeEntity;

/**
 * 工人管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-05-31
 */
public interface EmployeeService extends CrudService<EmployeeEntity, EmployeeDTO> {

}