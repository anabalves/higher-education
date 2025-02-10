package exercicio20;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CursoControl {

	LongProperty id = new SimpleLongProperty(0);
	StringProperty nome = new SimpleStringProperty("");
	LongProperty codigoCurso = new SimpleLongProperty(0);
	StringProperty nomeCoordenador = new SimpleStringProperty("");
	IntegerProperty qtdAlunos = new SimpleIntegerProperty(0);

	private static long counter = 0;

	private List<Curso> lista = new ArrayList<>();

	private ObservableList<Curso> listaView = FXCollections.observableArrayList();

	public Curso getEntity() {
		Curso c = new Curso();
		c.setId(id.get());
		c.setNome(nome.get());
		c.setCodigoCurso(codigoCurso.get());
		c.setNomeCoordenador(nomeCoordenador.get());
		c.setQtdAlunos(qtdAlunos.get());
		return c;
	}

	public void setEntity(Curso c) {
		id.set(c.getId());
		nome.set(c.getNome());
		codigoCurso.set(c.getCodigoCurso());
		nomeCoordenador.set(c.getNomeCoordenador());
		qtdAlunos.set(c.getQtdAlunos());
	}

	public void salvar() {
		Curso c = getEntity();
		boolean encontrado = false;
		for (int i = 0; i < lista.size(); i++) {
			Curso curso = lista.get(i);
			if (c.getId() == curso.getId()) {
				lista.set(i, c);
				encontrado = true;
				break;
			}
		}

		if (!encontrado) {
			lista.add(c);
		}
		atualizarListaView();
	}

	public void pesquisar() {
		listaView.clear();
		for(Curso c : lista) {
			if (c.getNome().contains(nome.get())) {
				listaView.add(c);
				// setEntity(c);
				// break;
			}
		}
	}

	public void remover(long id) {
		for (Curso c : lista) {
			if (c.getId() == id) {
				lista.remove(c);
				break;
			}
		}
		atualizarListaView();
	}

	public void novoCurso() {
		Curso c = new Curso();
		c.setId(++counter);
		setEntity(c);
	}

	public ObservableList<Curso> getListaView() {
		return listaView;
	}

	private void atualizarListaView() {
		listaView.clear();
		listaView.addAll(lista);
	}

}
