package exercicio13;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TelaCalculadora extends Application {

    @Override
    public void start(Stage stage) throws Exception {
    	BorderPane borderPane = new BorderPane();
    	FlowPane flowPane = new FlowPane();
    	GridPane gridPane = new GridPane();

        TextField tfVisor = new TextField();
        tfVisor.setMinWidth(160);
        tfVisor.setMinHeight(50);
        Button btnCE = new Button("CE");
        btnCE.setMinSize(50, 50);
        
        flowPane.getChildren().add(tfVisor);
        flowPane.getChildren().add(btnCE);
        flowPane.setHgap(5);
        flowPane.setVgap(5);
        
        Button btn1 = new Button("1");
        btn1.setMinSize(50, 50);
        Button btn2 = new Button("2");
        btn2.setMinSize(50, 50);
        Button btn3 = new Button("3");
        btn3.setMinSize(50, 50);
        Button btnSoma = new Button("+");
        btnSoma.setMinSize(50, 50);
        Button btn4 = new Button("4");
        btn4.setMinSize(50, 50);
        Button btn5 = new Button("5");
        btn5.setMinSize(50, 50);
        Button btn6 = new Button("6");
        btn6.setMinSize(50, 50);
        Button btnSub = new Button("-");
        btnSub.setMinSize(50, 50);
        Button btn7 = new Button("7");
        btn7.setMinSize(50, 50);
        Button btn8 = new Button("8");
        btn8.setMinSize(50, 50);
        Button btn9 = new Button("9");
        btn9.setMinSize(50, 50);
        Button btnMult = new Button("*");
        btnMult.setMinSize(50, 50);
        Button btnVir = new Button(",");
        btnVir.setMinSize(50, 50);
        Button btn0 = new Button("0");
        btn0.setMinSize(50, 50);
        Button btnIgual = new Button("=");
        btnIgual.setMinSize(50, 50);
        Button btnDiv = new Button("/");
        btnDiv.setMinSize(50, 50);
        
        gridPane.add(btn1, 0, 0);
        gridPane.add(btn2, 1, 0);
        gridPane.add(btn3, 2, 0);
        gridPane.add(btnSoma, 3, 0);
        gridPane.add(btn4, 0, 1);
        gridPane.add(btn5, 1, 1);
        gridPane.add(btn6, 2, 1);
        gridPane.add(btnSub, 3, 1);
        gridPane.add(btn7, 0, 2);
        gridPane.add(btn8, 1, 2);
        gridPane.add(btn9, 2, 2);
        gridPane.add(btnMult, 3, 2);
        gridPane.add(btnVir, 0, 3);
        gridPane.add(btn0, 1, 3);
        gridPane.add(btnIgual, 2, 3);
        gridPane.add(btnDiv, 3, 3);
        
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        
        borderPane.setTop(flowPane);
        borderPane.setCenter(gridPane);
        Scene scene = new Scene(borderPane, 240, 310);
        BorderPane.setAlignment(flowPane, Pos.TOP_CENTER);
        BorderPane.setMargin(flowPane, new Insets(10));  
    	flowPane.setMaxWidth(300);
        BorderPane.setAlignment(gridPane, Pos.CENTER);     
        BorderPane.setMargin(gridPane, new Insets(10));  
    	gridPane.setMaxWidth(300);
    	
        stage.setTitle("Calculadora");
        stage.setScene(scene);
        stage.show();
    }
	
	public static void main(String[] args) {
		Application.launch(TelaCalculadora.class, args);
	}
}
