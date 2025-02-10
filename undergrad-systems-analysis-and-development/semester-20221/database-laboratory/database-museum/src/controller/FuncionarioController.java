package controller;

import dao.FuncionarioDAOImpl;
import database.Database;
import database.DatabaseFactory;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import model.Funcionario;
import util.GerenciadorTelas;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.text.Normalizer;
import java.util.*;

public class FuncionarioController implements Initializable {

    @FXML
    private Label lblBuscarFuncionario;

    @FXML
    private TextField tfBuscarFuncionario;

    @FXML
    private Button btnAdicionar;

    @FXML
    private Button btnRecarregar;

    @FXML
    private ToggleGroup group;

    @FXML
    private RadioButton btnHome;

    @FXML
    private RadioButton btnArte;

    @FXML
    private RadioButton btnReserva;

    @FXML
    private RadioButton btnDoacao;

    @FXML
    private RadioButton btnFuncionario;

    @FXML
    private RadioButton btnSair;

    @FXML
    private TableView<Funcionario> tbFuncionario;

    @FXML
    private TableColumn<Funcionario, Long> tcId;

    @FXML
    private TableColumn<Funcionario, String> tcNome;

    @FXML
    private TableColumn<Funcionario, String> tcCpf;

    @FXML
    private TableColumn<Funcionario, String> tcTelefone;

    @FXML
    private TableColumn<Funcionario, String> tcCargo;

    @FXML
    private TableColumn<Funcionario, String> tcTurno;

    @FXML
    private TableColumn<Funcionario, String> tcEmail;

    @FXML
    private TableColumn<Funcionario, String> tcSenha;

    @FXML
    private TableColumn<Funcionario, String> tcAcoes;

    private List<Funcionario> listFuncionario = new ArrayList<>();
    private ObservableList<Funcionario> observableListFuncionario = FXCollections.observableArrayList();

    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    private final FuncionarioDAOImpl funcionarioDAO = new FuncionarioDAOImpl();
    private Funcionario funcionario = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        funcionarioDAO.setConnection(connection);
        carregarTableViewFuncionarios();
        pesquisar();

        btnHome.setOnAction(event -> {
            try {
                GerenciadorTelas.mudarScene(event, "../view/Home.fxml", "Database Museum - Home");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        btnArte.setOnAction(event -> {
            try {
                GerenciadorTelas.mudarScene(event, "../view/Arte.fxml", "Database Museum - Arte");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        btnReserva.setOnAction(event -> {
            try {
                GerenciadorTelas.mudarScene(event, "../view/Reserva.fxml", "Database Museum - Reserva");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        btnDoacao.setOnAction(event -> {
            try {
                GerenciadorTelas.mudarScene(event, "../view/Doacao.fxml", "Database Museum - Doação");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        btnSair.setOnAction(event -> {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
        });

        btnAdicionar.setOnMouseClicked(event -> {
            try {
                GerenciadorTelas.abrirPopUp(event, "../view/FuncionarioPopUp.fxml", "Database Museum - Adicionar Funcionário");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        btnRecarregar.setOnAction(event -> {
            recarregarTableViewFuncionarios();
            pesquisar();
        });
    }

    private void pesquisar() {

        FilteredList<Funcionario> funcionarioFilteredList = new FilteredList<>(observableListFuncionario, b -> true);
        tfBuscarFuncionario.textProperty().addListener((observable, oldValue, newValue) -> {
            funcionarioFilteredList.setPredicate(funcionario -> {
                if (newValue.isEmpty() || newValue.equals("") || newValue == null) {
                    return true;
                }

                String pesquisarPalavra = removeAccents(newValue.toLowerCase());

                if (removeAccents(funcionario.getNome()).toLowerCase().contains(pesquisarPalavra)) {
                    return true;
                } else {
                    return false;
                }

            });
        });

        SortedList<Funcionario> funcionarioSortedList = new SortedList<>(funcionarioFilteredList);
        funcionarioSortedList.comparatorProperty().bind(tbFuncionario.comparatorProperty());
        tbFuncionario.setItems(funcionarioSortedList);
    }

    private void carregarTableViewFuncionarios() {
        recarregarTableViewFuncionarios();

        tcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tcCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        tcTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        tcCargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));
        tcTurno.setCellValueFactory(new PropertyValueFactory<>("turno"));
        tcEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tcSenha.setCellValueFactory(new PropertyValueFactory<>("senha"));

        listFuncionario = funcionarioDAO.listar();
        observableListFuncionario = FXCollections.observableArrayList(listFuncionario);

        Callback<TableColumn<Funcionario, String>, TableCell<Funcionario, String>> cellFoctory = (TableColumn<Funcionario, String> param) -> {
            final TableCell<Funcionario, String> cell = new TableCell<Funcionario, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        FontAwesomeIconView deleteIcon = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
                        FontAwesomeIconView editIcon = new FontAwesomeIconView(FontAwesomeIcon.PENCIL_SQUARE);

                        deleteIcon.setStyle(" -fx-cursor: hand ;" + "-glyph-size:28px;" + "-fx-fill:#ff1744;");
                        editIcon.setStyle(" -fx-cursor: hand ;" + "-glyph-size:28px;" + "-fx-fill:#00E676;");
                        deleteIcon.setOnMouseClicked((MouseEvent event) -> {
                            Alert alert = new Alert(Alert.AlertType.WARNING, "Você tem certeza que deseja remover o funcionário? ", ButtonType.YES, ButtonType.CANCEL);
                            Optional<ButtonType> clicked = alert.showAndWait();
                            if (clicked.isPresent() && clicked.get().equals(ButtonType.YES)) {
                                funcionario = tbFuncionario.getSelectionModel().getSelectedItem();
                                funcionarioDAO.deletar(funcionario.getId());
                                recarregarTableViewFuncionarios();
                                pesquisar();
                            }
                        });

                        editIcon.setOnMouseClicked((MouseEvent event) -> {
                            funcionario = tbFuncionario.getSelectionModel().getSelectedItem();

                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("../view/FuncionarioPopUp.fxml"));
                            try {
                                loader.load();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            FuncionarioPopUpController funcionarioPopUpController = loader.getController();
                            funcionarioPopUpController.setUpdate(true);
                            funcionarioPopUpController.setTextField(funcionario.getId(), funcionario.getNome(), funcionario.getCpf(), funcionario.getTelefone(), funcionario.getCargo(), funcionario.getTurno(), funcionario.getEmail(), funcionario.getSenha());

                            Parent parent = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(parent));
                            stage.setTitle("Database Museum - Atualizar Funcionário");
                            stage.setResizable(false);
                            stage.initStyle(StageStyle.UTILITY);
                            stage.show();
                        });

                        HBox managebtn = new HBox(editIcon, deleteIcon);
                        managebtn.setStyle("-fx-alignment:center");
                        HBox.setMargin(deleteIcon, new Insets(2, 2, 0, 3));
                        HBox.setMargin(editIcon, new Insets(2, 3, 0, 2));

                        setGraphic(managebtn);
                        setText(null);
                    }
                }

            };

            return cell;
        };
        tcAcoes.setCellFactory(cellFoctory);

        tbFuncionario.setItems(observableListFuncionario);
    }

    private void recarregarTableViewFuncionarios() {
        observableListFuncionario.clear();

        listFuncionario = funcionarioDAO.listar();
        observableListFuncionario = FXCollections.observableArrayList(listFuncionario);
        tbFuncionario.setItems(observableListFuncionario);
    }

    public static String removeAccents(String text) {
        return text == null ? null : Normalizer.normalize(text, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }

}
