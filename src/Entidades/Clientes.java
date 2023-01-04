/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author barre
 */
public class Clientes {
 private String id;
 private String nombre;

    public Clientes() {
    }
    
    public Clientes(String id , String nombre){
    this.id = id;
    this.nombre = nombre;
    

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String toString(){
    return id +" - "+nombre;
    
    }
}
