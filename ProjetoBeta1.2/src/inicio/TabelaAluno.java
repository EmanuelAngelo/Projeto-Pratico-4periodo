package inicio;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class TabelaAluno {
	private SimpleIntegerProperty cod;
	private SimpleStringProperty assunto;
	private SimpleStringProperty professor;
	private SimpleStringProperty data;
	private SimpleStringProperty horario;
	private SimpleStringProperty status;
	public TabelaAluno(int cod,String assunto,String professor,String data,String horario,String status){
		this.setCod(new SimpleIntegerProperty(cod));
		this.setAssunto(new SimpleStringProperty(assunto));
		this.setData(new SimpleStringProperty(data));
		this.setProfessor(new SimpleStringProperty(professor));
		this.setHorario(new SimpleStringProperty(horario));
		this.setStatus(new SimpleStringProperty(status));
	}



	public String getAssunto() {
		return assunto.get();
	}

	public void setAssunto(SimpleStringProperty duvida) {
		this.assunto = duvida;
	}

	public String getProfessor() {
		return professor.get();
	}

	public void setProfessor(SimpleStringProperty professor) {
		this.professor = professor;
	}

	public String getHorario() {
		return horario.get();
	}

	public void setHorario(SimpleStringProperty horario) {
		this.horario = horario;
	}



	public String getData() {
		return data.get();
	}



	public void setData(SimpleStringProperty data) {
		this.data = data;
	}



	public Integer getCod() {
		return cod.get();
	}



	public void setCod(SimpleIntegerProperty cod) {
		this.cod = cod;
	}



	public String getStatus() {
		return status.get();
	}



	public void setStatus(SimpleStringProperty status) {
		this.status = status;
	}
	
}
