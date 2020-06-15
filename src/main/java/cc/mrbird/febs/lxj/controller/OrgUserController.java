package cc.mrbird.febs.lxj.controller;


import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.lxj.entity.OrgUserByPlus;
import cc.mrbird.febs.lxj.service.IOrgUserService;
import com.wuwenze.poi.ExcelKit;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 *  Controller
 *
 * @author ZhengShiHao
 * @date 2020-05-26 16:04:25
 */
@Slf4j
@Validated
@Controller
public class OrgUserController extends BaseController {

    @Autowired
    private IOrgUserService orgUserService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "orgUser")
    public String orgUserIndex(){
        return FebsUtil.view("orgUser/orgUser");
    }

    @GetMapping("orgUser")
    @ResponseBody
    @RequiresPermissions("orgUserByPlus:list")
    public FebsResponse getAllOrgUsers(OrgUserByPlus orgUserByPlus) {
        return new FebsResponse().success().data(orgUserService.findOrgUsers(orgUserByPlus));
    }

    @GetMapping("orgUser/list")
    @ResponseBody
    @RequiresPermissions("orgUserByPlus:list")
    public FebsResponse orgUserList(QueryRequest request, OrgUserByPlus orgUserByPlus) {
        Map<String, Object> dataTable = getDataTable(this.orgUserService.findOrgUsers(request, orgUserByPlus));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增OrgUser", exceptionMessage = "新增OrgUser失败")
    @PostMapping("orgUser")
    @ResponseBody
    @RequiresPermissions("orgUserByPlus:add")
    public FebsResponse addOrgUser(@Valid OrgUserByPlus orgUserByPlus) {
        this.orgUserService.createOrgUser(orgUserByPlus);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除OrgUser", exceptionMessage = "删除OrgUser失败")
    @GetMapping("orgUser/delete")
    @ResponseBody
    @RequiresPermissions("orgUserByPlus:delete")
    public FebsResponse deleteOrgUser(OrgUserByPlus orgUserByPlus) {
        this.orgUserService.deleteOrgUser(orgUserByPlus);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改OrgUser", exceptionMessage = "修改OrgUser失败")
    @PostMapping("orgUser/update")
    @ResponseBody
    @RequiresPermissions("orgUserByPlus:update")
    public FebsResponse updateOrgUser(OrgUserByPlus orgUserByPlus) {
        this.orgUserService.updateOrgUser(orgUserByPlus);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改OrgUser", exceptionMessage = "导出Excel失败")
    @PostMapping("orgUser/excel")
    @ResponseBody
    @RequiresPermissions("orgUserByPlus:export")
    public void export(QueryRequest queryRequest, OrgUserByPlus orgUserByPlus, HttpServletResponse response) {
        List<OrgUserByPlus> orgUserByPluses = this.orgUserService.findOrgUsers(queryRequest, orgUserByPlus).getRecords();
        ExcelKit.$Export(OrgUserByPlus.class, response).downXlsx(orgUserByPluses, false);
    }

}
