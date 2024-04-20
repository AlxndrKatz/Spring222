package su.soviet.carsMVC.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import su.soviet.carsMVC.service.CarService;

@Controller
public class CarController {

    private final CarService service;

    @Autowired
    public CarController(CarService service) {
        this.service = service;
    }

    @GetMapping("/cars")
    public void getListOfCars(@RequestParam(value = "count", required = false) Long count,
                              Model model) {
        if (count != null) {
            model.addAttribute("cars", service.getCarsByCount(count));
        } else  {
            model.addAttribute("cars", service.getAllCars());
        }
    }
}
