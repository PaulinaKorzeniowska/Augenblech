package augenblech;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class Augenblech implements Initializable {

	ObservableList<String> list = FXCollections.observableArrayList();

	@FXML
	public TextField Fed;
	public TextField fy;
	public TextField ym0;
	public TextField tsoll;
	public TextField t;
	public TextField dmin;
	public TextField asoll;
	public TextField csoll;
	public TextField a;
	public TextField c;
	public TextField Fbed;
	public TextField Fbrd;
	public TextField ausn;

	@FXML
	public ChoiceBox<String> stahl;
	public ChoiceBox<String> sprache;
	@FXML
	public Button rechnen;
	public Button rechnen1;
	public Button rechnen2;

	@FXML
	public MenuItem pl;
	public MenuItem de;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		loadData();
	}

	String fy1;

	public void fy() {

	try {	String stahl1 = stahl.getValue();
		if (stahl1 == null) {
			Exception1.dialogException();}
		else {		
		switch (stahl1) {
			case "S235":
				fy1 = "23.5";
				break;
			case "S275":
				fy1 = "27.5";
				break;
			case "S355":
				fy1 = "35.5";
				break;
			case "S420":
				fy1 = "42.0";
				break;
			case "S490":
				fy1 = "49.0";
				break;
			}
		
		fy.setText(fy1);}}
	catch (NullPointerException np){Exception1.dialogException();} 
}
	
	

	public void Fed()  {
	try {	fed1 = Fed.getText();

		Fed2 = Double.parseDouble(fed1);}
	catch (NumberFormatException nb) {Exception1.dialogException();}
	catch (NullPointerException np){Exception1.dialogException();}
	}

	Double Fed2;
	Double fy11;
	String fed1;

	public void tsoll()  {
		Fed();
		try {
		fy11 = Double.parseDouble(fy1);
		Double tsoll1 = 0.7 * Math.sqrt(Fed2 * 1 / fy11);
		String tsoll3 = Double.toString(tsoll1);
		tsoll.setText(tsoll3);}
		catch (NumberFormatException nb) {}
		catch (NullPointerException np){}
	}

	public void rechnen2()  {

		String gamma0 = "1.0";
		ym0.setText(gamma0);
		fy();
		tsoll();
	}

	String t1;
	String d1;
	Double t11;
	Double d11;

	public void t1d1() {
		try{t1 = t.getText();
		d1 = dmin.getText();
		t11 = Double.parseDouble(t1);
		d11 = Double.parseDouble(d1);}
		catch (NumberFormatException nb) {Exception1.dialogException();}
		catch (NullPointerException np){Exception1.dialogException();}
	}
	Double asoll1;
	public void asoll() {
	try{t1d1();
		asoll1 = Fed2 * 1 / (2 * t11 * fy11) + 2 * d11 / 3;
		String asoll11 = Double.toString(asoll1);
		asoll.setText(asoll11);}
	catch (NumberFormatException nb) {}
	catch (NullPointerException np){}
	}
	Double csoll1;
	public void csoll() {
		try{t1d1();
		csoll1 = (Fed2 * 1 / (2 * t11 * fy11)) + (d11 / 3);
		String csoll11 = Double.toString(csoll1);
		csoll.setText(csoll11);}
		catch (NumberFormatException nb) {}
		catch (NullPointerException np){}
	}

	public void rechnen() {
		asoll();
		csoll();

	}

	public void fbed()  {
	try {	Fed();
		Fbed.setText(fed1);}
	catch (NumberFormatException nb) {Exception1.dialogException();}
	catch (NullPointerException np){Exception1.dialogException();}
	}

	Double Fbrd11;

	public void fbrd()  {
	
	
	try {	String aaa = a.getText();
	Double daaa = Double.parseDouble(aaa);
	String ccc = c.getText();
	Double dccc = Double.parseDouble(ccc);
	if (aaa!=null && daaa>=asoll1 && ccc!=null && dccc>=csoll1) {
		Fbrd11 = 1.5 * t11 * d11 * fy11 / 1;
		String Fbrd1 = Double.toString(Fbrd11);
		Fbrd.setText(Fbrd1);}
	if ( daaa<=asoll1 && dccc<=csoll1) {Exception1.dialogException2();}
	
	}
	catch (NumberFormatException nb) {Exception1.dialogException();}
	catch (NullPointerException np){Exception1.dialogException();}
	
	
	}

	public void ausn()   {
	try{Double Ausn = Fed2 / Fbrd11 * 100;
		String Ausn1 = Double.toString(Ausn);
		ausn.setText(Ausn1);}
	catch (NumberFormatException nb) {Exception1.dialogException();}
	catch (NullPointerException np){Exception1.dialogException();}

	}

	public void rechnen1()  {
		fbed();
		fbrd();
		ausn();

	}

	@SuppressWarnings("unlikely-arg-type")
	private void loadData()  {
		list.remove(list);
		String a = "S235";
		String b = "S275";
		String c = "S355";
		String d = "S420";
		String e = "S490";
		list.addAll(a, b, c, d, e);
		stahl.getItems().addAll(list);

	}

	// Top Menu
	@FXML
	public void about(ActionEvent actionevent) {
		Dialog.dialogAboutApplication();
	}

	@FXML
	public void closeApplication(ActionEvent actionevent) {
		Optional<ButtonType> result = Dialog.confirmationDialog();
		if (result.get() == ButtonType.OK) {
			Platform.exit();
			System.exit(0);
		}
	}

	public void pl(ActionEvent event) {
		// Exception1.dialogException();
		// loadLang("pl");

	}

	public void de(ActionEvent event) {
		// loadLang("default");
	}

}
