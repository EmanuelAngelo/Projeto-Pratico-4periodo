package inicio;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.shape.Rectangle;

public class AjudaController implements Initializable {
	
	@FXML
	Rectangle rec;
	@FXML
	Button bt1;
	@FXML
	Button bt2;
	@FXML
	Button bt3;
	@FXML
	MediaView video;
	MediaPlayer player;
	Media midia;
	
	public void aluno(){
		String s = new File("aluno.mp4").getAbsolutePath();
		midia = new Media(new File(s).toURI().toString());
		player = new MediaPlayer(midia);
		video.setMediaPlayer(player);
		DoubleProperty width = video.fitWidthProperty();
		width.bind(Bindings.selectDouble(video.sceneProperty(),"width"));
		DoubleProperty height = video.fitHeightProperty();
		height.bind(Bindings.selectDouble(video.sceneProperty(),"height"));
		bt1.setDisable(false);
		bt2.setDisable(true);
		bt3.setDisable(true);
	}
	public void prof(){
		String s = new File("professor.mp4").getAbsolutePath();
		midia = new Media(new File(s).toURI().toString());
		player = new MediaPlayer(midia);
		video.setMediaPlayer(player);
		DoubleProperty width = video.fitWidthProperty();
		width.bind(Bindings.selectDouble(video.sceneProperty(),"width"));
		DoubleProperty height = video.fitHeightProperty();
		height.bind(Bindings.selectDouble(video.sceneProperty(),"height"));
		bt1.setDisable(false);
		bt2.setDisable(true);
		bt3.setDisable(true);
		
	}
	public void coord(){
		String s = new File("coordenador.mp4").getAbsolutePath();
		midia = new Media(new File(s).toURI().toString());
		player = new MediaPlayer(midia);
		video.setMediaPlayer(player);
		DoubleProperty width = video.fitWidthProperty();
		width.bind(Bindings.selectDouble(video.sceneProperty(),"width"));
		DoubleProperty height = video.fitHeightProperty();
		height.bind(Bindings.selectDouble(video.sceneProperty(),"height"));
		bt1.setDisable(false);
		bt2.setDisable(true);
		bt3.setDisable(true);
		
	}
	
	public void pause(){
		player.pause();
		bt2.setDisable(true);
		bt1.setDisable(false);
	}
	public void play(){
		player.play();
		bt1.setDisable(true);
		bt2.setDisable(false);
		bt3.setDisable(false);
	}
	
	public void reload(){
		player.seek(player.getStartTime());
		
	}
	
	public void retornar(ActionEvent evento) throws IOException{
		trocarTelas t = new trocarTelas();
		t.trocar(evento,"Tela_Login.fxml","Iniciar Sessão");
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	public void exibir (){
		bt1.setOpacity(1);
		bt2.setOpacity(1);
		bt3.setOpacity(1);
		rec.setOpacity(0.5);
	}
	public void ocultar(){
		bt1.setOpacity(0);
		bt2.setOpacity(0);
		bt3.setOpacity(0);
		rec.setOpacity(0);
	}
	
}
