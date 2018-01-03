
package modelo;


public class UsuarioLogado {
    private static int id;

    
    UsuarioLogado(int id){
        this.id=id;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        UsuarioLogado.id = id;
    }
}
