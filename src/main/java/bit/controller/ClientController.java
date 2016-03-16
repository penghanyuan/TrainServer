package bit.controller;

import bit.model.Client;
import bit.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by penghanyuan on 16/3/15.
 */
@Controller
@RequestMapping("/clientController")
public class ClientController {
    @Autowired
    private ClientService clientService;
    @RequestMapping("/{id}/showClient")
    public String showUser(@PathVariable int id, HttpServletRequest request) {
        Client c = clientService.getClientbyId(id);
        request.setAttribute("user", c);
        return "index";
    }
}
