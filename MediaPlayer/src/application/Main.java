package application;

import java.io.File;
import java.net.MalformedURLException;

import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;


public class Main extends Application {
	
	MenuBar menuBar;
	Menu fileMenu;
	MenuItem openItem;
	
	FileChooser mediaChooser;
	Player mediaPlayer;
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			
			mediaChooser = new FileChooser();
			
			menuBar = new MenuBar();
			fileMenu = new Menu("File");
			openItem = new MenuItem("Open");
			fileMenu.getItems().add(openItem);
			menuBar.getMenus().add(fileMenu);
			
			openItem.setOnAction((e) -> {
				try {
					File mediaFile = mediaChooser.showOpenDialog(primaryStage);
					if(mediaPlayer != null)
					{
						mediaPlayer.player.dispose();
					}
					mediaPlayer = new Player(mediaFile.toURI().toURL().toExternalForm());
					mediaPlayer.view.setFitWidth(scene.getWidth());
					root.setCenter(mediaPlayer);
					
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//System.out.println(mediaFile.getAbsolutePath());
			});
			
			root.setTop(menuBar);
			primaryStage.widthProperty().addListener((obs,oldVal,newVal) -> {
				if(mediaPlayer != null)
				{
					mediaPlayer.view.setFitWidth(scene.getWidth());
				}
			});
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
