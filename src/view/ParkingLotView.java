package view;

import java.util.Stack;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Car;
import model.HashTable;
import model.Motorcycle;
import model.ParkingSpot;
import model.Ticket;
import model.Truck;

public class ParkingLotView extends Application {
	private Stack<ParkingSpot> carStack;
	private Stack<ParkingSpot> motorCycleStack;
	private Stack<ParkingSpot> truckStack;
	private HashTable h1;
	private TicketPane ticketPane;
	private ExitParkingLotPane exitParkingLotPane;
	private ParkingSpot popedCar;

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane parkingPane = new Pane();
		exitParkingLotPane = new ExitParkingLotPane();
		ticketPane = new TicketPane();
		h1 = new HashTable(18);

		ParkingSpot[] carSpots = new ParkingSpot[10];
		ParkingSpot carSpot;
		for (int i = 0; i < 10; i++) {
			carSpot = new ParkingSpot(i, "Small");
			carSpots[i] = carSpot;
			carStack.push(carSpots[i]);
		}
		ParkingSpot[] truckSpots = new ParkingSpot[5];
		ParkingSpot truckSpot;
		for (int i = 10; i < 15; i++) {
			truckSpot = new ParkingSpot(i, "Small");
			truckSpots[i] = truckSpot;
			truckStack.push(truckSpots[i]);
		}
		ParkingSpot[] motorCycleSpots = new ParkingSpot[5];
		ParkingSpot motorCycleSpot;
		for (int i = 15; i < 18; i++) {
			motorCycleSpot = new ParkingSpot(i, "Small");
			truckSpots[i] = motorCycleSpot;
			truckStack.push(motorCycleSpots[i]);
		}

		carStack = new Stack<ParkingSpot>();
		motorCycleStack = new Stack<ParkingSpot>();
		truckStack = new Stack<ParkingSpot>();

		truckStack.setSize(5);
		carStack.setSize(10);
		motorCycleStack.setSize(3);

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
			if (ticketPane.getSizeList().getSelectionModel().getSelectedIndex() == 1) {
				if (parkCar() != null) {
					System.out.println("parked car");
					// alert car is parked
				} else {
					// alert car parking if full;
				}
			}
			if (ticketPane.getSizeList().getSelectionModel().getSelectedIndex() == 2) {
				// parkTruck();
			}
			if (ticketPane.getSizeList().getSelectionModel().getSelectedIndex() == 3) {

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

	private Car removeCar() {
		Car c1 = (Car) h1.find(exitParkingLotPane.getLicensePlateField().getText());
		if (c1 != null) {
			carStack.push(popedCar);
			return c1;
		}
		return null;
	}

	private ParkingSpot parkCar() {
		ParkingSpot p1 = carStack.pop();
		if (p1 != null) {
			h1.insert(createCar());
			return p1;
		}
		 popedCar = truckStack.pop();
		if (popedCar != null) {

			return popedCar;
		}
		return null;

	}

	private Car createCar() {
		Car c1 = new Car(ticketPane.getLicensePlateField().getText(), ticketPane.getColorField().getText());
		return c1;
	}

}
