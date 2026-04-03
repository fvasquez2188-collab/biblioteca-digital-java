package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Usuario;
import util.ConexionDB;

public class UsuarioDAO {

    public Usuario login(String usuario, String password){

        Usuario user = null;

        try {

            Connection con = ConexionDB.getConnection();

            String sql = "SELECT * FROM usuarios WHERE usuario=? AND password=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, usuario);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                user = new Usuario();

                user.setId(rs.getInt("id"));
                user.setUsuario(rs.getString("usuario"));
                user.setPassword(rs.getString("password"));

            }

        } catch(Exception e){
            e.printStackTrace();
        }

        return user;
    }

}