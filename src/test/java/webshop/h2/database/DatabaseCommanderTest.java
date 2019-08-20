package webshop.h2.database;

import webshop.repositories.BalloonRepository;
import webshop.repositories.CupsRepository;
import webshop.repositories.ShirtRepository;
import webshop.repositories.ShirtV2Repository;
import webshop.ware.templates.BasicWare;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class DatabaseCommanderTest {


    @InjectMocks
    DatabaseCommander databaseCommander;

    @Mock
    BasicWare basicWare;
    @Mock
    JpaRepository jpaRepository;
    @Mock
    ShirtRepository shirtRepository;
    @Mock
    ShirtV2Repository shirtV2Repository;
    @Mock
    CupsRepository cupsRepository;
    @Mock
    BalloonRepository balloonRepository;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
        basicWare = new BasicWare(Long.valueOf(1), "WareName", 10.99, "10", "WareDescription" );
        when(jpaRepository.findAll()).thenReturn(new ArrayList<>());

    }

    @Test
    void getAllWaresTest() {
        String [] wareTypes = {"shirts", "shirtsTwo", "cups", "balloons"};
        for (String s : wareTypes){
            List<?> list = databaseCommander.getAllWares(s);
            assertTrue(list.isEmpty());
        }
        List<?> list = databaseCommander.getAllWares("wrongInput");
        assertNull(list);
    }

    @Test
    void getOneItemTest(){
        assertEquals("WareName", basicWare.getWareName() );
    }
}