package cc.mrbird.febs.lxj.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 *  Entity
 *
 * @author ZhengShiHao
 * @date 2020-05-26 16:04:25
 */
@Data
@TableName("org_user")
public class OrgUserByPlus {

    /**
     * id
     */
    @TableField("id")
    private String id;

    /**
     * 员工在当前企业内的唯一标识
     */
    @TableField("unionid")
    private String unionid;

    /**
     * 员工钉钉id
     */
    @TableField("sourceId")
    private String sourceid;

    /**
     * 员工钉钉部门id
     */
    @TableField("sourceDepartmentId")
    private String sourcedepartmentid;

    /**
     * 员工系统部门id
     */
    @TableField("departmentId")
    private String departmentid;

    /**
     * 部门中的排序
     */
    @TableField("sortKey")
    private String sortkey;

    /**
     * 手机号
     */
    @TableField("mobile")
    private String mobile;

    /**
     * 分机号
     */
    @TableField("tel")
    private String tel;

    /**
     * 办公地点
     */
    @TableField("workPlace")
    private String workplace;

    /**
     * 是否是企业的管理员
     */
    @TableField("isAdmin")
    private boolean isAdmin;
    /**
     * 是否为企业的老板
     */
    @TableField("isBoss")
    private boolean isBoss;
    /**
     * 是否隐藏号码
     */
    @TableField("isHide")
    private boolean isHide;
    /**
     * 是否是部门的主管
     */
    @TableField("isLeader")
    private boolean isLeader;
    /**
     * 员工名称
     */
    @TableField("name")
    private String name;

    /**
     * 是否激活了钉钉
     */
    @TableField("active")
    private Integer active;

    /**
     * 职位信息
     */
    @TableField("position")
    private String position;

    /**
     * 	
员工的邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 员工的企业邮箱
     */
    @TableField("orgEmail")
    private String orgemail;

    /**
     * 头像url
     */
    @TableField("avatar")
    private String avatar;

    /**
     * 	
员工工号
     */
    @TableField("jobnumber")
    private String jobnumber;

    /**
     * 	
入职时间
     */
    @TableField("hiredDate")
    private Date hireddate;

    /**
     * 国家地区码
     */
    @TableField("stateCode")
    private String statecode;

    /**
     * 是否显示
     */
    @TableField("isShow")
    private boolean isShow;
}
