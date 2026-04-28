package org.example;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmprestimosDAO {

    public void cadastrarEmprestimo(Emprestimo emprestimo){

        String sql = "INSERT INTO EMPRESTIMOS (livro_id, cliente, data_emprestimo, data_devolução) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = null;

        try{
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1,emprestimo.getLivro().getId());
            ps.setString(2,emprestimo.getNomeCliente());
            ps.setString(3,emprestimo.getDataEmpréstimo());
            ps.setString(4,emprestimo.getDataDevolução());

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
