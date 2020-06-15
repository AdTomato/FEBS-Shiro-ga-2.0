package cc.mrbird.febs.lxj;

import cc.mrbird.febs.lxj.utils.DateRange;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiAttendanceGetattcolumnsRequest;
import com.dingtalk.api.request.OapiAttendanceGetcolumnvalRequest;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.response.OapiAttendanceGetattcolumnsResponse;
import com.dingtalk.api.response.OapiAttendanceGetcolumnvalResponse;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.taobao.api.ApiException;
import com.taobao.api.internal.util.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ResourceBundle;

@SpringBootTest
class SpringBootApplicationTests {

    @Test
    void contextLoads() throws ApiException, ParseException {
        ResourceBundle rb = ResourceBundle.getBundle("dingding");
        String appKey = rb.getString("AppKey");
        String appSecret = rb.getString("AppSecret");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateRange d = new DateRange(df.parse("2018-08-04 13:05:06"), df.parse("2019-06-05 12:25:36"));
        List<DateRange> list = d.splitByMonth();
        list.forEach(x -> System.out.println("start=" + df.format(x.getStart()) + ", end=" + df.format(x.getEnd())));

        DefaultDingTalkClient client1 = new DefaultDingTalkClient("https://oapi.dingtalk.com/gettoken");
        OapiGettokenRequest request = new OapiGettokenRequest();
        request.setAppkey(appKey);
        request.setAppsecret(appSecret);
        request.setHttpMethod("GET");
        OapiGettokenResponse response = client1.execute(request);
        String accessToken = response.getAccessToken();
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/attendance/getattcolumns");
        OapiAttendanceGetattcolumnsRequest req = new OapiAttendanceGetattcolumnsRequest();
        OapiAttendanceGetattcolumnsResponse rsp = client.execute(req, accessToken);
        System.out.println(rsp.getBody());
        DingTalkClient client3 = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/attendance/getcolumnval");
        OapiAttendanceGetcolumnvalRequest req3 = new OapiAttendanceGetcolumnvalRequest();
        req3.setUserid("013644493136282789");
        req3.setColumnIdList("22732335,22732323,22732357");
        req3.setFromDate(StringUtils.parseDateTime("2020-05-25 07:12:12"));
        req3.setToDate(StringUtils.parseDateTime("2020-05-25 16:47:12"));
        OapiAttendanceGetcolumnvalResponse rsp3 = client3.execute(req3, accessToken);
        JSONObject jsonObject = JSON.parseObject(rsp3.getBody());
        JSONObject result = jsonObject.getJSONObject("result");
        JSONArray column_vals = result.getJSONArray("column_vals");
        System.out.println(column_vals);
        for (Object column_val : column_vals) {
            //报表列id
            Object o = JSON.parseObject(column_val.toString()).getJSONObject("column_vo").get("id");
            System.out.println(o);
            JSONArray column_vals1 = JSON.parseObject(column_val.toString()).getJSONArray("column_vals");
            for (Object o1 : column_vals1) {
                Object date = JSON.parseObject(o1.toString()).get("date");
                Object value = JSON.parseObject(o1.toString()).get("value");
                System.out.println(date+"---"+value);


            }
        }
    }

    //王勇员工userId 2507640341938140



}


