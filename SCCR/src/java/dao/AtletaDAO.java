package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static javax.swing.UIManager.getString;
import modelo.Atleta;

public class AtletaDAO {

    public static List<Atleta> obterAtletas() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Atleta> atletas = new ArrayList<Atleta>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from atleta");
            while (rs.next()) {

                Atleta atleta = new Atleta(rs.getInt("id"), rs.getString("dataNascimento"), rs.getString("nome"),
                        rs.getString("sexo"), rs.getString("endereco"), rs.getString("tamCamisa"),
                        rs.getString("telefoneCel"), rs.getString("telefoneFixo"), rs.getString("cpf"),
                        rs.getString("apelido"), rs.getString("nomeDaEquipe"), rs.getString("senha"),
                        rs.getString("login"), rs.getString("email"));

                atletas.add(atleta);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);

        }
        return atletas;
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
