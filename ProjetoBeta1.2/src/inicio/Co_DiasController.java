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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

public class Co_DiasController implements Initializable {
	
	public int idprof;
	
	@FXML
	TextField dias1;
	@FXML
	TextField dias;
	@FXML
	TextField horario;
	@FXML
	ComboBox<String> professor;
	@FXML
	Button edita;
	
	@FXML
	Button save;
	private ObservableList<String> observa;	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			prof();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public void prof() throws SQLException{//metodo de população da combobox, para escolher o professor //
		List<String> listaprof = new ArrayList<String>();
		
		String sql = "select* from professor where nome_prof != 'Coordenadora Marineis'";
		 PreparedStatement ps = Conector.getConexao().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
			while(rs.next()){
				listaprof.add(rs.getString("nome_prof"));
			}
			observa = FXCollections.observableArrayList(listaprof);
			professor.setItems(observa);
		
	}
	
	public void info() throws SQLException{//método que possibilita a visualização dos dias e horario a partir do professor que foi selecionado na combobox//
		String n = professor.getValue();
		String sql = "select * from coordenacao where nome_prof = '"+n+"'";
		PreparedStatement ps = Conector.getConexao().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			idprof = rs.getInt("idprofessor");
			dias.setText(rs.getString("dias"));
			horario.setText(rs.getString("horario"));
			dias1.setText(rs.getString("dia2"));
		}
		edita.setDisable(false);
	}
			
	public void editar(){//método que possibilita a edição das datas do professor selecionado na combobox//
		dias.setEditable(true);
		dias1.setEditable(true);
		horario.setEditable(true);
		save.setDisable(false);
		
	}
	
	public void salvar()  {// este método faz um update no banco de dados dos dias e horario do professor selecionado se  caso for alterado//
		
		String sql = "update dias set dias =? , horario = ?,dia2 = ? where professor = ?";
		PreparedStatement ps;
		
			try {
				ps = Conector.getConexao().prepareStatement(sql);
				ps.setString(1, dias.getText());
				ps.setString(2, horario.getText());
				ps.setString(3, dias1.getText());
				ps.setInt(4, idprof);
				ps.execute();
				Alert al = new Alert(AlertType.INFORMATION);
				al.setHeaderText("Aviso");
				al.setContentText("Alterações realizadas com sucesso");
				al.showAndWait();
			} catch (SQLException e) {
				Alert al = new Alert(AlertType.ERROR);
				al.setHeaderText("Aviso");
				al.setContentText("Ocorreu um erro");
				al.showAndWait();
			}
			
	}
		public void voltar(ActionEvent evento) throws IOException{//retornar à tela do coordenador//
			trocarTelas t = new trocarTelas();
			t.trocar(evento, "Tela_Coordenador.fxml","Bem-Vinda Coordenadora Marineis");
		}
	
}
