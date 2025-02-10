package exercicio19;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
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

public class AlunoBoundary extends Application {

	private TextField tfId = new TextField();
	private TextField tfRa = new TextField();
	private TextField tfNome = new TextField();
	private DatePicker dpNascimento = new DatePicker();

	private Button btnNovoAluno = new Button("Novo Aluno");
	private Button btnSalvar = new Button("Salvar");
	private Button btnPesquisar = new Button("Pesquisar");

	private AlunoControl control = new AlunoControl();   // Composição

	private TableView<Aluno> table = new TableView<>();

	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private void criarTabela() {
		TableColumn<Aluno, Long> col1 = new TableColumn<>("Id");
		col1.setCellValueFactory( new PropertyValueFactory<>("id") );

		TableColumn<Aluno, String> col2 = new TableColumn<>("Ra");
		col2.setCellValueFactory( new PropertyValueFactory<>("ra") );

		TableColumn<Aluno, String> col3 = new TableColumn<>("Nome");
		col3.setCellValueFactory( new PropertyValueFactory<>("nome") );

		TableColumn<Aluno, String> col4 = new TableColumn<>("Nascimento");
		col4.setCellValueFactory( (alunoProp) -> {
			LocalDate n = alunoProp.getValue().getNascimento();
			String strData = n.format(this.dtf);
			return new ReadOnlyStringWrapper(strData);
		} );

		TableColumn<Aluno, String> col5 = new TableColumn<>("Ações");
		col5.setCellValueFactory( new PropertyValueFactory<>("DUMMY") );
		col5.setCellFactory( (tbCol) ->
		new TableCell<Aluno, String>() {
			final Button btn = new Button("Remover");

			public void updateItem(String item, boolean empty) {
				if (empty) {
					setGraphic(null);
					setText(null);
				} else {
					btn.setOnAction( (e) -> {
						Aluno a = getTableView().getItems().get(getIndex());
						Alert alert = new Alert(Alert.AlertType.WARNING,
								"Voc� confirma a remo��o do Aluno Id " +
										a.getId(), ButtonType.OK, ButtonType.CANCEL);
						Optional<ButtonType> clicado = alert.showAndWait();
						if (clicado.isPresent() &&
								clicado.get().equals(ButtonType.OK)) {
							control.remover(a.getId());
						}
					});
					setGraphic(btn);
					setText(null);
				}
			}
		}
				);

		table.getColumns().addAll(col1, col2, col3, col4, col5);

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
		Bindings.bindBidirectional(tfRa.textProperty(), control.ra);
		Bindings.bindBidirectional(tfNome.textProperty(), control.nome);
		Bindings.bindBidirectional(dpNascimento.valueProperty(), control.nascimento);

		gridPane.add(new Label("Id"), 0, 0);
		gridPane.add(tfId, 1, 0);

		tfId.setEditable(false);
		tfId.setDisable(true);

		gridPane.add(new Label("RA"), 0, 1);
		gridPane.add(tfRa, 1, 1);

		gridPane.add(new Label("Nome"), 0, 2);
		gridPane.add(tfNome, 1, 2);

		gridPane.add(new Label("Nascimento"), 0, 4);
		gridPane.add(dpNascimento, 1, 4);

		gridPane.setPadding(new Insets(18));
		gridPane.setPadding(new Insets(9));
		gridPane.setHgap(10);
		gridPane.setVgap(10);

		gridPane.add(btnSalvar, 0, 5);
		gridPane.add(btnPesquisar, 1, 5);
		gridPane.add(btnNovoAluno, 2, 0);

		btnSalvar.setOnAction( e -> {
			control.salvar();
		});

		btnPesquisar.setOnAction( e -> {
			control.pesquisar();
		});

		btnNovoAluno.setOnAction( e -> {
			control.novoAluno();
		});

		borderPane.setTop(gridPane);
		borderPane.setCenter(table);
		this.criarTabela();
		Scene scene = new Scene(borderPane, 600, 400);

		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("Gestão de Alunos");
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}