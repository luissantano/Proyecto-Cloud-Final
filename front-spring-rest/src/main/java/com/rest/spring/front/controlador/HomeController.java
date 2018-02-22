package com.rest.spring.front.controlador;

import com.rest.spring.core.basededatos.ConexionBaseDeDatos;
import com.rest.spring.core.Restaurant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * com.learningjava.rest.spring.front
 * Class
 * By berto. 12/02/2018
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(Model model) {
        System.out.println("TODO CARGADO");
        return "index";
    }
    @RequestMapping(value = "/restaurantes", method = RequestMethod.GET)
    public String init(@ModelAttribute("model") ModelMap model) {
        ConexionBaseDeDatos conexionBaseDeDatos = new ConexionBaseDeDatos();
        List<Restaurant> data = conexionBaseDeDatos.readRestaurant("");
        model.addAttribute("restaurantes", data);
        return "restaurantes";
    }
}