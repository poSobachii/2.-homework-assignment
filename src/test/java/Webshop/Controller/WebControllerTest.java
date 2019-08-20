package Webshop.Controller;

import Webshop.DatabaseDAO.DatabaseDAO;
import Webshop.H2database.OneWareInfoPrint;
import Webshop.PdfHandler.PDFConverter;
import org.springframework.core.io.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebControllerTest {

    @InjectMocks
    WebController webController;

    @Mock
    Resource resource;
    @Mock
    DatabaseDAO dbase;
    @Mock
    OneWareInfoPrint oneWareInfoPrint;
    @Mock
    PDFConverter pdfConverter;
    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void welcomeTest() {
        String returned = webController.welcome();
        assertEquals(returned, "homePage");
    }

    @Test
    void wareContentTest(){
        when(request.getParameter("ware")).thenReturn("allWares");
        when(dbase.getAllWares("allWares")).thenReturn(null);
        String returned = webController.wareContent(request, response);
        assertEquals(returned, "waresPage");
    }

    @Test
    void oneWareInfoTest(){
        when(request.getParameter("wareGroup")).thenReturn("wareGroup");
        when(request.getParameter("wareID")).thenReturn("1");
        String returned = webController.oneWareInfo(request, response);
        assertEquals(returned, "oneWareInfoPage");
    }

    @Test
    void basketTest(){
        String returned = webController.Basket();
        assertEquals(returned, "basket");
    }

    @Test
    void getPdfTest(){
        when(pdfConverter.handleRequest()).thenReturn(resource);
        ResponseEntity<Resource> returned = webController.getPdf();

    }
}
