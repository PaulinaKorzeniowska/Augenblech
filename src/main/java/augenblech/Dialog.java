package augenblech;
import java.util.Optional;
import java.util.ResourceBundle;


import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Dialog {
	

	static ResourceBundle boundle = ResourceBundle.getBundle("bundles.messages");
	public static void dialogAboutApplication() {
        Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
        informationAlert.setTitle(boundle.getString("aboutTitle"));
        informationAlert.setHeaderText(boundle.getString("aboutHeader"));
        informationAlert.setContentText(boundle.getString("aboutContent"));
        informationAlert.showAndWait();
        }
	public static Optional<ButtonType> confirmationDialog(){
		Alert confirmationDialog = new Alert(Alert.AlertType.INFORMATION);
		confirmationDialog.setTitle(boundle.getString("exitTitle"));
		confirmationDialog.setHeaderText(boundle.getString("exitHeader"));
		Optional<ButtonType> result = confirmationDialog.showAndWait();
		return result;
	}
}
