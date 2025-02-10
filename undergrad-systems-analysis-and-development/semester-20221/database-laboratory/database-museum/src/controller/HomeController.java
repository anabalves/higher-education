package controller;

import dao.ReservaDAOImpl;
import database.Database;
import database.DatabaseFactory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import java.net.URL;
import java.sql.Connection;
import java.util.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import util.GerenciadorTelas;

import java.io.IOException;


public class HomeController implements Initializable {

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
    private BarChart barChart;

    @FXML
    private CategoryAxis categoryAxis;

    @FXML
    private NumberAxis NumberAxis;

    private ObservableList<String> observableListMeses = FXCollections.observableArrayList();

    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    private final ReservaDAOImpl reservaDAO = new ReservaDAOImpl();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        String[] arrayMeses = {"Jan", "Fev", "Mar", "Abr", "Mai", "Jun", "Jul", "Ago", "Set", "Out", "Nov", "Dez"};

        observableListMeses.addAll(Arrays.asList(arrayMeses));

        categoryAxis.setCategories(observableListMeses);
        reservaDAO.setConnection(connection);
        Map<Integer, ArrayList> dados = reservaDAO.listarQuantidadeVisitasPorMes();
        for (Map.Entry<Integer, ArrayList> dadosItem : dados.entrySet()) {
            XYChart.Series<String, Integer> series = new XYChart.Series<>();
            series.setName(dadosItem.getKey().toString());
            for (int i = 0; i < dadosItem.getValue().size(); i = i + 2) {
                String mes;
                Integer quantidade;
                mes = retornaNomeMes((int) dadosItem.getValue().get(i));
                quantidade = (Integer) dadosItem.getValue().get(i + 1);
                series.getData().add(new XYChart.Data<>(mes, quantidade));
            }
            barChart.getData().add(series);
        }

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

        btnDoacao.setOnAction(event -> {
            try {
                GerenciadorTelas.mudarScene(event, "../view/Doacao.fxml", "Database Museum - Doação");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        btnSair.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.close();
            }
        });

    }

    public String retornaNomeMes(int mes) {
        switch (mes) {
            case 1:
                return "Jan";
            case 2:
                return "Fev";
            case 3:
                return "Mar";
            case 4:
                return "Abr";
            case 5:
                return "Mai";
            case 6:
                return "Jun";
            case 7:
                return "Jul";
            case 8:
                return "Ago";
            case 9:
                return "Set";
            case 10:
                return "Out";
            case 11:
                return "Nov";
            case 12:
                return "Dez";
            default:
                return "";
        }
    }

}
