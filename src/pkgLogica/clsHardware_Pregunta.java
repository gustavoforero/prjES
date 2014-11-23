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
public class clsHardware_Pregunta {
    
    private int id;
    private clsHardware hardware;
    private clsPregunta pregunta;

    public clsHardware_Pregunta() {
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

    public clsPregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(clsPregunta pregunta) {
        this.pregunta = pregunta;
    }
    
    
    
}
