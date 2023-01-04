/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author barre
 */
public class TIPOS_PLAN {
String id ;
String Nombre;

    public TIPOS_PLAN() {
    }

    public TIPOS_PLAN(String id, String Nombre) {
        this.id = id;
        this.Nombre = Nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
@Override
    public String toString(){
    return Nombre;
    
    }

        
}
