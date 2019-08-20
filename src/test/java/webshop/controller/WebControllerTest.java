package webshop.controller;

import webshop.database.dao.DatabaseDAO;
import webshop.h2.database.OneWareInfoPrint;
import webshop.pdf.handler.PDFConverter;
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
        assertEquals( "homePage", returned);
    }

    @Test
    void wareContentTest(){
        when(request.getParameter("ware")).thenReturn("allWares");
        when(dbase.getAllWares("allWares")).thenReturn(null);
        String returned = webController.wareContent(request, response);
        assertEquals("waresPage", returned);
    }

    @Test
    void oneWareInfoTest(){
        when(request.getParameter("wareGroup")).thenReturn("wareGroup");
        when(request.getParameter("wareID")).thenReturn("1");
        String returned = webController.oneWareInfo(request, response);
        assertEquals( "oneWareInfoPage", returned);
    }

    @Test
    void basketTest(){
        String returned = webController.Basket();
        assertEquals( "basket", returned);
    }

    @Test
    void getPdfTest(){
        when(pdfConverter.handleRequest()).thenReturn(resource);
        ResponseEntity<Resource> returned = webController.getPdf();

    }
}
