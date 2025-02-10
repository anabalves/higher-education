package exercicio22.aluno;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import exercicio22.StrategyBoundary;
import exercicio22.curso.Curso;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.geometry.Insets;
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
import javafx.scene.layout.Pane;
import javafx.util.converter.NumberStringConverter;

public class AlunoBoundary implements StrategyBoundary {

	private TextField tfId = new TextField();
	private TextField tfRa = new TextField();
	private TextField tfNome = new TextField();
	private DatePicker dpNascimento = new DatePicker();

	private Button btnAdicionar = new Button("Adicionar");
	private Button btnPesquisar = new Button("Pesquisar");
	private Button btnRemover = new Button("Remover");
	private Button btnAtualizar = new Button("Atualizar");
    private Button btnLimpar = new Button("Limpar");

	private AlunoControl control = new AlunoControl();   // Composição

	private TableView<Aluno> table = new TableView<>();

	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private void criarTabela() {
		control.listarTodos();
		
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

		table.getColumns().addAll(col1, col2, col3, col4);

		table.setItems(control.getListaView());

		table
		.getSelectionModel()
		.selectedItemProperty()
		.addListener( (obs, antigo, novo) -> {
			if (novo != null) {
				control.setEntity(novo);
			}
		});
	}

    @Override
    public Pane render() {
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

		gridPane.add(btnAdicionar, 0, 5);
		gridPane.add(btnPesquisar, 1, 5);
		gridPane.add(btnRemover, 2, 5);
		gridPane.add(btnAtualizar, 3, 5);
		gridPane.add(btnLimpar, 4, 5);

		btnAdicionar.setOnAction( e -> {
			control.adicionar();
		});

		btnPesquisar.setOnAction( e -> {
			control.pesquisar();
		});

		btnRemover.setOnAction( e -> {
			control.remover();
		});
		
		btnAtualizar.setOnAction( e -> {
			control.atualizar();
		});
		
		btnLimpar.setOnAction( e -> {
			control.limparCampos();
		});

		borderPane.setTop(gridPane);
		borderPane.setCenter(table);
        if (getTable().getColumns().size() == 0) {
    		this.criarTabela();
        }
		
        return (borderPane);
	}
    
	public TableView<Aluno> getTable() {
		return table;
	}

}