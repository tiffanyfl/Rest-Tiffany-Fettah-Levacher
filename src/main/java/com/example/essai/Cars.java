package com.example.essai;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.essai.Car;

@RestController
public class Cars {
    @GetMapping("/cars")
    @ResponseStatus(HttpStatus.OK)
    // @ResponseBody
    public String listOfCars() {
        return "This is all the cars";
    }

    @GetMapping("/cars/{plateNumber}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Car aCar(@PathVariable("plateNumber") String plateNumber) throws Exception {
        Car newCar = new Car();
        newCar.setPlateNumber(plateNumber);
        return newCar;
    }

    @PutMapping(value = "/voiture/{plateNumber}")
    @ResponseStatus(HttpStatus.OK)
    public void rentOrGetBack(
            @PathVariable("plateNumber") String plateNumber,
            @RequestParam(value = "rent", required = true) boolean rent) throws Exception {
        Car newCar = new Car();
        newCar.setRent(rent);
        System.out.println(newCar);
    }

    @PutMapping(value = "/cars/{plateNumber}")
    public void rent(
            @PathVariable("plateNumber") String plateNumber,
            @RequestParam(value = "rent", required = true) boolean rent,
            @RequestBody String dates) {

    }
}
