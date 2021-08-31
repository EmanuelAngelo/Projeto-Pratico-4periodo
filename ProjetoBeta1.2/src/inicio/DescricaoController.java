package inicio;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;


public class DescricaoController  implements Initializable{

	@FXML
	DatePicker data;
	@FXML
	Label lbl_data;
	@FXML
	Label curso;
	@FXML 
	Label assunto;
	@FXML
	ComboBox<String> status;
	@FXML
	TextArea des;
	@FXML
	Label nome;
	@FXML
	Button not;
	
	ObservableList<String> obs;
	
		
	
	public void salvar () throws SQLException{
		ProfessorController p = new ProfessorController();
		String d = "";
		d+=data.getValue();
		String sql;
		if(status.getValue().equals("Adiado")){
			 sql =  "update agendamento set status =?,situacao = 'Pendente',descricao = ?,data_agen = '"+d+"' where idagendamento = ?";
		}else{
			 sql =  "update agendamento set status =?,situacao = 'Concluído',descricao = ? where idagendamento = ?";
		}
		
		PreparedStatement ps = Conector.getConexao().prepareStatement(sql);
		ps.setString(1, status.getValue());
		ps.setString(2, des.getText());
		ps.setString(3, p.cc);
		
		ps.execute();
		Alert a = new Alert(AlertType.INFORMATION);
		a.setHeaderText("Operação concluída");
		a.setContentText("Descrição adicionada com sucesso.");
		a.showAndWait();
		
	}
	
	public void combo(){
		obs = FXCollections.observableArrayList("1º Atendimento","Retorno","Adiado");
		status.setItems(obs);
		
	}
	public void adiamento(){
		if(status.getValue().equals("Adiado")){
			not.setVisible(true);
			lbl_data.setVisible(true);
			data.setVisible(true);
		}else{
			not.setVisible(false);
			lbl_data.setVisible(false);
			data.setVisible(false);
		}
	}
	
	public void enviar() throws SQLException{
		String sql = "select * from alunos where nome = '"+nome.getText()+"'";
		PreparedStatement ps = Conector.getConexao().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		EmailSend e = new EmailSend();
		if(rs.next()){
			e.email(rs.getString("email"), des.getText());
		}
		
	}
	
	public void alimentar_descricao() throws SQLException{
		ProfessorController p = new ProfessorController();
		String sql = "select * from agendamento where idagendamento = "+p.cc;
		PreparedStatement ps = Conector.getConexao().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			des.setText(rs.getString("descricao"));
		}
	}
	
	public void deletar() throws SQLException{
		ProfessorController p = new ProfessorController();
		
		Alert ale = new Alert(AlertType.CONFIRMATION);
		ale.setHeaderText("Aviso");
		ale.setContentText("Deseja cancelar este atendimento ?");
		Optional<ButtonType> action = ale.showAndWait();
		if(action.get() == ButtonType.OK){
			String sql = "update agendamento set status = 'Cancelado',situacao = 'Cancelado' where idagendamento = "+p.cc;
			PreparedStatement ps = Conector.getConexao().prepareStatement(sql);
			ps.execute();
			Alert al = new Alert(AlertType.INFORMATION);
			al.setHeaderText("Aviso");
			al.setContentText("Agendamento cancelado com sucesso");
			al.showAndWait();
			
			
		}
		
	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ProfessorController p = new ProfessorController();
		nome.setText(p.name);
		curso.setText(p.cur);
		assunto.setText(p.as);
		combo();
		try {
			alimentar_descricao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
