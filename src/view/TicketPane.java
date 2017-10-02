package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.ListView;

public class TicketPane {

	private GridPane ticketPane;
	private Button buyTicketBtn;
	private TextField licensePlateField;
	private TextField colorField;
	private ListView<String> sizeList;
	private ListView<String> timeList;

	public TicketPane() {
		ticketPane = new GridPane();
		buyTicketBtn = new Button("Purchase Ticket");
		licensePlateField = new TextField("Enter License Plate");
		colorField = new TextField("Enter Color");
		sizeList = new ListView<String>(sizes);
		timeList = new ListView<String>(times);

		ticketPane.add(licensePlateField, 0, 0);
		ticketPane.add(colorField, 0, 1);
		ticketPane.add(sizeList, 0, 2);
		ticketPane.add(timeList, 0, 3);

		ticketPane.setVgap(20);
		ticketPane.setHgap(20);
		ticketPane.setPadding(new Insets(20, 20, 20, 20));

	}

	ObservableList<String> sizes = FXCollections.observableArrayList("MoterCycle", "Car", "Truck");
	ObservableList<String> times = FXCollections.observableArrayList("30 min", "1 Hour", "2 Hours", "3 Hours",
			"4 Hours", "8 Hours", "12 Hours", "24 Hours");

	public GridPane getTicketPane() {
		return ticketPane;
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

	public ListView<String> getSizeList() {
		return sizeList;
	}

	public void setSizeList(ListView<String> sizeList) {
		this.sizeList = sizeList;
	}

	public ListView<String> getTimeList() {
		return timeList;
	}

	public void setTimeList(ListView<String> timeList) {
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
