package controller;

import dao.DoacaoDAOImpl;
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
import model.Doacao;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import util.GerenciadorTelas;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.text.Normalizer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DoacaoController implements Initializable {

    @FXML
    private TableView<Doacao> tbDoacoa;

    @FXML
    private TableColumn<Doacao, Long> tcId;

    @FXML
    private TableColumn<Doacao, String> tcNomeInstituicao;

    @FXML
    private TableColumn<Doacao, String> tcCnpj;

    @FXML
    private TableColumn<Doacao, Double> tcValorDoado;

    @FXML
    private TableColumn<Doacao, String> tcDataDoacao;

    @FXML
    private TableColumn<Doacao, String> tcDescricao;

    @FXML
    private TableColumn<Doacao, String> tcAcoes;

    @FXML
    private TextField tfBuscarDoacao;

    @FXML
    private Label lblBuscarDoacao;

    @FXML
    private Button btnAdicionar;

    @FXML
    private Button btnRecarregar;

    @FXML
    private Button btnImprimir;

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

    private List<Doacao> listDoacao = new ArrayList<>();
    private ObservableList<Doacao> observableListDoacao = FXCollections.observableArrayList();

    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    private final DoacaoDAOImpl doacaoDAO = new DoacaoDAOImpl();
    private Doacao doacao = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        doacaoDAO.setConnection(connection);
        carregarTableViewDoacoes();
        pesquisar();

        btnImprimir.setOnAction(event -> {
            try {
                URL url = getClass().getResource("/view/RelatorioValorTotalDeDoacoesPorMes.jasper");
                JasperReport jasperReport = (JasperReport) JRLoader.loadObject(url);

                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, connection);
                JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
                jasperViewer.setVisible(true);
            } catch (JRException e) {
                e.printStackTrace();
            }
        });

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
                GerenciadorTelas.abrirPopUp(event, "../view/DoacaoPopUp.fxml", "Database Museum - Adicionar Doação");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        btnRecarregar.setOnAction(event -> {
            recarregarTableViewDoacoes();
            pesquisar();
        });
    }

    private void pesquisar() {
        FilteredList<Doacao> doacaoFilteredList = new FilteredList<>(observableListDoacao, b -> true);
        tfBuscarDoacao.textProperty().addListener((observable, oldValue, newValue) -> {
            doacaoFilteredList.setPredicate(doacao -> {
                if (newValue.isEmpty() || newValue.equals("") || newValue == null) {
                    return true;
                }

                String pesquisarPalavra = removeAccents(newValue.toLowerCase());

                if (removeAccents(doacao.getNomeInstituicao()).toLowerCase().contains(pesquisarPalavra)) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<Doacao> doacaoSortedList = new SortedList<>(doacaoFilteredList);
        doacaoSortedList.comparatorProperty().bind(tbDoacoa.comparatorProperty());
        tbDoacoa.setItems(doacaoSortedList);
    }

    private void carregarTableViewDoacoes() {
        recarregarTableViewDoacoes();

        tcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcNomeInstituicao.setCellValueFactory(new PropertyValueFactory<>("nomeInstituicao"));
        tcCnpj.setCellValueFactory(new PropertyValueFactory<>("cnpj"));
        tcValorDoado.setCellValueFactory(new PropertyValueFactory<>("valorDoado"));
        tcDataDoacao.setCellValueFactory((doacaoProp) -> {
            LocalDate localDate = doacaoProp.getValue().getDataDoacao();
            String dateToStr = localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            return new ReadOnlyStringWrapper(dateToStr);
        });

        tcDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));

        listDoacao = doacaoDAO.listar();
        observableListDoacao = FXCollections.observableArrayList(listDoacao);

        Callback<TableColumn<Doacao, String>, TableCell<Doacao, String>> cellFoctory = (TableColumn<Doacao, String> param) -> {
            final TableCell<Doacao, String> cell = new TableCell<Doacao, String>() {
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
                            Alert alert = new Alert(Alert.AlertType.WARNING, "Você tem certeza que deseja remover a doação? ", ButtonType.YES, ButtonType.CANCEL);
                            Optional<ButtonType> clicked = alert.showAndWait();
                            if (clicked.isPresent() && clicked.get().equals(ButtonType.YES)) {
                                doacao = tbDoacoa.getSelectionModel().getSelectedItem();
                                doacaoDAO.deletar(doacao.getId());
                                recarregarTableViewDoacoes();
                                pesquisar();
                            }
                        });

                        editIcon.setOnMouseClicked((MouseEvent event) -> {
                            doacao = tbDoacoa.getSelectionModel().getSelectedItem();

                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("../view/DoacaoPopUp.fxml"));
                            try {
                                loader.load();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            DoacaoPopUpController doacaoPopUpController = loader.getController();
                            doacaoPopUpController.setUpdate(true);
                            doacaoPopUpController.setTextField(doacao.getId(), doacao.getNomeInstituicao(), doacao.getCnpj(), doacao.getValorDoado(), doacao.getDataDoacao(), doacao.getDescricao());

                            Parent parent = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(parent));
                            stage.setTitle("Database Museum - Atualizar Doação");
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

        tbDoacoa.setItems(observableListDoacao);
    }

    private void recarregarTableViewDoacoes() {
        observableListDoacao.clear();

        listDoacao = doacaoDAO.listar();
        observableListDoacao = FXCollections.observableArrayList(listDoacao);
        tbDoacoa.setItems(observableListDoacao);
    }

    public static String removeAccents(String text) {
        return text == null ? null : Normalizer.normalize(text, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }

}
