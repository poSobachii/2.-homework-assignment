package webshop.pdf.handler;

import webshop.basket.BasketOrder;
import webshop.ware.templates.BasicWare;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class PDFConverter {

    @Autowired
    BasketOrder basketOrder;

    public Resource handleRequest(){
        prepareDocument();
        return throwOutDocument();
    }

    public void prepareDocument(){
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("uPDFfiles/order.pdf"));
            document.open();
            for (BasicWare e: basketOrder.getWareList()) {
                Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
                Chunk chunk = new Chunk(e.getWareName(), font);
                Image img = Image.getInstance(new File("src/main/webapp/pics/" + e.getClass().getSimpleName() + "/" + e.getId() + ".png").getAbsolutePath());
                document.add(img);
                document.add(chunk);
            }

            document.close();
        } catch (DocumentException | IOException e) {
            System.out.println(e);
        }

    }

    public Resource throwOutDocument(){
        try {
            Path file = Paths.get("uPDFfiles").resolve("order.pdf");
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }
        }
        catch (MalformedURLException e) {
            System.out.println(e);
        }
        return null;
    }
}
