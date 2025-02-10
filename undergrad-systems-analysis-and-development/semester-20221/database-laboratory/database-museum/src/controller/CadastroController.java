package controller;

import dao.FuncionarioDAOImpl;
import database.Database;
import database.DatabaseFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import model.Funcionario;
import util.GerenciadorTelas;
import util.Security;
import util.Validacoes;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class CadastroController implements Initializable {

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfCpf;

    @FXML
    private TextField tfTelefone;

    @FXML
    private ComboBox<String> cbCargo;

    @FXML
    private ComboBox<String> cbTurno;

    @FXML
    private TextField tfEmail;

    @FXML
    private PasswordField tfSenha;

    @FXML
    private Button btnLogin;

    @FXML
    private Label lblErros;

    @FXML
    private Button btnCadastrar;

    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    private final FuncionarioDAOImpl funcionarioDAO = new FuncionarioDAOImpl();
    private Funcionario funcionario = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        funcionarioDAO.setConnection(connection);
        carregarComboBox();

        btnCadastrar.setOnAction(event -> {
            if (tfNome.getText().equals("") || tfCpf.getText().equals("") || tfTelefone.getText().equals("") || cbCargo.getValue().equals("") || cbTurno.getValue().equals("") || tfEmail.getText().equals("") || tfSenha.getText().equals("")) {
                lblErros.setTextFill(Color.TOMATO);
                lblErros.setText("Preencha todos os campos");
            } else if (funcionarioDAO.existeEmail(tfEmail.getText())) {
                lblErros.setTextFill(Color.TOMATO);
                lblErros.setText("Email já cadastrado");
            } else if (funcionarioDAO.existeCpf(tfCpf.getText())) {
                lblErros.setTextFill(Color.TOMATO);
                lblErros.setText("CPF já cadastrado");
            } else if (!Validacoes.validarEmail(tfEmail.getText())) {
                lblErros.setTextFill(Color.TOMATO);
                lblErros.setText("Email inválido");
            } else if (!Validacoes.validarCPF(tfCpf.getText())) {
                lblErros.setTextFill(Color.TOMATO);
                lblErros.setText("CPF inválido");
            } else if (!Validacoes.validarTelefone(tfTelefone.getText())) {
                lblErros.setTextFill(Color.TOMATO);
                lblErros.setText("Telefone inválido");
            } else {
                Funcionario funcionario = new Funcionario(tfNome.getText(), Validacoes.removeCaracteresEspeciais(tfCpf.getText()), Validacoes.removeCaracteresEspeciais(tfTelefone.getText()), cbCargo.getValue(), cbTurno.getValue(), tfEmail.getText(), tfSenha.getText());
                funcionarioDAO.inserir(funcionario);
                try {
                    GerenciadorTelas.mudarScene(event, "../view/Home.fxml", "Database Museum - Home");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btnLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    GerenciadorTelas.mudarScene(event, "../view/Login.fxml", "Database Museum - Login");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void carregarComboBox() {
        ObservableList<String> cargos = FXCollections.observableArrayList("Administrador", "Gerente", "Museólogo", "Segurança");
        cbCargo.setItems(cargos);

        ObservableList<String> turnos = FXCollections.observableArrayList("Matutino", "Vespertino", "Noturno");
        cbTurno.setItems(turnos);
    }

}
