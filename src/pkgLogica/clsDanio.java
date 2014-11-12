/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgLogica;

/**
 *
 * @author kiritoxcii
 */
public class clsDanio {
    
    private int id;
    private String definicion;
    private clsHardware idHardware;

    public clsDanio() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDefinicion() {
        return definicion;
    }

    public void setDefinicion(String definicion) {
        this.definicion = definicion;
    }

    public clsHardware getIdHardware() {
        return idHardware;
    }

    public void setIdHardware(clsHardware idHardware) {
        this.idHardware = idHardware;
    }
    
    
}
