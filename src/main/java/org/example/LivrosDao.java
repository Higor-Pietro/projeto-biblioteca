package org.example;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LivrosDao {

    public void cadastrarLivro(Livro livro, int autorId){


        String sql = "INSERT INTO LIVROS (titulo, autor_id, disponível) VALUES (?,?,?)";

        PreparedStatement ps = null;

        try{
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, livro.getTitulo());
            ps.setInt(2, autorId);
            ps.setString(3, livro.disponibilidade());

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
