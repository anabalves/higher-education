package exercicio19;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AlunoControl {
	
    LongProperty id = new SimpleLongProperty(0);
    StringProperty ra = new SimpleStringProperty("");
    StringProperty nome = new SimpleStringProperty("");
    ObjectProperty nascimento = new SimpleObjectProperty(LocalDate.now());
    
    private static long counter = 0;

    private List<Aluno> lista = new ArrayList<>();
    
    private ObservableList<Aluno> listaView = FXCollections.observableArrayList();

    public Aluno getEntity() {
    	Aluno a = new Aluno();
        a.setId(id.get());
        a.setRa(ra.get());
        a.setNome(nome.get());
        a.setNascimento((LocalDate)nascimento.get());
        return a;
    }

    public void setEntity(Aluno a) {
        id.set(a.getId());
        ra.set(a.getRa());
        nome.set(a.getNome());
        nascimento.set(a.getNascimento());
    }

	public void salvar() {
		Aluno a = getEntity();
        boolean encontrado = false;
        for (int i = 0; i < lista.size(); i++) {
        	Aluno aluno = lista.get(i);
            if (a.getId() == aluno.getId()) {
                lista.set(i, a);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            lista.add(a);
        }
        atualizarListaView();
	}

	public void pesquisar() {
        listaView.clear();
        for(Aluno a : lista) {
            if (a.getNome().contains(nome.get())) {
                listaView.add(a);
               // setEntity(a);
               // break;
            }
        }
	}
	
    public void remover(long id) {
        for (Aluno a : lista) {
            if (a.getId() == id) {
                lista.remove(a);
                break;
            }
        }
        atualizarListaView();
    }
	
	public void novoAluno() {
		Aluno a = new Aluno();
        a.setId(++counter);
        setEntity(a);
	}

	public ObservableList<Aluno> getListaView() {
		return listaView;
	}

	private void atualizarListaView() {
        listaView.clear();
        listaView.addAll(lista);
	}

}
