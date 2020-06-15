package cc.mrbird.febs.lxj.service.impl;


import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.lxj.entity.OrgUserByPlus;
import cc.mrbird.febs.lxj.mapper.OrgUserMapper;
import cc.mrbird.febs.lxj.service.IOrgUserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *  Service实现
 *
 * @author ZhengShiHao
 * @date 2020-05-26 16:04:25
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class OrgUserServiceImpl extends ServiceImpl<OrgUserMapper, OrgUserByPlus> implements IOrgUserService {

    @Autowired
    private OrgUserMapper orgUserMapper;

    @Override
    public IPage<OrgUserByPlus> findOrgUsers(QueryRequest request, OrgUserByPlus orgUserByPlus) {
        LambdaQueryWrapper<OrgUserByPlus> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<OrgUserByPlus> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<OrgUserByPlus> findOrgUsers(OrgUserByPlus orgUserByPlus) {
	    LambdaQueryWrapper<OrgUserByPlus> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件

		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createOrgUser(OrgUserByPlus orgUserByPlus) {
        this.save(orgUserByPlus);
    }

    @Override
    @Transactional
    public void updateOrgUser(OrgUserByPlus orgUserByPlus) {
        this.saveOrUpdate(orgUserByPlus);
    }

    @Override
    @Transactional
    public void deleteOrgUser(OrgUserByPlus orgUserByPlus) {
        LambdaQueryWrapper<OrgUserByPlus> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wrapper);
	}

    @Override
    @Transactional
    public List<OrgUserByPlus> selectUsersBydeptIdAndPosition(List<String> deptIds, String position) {
        return orgUserMapper.selectUsersBydeptIdAndPosition(deptIds,position);
    }

    @Override
    public List<String> selectPositionList() {
        return orgUserMapper.selectPositionList();
    }

    @Override
    public List<String> selectPositionListByDept(List<String> deptIds) {
        return orgUserMapper.selectPositionListByDept(deptIds);
    }
}
