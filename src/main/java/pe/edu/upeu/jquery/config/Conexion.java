/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.jquery.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class Conexion {
    private static final String URL="jdbc:mysql://localhost:3306/prueba";
    private static final String USER = "root";
    private static final String PASS = "criscar22";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static Connection cx = null;
    public static Connection getConexion(){
        try {
            Class.forName(DRIVER);
            if(cx==null){
                cx = DriverManager.getConnection(URL, USER, PASS);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    return cx;
    }

}   