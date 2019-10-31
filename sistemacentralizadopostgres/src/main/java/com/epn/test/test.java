package com.epn.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;




public class test {
    public Connection getconexion(){

Connection conexion = null;
String servidor = "localhost";
String puerto = "5432";
String baseDatos = "supermercado";
String url = "jdbc:postgresql://"+servidor+":"+puerto+"/"+baseDatos;
String usuario="postgres";
String clave="admin";


try{
conexion = DriverManager.getConnection(url, usuario, clave);
}catch(SQLException ex){
Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
}
        return conexion;
    }
    
    public void insertar(int codigo, String nombre, double precio){
        
        Connection conexion = getconexion();
        String sql = "insert into productos values(" + codigo +",'"+ nombre +"','"+precio+"')";
        
        try (Statement st= conexion.createStatement()){
            
            st.executeUpdate(sql);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

public static void main(String[] args){
test n = new test();
n.insertar(1,"Aceite", 1.50);
}
}

