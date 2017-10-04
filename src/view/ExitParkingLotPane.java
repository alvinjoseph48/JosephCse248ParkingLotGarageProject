package view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class ExitParkingLotPane {
	private GridPane exitPane;
	private TextField licensePlateField;
	private Button confirmBtn;

	public ExitParkingLotPane() {
		exitPane = new GridPane();
		licensePlateField = new TextField("Enter Licesnse Plate");
		confirmBtn = new Button("Exit Parking Lot");

		exitPane.setVgap(20);
		exitPane.setHgap(20);
		exitPane.setPadding(new Insets(20, 20, 20, 20));
		exitPane.add(licensePlateField, 0, 0);
		exitPane.add(confirmBtn, 1, 0);

	}

	public GridPane getExitPane() {
		return exitPane;
	}

	public void setExitPane(GridPane exitPane) {
		this.exitPane = exitPane;
	}
	public void clear() {
		licensePlateField.clear();
		licensePlateField.setText("Enter Licesnse Plate");
	}

	public TextField getLicensePlateField() {
		return licensePlateField;
	}

	public void setLicensePlateField(TextField licensePlateField) {
		this.licensePlateField = licensePlateField;
	}

	public Button getConfirmBtn() {
		return confirmBtn;
	}

	public void setConfirmBtn(Button confirmBtn) {
		this.confirmBtn = confirmBtn;
	}
	

}
