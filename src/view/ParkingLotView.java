package view;

import java.util.EmptyStackException;
import java.util.Hashtable;
import java.util.Stack;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.Car;
import model.Motorcycle;
import model.ParkingSpot;
import model.Truck;
import model.Vehicle;

public class ParkingLotView extends Application {
	private Stack<ParkingSpot> carStack;
	private Stack<ParkingSpot> motorCycleStack;
	private Stack<ParkingSpot> truckStack;

	private TicketPane ticketPane;
	private ExitParkingLotPane exitParkingLotPane;
	private ParkingSpot popedVehicle;
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
		hashTable = new Hashtable<String, Vehicle>();

		carStack = new Stack<ParkingSpot>();
		motorCycleStack = new Stack<ParkingSpot>();
		truckStack = new Stack<ParkingSpot>();
		truckStack.setSize(5);
		carStack.setSize(10);
		motorCycleStack.setSize(2);

		ParkingSpot[] carSpots = new ParkingSpot[10];
		ParkingSpot carSpot;
		for (int i = 0; i < 10; i++) {
			carSpot = new ParkingSpot(i);
			carSpots[i] = carSpot;
			carStack.push(carSpots[i]);
		}
		ParkingSpot[] truckSpots = new ParkingSpot[5];
		ParkingSpot truckSpot;
		for (int i = 0; i < 5; i++) {
			truckSpot = new ParkingSpot(i);
			truckSpots[i] = truckSpot;
			truckStack.push(truckSpots[i]);
		}
		ParkingSpot[] motorCycleSpots = new ParkingSpot[2];
		ParkingSpot motorCycleSpot;
		for (int i = 0; i < 2; i++) {
			motorCycleSpot = new ParkingSpot(i);
			motorCycleSpots[i] = motorCycleSpot;
			motorCycleStack.push(motorCycleSpots[i]);
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
			if (!timeSelectionCheck()) {
				mustSelectTimeAlert();
				return;
			}
			if (ticketPane.getSizeList().getSelectionModel().getSelectedIndex() == 0) {
				if (parkMotorCycle() != null) {
					Vehicle c1 = hashTable.get(ticketPane.getLicensePlateField().getText());
					alertParked();
					System.out.println(c1.toString() + " " + c1.getLicense());
					System.out.println("parked car");

				} else {
					alertFull();
				}

			}
			if (ticketPane.getSizeList().getSelectionModel().getSelectedIndex() == 1) {
				try {
					if (parkCar() != null) {
						Vehicle c1 = hashTable.get(ticketPane.getLicensePlateField().getText());
						alertParked();
						System.out.println(c1.toString() + " " + c1.getLicense());
						System.out.println("parked car");
					} else {
						alertFull();
					}
				} catch (EmptyStackException e1) {
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

		});
		exitParkingLotPane.getConfirmBtn().setOnAction(e -> {
			if (removeVehicle() != null) {
				alertRemoved();
			} else {
				alertNotFound();
			}

		});

		Scene myScene = new Scene(parkingPane.getBorderPane(), 500, 500);
		primaryStage.setScene(myScene);
		primaryStage.show();

	}

	private boolean timeSelectionCheck() {
		if (ticketPane.getTimeList().getSelectionModel().isEmpty()) {
			return false;
		}
		return true;
	}

	private void alertNotFound() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setHeaderText("Car Was Never Parked!");
		alert.setContentText("Sorry please try again");
		alert.showAndWait();
	}

	private void mustSelectTimeAlert() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setHeaderText("Desired Time Selection");
		alert.setContentText("Please Select Desired Time!");
		alert.showAndWait();
	}

	private void alertParkingInTruckSpot() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("Only Truck Spots Available");
		alert.setContentText("Sorry for the inconvenience but please park in a truck Spot");
		alert.showAndWait();
	}

	private void alertParkingInCarSpot() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("Only Car Spots Available");
		alert.setContentText("Sorry for the inconvenience but please park in a Car Spot");
		alert.showAndWait();
	}

	private void alertRemoved() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setHeaderText("Leaving Parking Lot \nThank You Come Again!");
		alert.setContentText("License Plate: " + exitParkingLotPane.getLicensePlateField().getText());
		alert.showAndWait();
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
		alert.setContentText("License Plate: " + ticketPane.getLicensePlateField().getText() + "\nCost of Ticket: "
				+ costOfTicket());
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

	private Vehicle removeVehicle() {

		Vehicle c1 = hashTable.remove(exitParkingLotPane.getLicensePlateField().getText());
		if (c1 instanceof Car) {
			carStack.push(popedVehicle);
			return c1;
		} else if (c1 instanceof Motorcycle) {
			motorCycleStack.push(popedVehicle);
			return c1;
		} else if (c1 instanceof Truck) {
			truckStack.push(popedVehicle);
			return c1;
		}
		return null;
	}

	private ParkingSpot parkCar() {
		popedVehicle = carStack.pop();
		if (popedVehicle != null) {
			hashTable.put(createCar().getLicense(), createCar());
			return popedVehicle;
		}
		popedVehicle = truckStack.pop();
		if (popedVehicle != null) {
			alertParkingInTruckSpot();
			hashTable.put(createCar().getLicense(), createCar());
			return popedVehicle;
		} else
			return null;
	}

	private ParkingSpot parkMotorCycle() {
		popedVehicle = motorCycleStack.pop();
		if (popedVehicle != null) {
			hashTable.put(createMotorCycle().getLicense(), createMotorCycle());
			return popedVehicle;
		}
		popedVehicle = carStack.pop();
		if (popedVehicle != null) {
			alertParkingInCarSpot();
			hashTable.put(createCar().getLicense(), createCar());
			return popedVehicle;
		}
		popedVehicle = truckStack.pop();
		if (popedVehicle != null) {
			alertParkingInTruckSpot();
			hashTable.put(createCar().getLicense(), createCar());
			return popedVehicle;
		} else
			return null;
	}

	private ParkingSpot parkTruck() {
		if (!truckStack.empty()) {
			popedVehicle = truckStack.pop();
			hashTable.put(createTruck().getLicense(), createTruck());
			return popedVehicle;
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

	private Motorcycle createMotorCycle() {
		Motorcycle m1 = new Motorcycle(ticketPane.getLicensePlateField().getText(),
				ticketPane.getColorField().getText());
		return m1;
	}

}
