package inicio;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class Main extends Application {
public static Stage inicio = new Stage ();
@Override
	public void start(Stage in) {
		try {
			inicio.initStyle(StageStyle.UNDECORATED);
			Pane fxml  = FXMLLoader.load(getClass().getResource("loader.fxml"));
			Scene scene = new Scene(fxml,308,191);
			inicio.setScene(scene);
			inicio.setTitle("UNDB");
			inicio.setResizable(false);
			inicio.getIcons().add( new Image(Main.class.getResourceAsStream("icone.png")));
			inicio.centerOnScreen();
			inicio.show();
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void block (){
		Stage ss = new Stage();
		tela_descricao d = new tela_descricao();
		d.s.initOwner(inicio);
		d.s.initModality(Modality.APPLICATION_MODAL);
		d.start(ss);
	}
		
	public static void main(String[] args) {
		launch(args);
	}
}
