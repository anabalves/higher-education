package controller;

import dao.FuncionarioDAOImpl;
import database.Database;
import database.DatabaseFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Funcionario;
import util.GerenciadorTelas;
import util.Security;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class EsqueceuPopUpController implements Initializable {

    @FXML
    private TextField tfEmail;

    @FXML
    private PasswordField tfSenha;

    @FXML
    private Button btnAtualizar;

    @FXML
    private Label lblErros;

    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    private final FuncionarioDAOImpl funcionarioDAO = new FuncionarioDAOImpl();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        funcionarioDAO.setConnection(connection);

        btnAtualizar.setOnAction(event -> {
            if (tfEmail.getText().equals("") || tfSenha.getText().equals("")) {
                lblErros.setTextFill(Color.TOMATO);
                lblErros.setText("Preencha todos os campos");
            } else if (!funcionarioDAO.existeEmail(tfEmail.getText())) {
                lblErros.setTextFill(Color.TOMATO);
                lblErros.setText("Email não cadastrado");
            } else {
                funcionarioDAO.alterarSenha(tfEmail.getText(), tfSenha.getText());
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.close();
            }
        });
    }

}
