package exercicio21;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class PetBoundary extends Application {

	private TextField tfId = new TextField();
	private TextField tfNome = new TextField();
	private ComboBox<String> cbRaca = new ComboBox<>();
	private TextField tfPeso = new TextField();
	private DatePicker dtNascimento = new DatePicker();

	private Button btnNovoPet = new Button("Novo Pet");
	private Button btnSalvar = new Button("Salvar");
	private Button btnPesquisar = new Button("Pesquisar");

	private PetControl control = new PetControl();   // Composição

	private TableView<Pet> table = new TableView<>();

	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private void criarTabela() {
		ObservableList<String> items =
				FXCollections.observableArrayList("Vira lata", "Poodle", "Pastor Alemão", "Siamês");
		cbRaca.setItems(items);
		cbRaca.setValue("Selecione");

		TableColumn<Pet, Long> col1 = new TableColumn<>("Id");
		col1.setCellValueFactory( new PropertyValueFactory<>("id") );

		TableColumn<Pet, String> col2 = new TableColumn<>("Nome");
		col2.setCellValueFactory( new PropertyValueFactory<>("nome") );

		TableColumn<Pet, String> col3 = new TableColumn<>("Raça");
		col3.setCellValueFactory( new PropertyValueFactory<>("raca") );

		TableColumn<Pet, Double> col4 = new TableColumn<>("Peso");
		col4.setCellValueFactory( new PropertyValueFactory<>("peso") );

		TableColumn<Pet, String> col5 = new TableColumn<>("Nascimento");
		col5.setCellValueFactory( (petProp) -> {
			LocalDate n = petProp.getValue().getNascimento();
			String strData = n.format(this.dtf);
			return new ReadOnlyStringWrapper(strData);
		} );

		TableColumn<Pet, String> col6 = new TableColumn<>("Ações");
		col6.setCellValueFactory( new PropertyValueFactory<>("DUMMY") );
		col6.setCellFactory( (tbCol) ->
		new TableCell<Pet, String>() {
			final Button btn = new Button("Remover");

			public void updateItem(String item, boolean empty) {
				if (empty) {
					setGraphic(null);
					setText(null);
				} else {
					btn.setOnAction( (e) -> {
						Pet p = getTableView().getItems().get(getIndex());
						Alert alert = new Alert(Alert.AlertType.WARNING,
								"Você confirma a remoção do Pet Id " +
										p.getId(), ButtonType.OK, ButtonType.CANCEL);
						Optional<ButtonType> clicado = alert.showAndWait();
						if (clicado.isPresent() &&
								clicado.get().equals(ButtonType.OK)) {
							control.remover(p.getId());
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
		Bindings.bindBidirectional(cbRaca.valueProperty(), control.raca);
		Bindings.bindBidirectional(tfPeso.textProperty(), control.peso, new NumberStringConverter());
		Bindings.bindBidirectional(dtNascimento.valueProperty(),
				control.nascimento);

		gridPane.add(new Label("Id"), 0, 0);
		gridPane.add(tfId, 1, 0);

		tfId.setEditable(false);
		tfId.setDisable(true);

		gridPane.add(new Label("Nome"), 0, 1);
		gridPane.add(tfNome, 1, 1);

		gridPane.add(new Label("Raça"), 0, 2);
		gridPane.add(cbRaca, 1, 2);

		gridPane.add(new Label("Peso"), 0, 3);
		gridPane.add(tfPeso, 1, 3);

		gridPane.add(new Label("Nascimento"), 0, 4);
		gridPane.add(dtNascimento, 1, 4);

		gridPane.add(btnSalvar, 0, 5);
		gridPane.add(btnPesquisar, 1, 5);
		gridPane.add(btnNovoPet, 2, 0);

		gridPane.setPadding(new Insets(18));
		gridPane.setPadding(new Insets(9));
		gridPane.setHgap(10);
		gridPane.setVgap(10);

		btnSalvar.setOnAction(e -> {
			control.salvar();
		});

		btnPesquisar.setOnAction( e -> {
			control.pesquisar();
		});

		btnNovoPet.setOnAction( e -> {
			control.novoPet();
		});

		borderPane.setTop(gridPane);
		borderPane.setCenter(table);
		this.criarTabela();
		Scene scn = new Scene(borderPane, 600, 400);

		stage.setScene(scn);
		stage.setTitle("Gestão de Pets");
		stage.show();
	}

	public static void main(String[] args) {
		Application.launch(PetBoundary.class, args);
	}

}