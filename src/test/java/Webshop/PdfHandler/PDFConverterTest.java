package Webshop.PdfHandler;

import Webshop.BasketPack.BasketOrder;
import Webshop.Entities.Balloons;
import Webshop.WareTemplates.BasicWare;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.io.Resource;
import org.springframework.test.util.ReflectionTestUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;


public class PDFConverterTest {


    List<BasicWare> wareList = new ArrayList<>();
    BasicWare basicWare;

    @InjectMocks
    PDFConverter pdfConverter;
    @Mock
    BasketOrder basketOrder;
    @Mock
    BasicWare basicWareMock;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(pdfConverter, "basketOrder", basketOrder);
        basicWare = new Balloons(Long.valueOf(1501), "WareName", 10.99, "10", "WareDescription" );
        wareList.add(basicWare);
    }

    @Test
    void prepareDocumentTest() throws IOException {
        Files.deleteIfExists(Paths.get("uPDFfiles/order.pdf"));
        when(basketOrder.getWareList()).thenReturn(wareList);
        pdfConverter.prepareDocument();
        File file = new File("uPDFfiles");
        assertTrue(file.list().length > 0);
    }

    @Test
    void throwOutDocument() {
        when(basketOrder.getWareList()).thenReturn(wareList);
        pdfConverter.prepareDocument();
        Resource resource = pdfConverter.throwOutDocument();
        assertEquals(resource.getFilename(), "order.pdf");
    }

}
