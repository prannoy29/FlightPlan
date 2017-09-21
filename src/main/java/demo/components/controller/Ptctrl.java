package demo.components.controller;
import demo.components.dao.PointDao;
import demo.components.domain.GeoJsonPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class Ptctrl {
    @GetMapping("/point/getElevation")
    public String homepage() {
        return "getrequestobjj";
    }

    @RequestMapping(value = "point/getElevatio",method = RequestMethod.POST)
    public double getElevation(@RequestBody GeoJsonPoint geoJsonPoint){

        return 1.34433343;
    }

}



