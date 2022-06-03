/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.jquery.PostDaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.upeu.jquery.config.Conexion;
import pe.edu.upeu.jquery.dao.PostDao;
import pe.edu.upeu.jquery.model.Post;

/**
 *
 * @author admin
 */
public class PostDaoImpl implements PostDao{
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx;
    @Override
    public int create(Post post) {
        String SQL = "insert into post (id_alumno,escuela,nombres,correo,telefono) values(?,?,?,?,?)";
        int x = 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, post.getIdalumno());
            ps.setString(2, post.getEscuela());
            ps.setString(3, post.getNombres());
            ps.setString(4, post.getCorreo());
            ps.setString(5, post.getTelefono());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x;
    }

    @Override
    public int update(Post post) {
        String SQL = "update post set titulo=?, descripcion=? where idpost=?";
        int x = 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, post.getIdalumno());
            ps.setString(2, post.getEscuela());
            ps.setString(3, post.getNombres());
            ps.setString(4, post.getCorreo());
            ps.setString(5, post.getTelefono());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x;
    }

    @Override
    public int delete(int idpost) {
       String SQL = "delete from post where idpost=?";
        int x = 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, idpost);
            x = ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x;
    }

    @Override
    public Post read(int idpost) {
        String SQL = "Select *from post";
        Post p = new Post();
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){                
                p.setIdalumno(rs.getInt("idalumno"));
                p.setEscuela(rs.getString("escuela"));
                p.setNombres(rs.getString("nombres"));
                p.setCorreo(rs.getString("correo"));
                p.setTelefono(rs.getString("telefono"));
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return p;        
    }

    @Override
    public List<Post> readAll() {
        String SQL = "Select *from post";
        List<Post> lista = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                Post p = new Post();
                p.setIdalumno(rs.getInt("idalumno"));
                p.setEscuela(rs.getString("escuela"));
                p.setNombres(rs.getString("nombres"));
                p.setCorreo(rs.getString("correo"));
                p.setTelefono(rs.getString("telefono"));
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return lista;
        
    }
    
}