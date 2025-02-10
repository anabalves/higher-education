package controller;

import dao.ArteDAOImpl;
import database.Database;
import database.DatabaseFactory;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import model.Arte;
import util.GerenciadorTelas;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

public class ArtePopUpController implements Initializable {

    @FXML
    private TextField tfNomeObra;

    @FXML
    private TextField tfNomeArtista;

    @FXML
    private DatePicker dpDataCriacao;

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
    private final ArteDAOImpl arteDAO = new ArteDAOImpl();
    private boolean update;
    private Long arteId;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        arteDAO.setConnection(connection);

        addTextLimiter(tfNomeObra, 255);
        addTextLimiter(tfNomeArtista, 255);
        addTextLimiter(taDescricao, 255);

        btnOk.setOnAction(event -> {
            if (!update) {
                if (tfNomeObra.getText().equals("") || tfNomeArtista.getText().equals("") || dpDataCriacao.getValue() == null || taDescricao.getText().equals("")) {
                    lblErros.setTextFill(Color.TOMATO);
                    lblErros.setText("Preencha todos os campos");
                } else {
                    Arte arte = new Arte(tfNomeObra.getText(), tfNomeArtista.getText(), dpDataCriacao.getValue(), taDescricao.getText());
                    arteDAO.inserir(arte);
                    try {
                        GerenciadorTelas.fecharPopUp(event);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                if (tfNomeObra.getText().equals("") || tfNomeArtista.getText().equals("") || dpDataCriacao.getValue() == null || taDescricao.getText().equals("")) {
                    lblErros.setTextFill(Color.TOMATO);
                    lblErros.setText("Preencha todos os campos");
                } else {
                    Arte arte = new Arte(tfNomeObra.getText(), tfNomeArtista.getText(), dpDataCriacao.getValue(), taDescricao.getText());
                    arteDAO.alterar(arteId, arte);
                    try {
                        GerenciadorTelas.fecharPopUp(event);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        btnLimpar.setOnAction(event -> {
            tfNomeObra.setText("");
            tfNomeArtista.setText("");
            dpDataCriacao.setValue(null);
            taDescricao.setText("");
        });
    }

    void setUpdate(boolean b) {
        this.update = b;
    }

    public void setTextField(Long id, String nomeObra, String nomeArtista, LocalDate dataCriacao, String descricao) {
        arteId = id;
        tfNomeObra.setText(nomeObra);
        tfNomeArtista.setText(nomeArtista);
        dpDataCriacao.setValue(dataCriacao);
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