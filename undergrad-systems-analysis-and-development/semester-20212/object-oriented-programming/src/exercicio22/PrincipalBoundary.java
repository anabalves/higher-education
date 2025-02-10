package exercicio22;

import java.util.HashMap;
import java.util.Map;

import exercicio22.aluno.AlunoBoundary;
import exercicio22.curso.CursoBoundary;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PrincipalBoundary extends Application implements EventHandler<ActionEvent> {

    private Map<String, StrategyBoundary> telas = new HashMap<>();
    private BorderPane panePrincipal = new BorderPane();

    public PrincipalBoundary() {
        telas.put("Alunos", new AlunoBoundary());
        telas.put("Cursos", new CursoBoundary());
    }
	
	@Override
	public void handle(ActionEvent event) {
        EventTarget target = event.getTarget();
        if (target instanceof MenuItem) {
            MenuItem menu = (MenuItem) target;
            String texto = menu.getText();
            StrategyBoundary tela = telas.get(texto);
            panePrincipal.setCenter(tela.render());
        }
	}

	@Override
	public void start(Stage stage) throws Exception {
        Scene scn = new Scene(panePrincipal, 1024, 768);

        MenuBar menuPrincipal = new MenuBar();

        Menu menuArquivo = new Menu("Arquivos");
        Menu menuCadastros = new Menu("Cadastros");

        MenuItem itemSair = new MenuItem("Sair");
        MenuItem itemAluno = new MenuItem("Alunos");
        MenuItem itemCurso = new MenuItem("Cursos");

        itemSair.setOnAction((e) -> {
            Platform.exit();
            System.exit(0);
        });

        itemAluno.setOnAction(this);
        itemCurso.setOnAction(this);

        menuArquivo.getItems().addAll(itemSair);
        menuCadastros.getItems().addAll(itemAluno);
        menuCadastros.getItems().addAll(itemCurso);
        
        menuPrincipal.getMenus().addAll(menuArquivo, menuCadastros);
        panePrincipal.setTop(menuPrincipal);

        stage.setScene(scn);
        stage.setTitle("Gestão de Alunos e Cursos");
		stage.setResizable(false);
        stage.show();
	}
	
    public static void main(String[] args) {
        Application.launch(PrincipalBoundary.class, args);
    }

}
