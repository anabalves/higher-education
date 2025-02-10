package exercicio15;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TesteDeEventosLabel extends Application {

	@Override
	public void start(Stage stage) throws Exception {
        BorderPane borderPane = new BorderPane();
        Scene scn = new Scene(borderPane, 400, 150);
        
        Label lblTexto = new Label("Texto vai mudar");
        borderPane.setTop(lblTexto);
        BorderPane.setMargin(lblTexto, new Insets(20));  
        BorderPane.setAlignment(lblTexto, Pos.TOP_CENTER);
        
        Button btn = new Button("Ok");
        borderPane.setBottom(btn);
        BorderPane.setMargin(btn, new Insets(20));  
        BorderPane.setAlignment(btn, Pos.BOTTOM_CENTER);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	lblTexto.setText("Hello World");
            }
        });
        
        stage.setScene(scn);
        stage.setTitle("Teste de Eventos");
        stage.show();
	}

	public static void main(String[] args) {
		 Application.launch(TesteDeEventosLabel.class, args);
	}

}
