package inicio;

import java.io.IOException;
import java.io.OutputStream;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class Co_RelatoriosController implements Initializable {

	@FXML
	ProgressIndicator progresso = new ProgressIndicator();
	
	@FXML
	ComboBox<String> professor;
	ObservableList<String> observa;
	@FXML
	ComboBox<String> mes = null;
	@FXML
	ComboBox<String> ano = null;
	public static int m,a;
	
	@FXML
	TableView<Tabela> tabela ;
	@FXML
	TableColumn<Tabela, Integer> matricula;
	@FXML
	TableColumn<Tabela, String> nome;
	@FXML
	TableColumn<Tabela, String> duvida;
	@FXML
	TableColumn<Tabela, String> data;
	@FXML
	TableColumn<Tabela, String> curso;
	@FXML
	TableColumn<Tabela, String> periodo;
	@FXML
	TableColumn<Tabela, String> descricao;
	
	ObservableList<Tabela> Lista;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		mes.setValue("Mês...");
		ano.setValue("Ano...");
		try {
			prof();
			mes();
			ano();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void prof() throws SQLException{// este método serve para popular a combobox com os nomes dos professores existentes no banco//
		List<String> listaprof = new ArrayList<String>();
		
		String sql = "select * from professor where nome_prof != 'Coordenadora Marineis' ";
		 PreparedStatement ps = Conector.getConexao().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
			while(rs.next()){
				listaprof.add(rs.getString("nome_prof"));
			}
			listaprof.add("Todos");
			observa = FXCollections.observableArrayList(listaprof);
			professor.setItems(observa);
	}
	public void mes(){
		observa = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12");
		mes.setItems(observa);
	}
	public void ano(){
		observa = FXCollections.observableArrayList("2016","2017","2018","2019","2020");
		ano.setItems(observa);
	}
	
	
	
	
	public void combo(ActionEvent evento) throws SQLException{// tabela que exibe todos os agendamentos marcados a partir do professor selecionado na combobox//
		Lista = FXCollections.observableArrayList();
		String n = professor.getValue(), d,sql;
		if(professor.getValue().equals("Todos")){
			 sql = "select * from prof where situacao = 'Concluído'";
		}else{
			sql = "select * from prof where nome_prof = '"+n+"' and situacao = 'Concluído'";
			}
		PreparedStatement ps = Conector.getConexao().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			d = "";
			d+= rs.getDate("data_agen");
			Lista.add(new Tabela(rs.getInt("matricula"),rs.getString("nome"),rs.getString("assunto"), d, rs.getString("curso"), rs.getString("periodo"),rs.getString("descricao")));
				
		}

		matricula.setCellValueFactory(new PropertyValueFactory<Tabela,Integer>("matricula"));
		nome.setCellValueFactory(new PropertyValueFactory<Tabela,String>("nome"));
		duvida.setCellValueFactory(new PropertyValueFactory<Tabela,String>("duvida"));
		data.setCellValueFactory(new PropertyValueFactory<Tabela,String>("data"));
		curso.setCellValueFactory(new PropertyValueFactory<Tabela,String>("curso"));
		periodo.setCellValueFactory(new PropertyValueFactory<Tabela,String>("periodo"));
		descricao.setCellValueFactory(new PropertyValueFactory<Tabela,String>("descricao"));
		tabela.setItems(Lista);
			
	}
	
	public void retornar(ActionEvent evento) throws IOException{//retornar à tela do coordenador//
		trocarTelas t = new trocarTelas();
		t.trocar(evento,"Tela_Coordenador.fxml", "Bem-Vinda Coordenadora Marineis");
	}
	public void gerar() throws DocumentException, IOException, SQLException {
		
		if(mes.getValue().equals("Mês...")||ano.getValue().equals("Ano...")){
			Alert al = new Alert(AlertType.INFORMATION);
			al.setHeaderText("Aviso");
			al.setContentText("Para gerar o arquivo, os campos de mês e ano não podem ser nulos");
			al.showAndWait();
		}else{
		m = Integer.parseInt(mes.getValue());
		a = Integer.parseInt(ano.getValue());
		Document doc  = null;
		OutputStream os = null;
		
		progresso.setVisible(true);
		Task<Void> task = new Task<Void>(){

			@Override
			protected Void call() throws Exception {
				final int max = 100;
				for (int i = 1; i <= max; i++) {
				updateProgress(i, max);
				try {
				Thread.sleep(20);
				}
				catch (Exception e) {
					 e.printStackTrace();
				 }
				}
				pdf p  = new pdf(doc,os,m,a);
				
				return null;
			
		};
		
		};
		progresso.progressProperty().bind(task.progressProperty());
		new Thread(task).start();
		Alert al = new Alert(AlertType.INFORMATION);
		al.setHeaderText("Aviso");
		al.setContentText("O relatório será salvo na área de trabalho.");
		al.showAndWait();
		}
		
		
		
		
	}
	
	
}
