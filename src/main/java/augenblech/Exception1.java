package augenblech;


import java.util.ResourceBundle;

import javafx.scene.control.Alert;


public class Exception1 {
	static ResourceBundle boundle = ResourceBundle.getBundle("bundles.messages");
	public static void dialogException() {
        Alert ExceptAlert = new Alert(Alert.AlertType.INFORMATION);
        ExceptAlert.setContentText(boundle.getString("ExceptContent"));
        ExceptAlert.showAndWait();
        }
	public static void dialogException2() {
        Alert ExceptAlert = new Alert(Alert.AlertType.INFORMATION);
        ExceptAlert.setContentText(boundle.getString("ExceptContent2"));
        ExceptAlert.showAndWait();
        }
}
