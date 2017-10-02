package view;

import java.util.Stack;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Car;
import model.Motercycle;
import model.Truck;

public class ParkingLotView extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane parkingPane = new Pane();
		ExitParkingLotPane exitParkingLotPane = new ExitParkingLotPane();
		TicketPane ticketPane = new TicketPane();

		Stack<Car> carStack = new Stack<Car>();
		Stack<Motercycle> moterCycleStack = new <Motercycle>Stack();
		Stack<Truck> truckStack = new Stack<Truck>();

		// truckStack.setSize();
		// carStack.setSize(10);
		// moterCycleStack.setSize(20);

		parkingPane.getMenuBar().prefWidthProperty().bind(primaryStage.widthProperty());

		parkingPane.getParkingMenu().setOnAction(e -> {
			parkingPane.getBorderPane().setCenter(exitParkingLotPane.getExitPane());

		});
		parkingPane.getBuyTicket().setOnAction(e -> {
			parkingPane.getBorderPane().setCenter(ticketPane.getTicketPane());
		});
		parkingPane.getExit().setOnAction(e -> {
			System.exit(0);
		});
		ticketPane.getBuyTicketBtn().setOnAction(e -> {

		});
		exitParkingLotPane.getConfirmBtn().setOnAction(e -> {

		});

		Scene myScene = new Scene(parkingPane.getBorderPane(), 500, 500);
		primaryStage.setScene(myScene);
		primaryStage.show();

	}

}
