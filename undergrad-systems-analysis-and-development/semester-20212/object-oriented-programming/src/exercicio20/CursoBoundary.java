package exercicio20;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class CursoBoundary extends Application {
	
    private TextField tfId = new TextField();
    private TextField tfNome = new TextField();
    private TextField tfCodigoCurso = new TextField();
    private TextField tfNomeCoordenador = new TextField();
    private TextField tfQtdAlunos = new TextField();
    
	private Button btnNovoCurso = new Button("Novo Curso");
	private Button btnSalvar = new Button("Salvar");
	private Button btnPesquisar = new Button("Pesquisar");
	
	private CursoControl control = new CursoControl();   // Composição

	private TableView<Curso> table = new TableView<>();
    
    private List<Curso> lista = new ArrayList<>();

	private void criarTabela() {
		TableColumn<Curso, Long> col1 = new TableColumn<>("Id");
		col1.setCellValueFactory( new PropertyValueFactory<>("id") );

		TableColumn<Curso, String> col2 = new TableColumn<>("Nome do Curso");
		col2.setCellValueFactory( new PropertyValueFactory<>("nome") );

		TableColumn<Curso, Long> col3 = new TableColumn<>("Código do Curso");
		col3.setCellValueFactory( new PropertyValueFactory<>("codigoCurso") );

		TableColumn<Curso, String> col4 = new TableColumn<>("Nome do Coordenador");
		col4.setCellValueFactory( new PropertyValueFactory<>("nomeCoordenador") );
		
		TableColumn<Curso, Integer> col5 = new TableColumn<>("Quantidade de Alunos");
		col5.setCellValueFactory( new PropertyValueFactory<>("qtdAlunos") );

		TableColumn<Curso, String> col6 = new TableColumn<>("Ações");
		col6.setCellValueFactory( new PropertyValueFactory<>("DUMMY") );
		col6.setCellFactory( (tbCol) ->
		new TableCell<Curso, String>() {
			final Button btn = new Button("Remover");

			public void updateItem(String item, boolean empty) {
				if (empty) {
					setGraphic(null);
					setText(null);
				} else {
					btn.setOnAction( (e) -> {
						Curso c = getTableView().getItems().get(getIndex());
						Alert alert = new Alert(Alert.AlertType.WARNING,
								"Você confirma a remoção do Curso Id " +
										c.getId(), ButtonType.OK, ButtonType.CANCEL);
						Optional<ButtonType> clicado = alert.showAndWait();
						if (clicado.isPresent() &&
								clicado.get().equals(ButtonType.OK)) {
							control.remover(c.getId());
						}
					});
					setGraphic(btn);
					setText(null);
				}
			}
		}
				);

		table.getColumns().addAll(col1, col2, col3, col4, col5, col6);

		table.setItems(control.getListaView());

		table
		.getSelectionModel()
		.selectedItemProperty()
		.addListener( (obs, antigo, novo) -> {
			if (novo != null) {
				control.setEntity(novo);
			}
		}
				);
	}
    
	@Override
	public void start(Stage stage) {
		BorderPane borderPane = new BorderPane();
        GridPane gridPane = new GridPane();
        
		Bindings.bindBidirectional(tfId.textProperty(), control.id, new NumberStringConverter());
		Bindings.bindBidirectional(tfNome.textProperty(), control.nome);
		Bindings.bindBidirectional(tfCodigoCurso.textProperty(), control.codigoCurso, new NumberStringConverter());
		Bindings.bindBidirectional(tfNomeCoordenador.textProperty(), control.nomeCoordenador);
		Bindings.bindBidirectional(tfQtdAlunos.textProperty(), control.qtdAlunos, new NumberStringConverter());
		
        gridPane.add(new Label("Id"), 0, 0);
        gridPane.add(tfId, 1, 0);
        
		tfId.setEditable(false);
		tfId.setDisable(true);

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

		gridPane.add(btnSalvar, 0, 5);
		gridPane.add(btnPesquisar, 1, 5);
		gridPane.add(btnNovoCurso, 2, 0);

		btnSalvar.setOnAction( e -> {
			control.salvar();
		});

		btnPesquisar.setOnAction( e -> {
			control.pesquisar();
		});

		btnNovoCurso.setOnAction( e -> {
			control.novoCurso();
		});

		borderPane.setTop(gridPane);
		borderPane.setCenter(table);
		this.criarTabela();
		Scene scene = new Scene(borderPane, 700, 500);

        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Gestão de Cursos");
        stage.show();
    }

	public static void main(String[] args) {
		launch(args);
	}
	
}