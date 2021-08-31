package inicio;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import conexao_login_aluno.ConexaoAluno;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;


public class formulaController implements Initializable {//declaração dos componentes do FXML//
	Connection con  = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	int idaluno=0,iddia=0,idassunto=0;
	@FXML
	Label horario = new Label();
	
	@FXML
	Label disciplina = new Label();
	
	@FXML 
	DatePicker data = new DatePicker();
	@FXML
	Button entra = new Button();
	@FXML
	Button limpar = new Button();
	@FXML
	Button retornar = new Button();
	@FXML
	private ObservableList<String> observa;	
	@FXML
	ComboBox<String> duvida = new ComboBox<String>();
	@FXML
	ComboBox<String> professor = new ComboBox<String>();
	
	@FXML
	TableView<TabelaAluno>tabela;
	@FXML
	TableColumn<TabelaAluno, Integer>cod1;
	@FXML
	TableColumn<TabelaAluno, String> assunto;
	@FXML
	TableColumn<TabelaAluno, String> professor2;
	@FXML
	TableColumn<TabelaAluno, String> data2;
	@FXML
	TableColumn<TabelaAluno, String> horario2;
	@FXML
	TableColumn<TabelaAluno, String> status;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {//inicialização dos metodos da combobox//
		
		try {
			du();
			table();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void cancelar() throws SQLException{
		TabelaAluno p = tabela.getSelectionModel().getSelectedItem();
		if(p.getStatus().equals("Aguardando confirmação")){
		Alert ale = new Alert(AlertType.CONFIRMATION);
		ale.setTitle("Confirmação");
		ale.setHeaderText("Opções de atendimento");
		ale.setContentText("Deseja cancelar este encontro para o dia "+p.getData()+"?");
		Optional<ButtonType> action = ale.showAndWait();
		if(action.get() == ButtonType.OK){
			String sql = "update agendamento set status = 'Cancelado', situacao = 'Cancelado' where idagendamento = "+p.getCod();
			PreparedStatement ps = Conector.getConexao().prepareStatement(sql);
			ps.execute();
			refresh();
		}
		}else{
			
		}
	}
	
	
	public void refresh() throws SQLException{
		Login_alunoController log = new Login_alunoController();
		ObservableList<TabelaAluno>List = FXCollections.observableArrayList();
		String sql = "select * from prof where matricula ="+log.mat+" and (situacao = 'Pendente' or situacao ='Cancelado'or status = 'Confirmado')";
		PreparedStatement ps = Conector.getConexao().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		String d;
		while(rs.next()){
			d = "";
			d+=rs.getDate("data_agen");
			List.add(new TabelaAluno(rs.getInt("idagendamento"),rs.getString("assunto"), rs.getString("nome_prof"),d,rs.getString("horario"),rs.getString("status")));
		}
		cod1.setCellValueFactory(new PropertyValueFactory<TabelaAluno,Integer>("cod"));
		assunto.setCellValueFactory(new PropertyValueFactory<TabelaAluno,String>("Assunto"));
		professor2.setCellValueFactory(new PropertyValueFactory<TabelaAluno,String>("professor"));
		data2.setCellValueFactory(new PropertyValueFactory<TabelaAluno,String>("data"));
		horario2.setCellValueFactory(new PropertyValueFactory<TabelaAluno,String>("horario"));
		status.setCellValueFactory(new PropertyValueFactory<TabelaAluno,String>("status"));
		tabela.setItems(List);
	}
	
	public void table() throws SQLException{
		Login_alunoController log = new Login_alunoController();
		ObservableList<TabelaAluno>List = FXCollections.observableArrayList();
		String sql = "select * from prof where matricula ="+log.mat+" and (situacao = 'Pendente' or situacao ='Cancelado'or status = 'Confirmado')";
		PreparedStatement ps = Conector.getConexao().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		String d;
		while(rs.next()){
			d = "";
			d+=rs.getDate("data_agen");
			List.add(new TabelaAluno(rs.getInt("idagendamento"),rs.getString("assunto"), rs.getString("nome_prof"),d,rs.getString("horario"),rs.getString("status")));
		}
		cod1.setCellValueFactory(new PropertyValueFactory<TabelaAluno,Integer>("cod"));
		assunto.setCellValueFactory(new PropertyValueFactory<TabelaAluno,String>("Assunto"));
		professor2.setCellValueFactory(new PropertyValueFactory<TabelaAluno,String>("professor"));
		data2.setCellValueFactory(new PropertyValueFactory<TabelaAluno,String>("data"));
		horario2.setCellValueFactory(new PropertyValueFactory<TabelaAluno,String>("horario"));
		status.setCellValueFactory(new PropertyValueFactory<TabelaAluno,String>("status"));
		tabela.setItems(List);
	}
	
	
	public void du() throws SQLException{
		//pegando da tabela de dúvidas, as duvidas existentes//
		
		List<String> listaduvida = new ArrayList<String>();
		con = Conector.getConexao();
		String sql = "select * from assuntos";
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
			while(rs.next()){
				listaduvida.add(rs.getString("assunto"));
				
			}
			observa = FXCollections.observableArrayList(listaduvida);
			duvida.setItems(observa);

		
	}
	public void procura(ActionEvent evento) throws SQLException{//selecionar professor a partir da duvida selecionada//
		horario.setText("");
		List<String> listaprof = new ArrayList<String>();
		String n  = duvida.getValue();
		String ss = "select * from assuntos where assunto = '"+n+"'";
		PreparedStatement ps1 = Conector.getConexao().prepareStatement(ss);
		rs = ps1.executeQuery();
		while (rs.next()){
			idassunto = rs.getInt("idassuntos");
		}
		
		int id = 0;
		String sql = "Select * from agen where assunto ='"+n+"'";
		con = Conector.getConexao();
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		
		while(rs.next()){
			disciplina.setText(rs.getString("disciplina"));
			id= rs.getInt("iddisciplinas");
		}
		String sql1 = "Select * from professor where disciplinas = '"+id+"'";
		con = Conector.getConexao();
		ps = con.prepareStatement(sql1);
		rs = ps.executeQuery();
		while(rs.next()){
			listaprof.add(rs.getString("nome_prof"));
		}
		
		professor.setDisable(false);
		observa = FXCollections.observableArrayList(listaprof);
		professor.setItems(observa);
		
	}
	
	
	public void horario(ActionEvent evento) throws SQLException{// pega os dias e horarios a partir do professor selecionado//
		String prof = professor.getValue();
		String sql = "select * from agen where nome_prof = '"+prof+"'";
		con = Conector.getConexao();
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		while (rs.next()){
			horario.setText("Dias disponíveis: "+ rs.getString("dias")+" e "+rs.getString("dia2")+" das "+rs.getString("horario"));
			iddia = rs.getInt("iddias");
		}
		
	}
	
	

	//ação agendar no banco//
	public void agendar(ActionEvent evento) throws IOException, SQLException {
		
		LocalDate dd  = data.getValue();
		if(dd.getDayOfWeek() == DayOfWeek.MONDAY){
			String day = "Segunda";
			String sql0 = "select * from dias where (dias = '"+day+"'  or dia2 = '"+day+"') and iddias ="+iddia;
			PreparedStatement ps0 = Conector.getConexao().prepareStatement(sql0);
			ResultSet rs0 = ps0.executeQuery();
			if(rs0.next()){
				try{
					ConexaoAluno c = new ConexaoAluno();					
					idaluno = c.idalunos;
					String dat = "";
					String sql2 = "Insert into agendamento (alunos,data_agen,dias,assuntos,soma,situacao,status) values (?,?,?,?,1,'Pendente','Aguardando confirmação')";
					PreparedStatement ps2 = Conector.getConexao().prepareStatement(sql2);
					dat += data.getValue();
					ps2.setInt(1, idaluno);
					ps2.setString(2, dat);
					ps2.setInt(3, iddia);
					ps2.setInt(4, idassunto);
					ps2.execute();
					Alert al = new Alert(AlertType.INFORMATION);
					al.setHeaderText("Aviso");
					al.setContentText("Agendamento efetuado com sucesso!!");
					al.showAndWait();
					refresh();
					pegar();
					}catch(SQLException e){
						System.out.println(e);
						
					}
			}else{
				Alert a = new Alert(AlertType.ERROR);
				a.setHeaderText("Erro na operação");
				a.setContentText("A "+day+"-feira está indisponível para o professor "+professor.getValue());
				a.showAndWait();
			}
			
			
		}
		
		if(dd.getDayOfWeek() == DayOfWeek.TUESDAY){
			String day = "Terça";
			String sql0 = "select * from dias where (dias = '"+day+"'  or dia2 = '"+day+"') and iddias =" +iddia;
			PreparedStatement ps0 = Conector.getConexao().prepareStatement(sql0);
			ResultSet rs0 = ps0.executeQuery();
			if(rs0.next()){
				try{
					ConexaoAluno c = new ConexaoAluno();					
					idaluno = c.idalunos;
					String dat = "";
					String sql2 = "Insert into agendamento (alunos,data_agen,dias,assuntos,soma,situacao,status) values (?,?,?,?,1,'Pendente','Aguardando avaliação')";
					PreparedStatement ps2 = Conector.getConexao().prepareStatement(sql2);
					dat += data.getValue();
					ps2.setInt(1, idaluno);
					ps2.setString(2, dat);
					ps2.setInt(3, iddia);
					ps2.setInt(4, idassunto);
					ps2.execute();
					Alert al = new Alert(AlertType.INFORMATION);
					al.setHeaderText("Aviso");
					al.setContentText("Agendamento efetuado com sucesso!!");
					al.showAndWait();
					refresh();
					pegar();
					}catch(SQLException e){
						Alert a = new Alert(AlertType.ERROR);
						a.setHeaderText("Erro na operação");
						a.setContentText("Por favor, insira os campos obrigatórios para realizar o agendamento");
						a.showAndWait();
					}
			}else{
				Alert a = new Alert(AlertType.ERROR);
				a.setHeaderText("Erro na operação");
				a.setContentText("A "+day+"-feira está indisponível para o professor "+professor.getValue());
				a.showAndWait();
			}
			
			
		}
		
		if(dd.getDayOfWeek() == DayOfWeek.WEDNESDAY){
			String day = "Quarta";
			String sql0 = "select * from dias where (dias = '"+day+"'  or dia2 = '"+day+"') and iddias = "+iddia;
			PreparedStatement ps0 = Conector.getConexao().prepareStatement(sql0);
			ResultSet rs0 = ps0.executeQuery();
			if(rs0.next()){
				try{
					ConexaoAluno c = new ConexaoAluno();					
					idaluno = c.idalunos;
					String dat = "";
					String sql2 = "Insert into agendamento (alunos,data_agen,dias,assuntos,soma,situacao,status) values (?,?,?,?,1,'Pendente','Aguardando avaliação')";
					PreparedStatement ps2 = Conector.getConexao().prepareStatement(sql2);
					dat += data.getValue();
					ps2.setInt(1, idaluno);
					ps2.setString(2, dat);
					ps2.setInt(3, iddia);
					ps2.setInt(4, idassunto);
					ps2.execute();
					Alert al = new Alert(AlertType.INFORMATION);
					al.setHeaderText("Aviso");
					al.setContentText("Agendamento efetuado com sucesso!!");
					al.showAndWait();
					refresh();
					pegar();
					}catch(SQLException e){
						Alert a = new Alert(AlertType.ERROR);
						a.setHeaderText("Erro na operação");
						a.setContentText("Por favor, insira os campos obrigatórios para realizar o agendamento");
						a.showAndWait();
					}
			}else{
				Alert a = new Alert(AlertType.ERROR);
				a.setHeaderText("Erro na operação");
				a.setContentText("A "+day+"-feira está indisponível para o professor "+professor.getValue());
				a.showAndWait();
			}
			
			
		}
		
		if(dd.getDayOfWeek() == DayOfWeek.THURSDAY){
			String day = "Quinta";
			String sql0 = "select * from dias where (dias = '"+day+"'  or dia2 = '"+day+"') and iddias = " +iddia;
			PreparedStatement ps0 = Conector.getConexao().prepareStatement(sql0);
			ResultSet rs0 = ps0.executeQuery();
			if(rs0.next()){
				try{
					ConexaoAluno c = new ConexaoAluno();					
					idaluno = c.idalunos;
					String dat = "";
					String sql2 = "Insert into agendamento (alunos,data_agen,dias,assuntos,soma,situacao,status) values (?,?,?,?,1,'Pendente','Aguardando avaliação')";
					PreparedStatement ps2 = Conector.getConexao().prepareStatement(sql2);
					dat += data.getValue();
					ps2.setInt(1, idaluno);
					ps2.setString(2, dat);
					ps2.setInt(3, iddia);
					ps2.setInt(4, idassunto);
					ps2.execute();
					Alert al = new Alert(AlertType.INFORMATION);
					al.setHeaderText("Aviso");
					al.setContentText("Agendamento efetuado com sucesso!!");
					al.showAndWait();
					refresh();
					pegar();
					}catch(SQLException e){
						Alert a = new Alert(AlertType.ERROR);
						a.setHeaderText("Erro na operação");
						a.setContentText("Por favor, insira os campos obrigatórios para realizar o agendamento");
						a.showAndWait();
					}
			}else{
				Alert a = new Alert(AlertType.ERROR);
				a.setHeaderText("Erro na operação");
				a.setContentText("A "+day+"-feira está indisponível para o professor "+professor.getValue());
				a.showAndWait();
			}
			
			
		}
		
		if(dd.getDayOfWeek() == DayOfWeek.FRIDAY){
			String day = "Sexta";
			String sql0 = "select * from dias where (dias = '"+day+"'  or dia2 = '"+day+"') and iddias  = " +iddia;
			PreparedStatement ps0 = Conector.getConexao().prepareStatement(sql0);
			ResultSet rs0 = ps0.executeQuery();
			if(rs0.next()){
				try{
					ConexaoAluno c = new ConexaoAluno();					
					idaluno = c.idalunos;
					String dat = "";
					String sql2 = "Insert into agendamento (alunos,data_agen,dias,assuntos,soma,situacao,status) values (?,?,?,?,1,'Pendente','Aguardando avaliação')";
					PreparedStatement ps2 = Conector.getConexao().prepareStatement(sql2);
					dat += data.getValue();
					ps2.setInt(1, idaluno);
					ps2.setString(2, dat);
					ps2.setInt(3, iddia);
					ps2.setInt(4, idassunto);
					ps2.execute();
					Alert al = new Alert(AlertType.INFORMATION);
					al.setHeaderText("Aviso");
					al.setContentText("Agendamento efetuado com sucesso!!");
					al.showAndWait();
					refresh();
					pegar();
					}catch(SQLException e){
						System.out.println(e);
						Alert a = new Alert(AlertType.ERROR);
						a.setHeaderText("Erro na operação");
						a.setContentText("Por favor, insira os campos obrigatórios para realizar o agendamento");
						a.showAndWait();
					}
			}else{
				Alert a = new Alert(AlertType.ERROR);
				a.setHeaderText("Erro na operação");
				a.setContentText("A "+day+"-feira está indisponível para o professor "+professor.getValue());
				a.showAndWait();
			}
			
			
		}
		
		if(dd.getDayOfWeek() == DayOfWeek.SATURDAY || dd.getDayOfWeek() == DayOfWeek.SUNDAY){
			Alert a = new Alert(AlertType.ERROR);
			a.setHeaderText("Erro na operação");
			a.setContentText("Agendamento indisponível aos sábados e domingos");
			a.showAndWait();
		}
		
	}
		
		
	
	
	public void pegar(){//limpar valores//
		
		duvida.setValue("Selecione...");
		disciplina.setText("");
		professor.setPromptText("Selecione...");
		horario.setText("");
		professor.setDisable(true);
		data.setValue(null);
	}
	
	
	public void inicio(ActionEvent evento) throws IOException{//retornar à tela de login do aluno//
		trocarTelas t = new trocarTelas();
		t.trocar(evento, "Tela_Login.fxml", "Iniciar Sessão");
	}
}
