package exercicio22.curso;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import exercicio22.StrategyBoundary;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.converter.NumberStringConverter;

public class CursoBoundary implements StrategyBoundary {
	
    private TextField tfId = new TextField();
    private TextField tfNome = new TextField();
    private TextField tfDescricao = new TextField();
    private ComboBox<Boolean> cbAtivo = new ComboBox<>();
    private DatePicker dpInicio = new DatePicker();
    private DatePicker dpTermino = new DatePicker();
    
	private Button btnAdicionar = new Button("Adicionar");
	private Button btnPesquisar = new Button("Pesquisar");
	private Button btnRemover = new Button("Remover");
	private Button btnAtualizar = new Button("Atualizar");
    private Button btnLimpar = new Button("Limpar");
	
	private CursoControl control = new CursoControl();   // Composi��o
	private TableView<Curso> table = new TableView<>();
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
   
	private void criarTabela() {
		control.listarTodos();
		TableColumn<Curso, Long> col1 = new TableColumn<>("Id");
		col1.setCellValueFactory( new PropertyValueFactory<>("id") );

		TableColumn<Curso, String> col2 = new TableColumn<>("Nome do Curso");
		col2.setCellValueFactory( new PropertyValueFactory<>("nome") );

		TableColumn<Curso, String> col3 = new TableColumn<>("Descrição");
		col3.setCellValueFactory( new PropertyValueFactory<>("descricao") );

		ObservableList<Boolean> items =
				FXCollections.observableArrayList(true, false);
		cbAtivo.setItems(items);
		
		TableColumn<Curso, Boolean> col4 = new TableColumn<>("Ativo");
		col4.setCellValueFactory( new PropertyValueFactory<>("ativo") );
		
		TableColumn<Curso, String> col5 = new TableColumn<>("Inicio");
		col5.setCellValueFactory( (cursoProp) -> {
			LocalDate t = cursoProp.getValue().getInicio();
			String strData = t.format(this.dtf);
			return new ReadOnlyStringWrapper(strData);
		} );
		
		TableColumn<Curso, String> col6 = new TableColumn<>("Término");
		col6.setCellValueFactory( (cursoProp) -> {
			LocalDate t = cursoProp.getValue().getTermino();
			String strData = t.format(this.dtf);
			return new ReadOnlyStringWrapper(strData);
		} );

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
    public Pane render() {
		BorderPane borderPane = new BorderPane();
        GridPane gridPane = new GridPane();
        
		Bindings.bindBidirectional(tfId.textProperty(), control.id, new NumberStringConverter());
		Bindings.bindBidirectional(tfNome.textProperty(), control.nome);
		Bindings.bindBidirectional(tfDescricao.textProperty(), control.descricao);
		Bindings.bindBidirectional(cbAtivo.valueProperty(), control.ativo);
		Bindings.bindBidirectional(dpInicio.valueProperty(), control.inicio);
		Bindings.bindBidirectional(dpTermino.valueProperty(), control.termino);
		
        gridPane.add(new Label("Id"), 0, 0);
        gridPane.add(tfId, 1, 0);
        
		tfId.setEditable(false);
		tfId.setDisable(true);

        gridPane.add(new Label("Nome"), 0, 1);
        gridPane.add(tfNome, 1, 1);

        gridPane.add(new Label("Descrição"), 0, 2);
        gridPane.add(tfDescricao, 1, 2);

        gridPane.add(new Label("Ativo"), 0, 3);
        gridPane.add(cbAtivo, 1, 3);
        
        gridPane.add(new Label("Inicio"), 0, 4);
        gridPane.add(dpInicio, 1, 4);
    
        gridPane.add(new Label("Termino"), 0, 5);
        gridPane.add(dpTermino, 1, 5);
        
        gridPane.setPadding(new Insets(18));
        gridPane.setPadding(new Insets(9));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

		gridPane.add(btnAdicionar, 0, 6);
		gridPane.add(btnPesquisar, 1, 6);
		gridPane.add(btnRemover, 2, 6);
		gridPane.add(btnAtualizar, 3, 6);
		gridPane.add(btnLimpar, 4, 6);
		
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
    
	public TableView<Curso> getTable() {
		return table;
	}
	
}