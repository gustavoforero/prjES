/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgDatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pkgLogica.clsSintoma;
/**
 *
 * @author kiritoxcii
 */
public class dbSintoma {
    
    dbConexion cn;

    public dbSintoma() {
        cn = new dbConexion();
    }
    
     public clsSintoma getSintomaById(int id){
        clsSintoma sintoma = new clsSintoma();
        
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT * FROM sintoma " +
                                                                          "WHERE idsintoma = ? ");
            pstm.setInt(1, id);            
            
            ResultSet res = pstm.executeQuery();
            if(res.next()){
                sintoma.setIdSintoma(res.getInt("idhardware"));                
                sintoma.setDescripcion(res.getString("descripcion"));
                sintoma.setEstado(res.getBoolean("estado"));                             
                
            }
            
            res.close();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return sintoma;
    }
    
     /** trae todos los registros de la tabla contactos */
     public clsSintoma[] getSintoma(){
        int registros = 0;

        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement(
                   "SELECT count(1) as cont" +
                   " FROM sintoma ");
            
            ResultSet res = pstm.executeQuery();

            res.next();
            registros = res.getInt("cont");
            res.close(); 
            
            
        }catch(SQLException e){
            System.out.println(e);
        }
        clsSintoma[] data = new clsSintoma[registros];
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement(
                               "SELECT idsintoma, " +
                               " descripcion, " +
                               " estado " +
                               " FROM sintoma " + 
                               " ORDER BY idsintoma");
            
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
                data[i] = new clsSintoma();
                data[i].setIdSintoma(res.getInt("idsintoma"));                
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
     
    public int insertarSintoma(clsSintoma sintoma){
        int cont_sintoma = -1;
        int resultado = 0;//no hubo errores de validacion
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement(
                                      "select count(1) as cont " +
                                      " from sintoma " +
                                      " where descripcion = ? ");
            pstm.setString(1, sintoma.getDescripcion());

            ResultSet res = pstm.executeQuery();
            res.next();
            cont_sintoma = res.getInt("cont");
            res.close();
            
            
            if(cont_sintoma==0){
                pstm = cn.getConexion().prepareStatement(
                                   "insert into sintoma (descripcion," +
                                   " estado)" +                                   
                                   " values(?,?)");                
                pstm.setString(1, sintoma.getDescripcion());
                pstm.setBoolean(2, sintoma.isEstado());                
                
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
    
    public int actualizarSintoma(clsSintoma sintoma){
        int resultado = 0;
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement(
                                       "update sintoma " +
                                       " set descripcion = ?," +
                                       " estado = ?" +
                                       " where idsintoma = ?");
            
            pstm.setString(1, sintoma.getDescripcion());
            pstm.setBoolean(2, sintoma.isEstado());            
            pstm.setInt(3, sintoma.getIdSintoma());

            resultado = pstm.executeUpdate();
                
        }catch(SQLException e){
            System.out.println(e);
        }
        return resultado;
    }
    
    public int borrarSintoma(clsSintoma sintoma){
        int resultado = 0;
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement(
                                           "delete from sintoma " +
                                           " where idsintoma = ?");
            
            pstm.setInt(1, sintoma.getIdSintoma());

            resultado = pstm.executeUpdate();
                    
        }catch(SQLException e){
            System.out.println(e);
        }
        
        return resultado;
    }
    
}
