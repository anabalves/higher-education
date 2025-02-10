package controller;

import dao.DoacaoDAOImpl;
import database.Database;
import database.DatabaseFactory;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.beans.value.ChangeListener;
import model.Doacao;
import util.CurrencyField;
import util.GerenciadorTelas;
import util.Validacoes;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.scene.control.TextField;

public class DoacaoPopUpController implements Initializable {

    @FXML
    private TextField tfNomeInstituicao;

    @FXML
    private TextField tfCnpj;

    @FXML
    private CurrencyField tfValorDoacao;

    @FXML
    private DatePicker dpDataDoacao;

    @FXML
    private TextArea taDescricao;

    @FXML
    private Label lblErros;

    @FXML
    private Button btnOk;

    @FXML
    private Button btnLimpar;

    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    private final DoacaoDAOImpl doacaoDAO = new DoacaoDAOImpl();
    private boolean update;
    private Long doacaoId;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        doacaoDAO.setConnection(connection);

        addTextLimiter(tfNomeInstituicao, 255);
        addTextLimiter(taDescricao, 255);

        btnOk.setOnAction(event -> {
            if (!update) {
                if (tfNomeInstituicao.getText().equals("") || tfCnpj.getText().equals("") || tfValorDoacao.getAmount().equals(0.0) || dpDataDoacao.getValue() == null || taDescricao.getText().equals("")) {
                    lblErros.setTextFill(Color.TOMATO);
                    lblErros.setText("Preencha todos os campos");
                } else if (!Validacoes.validarCNPJ(tfCnpj.getText())) {
                    lblErros.setTextFill(Color.TOMATO);
                    lblErros.setText("CNPJ inválido");
                } else {
                    Doacao doacao = new Doacao(tfNomeInstituicao.getText(), Validacoes.removeCaracteresEspeciais(tfCnpj.getText()), tfValorDoacao.getAmount(), dpDataDoacao.getValue(), taDescricao.getText());
                    doacaoDAO.inserir(doacao);
                    try {
                        GerenciadorTelas.fecharPopUp(event);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                if (tfNomeInstituicao.getText().equals("") || tfValorDoacao.getAmount().equals(0.0) || dpDataDoacao.getValue() == null || taDescricao.getText().equals("")) {
                    lblErros.setTextFill(Color.TOMATO);
                    lblErros.setText("Preencha todos os campos");
                } else if (!Validacoes.validarCNPJ(tfCnpj.getText())) {
                    lblErros.setTextFill(Color.TOMATO);
                    lblErros.setText("CNPJ inválido");
                } else {
                    Doacao doacao = new Doacao(tfNomeInstituicao.getText(), Validacoes.removeCaracteresEspeciais(tfCnpj.getText()), tfValorDoacao.getAmount(), dpDataDoacao.getValue(), taDescricao.getText());
                    doacaoDAO.alterar(doacaoId, doacao);
                    try {
                        GerenciadorTelas.fecharPopUp(event);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        btnLimpar.setOnAction(event -> {
            tfNomeInstituicao.setText("");
            tfCnpj.setText("");
            tfValorDoacao.setAmount(0.0);
            dpDataDoacao.setValue(null);
            taDescricao.setText("");
        });
    }

    void setUpdate(boolean b) {
        this.update = b;
    }

    public void setTextField(Long id, String nomeInstituicao, String cnpj, Double valorDoado, LocalDate dataDoacao, String descricao) {
        doacaoId = id;
        tfNomeInstituicao.setText(nomeInstituicao);
        tfCnpj.setText(cnpj);
        tfValorDoacao.setAmount(valorDoado);
        dpDataDoacao.setValue(dataDoacao);
        taDescricao.setText(descricao);
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

    public static void addTextLimiter(final TextArea tf, final int maxLength) {
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


