package augenblech;

import java.lang.reflect.InvocationTargetException;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.LoadException;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import javafx.stage.Stage;
import loadLang.LoadLang;


public class Main extends Application{
	  public void start(Stage primaryStage) throws Exception  {
		
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Window.fxml"));
	    
	    	ResourceBundle boundle = ResourceBundle.getBundle("bundles.messages");
	  	loader.setResources(boundle);
	    	BorderPane borderPane = loader.load(); 
	    	Scene root = new Scene(borderPane);
	    
	    	Application.setUserAgentStylesheet(STYLESHEET_CASPIAN);
	    	
	    	
	    
	    
	    	    	
  	primaryStage.setScene(root);
  	primaryStage.show();
  	
  	}
  public static void main(String[] args) throws Exception {
		launch(args) ;
	
	}

}