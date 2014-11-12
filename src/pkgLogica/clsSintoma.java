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
public class clsSintoma {
    
    private int id;
    private String descripcion;
    private clsDanio idDanio;

    public clsSintoma() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public clsDanio getIdDanio() {
        return idDanio;
    }

    public void setIdDanio(clsDanio idDanio) {
        this.idDanio = idDanio;
    }
    
    
}
