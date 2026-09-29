package com.mycompany.sistema_archivos_alianza_rebelde;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * Paso 4: JavaBean que representa a un soldado rebelde o Jedi.
 * JAXB lo convierte automáticamente a XML (marshalling).
 */
@XmlRootElement(name = "personaje")
@XmlAccessorType(XmlAccessType.FIELD)
public class Personaje {

    @XmlElement(name = "nombre")
    private String nombre;

    @XmlElement(name = "rango")
    private String rango;

    // JAXB exige un constructor sin argumentos
    public Personaje() {
    }

    public Personaje(String nombre, String rango) {
        this.nombre = nombre;
        this.rango = rango;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    @Override
    public String toString() {
        return "Personaje{nombre=" + nombre + ", rango=" + rango + "}";
    }
}
