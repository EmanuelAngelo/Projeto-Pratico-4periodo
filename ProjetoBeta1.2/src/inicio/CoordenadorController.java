package inicio;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class CoordenadorController implements Initializable {
	@FXML
	Label status;
	
	@FXML
	ComboBox<String> select = new ComboBox<String>();
	@FXML
	Button tela;
	@FXML
	PieChart grafico ;
	@FXML
	ComboBox<String> select2 = new ComboBox<String>();
	
	trocarTelas t = new trocarTelas();
	public void prof () throws SQLException {// este método alimenta o gráfico, a partir da opção de filtragem selecionada na combobox//
		 int i = 0 ;
		String n = select.getValue();
		List<Data> lista = new ArrayList<Data>();
		if(n.equals("Assuntos")){
			status.setText("Passe o mouse no gráfico para ver a porcentagem");
			i=0;
			select2.setDisable(true);
			select2.setValue("Todos");
			String sql1 = "select assunto, sum(soma) from grafico  where situacao = 'Concluído' group by assunto";
			PreparedStatement ps1 = Conector.getConexao().prepareStatement(sql1);
			ResultSet rs1 = ps1.executeQuery();
				while(rs1.next()){
					lista.add(new PieChart.Data(rs1.getString("assunto"), rs1.getInt("sum(soma)")));
				i+=rs1.getInt("sum(soma)");
			}
			ObservableList<Data> observa = FXCollections.observableArrayList(lista);
			grafico.setData(observa);
			
			
			
		}
		if(n.equals("Professor")){
			status.setText("Passe o mouse no gráfico para ver a porcentagem");
			i=0;
			select2.setDisable(false);
			String sql1 = "select nome_prof, sum(soma) from grafico  where situacao = 'Concluído' group by nome_prof";
			PreparedStatement ps1 = Conector.getConexao().prepareStatement(sql1);
			ResultSet rs1 = ps1.executeQuery();
				while(rs1.next()){
					lista.add(new PieChart.Data(rs1.getString("nome_prof"), rs1.getInt("sum(soma)")));
					i+=rs1.getInt("sum(soma)");
				}
			ObservableList<Data> observa = FXCollections.observableArrayList(lista);
			grafico.setData(observa);
			
			popularcombo2();
		}
		if(n.equals("Curso")){
			status.setText("Passe o mouse no gráfico para ver a porcentagem");
			i=0;
			select2.setDisable(false);
			String sql1 = "select curso, sum(soma) from grafico  where situacao = 'Concluído' group by curso";
			PreparedStatement ps1 = Conector.getConexao().prepareStatement(sql1);
			ResultSet rs1 = ps1.executeQuery();
				while(rs1.next()){
					lista.add(new PieChart.Data(rs1.getString("curso"), rs1.getInt("sum(soma)")));
					i+=rs1.getInt("sum(soma)");
				}
			ObservableList<Data> observa = FXCollections.observableArrayList(lista);
			grafico.setData(observa);
			popularcombo2();
		}
		final int o = i;
		for(final PieChart.Data data : grafico.getData()){
			data.getNode().addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent event) {
					double f = 100*data.getPieValue()/o;
					
					status.setText(data.getName()+" "+String.format("%.1f", f)+"%");
					
				}
			});
			
			data.getNode().addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent arg0) {
					status.setText("Passe o mouse no gráfico para ver a porcentagem");
					
				}
				
			});
			
		}
		
	}
	
	public void combo2() throws SQLException{
		int i = 0;
		String n= select2.getValue();
		List<Data> lista = new ArrayList<Data>();
		if(select.getValue().equals("Professor")){
			status.setText("Passe o mouse no gráfico para ver a porcentagem");
		i=0;
		String sql1 = "select assunto, sum(soma) from grafico  where  nome_prof = '"+n+"' group by assunto";
		PreparedStatement ps1 = Conector.getConexao().prepareStatement(sql1);
		ResultSet rs1 = ps1.executeQuery();
			while(rs1.next()){
				lista.add(new PieChart.Data(rs1.getString("assunto"), rs1.getInt("sum(soma)")));
				i+=rs1.getInt("sum(soma)");
		}
		ObservableList<Data> observa = FXCollections.observableArrayList(lista);
		grafico.setData(observa);
		}
		
		if(select.getValue().equals("Curso")){
			status.setText("Passe o mouse no gráfico para ver a porcentagem");
			String sql1 = "select assunto, sum(soma) from grafico  where  curso = '"+n+"' group by assunto";
			PreparedStatement ps1 = Conector.getConexao().prepareStatement(sql1);
			ResultSet rs1 = ps1.executeQuery();
				while(rs1.next()){
					lista.add(new PieChart.Data(rs1.getString("assunto"), rs1.getInt("sum(soma)")));
					i+=rs1.getInt("sum(soma)");
			}
			ObservableList<Data> observa = FXCollections.observableArrayList(lista);
			grafico.setData(observa);
		}
		
		
		final int o = i;
		for(final PieChart.Data data : grafico.getData()){
			data.getNode().addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent event) {
					double f = 100*data.getPieValue()/o;
					status.setText(data.getName()+" "+String.format("%.1f", f)+"%");
					
				}
				
			});
			data.getNode().addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent arg0) {
					status.setText("Passe o mouse no gráfico para ver a porcentagem");
					
				}
				
			});
		}
		
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		popularcombo1();
		
	}
	
	public void popularcombo1(){// método de população da combobox//
		ObservableList<String> ob = FXCollections.observableArrayList("Assuntos","Professor","Curso");
		select.setItems(ob);
		
	}
	
	public void popularcombo2() throws SQLException{
		String n = select.getValue();
		List<String> lista = new ArrayList<String>();
		ObservableList<String> ob;
		if(n.equals("Professor")){
			status.setText("Passe o mouse no gráfico para ver a porcentagem");
			String sql1 = "select nome_prof, sum(soma) from grafico  where situacao = 'Concluído' group by nome_prof";
			PreparedStatement ps1 = Conector.getConexao().prepareStatement(sql1);
			ResultSet rs1 = ps1.executeQuery();
				while(rs1.next()){
					lista.add(rs1.getString("nome_prof"));
				}
				ob = FXCollections.observableArrayList(lista);
				select2.setItems(ob);
		}
		if(n.equals("Curso")){
			status.setText("Passe o mouse no gráfico para ver a porcentagem");
			String sql1 = "select curso, sum(soma) from grafico  where situacao = 'Concluído' group by curso";
			PreparedStatement ps1 = Conector.getConexao().prepareStatement(sql1);
			ResultSet rs1 = ps1.executeQuery();
				while(rs1.next()){
					lista.add(rs1.getString("curso"));
				}
				ob = FXCollections.observableArrayList(lista);
				select2.setItems(ob);
		}
		
	}
	
	public void dia(ActionEvent evento) throws IOException{// este método redireciona para a tela de alteração de datas e horarios dos professores//
		
		t.trocar(evento, "Tela_Coordenador_Dias.fxml","Alteração de datas");
	}
	
	public void relatorio(ActionEvent evento) throws IOException{// este método redireciona para a tela de relatorios, onde o coordenador pode visualizar todos os agendamentos feitos pelos alunos através da filtragem de professores//
		t.trocar(evento, "Tela_Relatorios_Coordenador.fxml","Relatórios");
	}
	
	public void retornar(ActionEvent  evento) throws IOException{//retornar à tela de login do professor//
		t.trocar(evento,"Tela_Login.fxml" , "Iniciar Sessão");
	}
	
}
