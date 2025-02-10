package exercicio14;

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

public class TesteDeEventosConsole extends Application {

	class Manipulador implements EventHandler<ActionEvent> {
	    public void handle(ActionEvent e) {
	        System.out.println("Hello World");
	    }
	}

	@Override
	public void start(Stage stage) throws Exception {
        BorderPane borderPane = new BorderPane();
        Scene scn = new Scene(borderPane, 400, 150);
        Manipulador man = new Manipulador();
        
        Label lblTextoConsole = new Label("Texto no Console");
        borderPane.setTop(lblTextoConsole);
        BorderPane.setMargin(lblTextoConsole, new Insets(20));  
        BorderPane.setAlignment(lblTextoConsole, Pos.TOP_CENTER);
        
        Button btn = new Button("Ok");
        borderPane.setBottom(btn);
        BorderPane.setMargin(btn, new Insets(20));  
        BorderPane.setAlignment(btn, Pos.BOTTOM_CENTER);
        btn.addEventFilter(ActionEvent.ANY, man);
        
        stage.setScene(scn);
        stage.setTitle("Teste de Eventos");
        stage.show();
	}
	
	public static void main(String[] args) {
		 Application.launch(TesteDeEventosConsole.class, args);
	}

}
