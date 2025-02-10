package exercicio17;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CursoBoundary extends Application {
	
    private TextField tfId = new TextField();
    private TextField tfNome = new TextField();
    private TextField tfCodigoCurso = new TextField();
    private TextField tfNomeCoordenador = new TextField();
    private TextField tfQtdAlunos = new TextField();
    private Button btnAdicionar = new Button("Adicionar");
    private Button btnPesquisar = new Button("Pesquisar");
    private List<Curso> lista = new ArrayList<>();

	@Override
	public void start(Stage stage) {
        GridPane gridPane = new GridPane();

        gridPane.add(new Label("Id"), 0, 0);
        gridPane.add(tfId, 1, 0);

        gridPane.add(new Label("Nome"), 0, 1);
        gridPane.add(tfNome, 1, 1);

        gridPane.add(new Label("Codigo do Curso"), 0, 2);
        gridPane.add(tfCodigoCurso, 1, 2);

        gridPane.add(new Label("Nome do Coordenador"), 0, 3);
        gridPane.add(tfNomeCoordenador, 1, 3);
        
        gridPane.add(new Label("Quantidade de Alunos"), 0, 4);
        gridPane.add(tfQtdAlunos, 1, 4);
        
        gridPane.setPadding(new Insets(18));
        gridPane.setPadding(new Insets(9));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        gridPane.add(btnAdicionar, 0, 5);
        gridPane.add(btnPesquisar, 1, 5);

        btnAdicionar.setOnAction( e -> {
        	Curso curso = this.boundarytoEntity();
            lista.add(curso);
            System.out.println(lista);
        });

        btnPesquisar.setOnAction( e -> {
           boolean encontrado = false;
           for(Curso curso : lista) {
              if (curso.getNome().contains(tfNome.getText())) {
                  this.entityToBoundary(curso);
                  encontrado = true;
                  break;
              }
           }
           if (!encontrado) {
               Alert a = new Alert(Alert.AlertType.INFORMATION,
                       "Curso não encontrado");
               a.showAndWait();
           }
        });

        Scene scene = new Scene(gridPane, 310, 215);

        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Gestão de Cursos");
        stage.show();
    }

    public Curso boundarytoEntity() {
    	Curso curso = new Curso();
        try {
        	curso.setId(Long.parseLong(tfId.getText()));
        	curso.setNome(tfNome.getText());
        	curso.setCodigoCurso(Long.parseLong(tfCodigoCurso.getText()));
        	curso.setNomeCoordenador(tfNomeCoordenador.getText());
        	curso.setQtdAlunos(Integer.parseInt(tfQtdAlunos.getText()));
        } catch (Exception e) {
            System.out.println("Erro : " + e.getMessage());
        }
        return curso;
    }

    public void entityToBoundary(Curso curso) {
        if (curso != null) {
           tfId.setText(String.valueOf(curso.getId()));
           tfNome.setText(curso.getNome());
           tfCodigoCurso.setText(String.valueOf(curso.getCodigoCurso()));
           tfNomeCoordenador.setText(curso.getNomeCoordenador());
           tfQtdAlunos.setText(String.valueOf(curso.getQtdAlunos()));
        }
    }

	public static void main(String[] args) {
		launch(args);
	}
	
}