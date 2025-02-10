package util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.stage.StageStyle;

import java.io.IOException;

public class GerenciadorTelas {

    public static void mudarScene(ActionEvent evento, String arquivoFxml, String titulo) throws IOException {
        Parent root = null;

        try {
            root = FXMLLoader.load(GerenciadorTelas.class.getResource(arquivoFxml));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) ((Node) evento.getSource()).getScene().getWindow();
        stage.setTitle(titulo);
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }

    public static void abrirPopUp(MouseEvent evento, String arquivoFxml, String titulo) throws IOException {
        FXMLLoader loader = new FXMLLoader(GerenciadorTelas.class.getResource(arquivoFxml));
        Scene newScene = null;
        try {
            newScene = new Scene(loader.load());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Stage newStage = new Stage();
        newStage.initOwner((Stage) ((Node) evento.getSource()).getScene().getWindow());
        newStage.setScene(newScene);
        newStage.setTitle(titulo);
        newStage.initStyle(StageStyle.UTILITY);
        newStage.setResizable(false);
        newStage.show();
    }

    public static void fecharPopUp(ActionEvent evento) throws IOException {
        Stage stage = (Stage) ((Node) evento.getSource()).getScene().getWindow();
        stage.close();
    }

}
