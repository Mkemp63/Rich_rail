package GUI;

import javax.swing.SwingUtilities;

import Logic.Controller;

public class Main {
	public static void main(String[] args)	{
        SwingUtilities.invokeLater(() -> {
            Window win = new Window("Richrail");
            cont.addTrain("T1");
            cont.addWagon(2222, 30);
            cont.addWagon(2223, 29);
            cont.addWagon(2224, 31);

        });
	}
    private static Controller cont = Controller.getInstance();
}