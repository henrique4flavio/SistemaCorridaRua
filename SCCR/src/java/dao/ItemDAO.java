package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Item;

public class ItemDAO {

    public static List<Item> obterItens() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Item> itens = new ArrayList<Item>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from item");
            while (rs.next()) {

                Item item = new Item(
                rs.getInt("id"), rs.getString("nomeItem"));
                
                
                itens.add(item);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);

        }
        return itens;
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
    
    
    public static void gravar(Item item) throws SQLException,ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            // caso de herança tem qeu fazer para as duas classes .
            String sql = "insert into item (id,nomeItem)"+"values(?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            comando.setInt(1,item.getId());
            comando.setString(2,item.getNomeItem());
            
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

    public static void alterar(Item item) throws SQLException,ClassNotFoundException {
       Connection conexao = null;
       try{
           conexao = BD.getConexao();
           String sql= "update item set nomeItem=? where id = ?";
           PreparedStatement comando = conexao.prepareStatement(sql);
           comando.setString(1,item.getNomeItem());
           comando.setInt(2,item.getId());
           comando.execute();
           comando.close();
           conexao.close();
       }    catch(SQLException e){
            throw e;
    }
}

    public static void excluir(Item item )throws SQLException,ClassNotFoundException {
           Connection conexao = null;
           Statement comando = null;
           String stringSQL;
           
           try{
               conexao = BD.getConexao();
               comando= conexao.createStatement();
               stringSQL = "delete from item where id ="+
                       item.getId();
               comando.execute(stringSQL);
           }catch(SQLException e){
               throw e;
           }finally {
               fecharConexao(conexao,comando);
           }
    
    
    }
    public static Item obterItem(int id) throws ClassNotFoundException,SQLException {
        Connection conexao = null;
        Statement comando = null;
        Item item = null;
        
        try{
            conexao = BD.getConexao();
            comando= conexao.createStatement();
            ResultSet rs = comando.executeQuery( "select *from item id = "+id);
            rs.first();
            
            item = new Item (rs.getInt("id"),
                    rs.getString("nomeItem"));
                   
            // para chave estrangeira.
            //curso.setMatriculaProfessorCoordenador(rs.getInt("professorCoordenador"))
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            fecharConexao(conexao,comando);
        }
           
        return item;
    }

    
    
    
    
}
