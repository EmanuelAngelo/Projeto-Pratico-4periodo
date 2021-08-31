package inicio;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Tabela {

	private SimpleIntegerProperty matricula;
	private SimpleStringProperty nome;
	private SimpleStringProperty duvida;
	private SimpleStringProperty data;
	private SimpleStringProperty curso;
	private SimpleStringProperty periodo;
	private SimpleStringProperty descricao;
	
	public Tabela(int matricula,String nome,String duvida, String data,String curso,String periodo,String descricao){// método para armazenar os dados nas colunas de uma tabela//
		this.matricula = new SimpleIntegerProperty(matricula);
		this.nome = new SimpleStringProperty(nome);
		this.duvida = new SimpleStringProperty(duvida);
		this.data = new SimpleStringProperty(data);
		this.curso = new SimpleStringProperty(curso);
		this.periodo = new SimpleStringProperty(periodo);
		this.setDescricao(new SimpleStringProperty(descricao));
	}

	public String getNome() {
		return nome.get();
	}

	public void setNome(SimpleStringProperty nome) {
		this.nome = nome;
	}

	public Integer getMatricula() {
		return matricula.get();
	}

	public void setMatricula(SimpleIntegerProperty matricula) {
		this.matricula = matricula;
	}

	public String getDuvida() {
		return duvida.get();
	}

	public void setDuvida(SimpleStringProperty duvida) {
		this.duvida = duvida;
	}

	public String getData() {
		return data.get();
	}

	public void setData(SimpleStringProperty data) {
		this.data = data;
	}

	public String getCurso() {
		return curso.get();
	}

	public void setCurso(SimpleStringProperty curso) {
		this.curso = curso;
	}

	public String getPeriodo() {
		return periodo.get();
	}

	public void setPeriodo(SimpleStringProperty periodo) {
		this.periodo = periodo;
	}

	public String getDescricao() {
		return descricao.get();
	}

	public void setDescricao(SimpleStringProperty descricao) {
		this.descricao = descricao;
	}
	
	
}
