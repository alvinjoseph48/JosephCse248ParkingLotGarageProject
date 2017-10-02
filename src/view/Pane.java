package view;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

public class Pane {
	private BorderPane borderPane;
	private Menu fileMenu;
	private Menu parkingMenu;
	private MenuBar menuBar;
	private MenuItem exit;
	private MenuItem buyTicket;
	private MenuItem exitLot;

	public Pane() {
		borderPane = new BorderPane();
		fileMenu = new Menu("File");
		parkingMenu = new Menu("Park/Exit Lot");
		menuBar = new MenuBar();
		exit = new MenuItem("Exit");
		buyTicket = new MenuItem("Purchase Ticket");
		exitLot = new MenuItem("Exit Lot");

		fileMenu.getItems().add(exit);
		parkingMenu.getItems().addAll(buyTicket, exitLot);
		borderPane.setTop(menuBar);
		menuBar.getMenus().addAll(fileMenu,parkingMenu);

	}

	public BorderPane getBorderPane() {
		return borderPane;
	}

	public void setBorderPane(BorderPane borderPane) {
		this.borderPane = borderPane;
	}

	public Menu getFileMenu() {
		return fileMenu;
	}

	public void setFileMenu(Menu fileMenu) {
		this.fileMenu = fileMenu;
	}

	public Menu getParkingMenu() {
		return parkingMenu;
	}

	public void setParkingMenu(Menu parkingMenu) {
		this.parkingMenu = parkingMenu;
	}

	public MenuBar getMenuBar() {
		return menuBar;
	}

	public void setMenuBar(MenuBar menuBar) {
		this.menuBar = menuBar;
	}

	public MenuItem getExit() {
		return exit;
	}

	public void setExit(MenuItem exit) {
		this.exit = exit;
	}

	public MenuItem getBuyTicket() {
		return buyTicket;
	}

	public void setBuyTicket(MenuItem buyTicket) {
		this.buyTicket = buyTicket;
	}

	public MenuItem getExitLot() {
		return exitLot;
	}

	public void setExitLot(MenuItem exitLot) {
		this.exitLot = exitLot;
	}

}
