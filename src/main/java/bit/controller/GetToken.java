package bit.controller;

import bit.model.Client;
import bit.service.ClientService;
import com.alibaba.druid.support.json.JSONParser;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * Created by vivid on 2016/4/18.
 */
@Controller
@RequestMapping("/GetToken")
public class GetToken {
    @Autowired
    private ClientService clientService;
    @RequestMapping("/{id}/getToken")
    @ResponseBody
    public String getToken(@PathVariable String id, HttpServletRequest request) {

        HttpURLConnection urlConnection  = null;
        // 发送请求
        try
        {
            URL url = new URL("https://api.cn.ronghub.com/user/getToken.json");
            urlConnection =(HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setUseCaches(false);
            String appkey,nonce,timestamp,signature;
            appkey="8brlm7ufrnaa3";
            nonce= new Random().nextInt(1000)+"";
            timestamp=System.currentTimeMillis()/1000+"";
            urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            urlConnection.setRequestProperty("POST", "/user/getToken.json HTTP/1.1");
            urlConnection.setRequestProperty("Host", "api.cn.ronghub.com");
            urlConnection.setRequestProperty("App-Key", appkey);
            urlConnection.setRequestProperty("Nonce", nonce);
            urlConnection.setRequestProperty("Timestamp", timestamp);
            signature="1uArJx7xNt4wx"+nonce+timestamp;
            try {
                signature=sha1(signature);
            }catch (NoSuchAlgorithmException e)
            {
                e.printStackTrace();
            }
            urlConnection.setRequestProperty("Signature",signature );
            urlConnection.connect();
            DataOutputStream out = new DataOutputStream(urlConnection.getOutputStream());
            // The URL-encoded contend
            // 正文，正文内容其实跟get的URL中 '? '后的参数字符串一致
            String content = "userId=" + URLEncoder.encode(id, "UTF-8");
            content +="&name=" + URLEncoder.encode("", "UTF-8");
            content +="&portraitUri=" + URLEncoder.encode("", "UTF-8");
            // DataOutputStream.writeBytes将字符串中的16位的unicode字符以8位的字符形式写到流里面
            out.writeBytes(content);

            out.flush();
            out.close();
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null){
               // System.out.println(line);

                return line;
            }

            reader.close();
            urlConnection.disconnect();

        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            urlConnection.disconnect();
        }
//        Client c = new Client();
//        c.setClientName("vivid");
//        request.setAttribute("user", c);
        return "index";

    }
    /**
     *     HAS1加密
      */
    public static String sha1(String data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA1");
        md.update(data.getBytes());
       StringBuffer buf = new StringBuffer();
         byte[] bits = md.digest();
        for(int i=0;i<bits.length;i++){
            int a = bits[i];
            if(a<0) a+=256;
            if(a<16) buf.append("0");
            buf.append(Integer.toHexString(a));
        }
        return buf.toString();
    }

}
