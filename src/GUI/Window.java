package GUI;

import Commands.*;
import Domain.*;
import Logic.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Window extends javax.swing.JFrame implements Observer, ActionListener {
		//TODO: uitzoeken hoe dit ookalweer werkt
    public Window(String name){
        super();
        makeWindow();
    }
    public void makeWindow(){

    }

    @Override
    public void update(Observable o) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
