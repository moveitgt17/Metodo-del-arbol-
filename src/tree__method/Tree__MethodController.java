/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree__method;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author CARLOS
 */
public class Tree__MethodController implements Initializable {
   
    @FXML
    private Label label;
    @FXML
    private Label inputArchiveLabel;
    @FXML
    private TextArea consoleArea;
    @FXML
    private TextArea inputArchiveArea;
    @FXML
    private Pane principal;
    @FXML
    private Label output;
    @FXML
    private JFXButton open;
    @FXML
    private JFXButton automaton;
    @FXML
    private JFXButton analize;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void openFile(ActionEvent event) {
      String route = openFile("txt");
      String content = getContent(route);
      inputArchiveArea.setText(content);
    }

    @FXML
    private void generateAutomaton(ActionEvent event) {
        try{
            Generate_Graphic();
        }catch(Exception e){
            System.out.println("Hola");
        }
        Graphviz graphviz = new Graphviz();
        graphviz.GraphvizStructure();
        System.out.println("Si");
    }

    @FXML
    private void analizeInput(ActionEvent event) {
        Lexic_Analizer analyze = new Lexic_Analizer();
        List<Token> tokens;
        tokens = analyze.scanner(inputArchiveArea.getText());
        List<String> console = analyze.getAux();
        String output="";
        for(int i=0; i<console.size();i++){
          output += console.get(i) + "\n";
        }
        consoleArea.setText(output);
    }
    
    
    private String openFile(String extension){
         try {
            JFileChooser JfC = new JFileChooser();
            JfC.setAcceptAllFileFilterUsed(false);
            JfC.setFileFilter(new FileNameExtensionFilter("Archivos con extension *." + extension, extension));
            JfC.setCurrentDirectory(new File("Escritorio"));
            JfC.showOpenDialog(null);
            String ruta = JfC.getSelectedFile().getAbsolutePath();
            return ruta;
        } catch (Exception E) {
            System.err.println("Error al abrir el archivo");
            return "";
        }
    }
  
    public String getContent(String Ruta) {
        String aux = "";
        String texto = "";
        try {
            File Archivo = new File(Ruta);
            if (Archivo != null) {
                Ruta = "" + Archivo;
                FileReader FR = new FileReader(Archivo);
                try (BufferedReader Buffer = new BufferedReader(FR)) {
                    while ((aux = Buffer.readLine()) != null) {
                        texto += aux + "\n";
                    }
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + "" + "\nNo se ha podido leer el archivo", "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
        }
        return texto;
    }
    
    public void Generate_Graphic()throws IOException{
        int meter = 0;
        String father = "";
        String leftChild = "";
        String rightChild = "";
        String data[][] = new String[2][3];
        data[0][0] = "\".\"";
        data[0][1] = "\"|\"";
        data[0][2] = "\"#\"";
        data[1][0] = "\"|\"";
        data[1][1] = "a";
        data[1][2] = "X";
        FileWriter aux = new FileWriter("C:\\Users\\CARLOS\\Desktop\\prueba.txt");
        aux.write("digraph D{" + "\n");
        //aux.write("rankdir=LR" + "\n");
        aux.write("node [fontname=\"Arial\"];" + "\n");
        for(int i=0; i<2; i++){
            for(int j=0; j<3; j++){
                
                if(meter==0){
                    meter++;
                    father = data[i][j];
                }else if(meter==1){
                    meter++;
                    leftChild = data[i][j];
                }else if(meter==2){
                    meter =0;
                    rightChild = data[i][j];
                    aux.write(father + " ->" + leftChild + "\n");
                    aux.write(father + " ->" + rightChild + "\n");
                }
            }
        }
        aux.close();
    }
    
    public void saveTreeData(String expresion){
        for(int i=0; i<expresion.length(); i++){
            char c = expresion.charAt(i);
            switch (c){
                case'{':{
                    
                }
            }
        }
    }
    
}
