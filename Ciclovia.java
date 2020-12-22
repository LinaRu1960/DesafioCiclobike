package com.example.ciromine.ciclobike;

/**
 * Created by ciromine on 8/26/19.
 */

public class Ciclovia {

    String nombre;
    String comuna;

    public Ciclovia(String nombre, String comuna) {
        this.nombre = nombre;
        this.comuna = comuna;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }
}
