/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgDatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pkgLogica.clsUsuario;
/**
 *
 * @author kiritoxcii
 *
public class dbUsuario {
    
     dbConexion cn;

    public dbUsuario() {
        cn = new dbConexion();
    }
    
     public clsUsuario getContactoById(int id){
        clsUsuario u = new clsUsuario();
        
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT * FROM contactos " +
                                                                          "WHERE idcontacto = ? ");
            pstm.setInt(1, id);
            
            ResultSet res = pstm.executeQuery();
            if(res.next()){
                c.setId(res.getInt("idcontacto"));
                c.setNombre(res.getString("nombre"));
                c.setApellido(res.getString("apellido"));
                c.setTelefonoDomicilio(res.getString("telefono_domicilio"));
                c.setTelefonoOficina(res.getString("telefono_oficina"));
                c.setCelular(res.getString("celular"));
                c.setCorreo(res.getString("correo"));
                c.setDireccionResidencia(res.getString("direccion_residencia"));
                c.setDireccionTrabajo(res.getString("direccion_trabajo"));
                
            }
            
            res.close();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return u;
    }
    
     /** trae todos los registros de la tabla contactos *
     public clsUsuario[] getContactos(){
        int registros = 0;

        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement(
                   "SELECT count(1) as cont" +
                   " FROM contactos ");
            
            ResultSet res = pstm.executeQuery();

            res.next();
            registros = res.getInt("cont");
            res.close(); 
            
            
        }catch(SQLException e){
            System.out.println(e);
        }
        clsUsuario[] data = new clsUsuario[registros];
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement(
                               "SELECT idcontacto, " +
                               " nombre, " +
                               " apellido, " +
                               " telefono_domicilio, " +
                               " telefono_oficina," +
                               " celular, " +
                               " correo, " +
                               " direccion_residencia," +
                               " direccion_trabajo " +
                               " FROM contactos " + 
                               " ORDER BY nombre, apellido ");
            
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
                data[i] = new clsContacto();
                data[i].setId(res.getInt("idcontacto"));
                data[i].setNombre(res.getString("nombre"));
                data[i].setApellido(res.getString("apellido"));
                data[i].setTelefonoDomicilio(res.getString("telefono_domicilio"));
                data[i].setTelefonoOficina(res.getString("telefono_oficina"));
                data[i].setCelular(res.getString("celular"));
                data[i].setCorreo(res.getString("correo"));
                data[i].setDireccionResidencia(res.getString("direccion_residencia"));
                data[i].setDireccionTrabajo(res.getString(
                                     "direccion_trabajo"));                  
                i++;
            }
            res.close(); 
            
        }catch(SQLException e){
            System.out.println(e);
        }
        return data;
    }
     
    public int insertarContacto(clsUsuario u){
        int cont_usuario = -1;
        int resultado = 0;//no hubo errores de validacion
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement(
                                      "select count(1) as cont " +
                                      " from contactos " +
                                      " where correo = ? ");
            pstm.setString(1, u.getCorreo());

            ResultSet res = pstm.executeQuery();
            res.next();
            cont_usuario = res.getInt("cont");
            res.close();
            
            
            if(cont_usuario==0){
                pstm = cn.getConexion().prepareStatement(
                                   "insert into contactos (nombre, " +
                                   " apellido," +
                                   " telefono_domicilio," +
                                   " telefono_oficina," +
                                   " celular," +
                                   " correo," +
                                   " direccion_residencia," +
                                   " direccion_trabajo) " +
                                   " values(?,?,?,?,?,?,?,?)");
                pstm.setString(1, c.getNombre());
                pstm.setString(2, c.getApellido());
                pstm.setString(3, c.getTelefonoDomicilio());
                pstm.setString(4, c.getTelefonoOficina());
                pstm.setString(5, c.getCelular());
                pstm.setString(6, c.getCorreo());
                pstm.setString(7, c.getDireccionResidencia());
                pstm.setString(8, c.getDireccionTrabajo());
                
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
    
    public int actualizarContacto(clsUsuario u){
        int resultado = 0;
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement(
                                       "update contactos " +
                                       " set nombre = ?, " +
                                       " apellido = ?," +
                                       " telefono_domicilio = ?," +
                                       " telefono_oficina = ?," +
                                       " celular = ?," +
                                       " correo = ?," +
                                       " direccion_residencia = ?," +
                                       " direccion_trabajo = ? " +
                                       " where idcontacto = ?");
            pstm.setString(1, c.getNombre());
            pstm.setString(2, c.getApellido());
            pstm.setString(3, c.getTelefonoDomicilio());
            pstm.setString(4, c.getTelefonoOficina());
            pstm.setString(5, c.getCelular());
            pstm.setString(6, c.getCorreo());
            pstm.setString(7, c.getDireccionResidencia());
            pstm.setString(8, c.getDireccionTrabajo());
            pstm.setInt(9, c.getId());

            resultado = pstm.executeUpdate();
                
        }catch(SQLException e){
            System.out.println(e);
        }
        return resultado;
    }
    
    public int borrarContacto(clsUsuario u){
        int resultado = 0;
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement(
                                           "delete from contactos " +
                                           " where idcontacto = ?");
            
            pstm.setInt(1, c.getId());

            resultado = pstm.executeUpdate();
                    
        }catch(SQLException e){
            System.out.println(e);
        }
        
        return resultado;
    }
}*/
