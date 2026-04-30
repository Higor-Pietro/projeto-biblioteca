package org.example;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmprestimosDAO {

    public int cadastrarEmprestimo(Emprestimo emprestimo, int livroId){

        String sql = "INSERT INTO EMPRESTIMOS (livro_id, cliente, data_emprestimo, data_devolução) VALUES (?, ?, ?, ?)";



        try{
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1,livroId);
            ps.setString(2,emprestimo.getNomeCliente());
            ps.setString(3,emprestimo.getDataEmpréstimo());
            ps.setString(4,emprestimo.getDataDevolução());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();

            if(rs.next()){
               emprestimo.setIdDataBase(rs.getInt(1));
               return rs.getInt(1);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void deletarEmprestimo(int idEmprestimo){

        String sql = "DELETE FROM emprestimos where id=?";

        try{
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);


            ps.setInt(1,idEmprestimo);
            ps.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
