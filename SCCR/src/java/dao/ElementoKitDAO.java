package dao;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.ElementoKit;
import modelo.Kit;
import modelo.Item;

public class ElementoKitDAO {

    public static List<ElementoKit> obterElementosKits() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<ElementoKit> elementosKits = new ArrayList<ElementoKit>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from elementokit");
            while (rs.next()) {

                ElementoKit elementoKit = new ElementoKit(
                        rs.getInt("id"), 
                        rs.getInt("Item_id"), 
                        rs.getInt("Kit_id"));

                elementosKits.add(elementoKit);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);

        }
        return elementosKits;
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

    public static void gravar(ElementoKit elementoKit) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();

            String sql = "insert into elementokit (id, item_id,kit_id) values(?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setInt(1, elementoKit.getId());
            comando.setInt(2, elementoKit.getItem_id());
            comando.setInt(3, elementoKit.getKit_id());

            comando.execute();
            comando.close();
            conexao.close();

        } catch (SQLException e) {

            throw e;
        }

    }

    public static void alterar(ElementoKit elementoKit) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "update elementokit set item_id=?, kit_id=? where id = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, elementoKit.getItem_id());
            comando.setInt(2, elementoKit.getKit_id());
            comando.setInt(3, elementoKit.getId());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void excluir(ElementoKit elementoKit )throws SQLException,ClassNotFoundException {
           Connection conexao = null;
           Statement comando = null;
           String stringSQL;
           
           try{
               conexao = BD.getConexao();
               comando= conexao.createStatement();
               stringSQL = "delete from elementokit where id ="+
                       elementoKit.getId();
               comando.execute(stringSQL);
           }catch(SQLException e){
               throw e;
           }finally {
               fecharConexao(conexao,comando);
           }
    
    
    }

    public static ElementoKit obterElementoKit(int id) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        ElementoKit elementoKit = null;

        try{
            conexao = BD.getConexao();
            comando= conexao.createStatement();
            ResultSet rs = comando.executeQuery( "select * from elementokit where id = "+id);
            rs.first();
            
            elementoKit = new ElementoKit (
                    rs.getInt("id"), 
                    rs.getInt("Item_id"), 
                    rs.getInt("Kit_id"));
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }

        return elementoKit;
    }

}
