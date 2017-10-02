package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ParkingLotView extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane parkingPane = new Pane();
		ExitParkingLotPane exitParkingLotPane = new ExitParkingLotPane();
		TicketPane ticketPane = new TicketPane();

		parkingPane.getMenuBar().prefWidthProperty().bind(primaryStage.widthProperty());

		parkingPane.getParkingMenu().setOnAction(e -> {

		});
		parkingPane.getBuyTicket().setOnAction(e -> {

		});
		parkingPane.getExit().setOnAction(e -> {
			System.exit(0);
		});

		Scene myScene = new Scene(parkingPane.getBorderPane(), 500, 500);
		primaryStage.setScene(myScene);
		primaryStage.show();

	}

}
