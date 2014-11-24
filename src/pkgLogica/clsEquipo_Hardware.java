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
public class clsEquipo_Hardware {
    
    private int id;
    private clsHardware hardware;
    private clsEquipo equipo;

    public clsEquipo_Hardware() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public clsHardware getHardware() {
        return hardware;
    }

    public void setHardware(clsHardware hardware) {
        this.hardware = hardware;
    }

    public clsEquipo getEquipo() {
        return equipo;
    }

    public void setEquipo(clsEquipo equipo) {
        this.equipo = equipo;
    }
    
    
    
}
