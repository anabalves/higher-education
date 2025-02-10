package exercicio22.aluno;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.time.LocalDate;

public class AlunoControl {
    LongProperty id = new SimpleLongProperty(0);
    StringProperty ra = new SimpleStringProperty("");
    StringProperty nome = new SimpleStringProperty("");
    ObjectProperty nascimento = new SimpleObjectProperty(LocalDate.now());

    private ObservableList<Aluno> listaView = FXCollections.observableArrayList();
    private AlunoDAO alunoDAO = new AlunoDAOImpl();
	
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

    public void adicionar() {
    	alunoDAO.adicionar(getEntity());
        this.listarTodos();
    }

    public void remover() {
    	alunoDAO.remover(id.get());
        atualizarListaView();
    }

    public void atualizar() {
    	alunoDAO.atualizar(id.get(), getEntity());
        this.pesquisar();
    }

    public void pesquisar() {
        listaView.clear();
        listaView.addAll(alunoDAO.pesquisarPorNome(nome.get()));
    }
    
    public void listarTodos() {
    	listaView.clear();
    	listaView.addAll(alunoDAO.pesquisarPorNome(""));
    }
    
    public void atualizarListaView() {
        listaView.clear();
        listaView.addAll(alunoDAO.pesquisarPorNome(""));
    }
    
    public void limparCampos(){
        Aluno aluno = getEntity();
        aluno.setId(0);
        id.set(0);
        ra.set("");
        nome.set("");
        nascimento.set(null);
        this.listarTodos();
    }

    public ObservableList<Aluno> getListaView() {
        return listaView;
    }
    
}