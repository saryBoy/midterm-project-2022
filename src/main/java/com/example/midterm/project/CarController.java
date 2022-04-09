package com.example.midterm.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String mainPage(){
        return "main";
    }

    @GetMapping(path = "/getCars")
    public String getCars(Model model){
        List<Car> cars = carService.getCars();
        model.addAttribute("cars", cars);
        return "home";
    }

    @GetMapping(path = "/newCar")
    public String newCarPage(Model model){
        model.addAttribute("car", new Car());
        return "newCar";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCar(@ModelAttribute ("car") Car car){
        carService.addNewCar(car);
        return "redirect:/getCars";
    }

    @RequestMapping(path = "/edit/{carId}")
    public ModelAndView editCar(
            @PathVariable("carId") Long carId
    ){
        ModelAndView modelAndView = new ModelAndView("newCar");
        Car car = carService.getCarById(carId);
        modelAndView.addObject("car", car);
        return modelAndView;
    }

    @RequestMapping(path = "/delete/{carId}")
    public String deleteCar(
            @PathVariable("carId") Long carId
    ){
        carService.deleteCar(carId);
        return "redirect:/getCars";
    }

}
