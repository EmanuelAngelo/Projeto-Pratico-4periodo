package inicio;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import conexao_login_aluno.ConexaoAluno;
import conexao_login_professor.Conecta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;

public class Login_alunoController implements Initializable{

	@FXML
	TextField matricula;
	@FXML 
	PasswordField nascimento;
	public static int mat;
	@FXML
	ComboBox<String> select;
	@FXML
	Button Cadastro;
	
	public void alimentarCombo(){
		ObservableList<String> observa = FXCollections.observableArrayList("Aluno","Professor/Coordenador");
		select.setItems(observa);
	}
	
	
	
	public void entrar(ActionEvent evento) throws IOException{//este método verificará a matricula e o nome do aluno, se existi, vai pra tela de agendamentos//
		trocarTelas t = new trocarTelas();
		if(select.getValue().equals("Aluno")){
		
			ConexaoAluno c = new ConexaoAluno();
			c.logar(matricula.getText(), nascimento.getText());
			
			if(c.teste == true){
				mat = Integer.parseInt(matricula.getText());
				t.trocar(evento, "Tela_Agendamentos.fxml", "Bem-Vindo, "+ c.nome);
			}else{
				Alert ale = new Alert(AlertType.ERROR);
				ale.setHeaderText("Falha na operação");
				ale.setContentText("Usuário e senha não cadastrados no sistema");
				ale.showAndWait();
			}
		}
		if(select.getValue().equals("Professor/Coordenador")){
			Conecta c = new Conecta();
			
			c.salvar(matricula.getText(), nascimento.getText());
			
			if(c.teste==true){
				String u = matricula.getText(), s = nascimento.getText();
				if(u.equalsIgnoreCase("Marineis@undb.edu.br")&& s.equals("123456")){
					
					t.trocar(evento,"Tela_Coordenador.fxml","Bem vinda, "+c.nome);
					
				}else{
					
				t.trocar(evento, "Tela_Professor_Agendamentos.fxml", "Bem vindo, Professor "+c.nome);
				
				}
				
			}else{
				Alert ale = new Alert(AlertType.ERROR);
				ale.setHeaderText("Falha na operação");
				ale.setContentText("Insira o login e/ou senha incorretos");
				ale.showAndWait();
			}
		}
		
		
	}
			public void cadastrar(ActionEvent event) throws IOException{//este método redireciona a página para a tela de cadastro//
					trocarTelas t = new trocarTelas();
					t.trocar(event,"Tela_Cadastro_Aluno.fxml","Cadastramento do aluno");
			}
			
			public void voltar(ActionEvent evento) throws IOException{//este método redireciona a página para o menu principal //
				System.exit(0);
			}
			public void ajuda(ActionEvent evento) throws IOException{
				trocarTelas t = new trocarTelas();
				t.trocar(evento, "Ajuda.fxml","Ajuda ao Usuário");
			}
			public void site(ActionEvent evento	) throws IOException{//este método direciona para o site da undb //
				Parent p = FXMLLoader.load(getClass().getResource("Site.fxml"));
				Scene cena = new Scene(p);
				Stage estagio = (Stage) (((Node) evento.getSource()).getScene().getWindow());
				estagio.setTitle("Unidade de Ensino Superior Dom Bosco");
				estagio.setResizable(false);
				estagio.setScene(cena);
				estagio.show();
				
			}
			
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		alimentarCombo();
		select.setValue("Aluno");
		
	}

}
