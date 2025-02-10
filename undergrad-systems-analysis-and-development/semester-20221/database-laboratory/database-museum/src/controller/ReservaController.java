package controller;

import dao.ArteDAOImpl;
import dao.ReservaDAOImpl;
import database.Database;
import database.DatabaseFactory;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.beans.property.ReadOnlyStringWrapper;
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
import model.Reserva;
import util.GerenciadorTelas;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.text.Normalizer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class ReservaController implements Initializable {

    @FXML
    public TableView<Reserva> tbReserva;

    @FXML
    public TableColumn<Reserva, Long> tcId;

    @FXML
    public TableColumn<Reserva, String> tcNome;

    @FXML
    public TableColumn<Reserva, String> tcCpf;

    @FXML
    public TableColumn<Reserva, String> tcTelefone;

    @FXML
    public TableColumn<Reserva, Integer> tcQuantidadePessoas;

    @FXML
    public TableColumn<Reserva, String> tcDataReserva;

    @FXML
    public TableColumn<Reserva, String> tcHorarioInicio;

    @FXML
    public TableColumn<Reserva, String> tcAcoes;

    @FXML
    private TextField tfBuscarReserva;

    @FXML
    private Label lblBuscarReserva;

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

    private List<Reserva> listReserva = new ArrayList<>();
    private ObservableList<Reserva> observableListReserva = FXCollections.observableArrayList();

    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    private final ReservaDAOImpl reservaDAO = new ReservaDAOImpl();
    private Reserva reserva = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        reservaDAO.setConnection(connection);
        carregarTableViewReservas();
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

        btnDoacao.setOnAction(event -> {
            try {
                GerenciadorTelas.mudarScene(event, "../view/Doacao.fxml", "Database Museum - Doação");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        btnFuncionario.setOnAction(event -> {
            try {
                GerenciadorTelas.mudarScene(event, "../view/Funcionario.fxml", "Database Museum - Funcionário");
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
                GerenciadorTelas.abrirPopUp(event, "../view/ReservaPopUp.fxml", "Database Museum - Adicionar Reserva");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        btnRecarregar.setOnAction(event -> {
            recarregarTableViewReservas();
            pesquisar();
        });
    }

    private void pesquisar() {
        FilteredList<Reserva> reservaFilteredList = new FilteredList<>(observableListReserva, b -> true);
        tfBuscarReserva.textProperty().addListener((observable, oldValue, newValue) -> {
            reservaFilteredList.setPredicate(reserva -> {
                if (newValue.isEmpty() || newValue.equals("") || newValue == null) {
                    return true;
                }

                String pesquisarPalavra = removeAccents(newValue.toLowerCase());

                if (removeAccents(reserva.getNome()).toLowerCase().contains(pesquisarPalavra)) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<Reserva> reservaSortedList = new SortedList<>(reservaFilteredList);
        reservaSortedList.comparatorProperty().bind(tbReserva.comparatorProperty());
        tbReserva.setItems(reservaSortedList);
    }

    private void carregarTableViewReservas() {
        recarregarTableViewReservas();

        tcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tcCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        tcTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        tcQuantidadePessoas.setCellValueFactory(new PropertyValueFactory<>("quantidadePessoas"));
        tcDataReserva.setCellValueFactory((reservaProp) -> {
            LocalDate localDate = reservaProp.getValue().getDataReserva();
            String dateToStr = localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            return new ReadOnlyStringWrapper(dateToStr);
        });
        tcHorarioInicio.setCellValueFactory(new PropertyValueFactory<>("horaInicio"));

        listReserva = reservaDAO.listar();
        observableListReserva = FXCollections.observableArrayList(listReserva);

        Callback<TableColumn<Reserva, String>, TableCell<Reserva, String>> cellFoctory = (TableColumn<Reserva, String> param) -> {
            final TableCell<Reserva, String> cell = new TableCell<Reserva, String>() {
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
                            Alert alert = new Alert(Alert.AlertType.WARNING, "Você tem certeza que deseja remover a reserva? ", ButtonType.YES, ButtonType.CANCEL);
                            Optional<ButtonType> clicked = alert.showAndWait();
                            if (clicked.isPresent() && clicked.get().equals(ButtonType.YES)) {
                                reserva = tbReserva.getSelectionModel().getSelectedItem();
                                reservaDAO.deletar(reserva.getId());
                                recarregarTableViewReservas();
                                pesquisar();
                            }
                        });

                        editIcon.setOnMouseClicked((MouseEvent event) -> {
                            reserva = tbReserva.getSelectionModel().getSelectedItem();

                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("../view/ReservaPopUp.fxml"));
                            try {
                                loader.load();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            ReservaPopUpController reservaPopUpController = loader.getController();
                            reservaPopUpController.setUpdate(true);
                            reservaPopUpController.setTextField(reserva.getId(), reserva.getNome(), reserva.getCpf(), reserva.getTelefone(), reserva.getQuantidadePessoas(), reserva.getDataReserva(), reserva.getHoraInicio());

                            Parent parent = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(parent));
                            stage.setTitle("Database Museum - Atualizar Reserva");
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

        tbReserva.setItems(observableListReserva);
    }

    private void recarregarTableViewReservas() {
        observableListReserva.clear();

        listReserva = reservaDAO.listar();
        observableListReserva = FXCollections.observableArrayList(listReserva);
        tbReserva.setItems(observableListReserva);
    }

    public static String removeAccents(String text) {
        return text == null ? null : Normalizer.normalize(text, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }

}
