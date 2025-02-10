package controller;

import dao.FuncionarioDAOImpl;
import database.Database;
import database.DatabaseFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import util.GerenciadorTelas;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private TextField tfEmail = new TextField();

    @FXML
    private PasswordField tfSenha = new PasswordField();

    @FXML
    private Label lblErros;

    @FXML
    private Button btnLogin;

    @FXML
    private Hyperlink btnEsqueceu;

    @FXML
    private Button btnCadastrar;

    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    private final FuncionarioDAOImpl funcionarioDAO = new FuncionarioDAOImpl();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        funcionarioDAO.setConnection(connection);

        btnLogin.setOnAction(event -> {
            if (tfEmail.getText().equals("") || tfSenha.getText().equals("")) {
                lblErros.setTextFill(Color.TOMATO);
                lblErros.setText("Preencha todos os campos");
            } else {
                boolean status = funcionarioDAO.login(tfEmail.getText(), tfSenha.getText());
                if (status) {
                    try {
                        GerenciadorTelas.mudarScene(event, "../view/Home.fxml", "Database Museum - Home");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    lblErros.setTextFill(Color.TOMATO);
                    lblErros.setText("Email ou Senha Incorreta");
                }
            }
        });

        btnCadastrar.setOnAction(event -> {
            try {
                GerenciadorTelas.mudarScene(event, "../view/Cadastro.fxml", "Database Museum - Cadastro");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        btnEsqueceu.setOnMouseClicked(event -> {
            try {
                GerenciadorTelas.abrirPopUp(event, "../view/EsqueceuPopUp.fxml", "Database Museum - Esqueceu sua Senha");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
