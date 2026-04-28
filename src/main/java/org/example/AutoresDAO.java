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
                return rs.getInt(1);
            }

            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
       }
    }
