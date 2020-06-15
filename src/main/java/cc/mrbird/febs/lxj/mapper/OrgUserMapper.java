package cc.mrbird.febs.lxj.mapper;


import cc.mrbird.febs.lxj.entity.OrgUser;
import cc.mrbird.febs.lxj.entity.OrgUserByPlus;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  Mapper
 *
 * @author ZhengShiHao
 * @date 2020-05-26 16:04:25
 */
public interface OrgUserMapper extends BaseMapper<OrgUserByPlus> {


    List<OrgUserByPlus> selectUsersBydeptIdAndPosition(List<String> deptIds, String position);

    List<String> selectPositionList();

    List<String> selectPositionListByDept(@Param("deptIds") List<String> deptIds);
}
