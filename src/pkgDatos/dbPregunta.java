/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgDatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pkgLogica.clsPregunta;

/**
 *
 * @author kiritoxcii
 */
public class dbPregunta {
    
    dbConexion cn;

    public dbPregunta() {
        cn = new dbConexion();
    }
    
     public clsPregunta getPreguntaById(int id){
        clsPregunta pregunta = new clsPregunta();
        
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT * FROM pregunta " +
                                                                          "WHERE idpregunta = ? ");
            pstm.setInt(1, id);
                        
            ResultSet res = pstm.executeQuery();
            if(res.next()){
                pregunta.setIdPregunta(res.getInt("idpregunta"));
                pregunta.setDescripcion(res.getString("descripcion"));            
                               
                
            }
            
            res.close();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return pregunta;
    }
    
     /** trae todos los registros de la tabla contactos */
     public clsPregunta[] getPregunta(){
        int registros = 0;

        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement(
                   "SELECT count(1) as cont" +
                   " FROM pregunta ");
            
            ResultSet res = pstm.executeQuery();

            res.next();
            registros = res.getInt("cont");
            res.close(); 
            
            
        }catch(SQLException e){
            System.out.println(e);
        }
        clsPregunta[] data = new clsPregunta[registros];
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement(
                               "SELECT idpregunta, " +
                               " descripcion " +
                               " FROM pregunta " + 
                               " ORDER BY idpregunta");
            
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
                data[i] = new clsPregunta();
                data[i].setIdPregunta(res.getInt("idpregunta"));                
                data[i].setDescripcion(res.getString("descripcion"));
                i++;
            }
            res.close(); 
            
        }catch(SQLException e){
            System.out.println(e);
        }
        return data;
    }
     
    public int insertarPregunta(clsPregunta pregunta){
        int cont_pregunta = -1;
        int resultado = 0;//no hubo errores de validacion
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement(
                                      "select count(1) as cont " +
                                      " from pregunta " +
                                      " where descripcion = ? ");
            pstm.setString(1, pregunta.getDescripcion());

            ResultSet res = pstm.executeQuery();
            res.next();
            cont_pregunta = res.getInt("cont");
            res.close();
            
            
            if(cont_pregunta==0){
                pstm = cn.getConexion().prepareStatement(
                                   "insert into pregunta (descripcion)" +                                   
                                   " values(?)");                
                pstm.setString(1, pregunta.getDescripcion());
                
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
    
    public int actualizarPregunta(clsPregunta pregunta){
        int resultado = 0;
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement(
                                       "update pregunta " +
                                       " set descripcion = ?" +
                                       " where idpregunta = ?");
            
            pstm.setString(1, pregunta.getDescripcion());            
            pstm.setInt(2, pregunta.getIdPregunta());

            resultado = pstm.executeUpdate();
                
        }catch(SQLException e){
            System.out.println(e);
        }
        return resultado;
    }
    
    public int borrarPregunta(clsPregunta pregunta){
        int resultado = 0;
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement(
                                           "delete from pregunta " +
                                           " where idpregunta = ?");
            
            pstm.setInt(1, pregunta.getIdPregunta());

            resultado = pstm.executeUpdate();
                    
        }catch(SQLException e){
            System.out.println(e);
        }
        
        return resultado;
    }
    
}
