package inicio;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class trocarTelas {
	
	public void trocar (ActionEvent evento, String fxml,String titulo ) throws IOException{// método para alternar as telas através da inserção de parâmetros, para economizar linhas de código//
		Parent p = FXMLLoader.load(getClass().getResource(fxml));
		Scene cena = new Scene(p);
		Stage estagio = (Stage) (((Node) evento.getSource()).getScene().getWindow());
		
		estagio.setTitle(titulo);
		estagio.setScene(cena);
		estagio.show();
	}
	

}
