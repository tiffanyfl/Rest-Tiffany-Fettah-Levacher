package com.example.essai;

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

import com.example.essai.Car;
import com.example.essai.Dates;

@RestController
public class Cars {

    /*
     * List<Car> carsList = new ArrayList<>(
     * 
     * );
     */
    // Get all the cars
    @GetMapping("/cars")
    @ResponseStatus(HttpStatus.OK)
    // @ResponseBody
    public Car listOfCars() {
        Car cars = new Car("1", false);
        return cars;
    }

    // Car newCar = new Car();
    // Get a car with a specific plateNumber - OK
    @GetMapping("/cars/{plateNumber}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Car aCar(@PathVariable("plateNumber") String plateNumber) throws Exception {
        Car newCar = new Car(plateNumber, false);
        // newCar.setPlateNumber(plateNumber);
        return newCar;
    }

    // Modify a car with a speficic plateNumber - Not working yet
    @PutMapping(value = "/voiture/{plateNumber}")
    @ResponseStatus(HttpStatus.OK)
    public void rentOrGetBack(
            @PathVariable("plateNumber") String plateNumber,
            @RequestParam(value = "rent", required = true) boolean rent) throws Exception {
        Car newCar2 = new Car(plateNumber, rent);
        // newCar2.setRent(rent);
        System.out.println(newCar2);
    }

    // Modify a car with a specific plateNumber - not working yet
    @PutMapping(value = "/cars/{plateNumber}")
    public void rent(
            @PathVariable("plateNumber") String plateNumber,
            @RequestParam(value = "rent", required = true) boolean rent,
            @RequestBody String dates) throws ParseException {
        Car newCar = new Car(plateNumber, rent);
        // newCar.setRent(rent);
        System.out.println(newCar);
        DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
        Dates dateRent = new Dates();
        dateRent.setDebut(dates);
        Date debut = dateFormat.parse(dateRent.getDebut());
        System.out.println(debut);

    }

    // Post location - ?
    // public void car reçoit des données
    @PostMapping("/loc")
    public void louer(@RequestBody Dates dates) throws ParseException {
        System.out.println(dates);
        DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
        Date debut = dateFormat.parse(dates.getDebut());
        System.out.println(debut);
    }
}
