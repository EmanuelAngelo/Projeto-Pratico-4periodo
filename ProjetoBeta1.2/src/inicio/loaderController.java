package inicio;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class loaderController implements Initializable {

	@FXML
	AnchorPane tela;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		new Splash().start();
		
	}

	class Splash extends Thread{
		
			
		 public void run (){
			 try {
				Thread.sleep(4000);
				
				Platform.runLater(new Runnable(){

					@Override
					public void run() {
						Pane fxml;
						try {
							fxml = FXMLLoader.load(getClass().getResource("Tela_Login.fxml"));
							Scene scene = new Scene(fxml,740,540);
							Stage inicio = new Stage();
							inicio.setScene(scene);
							inicio.setTitle("Sistema de Apoio Metodológico ao Discente");
							inicio.setResizable(false);
							inicio.getIcons().add( new Image(Main.class.getResourceAsStream("icone.png")));
							inicio.centerOnScreen();
							inicio.show();
							tela.getScene().getWindow().hide();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
						
					}
					
				});
				} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
				}
				
			
		 }
		
	}
	
}
