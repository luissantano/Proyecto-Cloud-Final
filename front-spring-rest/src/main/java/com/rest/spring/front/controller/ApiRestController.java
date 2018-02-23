package com.rest.spring.front.controller;

import com.rest.spring.core.basededatos.ReadDB;
import com.rest.spring.core.Restaurant;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
/**
 * com.learningjava.rest.spring.front
 * Class
 * By berto. 12/02/2018
 */
@RestController
@RequestMapping(path = "/rest/api")
public class ApiRestController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(path = "/restaurantes", method = RequestMethod.GET)
    public List<Restaurant> listaRestaurantes(){
        ReadDB readDB = new ReadDB();
            return readDB.readRestaurant("");
    }

}
