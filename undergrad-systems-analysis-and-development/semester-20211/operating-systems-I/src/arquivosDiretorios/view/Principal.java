package arquivosDiretorios.view;

import java.io.IOException;
import arquivosDiretorios.controller.ArquivosController;
import arquivosDiretorios.controller.IArquivosController;

public class Principal {

	public static void main(String[] args) {
		
		IArquivosController arqCont = new ArquivosController();
		String dirWin = "C:\\Windows";
		String path = "C:\\Teste";
		String nome = "teste.csv";
		
		try {
//			arqCont.readDir(dirWin);
//			arqCont.createFile(path, nome);
//			arqCont.readFile(path, nome);
			arqCont.openFile(path, nome);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}