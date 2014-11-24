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
public class clsDiagnostico {
    
    private int idDiagnostico;
    private String descripcion;
    private clsHardware hardware;

    public clsDiagnostico() {
    }

    public int getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(int idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public clsHardware getHardware() {
        return hardware;
    }

    public void setHardware(clsHardware hardware) {
        this.hardware = hardware;
    }
    
    
    
}
