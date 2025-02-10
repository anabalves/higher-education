package controller;

import dao.ArteDAOImpl;
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
import model.Arte;
import util.GerenciadorTelas;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.text.Normalizer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ArteController implements Initializable {

    @FXML
    private TextField tfBuscarArte;

    @FXML
    private Label lblBuscarArte;

    @FXML
    private Button btnAdicionar;

    @FXML
    private Button btnRecarregar;

    @FXML
    private TableView<Arte> tbArte;

    @FXML
    private TableColumn<Arte, Long> tcId;

    @FXML
    private TableColumn<Arte, String> tcNomeObra;

    @FXML
    private TableColumn<Arte, String> tcNomeArtista;

    @FXML
    private TableColumn<Arte, String> tcDataCriacao;

    @FXML
    private TableColumn<Arte, String> tcDescricao;

    @FXML
    private TableColumn<Arte, String> tcAcoes;

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

    private List<Arte> listArte = new ArrayList<>();
    private ObservableList<Arte> observableListArte = FXCollections.observableArrayList();

    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    private final ArteDAOImpl arteDAO = new ArteDAOImpl();
    private Arte arte = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        arteDAO.setConnection(connection);
        carregarTableViewArtes();
        pesquisar();

        btnHome.setOnAction(event -> {
            try {
                GerenciadorTelas.mudarScene(event, "../view/Home.fxml", "Database Museum - Home");
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
                GerenciadorTelas.abrirPopUp(event, "../view/ArtePopUp.fxml", "Database Museum - Adicionar Arte");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        btnRecarregar.setOnAction(event -> {
            recarregarTableViewArtes();
            pesquisar();
        });
    }

    private void pesquisar() {
        FilteredList<Arte> arteFilteredList = new FilteredList<>(observableListArte, b -> true);
        tfBuscarArte.textProperty().addListener((observable, oldValue, newValue) -> {
            arteFilteredList.setPredicate(arte -> {
                if (newValue.isEmpty() || newValue.equals("") || newValue == null) {
                    return true;
                }

                String pesquisarPalavra = removeAccents(newValue.toLowerCase());

                if (removeAccents(arte.getNomeObra()).toLowerCase().contains(pesquisarPalavra)) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<Arte> arteSortedList = new SortedList<>(arteFilteredList);
        arteSortedList.comparatorProperty().bind(tbArte.comparatorProperty());
        tbArte.setItems(arteSortedList);
    }

    private void carregarTableViewArtes() {
        recarregarTableViewArtes();

        tcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcNomeObra.setCellValueFactory(new PropertyValueFactory<>("nomeObra"));
        tcNomeArtista.setCellValueFactory(new PropertyValueFactory<>("nomeArtista"));
        tcDataCriacao.setCellValueFactory((arteProp) -> {
            LocalDate localDate = arteProp.getValue().getDataCriacao();
            String dateToStr = localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            return new ReadOnlyStringWrapper(dateToStr);
        });

        tcDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));

        listArte = arteDAO.listar();
        observableListArte = FXCollections.observableArrayList(listArte);

        Callback<TableColumn<Arte, String>, TableCell<Arte, String>> cellFoctory = (TableColumn<Arte, String> param) -> {
            final TableCell<Arte, String> cell = new TableCell<Arte, String>() {
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
                            Alert alert = new Alert(Alert.AlertType.WARNING, "Você tem certeza que deseja remover a arte? ", ButtonType.YES, ButtonType.CANCEL);
                            Optional<ButtonType> clicked = alert.showAndWait();
                            if (clicked.isPresent() && clicked.get().equals(ButtonType.YES)) {
                                arte = tbArte.getSelectionModel().getSelectedItem();
                                arteDAO.deletar(arte.getId());
                                recarregarTableViewArtes();
                                pesquisar();
                            }
                        });

                        editIcon.setOnMouseClicked((MouseEvent event) -> {
                            arte = tbArte.getSelectionModel().getSelectedItem();

                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("../view/ArtePopUp.fxml"));
                            try {
                                loader.load();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            ArtePopUpController artePopUpController = loader.getController();
                            artePopUpController.setUpdate(true);
                            artePopUpController.setTextField(arte.getId(), arte.getNomeObra(), arte.getNomeArtista(), arte.getDataCriacao(), arte.getDescricao());

                            Parent parent = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(parent));
                            stage.setTitle("Database Museum - Atualizar Arte");
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

        tbArte.setItems(observableListArte);
    }

    private void recarregarTableViewArtes() {
        observableListArte.clear();

        listArte = arteDAO.listar();
        observableListArte = FXCollections.observableArrayList(listArte);
        tbArte.setItems(observableListArte);
    }

    public static String removeAccents(String text) {
        return text == null ? null : Normalizer.normalize(text, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }

}
