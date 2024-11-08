package com.example.essai.web;

import org.springframework.boot.autoconfigure.web.reactive.WebFluxProperties.Format;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.example.essai.data.Car;
import com.example.essai.data.Dates;

@RestController
public class Cars {

    List<Car> carsList = new ArrayList<Car>();

    public Cars() {
        carsList.add(new Car("1", false));
        carsList.add(new Car("2", true));
        carsList.add(new Car("3", false));
        carsList.add(new Car("4", false));
    }

    // Get all the cars - Ok
    @GetMapping("/cars")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Car> listOfCars() {
        return carsList;
    }

    // Get a car with a specific plateNumber - OK
    @GetMapping("/cars/{plateNumber}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Car aCar(@PathVariable("plateNumber") String plateNumber) throws Exception {
        for (int i = 0; i < carsList.size(); i++) {
            if (carsList.get(i).getPlateNumber().equals(plateNumber)) {
                return carsList.get(i);
            }
        }
        return null;
    }

    // Modify a car with a speficic plateNumber - Ok
    @PutMapping(value = "/cars/{plateNumber}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void rentOrGetBack(
            @PathVariable("plateNumber") String plateNumber,
            @RequestParam(value = "rent", required = true) boolean rent,
            @RequestParam(value = "debut", required = true) String debut,
            @RequestParam(value = "fin", required = true) String fin) throws Exception {
        // @RequestBody Dates dates) throws ParseException {
        for (int i = 0; i < carsList.size(); i++) {
            if (carsList.get(i).getPlateNumber().equals(plateNumber)) {
                carsList.get(i).setRent(rent);
                Dates dateRent = new Dates();
                dateRent.setDebut(debut);
                dateRent.setFin(fin);
                carsList.get(i).setDatesRent(dateRent);
            }
        }
    }
}
