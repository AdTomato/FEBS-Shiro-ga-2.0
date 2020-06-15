package cc.mrbird.febs.lxj.service;


import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.lxj.entity.OrgUserByPlus;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *  Service接口
 *
 * @author ZhengShiHao
 * @date 2020-05-26 16:04:25
 */
public interface IOrgUserService extends IService<OrgUserByPlus> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param orgUserByPlus orgUserByPlus
     * @return IPage<OrgUserByPlus>
     */
    IPage<OrgUserByPlus> findOrgUsers(QueryRequest request, OrgUserByPlus orgUserByPlus);

    /**
     * 查询（所有）
     *
     * @param orgUserByPlus orgUserByPlus
     * @return List<OrgUserByPlus>
     */
    List<OrgUserByPlus> findOrgUsers(OrgUserByPlus orgUserByPlus);

    /**
     * 新增
     *
     * @param orgUserByPlus orgUserByPlus
     */
    void createOrgUser(OrgUserByPlus orgUserByPlus);

    /**
     * 修改
     *
     * @param orgUserByPlus orgUserByPlus
     */
    void updateOrgUser(OrgUserByPlus orgUserByPlus);

    /**
     * 删除
     *
     * @param orgUserByPlus orgUserByPlus
     */
    void deleteOrgUser(OrgUserByPlus orgUserByPlus);
    /**
     * 根据部门ids和职位查询用户
     */
    List<OrgUserByPlus> selectUsersBydeptIdAndPosition(List<String> deptIds,String position);

    List<String> selectPositionList();

    List<String> selectPositionListByDept(List<String> deptIds);
}
