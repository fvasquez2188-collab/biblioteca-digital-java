package dao;

import java.sql.*;
import java.util.*;

import model.Libro;
import util.ConexionDB;

public class LibroDAO {

    public List<Libro> listar(){

        List<Libro> lista = new ArrayList<>();

        try{

            Connection conn = ConexionDB.getConnection();

            String sql = "SELECT * FROM libros";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Libro l = new Libro();

                l.setId(rs.getInt("id"));
                l.setTitulo(rs.getString("titulo"));
                l.setAutor(rs.getString("autor"));
                l.setDisponible(rs.getBoolean("disponible"));

                lista.add(l);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return lista;
    }
}