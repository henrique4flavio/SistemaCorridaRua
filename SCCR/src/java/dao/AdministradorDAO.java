package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static javax.swing.UIManager.getString;
import modelo.Administrador;
import static sun.security.jgss.GSSUtil.login;

public class AdministradorDAO {

    public static List<Administrador> obterAdministradores() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Administrador> administradores = new ArrayList<Administrador>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from administrador");
            while (rs.next()) {

                Administrador administrador = new Administrador(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("senha"),
                        rs.getString("login"),
                        rs.getString("email"));
                

                administradores.add(administrador);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);

        }
        return administradores;
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
    
    public static void gravar(Administrador administrador) throws SQLException,ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            // caso de herança tem qeu fazer para as duas classes .
            String sql = "insert into administrador (nome,senha,login,email,id) values(?,?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            comando.setString(1,administrador.getNome());
            comando.setString(2,administrador.getSenha());
            comando.setString(3,administrador.getLogin());
            comando.setString(4,administrador.getEmail());
            comando.setInt(5,administrador.getId());
        // comando caso tenha um campo opcional,chave estrngeira seja vazia.
        /*
        if(curso.setNull(6,Types.null));
        else{
                comando.set(6,curso.getCoordenador().getMatricula());
        }
        comando.setInt(6,curso.getCodCurso());
*/
        comando.execute();
        comando.close();
        conexao.close();
            
        }
    catch(SQLException e){
    
    throw e;
}

}

    public static void alterar(Administrador administrador) throws SQLException,ClassNotFoundException {
       Connection conexao = null;
       try{
           conexao = BD.getConexao();
           String sql= "update administrador set nome=?,senha=?,login=?,email=? where id = ?";
           PreparedStatement comando = conexao.prepareStatement(sql);
           comando.setString(1,administrador.getNome());
           comando.setString(2,administrador.getSenha());
           comando.setString(3,administrador.getLogin());
           comando.setString(4,administrador.getEmail());
           comando.setInt(5,administrador.getId());
           comando.execute();
           comando.close();
           conexao.close();
       }    catch(SQLException e){
            throw e;
    }
}

    public static void excluir(Administrador administrador)throws SQLException,ClassNotFoundException {
           Connection conexao = null;
           Statement comando = null;
           String stringSQL;
           
           try{
               conexao = BD.getConexao();
               comando= conexao.createStatement();
               stringSQL = "delete from administrador where id ="+
                       administrador.getId();
               comando.execute(stringSQL);
           }catch(SQLException e){
               throw e;
           }finally {
               fecharConexao(conexao,comando);
           }
    
    
    }
    public static Administrador obterAdministrador(int id) throws ClassNotFoundException,SQLException {
        Connection conexao = null;
        Statement comando = null;
        Administrador administrador = null;
        
        try{
            conexao = BD.getConexao();
            comando= conexao.createStatement();
            ResultSet rs = comando.executeQuery( "select * from administrador where id = "+id);
            rs.first();
            
            administrador = new Administrador (rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("senha"),
                    rs.getString("login"),
                    rs.getString("email"));
            // para chave estrangeira.
            //curso.setMatriculaProfessorCoordenador(rs.getInt("professorCoordenador"))
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            fecharConexao(conexao,comando);
        }
           
        return administrador;
    }
    
      public static List<Administrador> pesquisarAdministrador(String nome) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Administrador> administradores = new ArrayList<Administrador>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from administrador where nome like '%"+nome+"%'");
            while (rs.next()) {

                Administrador administrador = new Administrador(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("senha"),
                        rs.getString("login"),
                        rs.getString("email"));
                

                administradores.add(administrador);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);

        }
        return administradores;
    }

    public static Administrador logar(String login, String senha) throws ClassNotFoundException {
       
     Connection conexao = null;
        Administrador administrador = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = "select * from administrador WHERE login = ? and senha = ?";
            comando = conexao.prepareStatement(sql);
            comando.setString(1, login);
            comando.setString(2, senha);
            ResultSet rs = comando.executeQuery();
            if (rs.first()) {
               administrador = new Administrador(
                    rs.getInt("id"),
                    rs.getString("nome"),
                       rs.getString("senha"),
                    rs.getString("login"),
                    rs.getString("email"));
            }

            comando.close();
            conexao.close();
        } catch (SQLException e) {
        } finally {
            fecharConexao(conexao, comando);
        }
        return administrador;
    
    }


}
