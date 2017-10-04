package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.ListView;

public class TicketPane {

	private GridPane ticketPane;
	private Button buyTicketBtn;
	private TextField licensePlateField;
	private TextField colorField;
	private ComboBox<String> sizeList;
	private ComboBox<String> timeList;
	// private Label sizeLbl;
	// private Label timeLbl;

	public TicketPane() {
		ticketPane = new GridPane();
		buyTicketBtn = new Button("Purchase Ticket");
		licensePlateField = new TextField("Enter License Plate");
		colorField = new TextField("Enter Color");
		sizeList = new ComboBox<String>(sizes);
		timeList = new ComboBox<String>(times);
		// sizeLbl = new Label("Select your Vehicle size");
		// timeLbl = new Label("Desired Time");

		ticketPane.add(licensePlateField, 0, 0);
		ticketPane.add(colorField, 0, 1);
		// ticketPane.add(sizeLbl, 0, 2);
		ticketPane.add(sizeList, 0, 2);
		// ticketPane.add(timeLbl, 0, 4);
		ticketPane.add(timeList, 0, 3);
		ticketPane.add(buyTicketBtn, 1, 3);
		buyTicketBtn.setStyle("-fx-font: 14 arial; -fx-base: #b6e7c9;");

		ticketPane.setVgap(20);
		ticketPane.setHgap(20);
		ticketPane.setPadding(new Insets(20, 20, 20, 20));

	}

	ObservableList<String> sizes = FXCollections.observableArrayList("MotorCycle", "Car", "Truck");
	ObservableList<String> times = FXCollections.observableArrayList("30 min", "1 Hour", "2 Hours", "3 Hours",
			"4 Hours", "8 Hours", "12 Hours", "24 Hours");

	public GridPane getTicketPane() {
		return ticketPane;
	}

	public void clear() {
		licensePlateField.clear();
		colorField.clear();
		licensePlateField.setText("Enter License Plate");
		colorField.setText("Enter Color ");
		sizeList.getSelectionModel().select("Select Vehicle size");
		timeList.getSelectionModel().select("Select Desired Time");
	}

	public void setTicketPane(GridPane ticketPane) {
		this.ticketPane = ticketPane;
	}

	public Button getBuyTicketBtn() {
		return buyTicketBtn;
	}

	public void setBuyTicketBtn(Button buyTicketBtn) {
		this.buyTicketBtn = buyTicketBtn;
	}

	public TextField getLicensePlateField() {
		return licensePlateField;
	}

	public void setLicensePlateField(TextField licensePlateField) {
		this.licensePlateField = licensePlateField;
	}

	public TextField getColorField() {
		return colorField;
	}

	public void setColorField(TextField colorField) {
		this.colorField = colorField;
	}

	public ComboBox<String> getSizeList() {
		return sizeList;
	}

	public void setSizeList(ComboBox<String> sizeList) {
		this.sizeList = sizeList;
	}

	public ComboBox<String> getTimeList() {
		return timeList;
	}

	public void setTimeList(ComboBox<String> timeList) {
		this.timeList = timeList;
	}

	public ObservableList<String> getSizes() {
		return sizes;
	}

	public void setSizes(ObservableList<String> sizes) {
		this.sizes = sizes;
	}

	public ObservableList<String> getTimes() {
		return times;
	}

	public void setTimes(ObservableList<String> times) {
		this.times = times;
	}

}
