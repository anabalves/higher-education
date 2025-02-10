package javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class TelaCadastrarContatoResponsiva extends Application {

	@Override
	public void start(Stage stage) throws Exception {
        FlowPane pan = new FlowPane();
        pan.setHgap(20);
        pan.setVgap(20);   
        
        Scene scn = new Scene(pan, 600, 200);
        stage.setTitle("Cadastro de Contatos");
        
        Label lblId = new Label("Id");
        TextField tfId = new TextField(); 
        tfId.setPrefWidth(470);
        
        Label lblNome = new Label("Nome");
        TextField tfNome = new TextField();  
        tfNome.setPrefWidth(470);
        
        Label lblTelefone = new Label("Telefone");
        TextField tfTelefone = new TextField(); 
        tfTelefone.setPrefWidth(470);
        
        Button btnSalvar = new Button("Salvar");
        Button btnPesquisar = new Button("Pesquisar");
        
        pan.getChildren().addAll(lblId, tfId, lblNome, tfNome, lblTelefone, tfTelefone, btnSalvar, btnPesquisar);
        
        stage.setScene(scn);
        stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(TelaCadastrarContatoResponsiva.class, args);
	}

}
