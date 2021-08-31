package inicio;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import conexao_login_professor.Conecta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;



public class ProfessorController implements Initializable {
	Conecta c = new Conecta();
	
	public static String cc ,name,cur,as;
	
	@FXML
	Label p;
	@FXML
	ComboBox<String> filtro;
	@FXML
	Button procura;
	@FXML
	TableView<TabelaProf> tabela ;
	@FXML
	TableColumn<TabelaProf, Integer> cod;
	@FXML
	TableColumn<TabelaProf, Integer> matricula;
	@FXML
	TableColumn<TabelaProf, String> nome;
	@FXML
	TableColumn<TabelaProf, String> duvida;
	@FXML
	TableColumn<TabelaProf, String> data;
	@FXML
	TableColumn<TabelaProf, String> curso;
	@FXML
	TableColumn<TabelaProf, String> periodo;
	@FXML
	TableColumn<TabelaProf, String> situacao;
	@FXML
	TableColumn<TabelaProf, String> descricao;
	ObservableList<TabelaProf> Lista;
	
	
	
	public void retornar(ActionEvent evento) throws IOException{ //retornar ao menu principal//
		trocarTelas t = new trocarTelas();
		t.trocar(evento,"Tela_Login.fxml", "Iniciar Sessão");

	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		popularcombo();
		filtro.setValue("Pendente");
		try {
			populartabela();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
	public void popularcombo(){
		ObservableList<String> observa = FXCollections.observableArrayList("Pendente","Concluído","Todos");
		filtro.setItems(observa);
	}
	
	public void populartabela() throws SQLException{
		filtro.getValue();
		if(filtro.getValue().equals("Todos")){
			Lista = FXCollections.observableArrayList();
			Conecta c = new Conecta();
			PreparedStatement ps = null;
			String d;
			ResultSet rs = null;
			String sql = "SELECT * FROM prof where idprofessor = '"+c.idprof+"'";
					ps =  Conector.getConexao().prepareStatement(sql);
					rs = ps.executeQuery();
				while(rs.next()){
					d = "";
					d+= rs.getDate("data_agen");
					Lista.add(new TabelaProf(rs.getInt("idagendamento"),rs.getInt("matricula"),rs.getString("nome"),rs.getString("assunto"), d, rs.getString("curso"), rs.getString("periodo"),rs.getString("situacao"),rs.getString("status")));
					
				}
		}
		if(filtro.getValue().equals("Pendente")){
			Lista = FXCollections.observableArrayList();
			Conecta c = new Conecta();
			PreparedStatement ps = null;
			String d;
			ResultSet rs = null;
			String sql = "SELECT * FROM prof where idprofessor = '"+c.idprof+"' and situacao = 'Pendente'";
					ps =  Conector.getConexao().prepareStatement(sql);
					rs = ps.executeQuery();
				while(rs.next()){
					d = "";
					d+= rs.getDate("data_agen");
					Lista.add(new TabelaProf(rs.getInt("idagendamento"),rs.getInt("matricula"),rs.getString("nome"),rs.getString("assunto"), d, rs.getString("curso"), rs.getString("periodo"),rs.getString("situacao"),rs.getString("status")));
					
				}
		}
		if(filtro.getValue().equals("Concluído")){
			Lista = FXCollections.observableArrayList();
			Conecta c = new Conecta();
			PreparedStatement ps = null;
			String d;
			ResultSet rs = null;
			String sql = "SELECT * FROM prof where idprofessor = '"+c.idprof+"' and situacao = 'Concluído'";
					ps =  Conector.getConexao().prepareStatement(sql);
					rs = ps.executeQuery();
				while(rs.next()){
					d = "";
					d+= rs.getDate("data_agen");
					Lista.add(new TabelaProf(rs.getInt("idagendamento"),rs.getInt("matricula"),rs.getString("nome"),rs.getString("assunto"), d, rs.getString("curso"), rs.getString("periodo"),rs.getString("situacao"),rs.getString("status")));
					
				}
		}
		
		
		cod.setCellValueFactory(new PropertyValueFactory<TabelaProf,Integer>("cod"));
		matricula.setCellValueFactory(new PropertyValueFactory<TabelaProf,Integer>("matricula"));
		nome.setCellValueFactory(new PropertyValueFactory<TabelaProf,String>("nome"));
		duvida.setCellValueFactory(new PropertyValueFactory<TabelaProf,String>("duvida"));
		data.setCellValueFactory(new PropertyValueFactory<TabelaProf,String>("data"));
		curso.setCellValueFactory(new PropertyValueFactory<TabelaProf,String>("curso"));
		periodo.setCellValueFactory(new PropertyValueFactory<TabelaProf,String>("periodo"));
		descricao.setCellValueFactory(new PropertyValueFactory<TabelaProf,String>("descricao"));
		situacao.setCellValueFactory(new PropertyValueFactory<TabelaProf,String>("situacao"));
		tabela.setItems(Lista);
		
		
		
	}
	
	public void refresh() throws SQLException{
		Lista = FXCollections.observableArrayList();
		Conecta c = new Conecta();
		PreparedStatement ps = null;
		String d;
		ResultSet rs = null;
		String sql = "SELECT * FROM prof where idprofessor = '"+c.idprof+"'";
				ps =  Conector.getConexao().prepareStatement(sql);
				rs = ps.executeQuery();
			while(rs.next()){
				d = "";
				d+= rs.getDate("data_agen");
				Lista.add(new TabelaProf(rs.getInt("idagendamento"),rs.getInt("matricula"),rs.getString("nome"),rs.getString("assunto"), d, rs.getString("curso"), rs.getString("periodo"),rs.getString("situacao"),rs.getString("status")));
				
			}
			cod.setCellValueFactory(new PropertyValueFactory<TabelaProf,Integer>("cod"));
			matricula.setCellValueFactory(new PropertyValueFactory<TabelaProf,Integer>("matricula"));
			nome.setCellValueFactory(new PropertyValueFactory<TabelaProf,String>("nome"));
			duvida.setCellValueFactory(new PropertyValueFactory<TabelaProf,String>("duvida"));
			data.setCellValueFactory(new PropertyValueFactory<TabelaProf,String>("data"));
			curso.setCellValueFactory(new PropertyValueFactory<TabelaProf,String>("curso"));
			periodo.setCellValueFactory(new PropertyValueFactory<TabelaProf,String>("periodo"));
			descricao.setCellValueFactory(new PropertyValueFactory<TabelaProf,String>("descricao"));
			situacao.setCellValueFactory(new PropertyValueFactory<TabelaProf,String>("situacao"));
			tabela.setItems(Lista);
	}
	
	
	
	
	public void d() throws SQLException {
		cc=name=cur=as="";
		
		TabelaProf p = tabela.getSelectionModel().getSelectedItem(); // <-
		cc+=p.getCod();
		name+=p.getNome();
		cur+=p.getCurso();
		as+=p.getDuvida();
		
		if(p.getDescricao().equals("Aguardando confirmação")){
			Alert ale = new Alert(AlertType.CONFIRMATION);
			ale.setHeaderText("Aviso");
			ale.setContentText("Deseja confirmar o atendimento?");
			Optional<ButtonType> action = ale.showAndWait();
			if(action.get() == ButtonType.OK){
				String sql ="update agendamento set status = 'Confirmado' where idagendamento = "+p.getCod();
				PreparedStatement ps = Conector.getConexao().prepareStatement(sql);
				ps.execute();
				refresh();
				Alert ale1 = new Alert(AlertType.INFORMATION);
				ale1.setHeaderText("Aviso");
				ale1.setContentText("O atendimento foi confirmado com sucesso.");
				ale1.showAndWait();
			}
				
		
		}
		if(p.getDescricao().equals("1º Atendimento")||p.getDescricao().equals("Retorno")||p.getDescricao().equals("Adiado")||p.getDescricao().equals("Confirmado")){
			Main m = new Main();
			m.block();
		}
		
		
		
	}
	
	
}
