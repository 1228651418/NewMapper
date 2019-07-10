package com.jyx.edu.NewMapper180831.service.impl;

import com.jyx.edu.NewMapper180831.basemapper.mapper.DepartmentMapper;
import com.jyx.edu.NewMapper180831.entity.SysDepartment;
import com.jyx.edu.NewMapper180831.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public  class DepartmentServiceImpl extends BaseServiceImpl<SysDepartment> implements DepartmentService {

    @Autowired
    private DepartmentMapper mapper;


    /**
     * 一般只需多表操作代码
     */

}
