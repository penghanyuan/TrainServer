package bit.controller;

import bit.facade.ServerFacade;
import bit.function.MyFunction;
import bit.jsonmodel.JsonOrder;
import bit.model.Order;
import bit.model.Server;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by penghanyuan on 16/4/11.
 */
@Controller
@RequestMapping("/serverController")
public class ServerController {
    @Autowired
    ServerFacade serverFacade;
    @Autowired
    MyFunction myFunction;
    @RequestMapping(value = "/ServerSignUp", method = RequestMethod.POST)
    @ResponseBody
    public int ServerSignUp(@RequestBody JSONObject jsonObject) {
        System.out.println(jsonObject);
        int t= this.serverFacade.signUp(myFunction.verfiyServer(jsonObject));
        return t;
    }

    @RequestMapping(value = "/ServerLogIn", method = RequestMethod.POST)
    @ResponseBody
    public int ServerLogIn(@RequestBody JSONObject jsonObject) {
        System.out.println(jsonObject);
        int t= this.serverFacade.logIn(jsonObject.getString("username"),jsonObject.getString("password"));
        return t;
    }
    @RequestMapping(value = "{serverid}/{clientid}/ServerCode", method = RequestMethod.GET)
    @ResponseBody
    public int ServerCode(@PathVariable String serverid,@PathVariable String clientid) {
        int t = serverFacade.setPushCid(clientid,serverid);
        return t;
    }
    @RequestMapping(value = "{serverid}/GetServer", method = RequestMethod.GET)
    @ResponseBody
    public Server GetServer(@PathVariable String serverid) {

        return serverFacade.getSrver(Integer.valueOf(serverid));
    }
}
