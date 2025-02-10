package javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TelaCadastrarContato extends Application {

	@Override
	public void start(Stage stage) throws Exception {
        Pane pan = new Pane();
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
        
        lblId.relocate(20, 20);
        tfId.relocate(100, 20);
        lblNome.relocate(20, 60);
        tfNome.relocate(100, 60);
        lblTelefone.relocate(20, 100);
        tfTelefone.relocate(100, 100);
        btnSalvar.relocate(20, 140);
        btnPesquisar.relocate(80, 140);
        
        pan.getChildren().addAll(lblId, tfId, lblNome, tfNome, lblTelefone, tfTelefone, btnSalvar, btnPesquisar);
        
        stage.setScene(scn);
        stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(TelaCadastrarContato.class, args);
	}

}
