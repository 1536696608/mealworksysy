package io.renren.modules.demo.service;

import io.renren.common.service.CrudService;
import io.renren.modules.demo.dto.EmployeesDTO;
import io.renren.modules.demo.entity.EmployeesEntity;

/**
 * 员工管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-05-31
 */
public interface EmployeesService extends CrudService<EmployeesEntity, EmployeesDTO> {

}