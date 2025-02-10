package controller;

import dao.FuncionarioDAOImpl;
import database.Database;
import database.DatabaseFactory;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import model.Funcionario;
import util.GerenciadorTelas;
import util.Validacoes;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class FuncionarioPopUpController implements Initializable {

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfCpf;

    @FXML
    private TextField tfTelefone;

    @FXML
    private TextField tfEmail;

    @FXML
    private PasswordField tfSenha;

    @FXML
    private ComboBox<String> cbCargo;

    @FXML
    private ComboBox<String> cbTurno;

    @FXML
    private Label lblErros;

    @FXML
    private Button btnOk;

    @FXML
    private Button btnLimpar;

    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    private final FuncionarioDAOImpl funcionarioDAO = new FuncionarioDAOImpl();
    private boolean update;
    private Long funcionarioId;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        funcionarioDAO.setConnection(connection);
        carregarComboBox();

        addTextLimiter(tfNome, 255);

        btnOk.setOnAction(event -> {
            if (!update) {
                if (tfNome.getText().equals("") || tfCpf.getText().equals("") || tfTelefone.getText().equals("") || cbCargo.getValue() == null || cbTurno.getValue() == null || tfEmail.getText().equals("") || tfSenha.getText().equals("")) {
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
                        GerenciadorTelas.fecharPopUp(event);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                if (tfNome.getText().equals("")  || tfTelefone.getText().equals("") || cbCargo.getValue().equals("") || cbTurno.getValue().equals("")) {
                    lblErros.setTextFill(Color.TOMATO);
                    lblErros.setText("Preencha todos os campos");
                } else if (!Validacoes.validarTelefone(tfTelefone.getText())) {
                    lblErros.setTextFill(Color.TOMATO);
                    lblErros.setText("Telefone inválido");
                } else {
                    Funcionario funcionario = new Funcionario(tfNome.getText(), Validacoes.removeCaracteresEspeciais(tfTelefone.getText()), cbCargo.getValue(), cbTurno.getValue());
                    funcionarioDAO.alterar(funcionarioId, funcionario);
                    try {
                        GerenciadorTelas.fecharPopUp(event);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        btnLimpar.setOnAction(event -> {
            tfNome.setText("");
            tfCpf.setText("");
            tfTelefone.setText("");
            cbCargo.setValue(null);
            cbTurno.setValue(null);
            tfEmail.setText("");
            tfSenha.setText("");
        });
    }

    private void carregarComboBox() {
        ObservableList<String> cargos = FXCollections.observableArrayList("Administrador", "Gerente", "Museólogo", "Segurança");
        cbCargo.setItems(cargos);

        ObservableList<String> turnos = FXCollections.observableArrayList("Matutino", "Vespertino", "Noturno");
        cbTurno.setItems(turnos);
    }

    void setUpdate(boolean b) {
        this.update = b;
    }

    public void setTextField(Long id, String nome, String cpf, String telefone, String cargo, String turno, String email, String senha) {
        funcionarioId = id;
        tfNome.setText(nome);
        tfCpf.setText(cpf);
        tfTelefone.setText(telefone);
        cbCargo.setValue(cargo);
        cbTurno.setValue(turno);
        tfEmail.setText(email);
        tfSenha.setText(senha);
        tfCpf.setDisable(true);
        tfCpf.setEditable(false);
        tfEmail.setDisable(true);
        tfEmail.setEditable(false);
        tfSenha.setDisable(true);
        tfSenha.setEditable(false);
    }

    public static void addTextLimiter(final TextField tf, final int maxLength) {
        tf.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
                if (tf.getText().length() > maxLength) {
                    String s = tf.getText().substring(0, maxLength);
                    tf.setText(s);
                }
            }
        });
    }

}
