package inicio;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;


public class tela_descricao extends Application {
	public  Stage s = new Stage();
	
	public void start(Stage stage) {
		try {
			
	        
			
			Pane fxml  = FXMLLoader.load(getClass().getResource("Professor_descricao.fxml"));
			Scene scene = new Scene(fxml,555,410);
			s.setScene(scene);
			s.setTitle("Opções de atendimento");
			s.getIcons().add( new Image(Main.class.getResourceAsStream( "icone.png" )));
			s.show();
			s.setResizable(false);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
