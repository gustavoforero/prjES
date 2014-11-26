/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgDatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pkgLogica.clsEquipo;
/**
 *
 * @author kiritoxcii
 */
public class dbEquipo {
    
   dbConexion cn;

    public dbEquipo() {
        cn = new dbConexion();
    }
    
     public clsEquipo getHardwareById(int id){
        clsEquipo equipo = new clsEquipo();
        
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT * FROM equipo " +
                                                                          "WHERE idequipo = ? ");
            pstm.setInt(1, id);            
            
            ResultSet res = pstm.executeQuery();
            if(res.next()){
                equipo.setIdEquipo(res.getInt("idequipo"));
                equipo.setModelo(res.getString("modelo"));
                equipo.setMarca(res.getString("marca"));                
                
                
            }
            
            res.close();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return equipo;
    }
    
     /** trae todos los registros de la tabla contactos */
     public clsEquipo[] getEquipo(){
        int registros = 0;

        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement(
                   "SELECT count(1) as cont" +
                   " FROM equipo ");
            
            ResultSet res = pstm.executeQuery();

            res.next();
            registros = res.getInt("cont");
            res.close(); 
            
            
        }catch(SQLException e){
            System.out.println(e);
        }
        clsEquipo[] data = new clsEquipo[registros];
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement(
                               "SELECT idequipo, " +
                               " modelo, " +
                               " marca" +
                               " FROM equipo " + 
                               " ORDER BY idequipo");
            
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
                data[i] = new clsEquipo();
                data[i].setIdEquipo(res.getInt("idequipo"));
                data[i].setModelo(res.getString("modelo"));
                data[i].setMarca(res.getString("marca"));                
                i++;
            }
            res.close(); 
            
        }catch(SQLException e){
            System.out.println(e);
        }
        return data;
    }
     
    public int insertarEquipo(clsEquipo equipo){
        int cont_equipo = -1;
        int resultado = 0;//no hubo errores de validacion
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement(
                                      "select count(1) as cont " +
                                      " from equipo " +
                                      " where modelo = ? ");
            pstm.setString(1, equipo.getModelo());

            ResultSet res = pstm.executeQuery();
            res.next();
            cont_equipo = res.getInt("cont");
            res.close();
            
            
            if(cont_equipo==0){
                pstm = cn.getConexion().prepareStatement(
                                   "insert into equipo (modelo, " +
                                   " marca)" +
                                   " values(?,?)");
                pstm.setString(1, equipo.getModelo());
                pstm.setString(2, equipo.getMarca());                
                
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
    
    public int actualizarEquipo(clsEquipo equipo){
        int resultado = 0;
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement(
                                       "update equipo " +
                                       " set modelo = ?, " +
                                       " marca = ?" +
                                       " where idequipo = ?");
            pstm.setString(1, equipo.getModelo());
            pstm.setString(2, equipo.getMarca());            
            pstm.setInt(3, equipo.getIdEquipo());

            resultado = pstm.executeUpdate();
                
        }catch(SQLException e){
            System.out.println(e);
        }
        return resultado;
    }
    
    public int borrarEquipo(clsEquipo equipo){
        int resultado = 0;
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement(
                                           "delete from equipo " +
                                           " where idequipo = ?");
            
            pstm.setInt(1, equipo.getIdEquipo());

            resultado = pstm.executeUpdate();
                    
        }catch(SQLException e){
            System.out.println(e);
        }
        
        return resultado;
    }
}
