package exercicio22.curso;

import java.time.LocalDate;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CursoControl {
    LongProperty id = new SimpleLongProperty(0);
    StringProperty nome = new SimpleStringProperty("");
    StringProperty descricao = new SimpleStringProperty("");
    BooleanProperty ativo = new SimpleBooleanProperty();  
    ObjectProperty inicio = new SimpleObjectProperty(LocalDate.now());
    ObjectProperty termino = new SimpleObjectProperty(LocalDate.now());
    
    private ObservableList<Curso> listaView = FXCollections.observableArrayList();
    private CursoDAO cursoDAO = new CursoDAOImpl();
	
    public Curso getEntity() {
    	Curso c = new Curso();
        c.setId(id.get());
        c.setNome(nome.get());
        c.setDescricao(descricao.get());
        c.setAtivo(ativo.get());
        c.setInicio((LocalDate)inicio.get());
        c.setTermino((LocalDate)termino.get());
        return c;
    }

    public void setEntity(Curso c) {
        id.set(c.getId());
        nome.set(c.getNome());        
        descricao.set(c.getDescricao());
        ativo.set(c.getAtivo());
        inicio.set(c.getInicio());
        termino.set(c.getTermino());
    }

    public void adicionar() {
    	cursoDAO.adicionar(getEntity());
        this.listarTodos();
    }
    
    public void remover() {
    	cursoDAO.remover(id.get());
        atualizarListaView();
    }

    public void atualizar() {
    	cursoDAO.atualizar(id.get(), getEntity());
        this.pesquisar();
    }

    public void pesquisar() {
        listaView.clear();
        listaView.addAll(cursoDAO.pesquisarPorNome(nome.get()));
    }
    
    public void listarTodos() {
    	listaView.clear();
    	listaView.addAll(cursoDAO.pesquisarPorNome(""));
    }

    public void atualizarListaView() {
        listaView.clear();
        listaView.addAll(cursoDAO.pesquisarPorNome(""));
    }
    
    public void limparCampos(){
        Curso curso = getEntity();
        curso.setId(0);
        id.set(0);
        nome.set("");
        descricao.set("");
        ativo.set(true);
        inicio.set(null);
        termino.set(null);
        this.listarTodos();
    }

    public ObservableList<Curso> getListaView() {
        return listaView;
    }
    
}