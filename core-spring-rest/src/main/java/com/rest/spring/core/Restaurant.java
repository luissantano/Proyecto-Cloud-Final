package com.rest.spring.core;


//Creamos un objeto para almacenar los restaurantes

//import javax.persistance.Entity
//import javax.persistance.Column

import java.util.ArrayList;

/*
Implementación de functional
@Entity()
public class Restaurant{

@Column(name="RES_CODI")

    private String code;

@Column(name="RES_NOM")

    private  String name;

@Column(name="RES_ADRECA")
    private String address;

@Column(name="RES_WEB")

    private  String website;

@Column(name="RES_TELEFON")

    private String numero;

@Column(name="TRS_DESCRIPCIO")

    private String type;

@Column(name="RES_URL_IMG")

    private String images;

    @Column(name="RES_MITJANA")

    private String mitjana;

}

 */


public class Restaurant {

    private String nombre;

    private  String direccion;

    private String web;

    private  String telefono;

    private String url_imagen;

    private String tipo;

    private String ID;


    //Private arraylist para comentarios
    private ArrayList<String> opinions;

    public ArrayList<String> getOpinions() {
        return opinions;
    }

    public void setOpinions(ArrayList<String> opinions) {
        this.opinions = opinions;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }


    public String getUrl_imagen() {
        return url_imagen;
    }

    public void setUrl_imagen(String url_imagen) {
        this.url_imagen = url_imagen;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }



    public Restaurant() {
        this.opinions = new ArrayList<String>();
    }
}
