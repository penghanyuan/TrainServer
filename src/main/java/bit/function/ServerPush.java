package bit.function;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.AppMessage;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.TransmissionTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vivid on 2016/5/7.
 */
@Component("serverPush")
public class ServerPush {
    //定义常量, appId、appKey、masterSecret 采用本文档 "第二步 获取访问凭证 "中获得的应用配置
    private static String appId = "RwyfyXk6elAGNXZIj3m6F8";
    private static String appKey = "3tkvZJyreD7rCEK06SbOi4";
    private static String masterSecret = "mvIxTgDuAD9JwjwZOij5x9";
    private static String url = "http://sdk.open.api.igexin.com/apiex.htm";

    public static TransmissionTemplate transmissionTemplateDemo(Integer orderid) {
        TransmissionTemplate template = new TransmissionTemplate();
        template.setAppId(appId);
        template.setAppkey(appKey);
        // 透传消息设置，1为强制启动应用，客户端接收到消息后就会立即启动应用；2为等待应用启动
        template.setTransmissionType(2);
        template.setTransmissionContent(orderid.toString());
        // 设置定时展示时间
        // template.setDuration("2015-01-16 11:40:00", "2015-01-16 12:24:00");
        return template;
    }

    public void push(Integer orderid) throws IOException {
        IGtPush push = new IGtPush(url, appKey, masterSecret);
        push.connect();

        List<String> appIds = new ArrayList<String>();
        appIds.add(appId);

        // 定义"AppMessage"类型消息对象，设置消息内容模板、发送的目标App列表、是否支持离线发送、以及离线消息有效期(单位毫秒)
        AppMessage message = new AppMessage();
        message.setData(MyAndroidPush.transmissionTemplateDemo(orderid));
        message.setAppIdList(appIds);
        message.setOffline(true);
        message.setOfflineExpireTime(1000 * 600);

        IPushResult ret = push.pushMessageToApp(message);
        System.out.println(ret.getResponse().toString());
    }
}

