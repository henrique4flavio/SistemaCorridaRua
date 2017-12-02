package modelo;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ResultadoProva {
    

    public void consultarResultadoIndividual() {

    }

    public void importarEquipeMasculino() {

    }

    public void importarEquipeFeminino() {

    }

    public void importarFaixaEtariaMasculino() {

    }

    public void importarFaixaEtariaFeminino() {

    }
    public void importarGeralMasculino(){

    }
    public void importarGeralFeminino(){

    }
    public void exportarEquipeMasculino(){

    }
    public void exportarEquipeFeminino(){

Desktop desktop = Desktop.getDesktop();  
        try {
            desktop.open(new File("C:\equipeFeminino.pdf"));
        } catch (IOException ex) {
            Logger.getLogger(ResultadoProva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void exportarFaixaEtariaMasculino(){

    }
    public void exportarFaixaEtariaFeminino(){

    }
    public void exportarGeralMasculino(){

    }
    public void exportarGeralFeminino(){

    }
    
   
}

