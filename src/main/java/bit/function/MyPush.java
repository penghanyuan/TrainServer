package bit.function;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.AppMessage;
import com.gexin.rp.sdk.base.payload.APNPayload;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.LinkTemplate;
import com.gexin.rp.sdk.template.TransmissionTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component("myPush")
public class MyPush {

    //定义常量, appId、appKey、masterSecret 采用本文档 "第二步 获取访问凭证 "中获得的应用配置
    private static String appId = "mEJB3tlDuv9ikjwQs4y9gA";
    private static String appKey = "sA2qe6KNPO9pGcWrWpG1M";
    private static String masterSecret = "4aXotD76HJ6pUeDK2fqI87";
    private static String url = "http://sdk.open.api.igexin.com/apiex.htm";

    public static TransmissionTemplate getTemplate(Integer orderid) {
        TransmissionTemplate template = new TransmissionTemplate();
        template.setAppId(appId);
        template.setAppkey(appKey);
        template.setTransmissionContent("透传内容");
        template.setTransmissionType(2);
        APNPayload payload = new APNPayload();
        payload.setBadge(1);
        payload.setContentAvailable(1);
        payload.setSound("default");
        payload.setCategory("$由客户端定义");
        //简单模式APNPayload.SimpleMsg
        //payload.setAlertMsg(new APNPayload.SimpleAlertMsg("hello"));
        //字典模式使用下者
        payload.setAlertMsg(getDictionaryAlertMsg(orderid));
        template.setAPNInfo(payload);
        return template;
    }
    private static APNPayload.DictionaryAlertMsg getDictionaryAlertMsg(Integer orderid){
        APNPayload.DictionaryAlertMsg alertMsg = new APNPayload.DictionaryAlertMsg();
        alertMsg.setBody("您有新的订单哦.");
        alertMsg.setActionLocKey("查看");
        //alertMsg.setLocKey("%");
        alertMsg.addLocArg(orderid.toString());
        alertMsg.setLaunchImage("launch-image");
        // IOS8.2以上版本支持
        alertMsg.setTitle("Title");
        alertMsg.setTitleLocKey("TitleLocKey");
        alertMsg.addTitleLocArg("TitleLocArg");
        return alertMsg;
    }

    public void push(Integer orderid) throws IOException {

        IGtPush push = new IGtPush(url, appKey, masterSecret);


        List<String> appIds = new ArrayList<String>();
        appIds.add(appId);

        // 定义"AppMessage"类型消息对象，设置消息内容模板、发送的目标App列表、是否支持离线发送、以及离线消息有效期(单位毫秒)
        AppMessage message = new AppMessage();
        message.setData(MyPush.getTemplate(orderid));
        message.setAppIdList(appIds);
        message.setOffline(true);
        message.setOfflineExpireTime(1000 * 600);

        IPushResult ret = push.pushMessageToApp(message);
        System.out.println(ret.getResponse().toString());
    }
}