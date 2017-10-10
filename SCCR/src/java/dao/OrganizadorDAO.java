
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static javax.swing.UIManager.getString;
import modelo.Organizador;


public class OrganizadorDAO {

    public static List<Organizador> obterOrganizadores() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Organizador> organizadores = new ArrayList<Organizador>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select*from organizador");
            while (rs.next()) {

                Organizador organizador = new Organizador(
                        rs.getString("nome"),
                        rs.getString("senha"),
                        rs.getString("login"),
                        rs.getString("email"), null);
                      
                        organizador.setAdministrador_ID(rs.getString("administrador_ID"));;
                

                organizadores.add(organizador);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);

        }
        return organizadores;
    }

    private static void fecharConexao(Connection conexao, Statement comando) {
        try {
            if (comando != null) {
                comando.close();
            }
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException e) {

        }

    }

}

