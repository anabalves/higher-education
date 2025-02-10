package exercicio16;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AlunoBoundary extends Application {
	
	    private TextField tfId = new TextField();
	    private TextField tfRa = new TextField();
	    private TextField tfNome = new TextField();
	    private DatePicker tfNascimento = new DatePicker();
	    private Button btnAdicionar = new Button("Adicionar");
	    private Button btnPesquisar = new Button("Pesquisar");
	    private List<Aluno> lista = new ArrayList<>();

	    @Override
	    public void start(Stage stage) {
	        GridPane gridPane = new GridPane();

	        gridPane.add(new Label("Id"), 0, 0);
	        gridPane.add(tfId, 1, 0);

	        gridPane.add(new Label("RA"), 0, 1);
	        gridPane.add(tfRa, 1, 1);

	        gridPane.add(new Label("Nome"), 0, 2);
	        gridPane.add(tfNome, 1, 2);

	        gridPane.add(new Label("Nascimento"), 0, 4);
	        gridPane.add(tfNascimento, 1, 4);
	        
	        gridPane.setPadding(new Insets(18));
	        gridPane.setPadding(new Insets(9));
	        gridPane.setHgap(10);
	        gridPane.setVgap(10);

	        gridPane.add(btnAdicionar, 0, 5);
	        gridPane.add(btnPesquisar, 1, 5);

	        btnAdicionar.setOnAction( e -> {
	        	Aluno aluno = this.boundarytoEntity();
	            lista.add(aluno);
	            System.out.println(lista);
	        });

	        btnPesquisar.setOnAction( e -> {
	           boolean encontrado = false;
	           for(Aluno aluno : lista) {
	              if (aluno.getNome().contains(tfNome.getText())) {
	                  this.entityToBoundary(aluno);
	                  encontrado = true;
	                  break;
	              }
	           }
	           if (!encontrado) {
	               Alert a = new Alert(Alert.AlertType.INFORMATION,
	                       "Aluno não encontrado");
	               a.showAndWait();
	           }
	        });

	        Scene scene = new Scene(gridPane, 300, 200);

	        stage.setScene(scene);
	        stage.setResizable(false);
	        stage.setTitle("Gestão de Alunos");
	        stage.show();
	    }

	    public Aluno boundarytoEntity() {
	        Aluno aluno = new Aluno();
	        try {
	        	aluno.setId(Long.parseLong(tfId.getText()));
	        	aluno.setRa(tfRa.getText());
	        	aluno.setNome(tfNome.getText());
	        	aluno.setNascimento(tfNascimento.getValue());
	        } catch (Exception e) {
	            System.out.println("Erro : " + e.getMessage());
	        }
	        return aluno;
	    }

	    public void entityToBoundary(Aluno aluno) {
	        if (aluno != null) {
	           tfId.setText(String.valueOf(aluno.getId()));
	           tfRa.setText(aluno.getRa());
	           tfNome.setText(aluno.getNome());
	           tfNascimento.setValue(aluno.getNascimento());
	        }
	    }

	    public static void main(String[] args) {
	    	launch(args);
	    }
	    
	}