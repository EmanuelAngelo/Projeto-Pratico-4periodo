package inicio;


import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;

import javafx.scene.control.TextField;

public class CadastroController implements Initializable {
	@FXML
	TextField nome = null;
	@FXML
	TextField nascimento = null;
	@FXML
	TextField matricula = null;
	@FXML
	TextField email = null;
	@FXML
	ComboBox<String> curso;
	@FXML
	ComboBox<String> periodo;
	ObservableList<String> observa;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		c();
		combo();
		
	}

	
	public void c(){//metodo da combobox curso//
		observa = FXCollections.observableArrayList("Selecione...","Administra��o","Direito","Sistemas de Informa��o","Ciencias Cont�beis","Arquitetura e Urbanismo","Educa��o F�sica","Engenharia Civil","Engenharia de produ��o","Odontologia","Pedagogia","Psicologia","Turismo");
		curso.setItems(observa);
	}
	public void combo(){//metodo da combobox periodo//
	
		observa = FXCollections.observableArrayList("Selecione...", "1�per�odo","2�per�odo","3�per�odo","4�per�odo","5�per�odo","6�per�odo","7�per�odo","8�per�odo","9�per�odo","10�per�odo");
		periodo.setItems(observa);
		
	}
	
	
	public void cadastrar(ActionEvent evento) throws IOException, SQLException {// este m�todo cadastra os dados do aluno no banco de dados.Se o aluno existir no banco, ele informa que ja existe, sen�o, ele cadastra//
		
		String sql0 = "select * from alunos where matricula = '"+matricula.getText()+"'";
		PreparedStatement ps0 = Conector.getConexao().prepareStatement(sql0);
		ResultSet rs0 = ps0.executeQuery();
		if(rs0.next()){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Falha na opera��o");
			alert.setContentText("Usu�rio j� cadastrado no banco de dados");
			alert.showAndWait();
		}
		if(nome.getText().isEmpty()|| matricula.getText().isEmpty()|| email.getText().isEmpty()){
			Alert alert = new Alert(AlertType.WARNING);
			alert.setHeaderText("Falha na opera��o");
			alert.setContentText("Preencha os campos corretamente");
			alert.showAndWait();
		}
		else{
		
			String sql  = "INSERT INTO alunos(nome,matricula,curso,periodo,data_nascimento,email,sum) values(?,?,?,?,?,?,'1')"; 
	
			PreparedStatement ps;
			try {
				ps = Conector.getConexao().prepareStatement(sql);
				ps.setString(1,nome.getText());
				ps.setString(2,matricula.getText());
				ps.setString(3, curso.getValue());
				ps.setString(4, periodo.getValue());
				ps.setString(5, nascimento.getText());
				ps.setString(6, email.getText());
				ps.execute();
				ps.close();
				Alert al = new Alert(AlertType.INFORMATION);
				al.setHeaderText("Aviso");
				al.setContentText(nome.getText()+ ", seu cadastro foi efetuado com sucesso!!! seu usu�rio � a sua matr�cula e sua senha padr�o � a data de nascimento cadastrada anteriormente");
				al.showAndWait();
				trocarTelas t = new trocarTelas();
				t.trocar(evento, "Tela_Login.fxml", "Iniciar Sess�o");
				} catch (SQLException e) {
						Alert ale = new Alert(AlertType.ERROR);
						ale.setHeaderText("Falha na opera��o");
						ale.setContentText("Insira as informa��es nos respectivos campos corretamente.");
						ale.showAndWait();
				}
			
		}
		}
			
		public void voltar(ActionEvent evento) throws IOException{//este m�todo redireciona a p�gina para a tela de login do aluno//
			trocarTelas t = new trocarTelas();
			t.trocar(evento,"Tela_Login.fxml" ,"Iniciar Sess�o");
		}
	
	
	
}
