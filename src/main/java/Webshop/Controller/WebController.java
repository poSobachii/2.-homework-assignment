package Webshop.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class WebController {

    @RequestMapping(value= {"/", "home"})
    public String welcome() {
        return "homePage";
    }

    @RequestMapping("/testTemp")
    public String testTemp() {
        return "waresPage";
    }


    @RequestMapping(value = "/wareContent", method = RequestMethod.GET)
    public String wareContent(HttpServletRequest request, HttpServletResponse response) {
        return "waresPage";

    }

    @RequestMapping(value = "/wareInfo", method = RequestMethod.GET)
    public String oneWareInfo(HttpServletRequest request, HttpServletResponse response) {
        return "oneWareInfoPage";
    }

    @RequestMapping("/basket")
    public String Basket() {
        return "basket";
    }

}
