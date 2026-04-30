package org.example;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AutoresDAO {


    public int cadastrarAutor(Autor autor) {


        String sql = "INSERT INTO AUTORES (nome) VALUES (?)";

        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, autor.getNome());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                autor.setIdDataBase(rs.getInt(1));
                return rs.getInt(1);
            }

            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
       }

    public void deletarAutor(int idAutor){

        String sql = "DELETE FROM autores where id=?";

        try{

            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);



            ps.setInt(1, idAutor);
            ps.execute();

        }catch(SQLException e ){
            e.printStackTrace();
        }

    }

    }
