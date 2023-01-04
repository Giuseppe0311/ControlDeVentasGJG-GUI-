/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author barre
 */
public class Planes {
    int idplan;
    String NombrePlan;
    int duraciondias;
    String tipo_moneda;

    public Planes() {
    }

    public Planes(int idplan, String NombrePlan, int duraciondias, String tipo_moneda) {
        this.idplan = idplan;
        this.NombrePlan = NombrePlan;
        this.duraciondias = duraciondias;
        this.tipo_moneda = tipo_moneda;
    }

    public int getIdplan() {
        return idplan;
    }

    public void setIdplan(int idplan) {
        this.idplan = idplan;
    }

    public String getNombrePlan() {
        return NombrePlan;
    }

    public void setNombrePlan(String NombrePlan) {
        this.NombrePlan = NombrePlan;
    }

    public int getDuraciondias() {
        return duraciondias;
    }

    public void setDuraciondias(int duraciondias) {
        this.duraciondias = duraciondias;
    }

    public String getTipo_moneda() {
        return tipo_moneda;
    }

    public void setTipo_moneda(String tipo_moneda) {
        this.tipo_moneda = tipo_moneda;
    }

    
    @Override
    public String toString() {
        return NombrePlan +"-"+tipo_moneda;
    }
    
}
