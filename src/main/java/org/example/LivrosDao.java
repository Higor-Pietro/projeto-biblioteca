package org.example;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LivrosDao {



    public int cadastrarLivro(Livro livro, int autorId){


        String sql = "INSERT INTO LIVROS (titulo, autor_id, disponível) VALUES (?,?,?)";



        try{

            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, livro.getTitulo());
            ps.setInt(2, autorId);
            ps.setString(3, livro.disponibilidade());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();

            if(rs.next()){
                livro.setIdDataBase(rs.getInt(1));
                return rs.getInt(1);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public void deletarLivro(int idLivro){

        String sql = "DELETE FROM livros where id =?";

        try{

            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ps.setInt(1, idLivro);
            ps.execute();


        }catch(SQLException e){
           e.printStackTrace();
        }

    }

    public void alterarLivro(int idLivro, String disponibilidade){

        String sql = "UPDATE livros SET disponível=? where id=? ";

        try{
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ps.setString(1, disponibilidade);
            ps.setInt(2,idLivro);
            ps.execute();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
