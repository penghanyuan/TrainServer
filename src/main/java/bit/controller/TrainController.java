package bit.controller;

import bit.facade.TrainFacade;
import bit.function.MyFunction;
import bit.jsonmodel.JsonOrder;
import bit.jsonmodel.JsonTrain;
import bit.model.Order;
import bit.model.Train;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by penghanyuan on 16/3/29.
 */
@Controller
@RequestMapping("/trainController")
public class TrainController {
    @Autowired
    TrainFacade trainFacade;
    @Autowired
    MyFunction myFunction;
    @RequestMapping("/{clientid}/showAllClientTrain")
    @ResponseBody
    public Map<String,Object> showAllClientTrain(@PathVariable int clientid, HttpServletRequest request) {
        Map<String,Object> rmap = new HashMap<String, Object>();
        List<JsonTrain> trains = myFunction.fomartTrain(this.trainFacade.showClientTrainbyClientid(clientid));
        if(trains!=null)
        {
            rmap.put("status",1);
            rmap.put("data",trains);
        }
        else {
            rmap.put("status",0);
        }
        return rmap;
    }
}
