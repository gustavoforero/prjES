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
public class clsSintoma_Hardware {
    
    private int id;
    private clsHardware hardware;
    private clsSintoma sintoma;

    public clsSintoma_Hardware() {
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

    public clsSintoma getSintoma() {
        return sintoma;
    }

    public void setSintoma(clsSintoma sintoma) {
        this.sintoma = sintoma;
    }
    
    
    
}
