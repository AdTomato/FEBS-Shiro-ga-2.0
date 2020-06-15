package cc.mrbird.febs.lxj.service;


import cc.mrbird.febs.common.entity.DeptTree;
import cc.mrbird.febs.lxj.entity.OrgDepartment;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/**
 * @Author:wangyong
 * @Date:2020/4/17 11:53
 * @Description:
 */
public interface DepartmentService {

    List<OrgDepartment> getAllDepartment();



}
