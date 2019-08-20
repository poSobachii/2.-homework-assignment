package Webshop.Controller;

import Webshop.DatabaseDAO.DatabaseDAO;
import Webshop.H2database.OneWareInfoPrint;
import Webshop.H2database.PrintContent;
import Webshop.PDfHandler.PDFConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class WebController {

    @Inject
    DatabaseDAO dbase;
    @Autowired
    PrintContent printContent;
    @Autowired
    OneWareInfoPrint oneWareInfoPrint;
    @Autowired
    PDFConverter pdfConverter;

    @RequestMapping(value= {"/", "home"})
    public String welcome() {
        return "homePage";
    }

    @RequestMapping(value = "/wareContent", method = RequestMethod.GET)
    public String wareContent(HttpServletRequest request, HttpServletResponse response) {
        printContent.PrintWares(dbase.getAllWares(request.getParameter("ware")));
        return "waresPage";

    }

    @RequestMapping(value = "/wareInfo", method = RequestMethod.GET)
    public String oneWareInfo(HttpServletRequest request, HttpServletResponse response) {
        String temp = request.getParameter("wareGroup");
        Long wareID = Long.parseLong(request.getParameter("wareID"));
        oneWareInfoPrint.oneWareInfo(dbase.getOneItem(temp, wareID));
        return "oneWareInfoPage";
    }

    @RequestMapping("/basket")
    public String Basket() {
        return "basket";
    }

    @PostMapping("/pdf")
    public ResponseEntity<Resource> getPdf(){
        Resource file = pdfConverter.handleRequest();
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
}
