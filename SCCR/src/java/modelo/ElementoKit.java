package modelo;

import java.sql.SQLException;
import java.util.*;

public class ElementoKit {

    private int item_id;
    private int kit_id;

    public ElementoKit(int item_id, int kit_id) {
        this.item_id = item_id;
        this.kit_id = kit_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getKit_id() {
        return kit_id;
    }

    public void setKit_id(int kit_id) {
        this.kit_id = kit_id;
    }

    public static List<ElementoKit> obterElementosKits()
            throws ClassNotFoundException {
        return ElementoKitDAO.obterElementosKits();

    }

    public void gravar() throws SQLException, ClassNotFoundException {

        ElementoKitDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        ElementoKitDAO.alterar(this);

    }

    public void excluir() throws SQLException, ClassNotFoundException {
        ElementoKitDAO.excluir(this);
    }

    public static ElementoKit obterElementoKit(int id) throws ClassNotFoundException, SQLException {
        return ElementoKitDAO.obterElementoKit(id);

    }
}
