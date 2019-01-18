package GUI;

import Domain.Train;
import Domain.Wagon;
import Logic.Controller;
import Persistency.DAO;
import Persistency.TreinDAO;
import Persistency.WagonDAO;

import javax.swing.*;



public class Main {
    private static Controller cont = Controller.getInstance();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            Window win = new Window("Richrail");
            cont.addTrain("T1");
            cont.addWagon(2222, 30);
            cont.addWagon(2223, 29);
            cont.addWagon(2224, 31);

            win.setLocationRelativeTo(null);
            win.setVisible(true);
        });
        Train t = new Train("T2");
        Wagon w = new Wagon(2,50);
        DAO<Wagon> wagonDAO = new WagonDAO();
        DAO<Train> trainDAO = new TreinDAO();
        wagonDAO.add(w);
        trainDAO.add(t);

    }
}