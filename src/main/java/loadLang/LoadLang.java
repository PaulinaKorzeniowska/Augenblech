package loadLang;

import java.util.Locale;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;

public class LoadLang {
	Locale locale;
	ResourceBundle boundle = ResourceBundle.getBundle("bundles.messages",locale);
	public  void loadLang(String lang) {
		locale = new Locale(lang);
		
		Locale.setDefault(new Locale("default"));
	
	
	}
}
