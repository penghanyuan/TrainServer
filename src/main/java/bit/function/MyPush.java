package bit.function;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.AppMessage;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.base.payload.APNPayload;
import com.gexin.rp.sdk.exceptions.RequestException;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.APNTemplate;
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

    private static String appIdC = "HMaetPwKjl5PAF2P00S8Z8";
    private static String appKeyC = "lxqrlrnGN0A3ZVIrmRRkj3";
    private static String masterSecretC = "LtuBhq4HEh7KIcLkydKlz3";

    public static TransmissionTemplate getTemplate(Integer orderid,String aid,String akey) {
        TransmissionTemplate template = new TransmissionTemplate();
        template.setAppId(aid);
        template.setAppkey(akey);
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

    public void push(Integer orderid,List<String> cids) throws IOException {

        IGtPush push = new IGtPush(url, appKey, masterSecret);


        List<String> appIds = new ArrayList<String>();
        appIds.add(appId);

        // 定义"AppMessage"类型消息对象，设置消息内容模板、发送的目标App列表、是否支持离线发送、以及离线消息有效期(单位毫秒)
        SingleMessage message = new SingleMessage();
        message.setData(MyPush.getTemplate(orderid,appId,appKey));
       // message.setAppId(appIds);
        message.setOffline(true);
        message.setOfflineExpireTime(1000 * 600);

       // IPushResult ret = push.pushMessageToApp(message);
      //  System.out.println(ret.getResponse().toString());

        // 可选，1为wifi，0为不限制网络环境。根据手机处于的网络情况，决定是否下发
        message.setPushNetWorkType(0);
        for(int i = 0;i<cids.size();i++) {
            Target target = new Target();
            target.setAppId(appId);
            target.setClientId(cids.get(i));
            //target.setAlias(Alias);
            IPushResult ret = null;
            try {
                ret = push.pushMessageToSingle(message, target);
            } catch (RequestException e) {
                e.printStackTrace();
                ret = push.pushMessageToSingle(message, target, e.getRequestId());
            }
            if (ret != null) {
                System.out.println(ret.getResponse().toString());
            } else {
                System.out.println("服务器响应异常");
            }
        }
    }

    public void push(Integer orderid) throws IOException {

        IGtPush push = new IGtPush(url, appKeyC, masterSecretC);


        // 定义"AppMessage"类型消息对象，设置消息内容模板、发送的目标App列表、是否支持离线发送、以及离线消息有效期(单位毫秒)
        SingleMessage message = new SingleMessage();

        // 定义"AppMessage"类型消息对象，设置消息内容模板、发送的目标App列表、是否支持离线发送、以及离线消息有效期(单位毫秒)

        message.setData(MyPush.getTemplate(orderid,appIdC,appKeyC));
        // message.setAppId(appIds);
        message.setOffline(true);
        message.setOfflineExpireTime(1000 * 600);

        // IPushResult ret = push.pushMessageToApp(message);
        //  System.out.println(ret.getResponse().toString());

        // 可选，1为wifi，0为不限制网络环境。根据手机处于的网络情况，决定是否下发
        message.setPushNetWorkType(0);

        Target target = new Target();
        target.setAppId(appIdC);
        target.setClientId("5a24bc9db732271cd380c463160ad2a8");
        //target.setAlias(Alias);
        IPushResult ret = null;
        try {
            ret = push.pushMessageToSingle(message, target);
        } catch (RequestException e) {
            e.printStackTrace();
            ret = push.pushMessageToSingle(message, target, e.getRequestId());
        }
        if (ret != null) {
            System.out.println(ret.getResponse().toString());
        } else {
            System.out.println("服务器响应异常");
        }

    }

    public static TransmissionTemplate getTemplate() {
        TransmissionTemplate template = new TransmissionTemplate();
        template.setAppId(appIdC);
        template.setAppkey(appKeyC);
        template.setTransmissionContent("透传内容");
        template.setTransmissionType(2);
        APNPayload payload = new APNPayload();
        payload.setBadge(1);
        payload.setContentAvailable(1);
        payload.setSound("default");
        payload.setCategory("$由客户端定义");
        //简单模式APNPayload.SimpleMsg
        payload.setAlertMsg(new APNPayload.SimpleAlertMsg("hello"));
        //字典模式使用下者
        //payload.setAlertMsg(getDictionaryAlertMsg());
        template.setAPNInfo(payload);
        return template;
    }
    private static APNPayload.DictionaryAlertMsg getDictionaryAlertMsg(){
        APNPayload.DictionaryAlertMsg alertMsg = new APNPayload.DictionaryAlertMsg();
        alertMsg.setBody("body");
        alertMsg.setActionLocKey("ActionLockey");
        alertMsg.setLocKey("LocKey");
        alertMsg.addLocArg("loc-args");
        alertMsg.setLaunchImage("launch-image");
        // IOS8.2以上版本支持
        alertMsg.setTitle("Title");
        alertMsg.setTitleLocKey("TitleLocKey");
        alertMsg.addTitleLocArg("TitleLocArg");
        return alertMsg;
    }

    public void pushAPN(){
        IGtPush push = new IGtPush(url, appKeyC, masterSecretC);
        TransmissionTemplate template = getTemplate();
        SingleMessage message = new SingleMessage();
        message.setOffline(true);
        // 离线有效时间，单位为毫秒，可选
        message.setOfflineExpireTime(24 * 3600 * 1000);
        message.setData(template);
        // 可选，1为wifi，0为不限制网络环境。根据手机处于的网络情况，决定是否下发
        message.setPushNetWorkType(0);
        Target target = new Target();
        target.setAppId(appIdC);
        target.setClientId("5a24bc9db732271cd380c463160ad2a8");
        //target.setAlias(Alias);
        IPushResult ret = null;
        try {
            ret = push.pushMessageToSingle(message, target);
        } catch (RequestException e) {
            e.printStackTrace();
            ret = push.pushMessageToSingle(message, target, e.getRequestId());
        }
        if (ret != null) {
            System.out.println(ret.getResponse().toString());
        } else {
            System.out.println("服务器响应异常");
        }

    }

}