package GUI;
//TODO:

import Commands.*;
import Domain.Train;
import Domain.Wagon;
import Logic.Controller;
import Logic.Observable;
import Logic.Observer;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;


public class Window extends javax.swing.JFrame implements Observer, ActionListener {
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel drawPanel;
    private JPanel pnlWagons;
    private JTextArea jTA1;
    private JTextArea jTA2;
    private JTextField jTF1;
    private JTextField tfCurrentTrain;
    private JTextField tfNewTrain;
    private JTextField tfCurrentWagon;
    private JTextField tfNewWagon;
    private JButton btnDeleteWagon3;
    private JButton btnDeleteWagon2;
    private JButton btnDeleteWagon1;
    private JButton jButton1;
    private JButton btnAddWagon2;
    private JButton btnAddWagon1;
    private JButton btnDeleteTrain;
    private JButton btnChooseTrain;
    private JButton btnNewWindow;
    private JButton btnExecute;
    private JButton btnNewTrain;
    private JButton btnOpenNewWindow;
    private JButton btnOtherWindow;
    private JButton btnNewWagon;
    private JButton btnDeleteWagon;
    private JButton btnChooseWagon;
    private JButton btnConnectWagon;
    private JButton btnDisconnectWagon;
    private JComboBox cbAllTrains;
    private JComboBox cbAllWagons;
    private HashMap numberOfWagons;
    private int currentNumberOfWagons;
    private int currentTrain = -1;
    private int currentWagon = -1;
    private int OFFSET = 100;
    private int TRAINLENGTH = 100;

    private ArrayList<String> logs = new ArrayList<>();
    private Controller cont = Controller.getInstance();
    private JTextField tfSeats;


    public Window(String name) {
        super();
        makeWindow();
    }

    public void makeWindow() {
        this.setController(cont);
        this.setTitle("Window");
        logs.addAll(cont.getLogs());
        initCLI();
    }

    private void initCLI() {
        try {
            this.setTitle("CLI");
            GridBagLayout thisLayout = new GridBagLayout();
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            thisLayout.rowWeights = new double[]{0.1, 0.1, 0.1, 0.1};
            thisLayout.rowHeights = new int[]{7, 7, 7, 7};
            thisLayout.columnWeights = new double[]{0.1, 0.1, 0.1, 0.1};
            thisLayout.columnWidths = new int[]{7, 7, 7, 7};
            getContentPane().setLayout(thisLayout);
            {
                jPanel1 = new JPanel();
                GridBagLayout gbl1 = new GridBagLayout();
                GridBagConstraints gbc = new GridBagConstraints();
                getContentPane().add(jPanel1, new GridBagConstraints(0, 0, 4, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
                jPanel1.setLayout(gbl1);
                {
                    jTA1 = new JTextArea();
                    jTA1.setPreferredSize(new Dimension(350, 400));
                    jTA1.setEditable(false);
                    jTA1.setText("halloooo");
                    jTA1.setForeground(Color.BLACK);
                    jTA1.setVisible(true);
                    jTA1.setLineWrap(true);
                    jTA1.setBackground(Color.WHITE);
                    jTA1.setSize(400, 200);
                    JScrollPane scrollpane = new JScrollPane(jTA1);
                    gbc.gridy = 0;
                    gbc.gridx = 0;
                    gbc.gridwidth = 2;
                    jPanel1.add(scrollpane, gbc);
                }
                {
                    jTA2 = new JTextArea();
                    jTA2.setForeground(Color.WHITE);
                    jTA2.setBackground(Color.BLACK);
                    jTA2.setEditable(false);
                    jTA2.setPreferredSize(new Dimension(350, 400));

                    StringBuilder s = new StringBuilder();
                    for (String string : logs) {
                        s.insert(0, string + "\n");
                    }

                    jTA2.setText(s.toString());
                    jTA2.setSize(400, 200);
                    jTA2.setVisible(true);
                    jTA2.setLineWrap(true);
                    JScrollPane scrollpane1 = new JScrollPane(jTA2);
                    gbc.gridy = 0;
                    gbc.gridx = 2;
                    jPanel1.add(scrollpane1, gbc);
                }
                {
                    jTF1 = new JTextField(20);
                    gbc.gridx = 1;
                    gbc.gridy = 2;
                    jTF1.setText("Commands");
                    jPanel1.add(jTF1, gbc);

                }
                {
                    btnExecute = new JButton();
                    gbc.gridy = 3;
                    gbc.gridx = 1;
                    jPanel1.add(btnExecute, gbc);
                    btnExecute.setText("Execute");
                    btnExecute.addActionListener(this);
                }
                {
                    btnNewWindow = new JButton();
                    gbc.gridy = 2;
                    gbc.gridx = 2;
                    jPanel1.add(btnNewWindow, gbc);
                    btnNewWindow.setText("Go to GUI");
                    btnNewWindow.addActionListener(this);
                }
            }
            pack();
            setSize(800, 600);
            numberOfWagons = new HashMap();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initGUI() {
        try {
            this.setTitle("RichRail");
            GridBagLayout thisLayout = new GridBagLayout();
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            thisLayout.rowWeights = new double[]{0.1, 0.1, 0.1, 0.1};
            thisLayout.rowHeights = new int[]{7, 7, 7, 7};
            thisLayout.columnWeights = new double[]{0.1, 0.1, 0.1, 0.1};
            thisLayout.columnWidths = new int[]{7, 7, 7, 7};
            getContentPane().setLayout(thisLayout);
            {
                GridBagConstraints c = new GridBagConstraints();
                jPanel1 = new JPanel();
                jPanel1.setLayout(new BorderLayout());
                getContentPane().add(jPanel1, new GridBagConstraints(0, 0, 4, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
                {
                    JTextArea taVisualOutput = new JTextArea();
                    taVisualOutput.setPreferredSize(new Dimension(350, 400));
                    taVisualOutput.setBackground(Color.BLACK);
                    taVisualOutput.setForeground(Color.WHITE);
                    taVisualOutput.setEditable(false);

                    // methode om de logs te laten zien in de textarea
                    StringBuilder s = new StringBuilder();
                    for (String string : logs) {
                        s.insert(0, string + "\n");
                    }

                    taVisualOutput.setText(s.toString());
                    taVisualOutput.setSize(400, 300);
                    taVisualOutput.setVisible(true);
                    taVisualOutput.setLineWrap(true);
                    c.gridy = 0;
                    c.gridx = 0;
                    c.gridwidth = 4;
                    c.gridheight = 2;
                    JScrollPane scrollpane1 = new JScrollPane(taVisualOutput);
                    jPanel1.add(scrollpane1, BorderLayout.CENTER);
                }
            }
            {
                GridBagConstraints gbc = new GridBagConstraints();
                jPanel2 = new JPanel();
                GridBagLayout jPanel2Layout = new GridBagLayout();
                //jPanel2.setLayout(null);
                jPanel2.setLayout(jPanel2Layout);
                // componenten aan panel toevoegen
                getContentPane().add(jPanel2, new GridBagConstraints(0, 1, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
                {
                    JTextPane tpTextTrain = new JTextPane();
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;
                    jPanel2.add(tpTextTrain, gbc);
                    jPanel2.setBounds(10, 10, 100, 15);
                    jPanel2Layout.rowWeights = new double[]{0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
                    jPanel2Layout.rowHeights = new int[]{7, 7, 7, 7, 7, 7, 7};
                    jPanel2Layout.columnWeights = new double[]{0.1, 0.1, 0.1, 0.1};
                    jPanel2Layout.columnWidths = new int[]{7, 7, 7, 7};
                    tpTextTrain.setText("Train name:");
                }
                {
                    tfNewTrain = new JTextField(20);
                    gbc.gridx = 1;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;
                    jPanel2.add(tfNewTrain, gbc);
                }
                {
                    btnNewTrain = new JButton();
                    gbc.gridx = 2;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;
                    jPanel2.add(btnNewTrain, gbc);
                    btnNewTrain.setText("Make new train");
                    btnNewTrain.addActionListener(this);
                }
                {
                    cbAllTrains = new JComboBox();
                    cbAllTrains.removeAllItems();
                    for (Train t : cont.trains) {
                        cbAllTrains.addItem(t.getName());
                    }
                    gbc.gridx = 1;
                    gbc.gridy = 1;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 2;
                    jPanel2.add(cbAllTrains, gbc);
                }
                {
                    btnChooseTrain = new JButton();
                    gbc.gridx = 2;
                    gbc.gridy = 1;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;
                    jPanel2.add(btnChooseTrain, gbc);
                    btnChooseTrain.setText("Select train");
                    btnChooseTrain.addActionListener(this);
                }
                {
                    btnDeleteTrain = new JButton();
                    gbc.gridx = 2;
                    gbc.gridy = 2;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;
                    jPanel2.add(btnDeleteTrain, gbc);
                    btnDeleteTrain.setText("Delete train");
                    btnDeleteTrain.addActionListener(this);
                }
                {
                    btnOtherWindow = new JButton();
                    gbc.gridx = 2;
                    gbc.gridy = 6;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;
                    jPanel2.add(btnOtherWindow, gbc);
                    btnOtherWindow.setText("Open CLI Window");
                    btnOtherWindow.addActionListener(this);
                }
                {
                    JTextPane tpTextWagon = new JTextPane();
                    gbc.gridx = 0;
                    gbc.gridy = 3;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;
                    jPanel2.add(tpTextWagon, gbc);
                    tpTextWagon.setText("Wagon name:");
                }
                {
                    tfNewWagon = new JTextField(20);
                    gbc.gridx = 1;
                    gbc.gridy = 3;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;
                    jPanel2.add(tfNewWagon, gbc);
                }
                {
                    btnNewWagon = new JButton();
                    gbc.gridx = 2;
                    gbc.gridy = 3;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;
                    jPanel2.add(btnNewWagon, gbc);
                    btnNewWagon.setText("Make new wagon");
                    btnNewWagon.addActionListener(this);
                }
                {
                    cbAllWagons = new JComboBox();
                    cbAllWagons.removeAllItems();
                    for (Wagon w : cont.wagons) {
                        cbAllWagons.addItem(w.getID());
                    }
                    gbc.gridx = 1;
                    gbc.gridy = 4;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 3;
                    jPanel2.add(cbAllWagons, gbc);
                }
                {
                    btnChooseWagon = new JButton();
                    gbc.gridx = 2;
                    gbc.gridy = 4;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;
                    jPanel2.add(btnChooseWagon, gbc);
                    btnChooseWagon.setText("Select wagon");
                    btnChooseWagon.addActionListener(this);
                }
                {
                    btnDeleteWagon = new JButton();
                    gbc.gridx = 2;
                    gbc.gridy = 5;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;
                    jPanel2.add(btnDeleteWagon, gbc);
                    btnDeleteWagon.setText("Delete wagon");
                    btnDeleteWagon.addActionListener(this);
                }
                {
                    JTextPane tpSeats = new JTextPane();
                    gbc.gridx = 0;
                    gbc.gridy = 7;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;
                    jPanel2.add(tpSeats, gbc);
                    tpSeats.setText("Give seats:");
                }
                {
                    tfSeats = new JTextField(20);
                    gbc.gridx = 1;
                    gbc.gridy = 7;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;
                    jPanel2.add(tfSeats, gbc);
                }
            }
            {
                GridBagConstraints gbc = new GridBagConstraints();
                pnlWagons = new JPanel();
                GridBagLayout jPanel3Layout = new GridBagLayout();
                getContentPane().add(pnlWagons, new GridBagConstraints(1, 2, 1, 3, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
                jPanel3Layout.rowWeights = new double[]{0.1, 0.1, 0.1, 0.1};
                jPanel3Layout.rowHeights = new int[]{7, 7, 7, 7};
                jPanel3Layout.columnWeights = new double[]{0.1, 0.1, 0.1, 0.1};
                jPanel3Layout.columnWidths = new int[]{7, 7, 7, 7};
                pnlWagons.setLayout(jPanel3Layout);
                // hier worden weer de componenten toegevoegd aan het panel
                pnlWagons.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
                {
                    tfCurrentTrain = new JTextField(20);
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;
                    pnlWagons.add(tfCurrentTrain, gbc);
                    tfCurrentTrain.setText("Selected: ");
                }
                {
                    tfCurrentWagon = new JTextField(20);
                    gbc.gridx = 0;
                    gbc.gridy = 1;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;
                    pnlWagons.add(tfCurrentWagon, gbc);
                    tfCurrentWagon.setText("Selected: ");
                }
                {
                    btnConnectWagon = new JButton();
                    gbc.gridx = 0;
                    gbc.gridy = 3;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;
                    pnlWagons.add(btnConnectWagon, gbc);
                    btnConnectWagon.setText("Link selected wagon to selected train");
                    btnConnectWagon.addActionListener(this);
                }
                {
                    btnDisconnectWagon = new JButton();
                    gbc.gridx = 0;
                    gbc.gridy = 4;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;
                    pnlWagons.add(btnDisconnectWagon, gbc);
                    btnDisconnectWagon.setText("Unlink selected wagon to selected train");
                    btnDisconnectWagon.addActionListener(this);
                }
            }
            pack();
            setSize(800, 600);
            numberOfWagons = new HashMap();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setController(Controller controller) {
        this.cont = controller;
        controller.addObserver(this);
    }

    @Override
    public void update(Observable subject) {
        String overviewString = "";

        //Overview Area train update:
        jTA1.setText(overviewString);
        jTA1.setText(jTA1.getText() + "Trains: \n");
        for (Train tr : cont.trains) {
            overviewString = overviewString + "(" + tr.getName() + ")";
            for (Wagon w : tr.getWagons()) {
                overviewString = overviewString + "-(" + w.getID() + ")";
            }
            overviewString = overviewString + "\n";
        }
        jTA1.setText(jTA1.getText() + overviewString);

        overviewString = "";
        //Overview Area wagon update:
        jTA1.setText(jTA1.getText() + "Wagons: \n");
        for (Wagon w : cont.wagons) {
            overviewString = overviewString + "(" + w.getID() + ")";
        }
        jTA1.setText(jTA1.getText() + overviewString);
        overviewString = "";


        //Log update:
        for (String log : cont.getLogs()) {
            if (!logs.contains(log)) {
                logs.add(log);
            }
        }
        String s = "";
        for (String log : logs) {
            s = s + log + "\n";
        }
        jTA2.setText(s);
    }

    // hier worden alle button acties genomen en krijgen ze er een actie aan gehangen
    // die wordt uitgevoerd als op de button geklikt wordt
    @Override
    public void actionPerformed(ActionEvent event) {
        Command cmdAdd = new AddCommand();
        Command cmdDelete = new DeleteCommand();
        Command cmdRemove = new RemoveCommand();
        Command cmdNew = new NewCommand();
        Command cmdGet = new GetCommand();
        String firstWord;

        if (event.getSource() == btnExecute) {
            String inputCommand = jTF1.getText();
            if (inputCommand != null && inputCommand.length() > 0 && inputCommand.charAt(inputCommand.length() - 1) == ';') {
                inputCommand = inputCommand.substring(0, inputCommand.length() - 1);
                String[] commands = inputCommand.split(" ");
                firstWord = commands[0];
                switch (firstWord) {
                    case "new":
                        cmdNew.useCommand(inputCommand);
                        break;
                    case "add":
                        cmdAdd.useCommand(inputCommand);
                        break;
                    case "delete":
                        cmdDelete.useCommand(inputCommand);
                        break;
                    case "getnumseats":
                        cmdGet.useCommand(inputCommand);
                        break;
                    case "remove":
                        cmdRemove.useCommand(inputCommand);

                        jTF1.setText("");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "command not not recognized");
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "command not recognized");
                System.out.println("Command not recognized");
            }
            jTF1.setText("");
        } else if (event.getSource() == btnNewWindow) {
            getContentPane().remove(jPanel1);
            initGUI();
        } else if (event.getSource() == btnOtherWindow) {
            getContentPane().remove(jPanel1);
            getContentPane().remove(jPanel2);
            getContentPane().remove(pnlWagons);
            initCLI();
        } else if (event.getSource() == btnNewTrain) {
            String train = tfNewTrain.getText();
            if (train != null && train.trim().length() > 0) {
                if (!cont.trainExists(train)) {
                    cont.addTrain(train);
                    currentTrain = cbAllTrains.getSelectedIndex();
                    cbAllTrains.removeAllItems();
                    for (Train t : cont.trains) {
                        cbAllTrains.addItem(t.getName());
                    }
                }
            }
        } else if (event.getSource() == btnChooseTrain) {
            if (cbAllTrains.getItemCount() > 0) {
                String selection = (String) cbAllTrains.getSelectedItem();
                tfCurrentTrain.setText("Selected: " + selection);
                int ti = cbAllTrains.getSelectedIndex();
                if (ti != currentTrain) {
                    numberOfWagons.put(currentTrain, currentNumberOfWagons);
                }
                currentTrain = ti;
                try {
                    currentNumberOfWagons = (Integer) numberOfWagons.get(currentTrain);
                } catch (Exception e) {
                    currentNumberOfWagons = 0;
                }
            }
        } else if (event.getSource() == btnDeleteTrain) {
            if (cbAllTrains.getItemCount() > 0) {
                String t = (String) cbAllTrains.getSelectedItem();
                cbAllTrains.removeItemAt(cbAllTrains.getSelectedIndex());
                numberOfWagons.remove(t);
                cont.deleteTrain(t);
                cbAllTrains.removeAllItems();
                for (Train train : cont.trains) {
                    cbAllTrains.addItem(train.getName());
                }
                repaint();
                if (cbAllTrains.getSelectedItem() != null) {
                    currentTrain = cbAllTrains.getSelectedIndex();
                    tfCurrentTrain.setText("selected: " + (String) cbAllTrains.getSelectedItem());
                } else {
                    currentTrain = 0;
                    tfCurrentTrain.setText("Selected: ");
                }
            }
        } else if (event.getSource() == btnNewWagon) {
            int wagon = Integer.parseInt(tfNewWagon.getText());
            int seats = Integer.parseInt(tfSeats.getText());
            if (wagon > 0 && seats > 0) {
                if (!cont.wagonExists(wagon)) {
                    cont.addWagon(wagon, seats);
                    currentTrain = cbAllWagons.getSelectedIndex();
                    cbAllWagons.removeAllItems();
                    for (Wagon w : cont.wagons) {
                        cbAllWagons.addItem(w.getID());
                    }
                }
            }
        } else if (event.getSource() == btnChooseWagon) {
            if (cbAllWagons.getItemCount() > 0) {
                int selection = (int) cbAllWagons.getSelectedItem();
                tfCurrentWagon.setText("Selected: " + selection);
                int index = cont.getIByID(selection);
                currentWagon = index;
                System.out.println("Selected wagon has id: " + index);
            }
        } else if (event.getSource() == btnDeleteWagon) {
            if (cbAllWagons.getItemCount() > 0) {
                int w = (int) cbAllWagons.getSelectedItem();
                cbAllWagons.removeItemAt(cbAllWagons.getSelectedIndex());
                numberOfWagons.remove(w);
                cont.deleteWagon(w);
                cbAllWagons.removeAllItems();
                for (Wagon wagon : cont.wagons) {
                    cbAllTrains.addItem(wagon.getID());
                    currentWagon = 0;
                    tfCurrentWagon.setText("Selected: ");
                }
            }
        } else if (event.getSource() == btnConnectWagon) {
            String selection = (String) cbAllTrains.getSelectedItem();
            cont.connectWagon(currentWagon, selection);
        } else if (event.getSource() == btnDisconnectWagon) {
            String selection = (String) cbAllTrains.getSelectedItem();
            cont.disconnectWagon(currentWagon, selection);
        }
    }
}