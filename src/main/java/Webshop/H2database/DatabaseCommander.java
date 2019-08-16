package Webshop.H2database;

import Webshop.DatabaseDAO.DatabaseDAO;
import Webshop.Repository.BalloonRepository;
import Webshop.Repository.CupsRepository;
import Webshop.Repository.ShirtRepository;
import Webshop.Repository.ShirtV2Repository;
import Webshop.WareTemplates.BasicWare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatabaseCommander implements DatabaseDAO {

    @Autowired
    ShirtRepository shirtRepository;
    @Autowired
    ShirtV2Repository shirtV2Repository;
    @Autowired
    CupsRepository cupsRepository;
    @Autowired
    BalloonRepository balloonRepository;

    @Override
    public List<?> getAllWares(String wareType) {
        switch (wareType) {
            case "shirts":
                return shirtRepository.findAll();
            case "shirtsTwo":
                return shirtV2Repository.findAll();
            case "cups":
                return cupsRepository.findAll();
            case "balloons":
                return balloonRepository.findAll();
            default:
                return null;
        }
    }

    @Override
    public BasicWare getOneItem(String wareType, Long id) {
        switch (wareType) {
            case "TShirts":
                return shirtRepository.findOne(id);
            case "TShirtsv2":
                return shirtV2Repository.findOne(id);
            case "Cups":
                return cupsRepository.findOne(id);
            case "Balloons":
                return balloonRepository.findOne(id);
            default:
                return null;
        }
    }

}
