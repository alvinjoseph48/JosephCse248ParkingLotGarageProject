package view;

import java.util.Hashtable;
import java.util.Stack;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.Car;
import model.HashTable;
import model.Motorcycle;
import model.ParkingSpot;
import model.Ticket;
import model.Truck;
import model.Vehicle;

public class ParkingLotView extends Application {
	private Stack<ParkingSpot> carStack;
	private Stack<ParkingSpot> motorCycleStack;
	private Stack<ParkingSpot> truckStack;
	// private HashTable h1;
	private TicketPane ticketPane;
	private ExitParkingLotPane exitParkingLotPane;
	private ParkingSpot popedCar;
	private Hashtable<String, Vehicle> hashTable;
	private double carCost = 10.0;
	private double truckCost = 20.0;
	private double motorCycleCost = 7.5;
	private double hourlyRate = 1;

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane parkingPane = new Pane();
		exitParkingLotPane = new ExitParkingLotPane();
		ticketPane = new TicketPane();
		// h1 = new HashTable(18);
		hashTable = new Hashtable<String, Vehicle>();

		carStack = new Stack<ParkingSpot>();
		motorCycleStack = new Stack<ParkingSpot>();
		truckStack = new Stack<ParkingSpot>();
		truckStack.setSize(10);
		carStack.setSize(10);
		motorCycleStack.setSize(10);

		ParkingSpot[] carSpots = new ParkingSpot[10];
		ParkingSpot carSpot;
		for (int i = 0; i < 10; i++) {
			carSpot = new ParkingSpot(i);
			carSpots[i] = carSpot;
			carStack.push(carSpots[i]);
		}
		ParkingSpot[] truckSpots = new ParkingSpot[10];
		ParkingSpot truckSpot;
		for (int i = 0; i < 10; i++) {
			truckSpot = new ParkingSpot(i);
			truckSpots[i] = truckSpot;
			truckStack.push(truckSpots[i]);
			System.out.println(truckSpots[i].toString());
		}
		ParkingSpot[] motorCycleSpots = new ParkingSpot[10];
		ParkingSpot motorCycleSpot;
		for (int i = 0; i < 10; i++) {
			motorCycleSpot = new ParkingSpot(i);
			truckSpots[i] = motorCycleSpot;
			truckStack.push(motorCycleSpots[i]);
		}

		parkingPane.getMenuBar().prefWidthProperty().bind(primaryStage.widthProperty());

		parkingPane.getParkingMenu().setOnAction(e -> {
			parkingPane.getBorderPane().setCenter(exitParkingLotPane.getExitPane());
			exitParkingLotPane.clear();

		});
		parkingPane.getBuyTicket().setOnAction(e -> {
			parkingPane.getBorderPane().setCenter(ticketPane.getTicketPane());
			ticketPane.clear();
		});
		parkingPane.getExit().setOnAction(e -> {
			System.exit(0);
		});
		ticketPane.getBuyTicketBtn().setOnAction(e -> {
			// check if stack has spaces open to pop
			if (ticketPane.getSizeList().getSelectionModel().getSelectedIndex() == 0) {
				// parkTruck();
			}
			if (ticketPane.getSizeList().getSelectionModel().getSelectedIndex() == 1) {
				if (parkCar() != null) {
					Vehicle c1 = hashTable.get(ticketPane.getLicensePlateField().getText());
					alertParked();
					System.out.println(c1.toString() + " " + c1.getLicense());
					System.out.println("parked car");
					// alert car is parked
				} else {
					alertFull();
				}
			}
			if (ticketPane.getSizeList().getSelectionModel().getSelectedIndex() == 2) {
				if (parkTruck() != null) {
					Vehicle c1 = hashTable.get(ticketPane.getLicensePlateField().getText());
					alertParked();
					System.out.println(c1.toString() + " " + c1.getLicense());
					System.out.println("parked car");

				} else {
					alertFull();
				}
			}

			// put in hashtable

		});
		exitParkingLotPane.getConfirmBtn().setOnAction(e -> {
			// check if in hashTable
			removeCar();
			// push to stack
		});

		Scene myScene = new Scene(parkingPane.getBorderPane(), 500, 500);
		primaryStage.setScene(myScene);
		primaryStage.show();

	}

	private void alertFull() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setHeaderText("Parking is full");
		alert.setContentText("No more spaces, please try again later");
		alert.showAndWait();
	}

	private void alertParked() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setHeaderText("Parking ticket purchased ");
		alert.setContentText(
				"License Plate:" + ticketPane.getLicensePlateField().getText() + "\nCost of Ticket: " + costOfTicket());
		alert.showAndWait();
	}

	private double costOfTicket() {
		int value = ticketPane.getSizeList().getSelectionModel().getSelectedIndex();
		double time = timeReturn();
		double cost = 0;
		if (value == 1) {
			cost = carCost + (hourlyRate * time);
		} else if (value == 2) {
			cost = truckCost + (hourlyRate * time);
		} else {
			cost = motorCycleCost + (hourlyRate * time);
		}
		return cost;
	}

	private double timeReturn() {
		int timeIndex = ticketPane.getTimeList().getSelectionModel().getSelectedIndex();
		if (timeIndex == 0) {
			return .5;
		} else if (timeIndex == 1) {
			return 1;
		} else if (timeIndex == 2) {
			return 2;
		} else if (timeIndex == 3) {
			return 3;
		} else if (timeIndex == 4) {
			return 4;
		} else if (timeIndex == 5) {
			return 8;
		} else if (timeIndex == 6) {
			return 12;
		} else if (timeIndex == 7) {
			return 24;
		}
		return 0;
	}

	private Car removeCar() {
		Car c1 = (Car) hashTable.get(ticketPane.getLicensePlateField().getText());
		if (c1 != null) {
			carStack.push(popedCar);
			return c1;
		}
		return null;
	}

	private ParkingSpot parkCar() {
		ParkingSpot p1 = carStack.pop();
		if (p1 != null) {
			hashTable.put(createCar().getLicense(), createCar());
			return p1;
		}
		popedCar = truckStack.pop();
		if (popedCar != null) {
			hashTable.put(createCar().getLicense(), createCar());
			return popedCar;
		} else

			return null;
	}

	private ParkingSpot parkTruck() {
		ParkingSpot p1 = truckStack.pop();
		if (p1 != null) {
			hashTable.put(createTruck().getLicense(), createTruck());
			return p1;
		}
		return null;
	}

	private Truck createTruck() {
		Truck t1 = new Truck(ticketPane.getLicensePlateField().getText(), ticketPane.getColorField().getText());
		return t1;
	}

	private Car createCar() {
		Car c1 = new Car(ticketPane.getLicensePlateField().getText(), ticketPane.getColorField().getText());
		return c1;
	}

}
