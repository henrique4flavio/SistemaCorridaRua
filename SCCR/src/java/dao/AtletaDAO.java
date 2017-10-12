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

                Atleta atleta = new Atleta(rs.getInt("id"), rs.getString("nome"), rs.getString("nomeEquipe"),
                        rs.getString("dtNascimento"), rs.getString("apelido"), rs.getString("cpf"),
                        rs.getString("tamCamisa"), rs.getString("sexo"), rs.getString("telefoneFixo"),
                        rs.getString("telefoneCelular"), rs.getString("rua"), rs.getString("bairro"),
                        rs.getString("cidade"), rs.getString("estado"),rs.getString("pais"),rs.getString("login"),rs.getString("senha"),rs.getString("email"));


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
