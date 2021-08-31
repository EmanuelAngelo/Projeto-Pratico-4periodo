package inicio;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class SiteController implements Initializable {

	@FXML
	WebView web = new WebView();
	
	WebEngine wb = new WebEngine();
	
	
	public void atualizar(ActionEvent evento){// método que possibilita o acesso ao site da undb//
		wb.load("http://www.undb.edu.br/home/");
	}
	
	public void voltar(ActionEvent evento) throws IOException{// retornar ao menu principal//
		Parent p = FXMLLoader.load(getClass().getResource("Tela_Login.fxml"));
		Scene cena = new Scene(p);
		Stage estagio = (Stage) (((Node) evento.getSource()).getScene().getWindow());
		estagio.setTitle("iniciar Sessão");
		estagio.setResizable(false);
		estagio.setScene(cena);
		estagio.show();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		wb = web.getEngine();
		
	}

}
