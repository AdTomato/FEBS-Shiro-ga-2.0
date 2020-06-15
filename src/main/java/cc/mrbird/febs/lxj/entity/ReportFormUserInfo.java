package cc.mrbird.febs.lxj.entity;


import lombok.Data;

@Data
public class ReportFormUserInfo {
    //@ExcelProperty("姓名")
    private String name;
    //@ExcelProperty("职位")
    private String duty;

    //@ExcelProperty("出勤天数")
    //出勤天数
    private double attendance_days;
    //@ExcelProperty("旷工天数")
    private int absenteeism_days;//旷工天数
    //@ExcelProperty("缺卡次数")
    private int work_lack_card_times;//缺卡次数
    //@ExcelProperty("迟到次数")
    private int late_times;//迟到次数
    //@ExcelProperty("早退次数")
    private int leave_early_times;//早退次数
    //@ExcelProperty("补卡次数")
    private int making_up_lack_times;//补卡次数



}
