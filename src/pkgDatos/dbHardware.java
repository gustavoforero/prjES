/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgDatos;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pkgLogica.clsHardware;
/**
 *
 * @author kiritoxcii
 */
public class dbHardware {
    
     dbConexion cn;

    public dbHardware() {
        cn = new dbConexion();
    }
    
     public clsHardware getHardwareById(int id){
        clsHardware hardware = new clsHardware();
        
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT * FROM hardware " +
                                                                          "WHERE idhardware = ? ");
            pstm.setInt(1, id);            
            
            ResultSet res = pstm.executeQuery();
            if(res.next()){
                hardware.setIdHardware(res.getInt("idhardware"));
                hardware.setNombre(res.getString("nombre"));
                hardware.setDescripcion(res.getString("descripcion"));
                hardware.setEstado(res.getBoolean("estado"));
                //equipo.setIdDiagnostico(dbc.getDiagnosticoById(res.getInt("idhardware")));                
                
            }
            
            res.close();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return hardware;
    }
    
     /** trae todos los registros de la tabla contactos */
     public clsHardware[] getHardware(){
        int registros = 0;

        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement(
                   "SELECT count(1) as cont" +
                   " FROM hardware ");
            
            ResultSet res = pstm.executeQuery();

            res.next();
            registros = res.getInt("cont");
            res.close(); 
            
            
        }catch(SQLException e){
            System.out.println(e);
        }
        clsHardware[] data = new clsHardware[registros];
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement(
                               "SELECT idhardware, " +
                               " nombre, " +
                               " descripcion, " +
                               " estado " +
                               " FROM hardware " + 
                               " ORDER BY idhardware");
            
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
                data[i] = new clsHardware();
                data[i].setIdHardware(res.getInt("idhardware"));
                data[i].setNombre(res.getString("nombre"));
                data[i].setDescripcion(res.getString("descripcion"));
                data[i].setEstado(res.getBoolean("estado"));                
                i++;
            }
            res.close(); 
            
        }catch(SQLException e){
            System.out.println(e);
        }
        return data;
    }
     
    public int insertarHardware(clsHardware hardware){
        int cont_hardware = -1;
        int resultado = 0;//no hubo errores de validacion
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement(
                                      "select count(1) as cont " +
                                      " from hardware " +
                                      " where descripcion = ? ");
            pstm.setString(1, hardware.getDescripcion());

            ResultSet res = pstm.executeQuery();
            res.next();
            cont_hardware = res.getInt("cont");
            res.close();
            
            
            if(cont_hardware==0){
                pstm = cn.getConexion().prepareStatement(
                                   "insert into hardware (nombre, " +
                                   " descripcion," +
                                   " estado)" +                                   
                                   " values(?,?,?)");
                pstm.setString(1, hardware.getNombre());
                pstm.setString(2, hardware.getDescripcion());
                pstm.setBoolean(3, hardware.isEstado());                
                
                pstm.executeUpdate();
                    
                pstm = cn.getConexion().prepareStatement("select last_insert_id()");
                res = pstm.executeQuery();
                res.next();
                resultado = res.getInt(1);
                res.close();
            }else{
                resultado = -2;//el login ya existe
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return resultado;
    }
    
    public int actualizarHardware(clsHardware hardware){
        int resultado = 0;
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement(
                                       "update hardware " +
                                       " set nombre = ?, " +
                                       " descripcion = ?," +
                                       " estado = ?" +
                                       " where idhardware = ?");
            pstm.setString(1, hardware.getNombre());
            pstm.setString(2, hardware.getDescripcion());
            pstm.setBoolean(3, hardware.isEstado());            
            pstm.setInt(4, hardware.getIdHardware());

            resultado = pstm.executeUpdate();
                
        }catch(SQLException e){
            System.out.println(e);
        }
        return resultado;
    }
    
    public int borrarHardware(clsHardware hardware){
        int resultado = 0;
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement(
                                           "delete from hardware " +
                                           " where idhardware = ?");
            
            pstm.setInt(1, hardware.getIdHardware());

            resultado = pstm.executeUpdate();
                    
        }catch(SQLException e){
            System.out.println(e);
        }
        
        return resultado;
    }
}
