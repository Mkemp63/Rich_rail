package GUI;

import Logic.Controller;

import javax.swing.*;

public class Main {
    private static Controller cont = Controller.getInstance();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Window win = new Window("Richrail");
                cont.addTrain("T1");
                cont.addWagon(2222, 30);
                cont.addWagon(2223, 29);
                cont.addWagon(2224, 31);

                win.setLocationRelativeTo(null);
                win.setVisible(true);
            }
        });
    }
}