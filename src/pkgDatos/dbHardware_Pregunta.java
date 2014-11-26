/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgDatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pkgLogica.clsHardware_Pregunta;

/**
 *
 * @author kiritoxcii
 */
public class dbHardware_Pregunta {
    
    dbConexion cn;
    
    public dbDiagnostico() {
        cn = new dbConexion();
    }

    /** trae una cita por su id*/
    public clsDiagnostico getCitaById(int id){
        clsDiagnostico data = new clsDiagnostico();
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement(
                                                "SELECT * FROM diagnostico " + 
                                                " where iddiagnostico = ? ");

            pstm.setInt(1, id);
            ResultSet res = pstm.executeQuery();
            int i = 0;
            dbHardware dbh = new dbHardware();
            if(res.next()){
                data = new clsDiagnostico();
                data.setIdDiagnostico(res.getInt("iddiagnostico"));
                data.setHardware(dbh.getHardwareById(res.getInt("idhardware")));
                data.setDescripcion(res.getString("diagnostico"));
            }
            res.close(); 
            
            
        }catch(SQLException e){
            System.out.println(e);
        }
        return data;
    }
    
    /** trae todas las citas de un contacto*/
    public clsDiagnostico[] getCitasByIdHardware(int idhardware){
        int registros = 0;

        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement(
                                     "SELECT count(1) as cont" +
                                     " FROM diagnostico ");
            
            ResultSet res = pstm.executeQuery();

            res.next();
            registros = res.getInt("cont");
            res.close(); 
            
            
        }catch(SQLException e){
            System.out.println(e);
        }
        clsDiagnostico[] data = new clsDiagnostico[registros];
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement(
                                      "SELECT * FROM diagnostico WHERE idhardware=?");

            pstm.setInt(1, idhardware);
            ResultSet res = pstm.executeQuery();
            int i = 0;
            dbHardware dbh = new dbHardware();
            while(res.next()){
                data[i] = new clsDiagnostico();
                data[i].setIdDiagnostico(res.getInt("iddiagnostico"));                
                data[i].setDescripcion(res.getString("descripcion"));
                data[i].setHardware(dbh.getHardwareById(res.getInt("idhardware")));
                i++;
            }
            res.close(); 
            
            
        }catch(SQLException e){
            System.out.println(e);
        }
        return data;    }
    
    /** trae todos los registros de la tabla citas */
     public clsDiagnostico[] getDiagnostico(){
        int registros = 0;

        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement(
                                     "SELECT count(1) as cont" +
                                     " FROM diagnostico ");
            
            ResultSet res = pstm.executeQuery();

            res.next();
            registros = res.getInt("cont");
            res.close(); 
            
            
        }catch(SQLException e){
            System.out.println(e);
        }
        clsDiagnostico[] data = new clsDiagnostico[registros];
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement(
                                      "SELECT * FROM diagnostico");

            ResultSet res = pstm.executeQuery();
            int i = 0;
            dbHardware dbh = new dbHardware();
            while(res.next()){
                data[i] = new clsDiagnostico();
                data[i].setIdDiagnostico(res.getInt("iddiagnostico"));                
                data[i].setDescripcion(res.getString("descripcion"));
                data[i].setHardware(dbh.getHardwareById(res.getInt("idhardware")));                
                i++;
            }
            res.close(); 
            
            
        }catch(SQLException e){
            System.out.println(e);
        }
        return data;
    }
     
    public int insertarDiagnostico(clsDiagnostico diagnostico){
        int resultado = 0;//no hubo errores de validacion
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement(
                                   "insert into diagnostico (descripcion," +
                                   " idhardware)" +
                                   " values(?,?)");
            pstm.setString(1, diagnostico.getDescripcion());
            pstm.setInt(2, diagnostico.getHardware().getIdHardware());
            pstm.executeUpdate();

            pstm = cn.getConexion().prepareStatement("select last_insert_id()");
            ResultSet res = pstm.executeQuery();
            res.next();
            resultado = res.getInt(1);
            res.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return resultado;
    }
    
    public int actualizarDiagnostico(clsDiagnostico diagnostico){
        int resultado = 0;
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement(
                                       "update diagnostico " +
                                       " set  descripcion= ?, " +
                                       " idhardware = ?" +
                                       " where iddiagnostico = ?");
            pstm.setString(1, diagnostico.getDescripcion());
            pstm.setInt(2, diagnostico.getHardware().getIdHardware());            
            pstm.setInt(3, diagnostico.getIdDiagnostico());

            resultado = pstm.executeUpdate();

        }catch(SQLException e){
            System.out.println(e);
        }
        return resultado;
    }
    
    public int borrarDiagnostico(clsDiagnostico diagnostico){
        int resultado = 0;
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement(
                                  "delete from diagnostico " +
                                  " where iddiagnostico = ?");
            
            pstm.setInt(1, diagnostico.getIdDiagnostico());

            resultado = pstm.executeUpdate();
                    
        }catch(SQLException e){
            System.out.println(e);
        }

        return resultado;
    }
}
