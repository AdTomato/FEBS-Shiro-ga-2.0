package cc.mrbird.febs.lxj.entity;

import lombok.Data;

import java.util.List;

@Data
public class ReportFormCondition {
    private String startDate;
    private String endDate;
    private String position;
    private String[] departmentIds;
    private String departmentName;
    private String[] includeColumn;

}
