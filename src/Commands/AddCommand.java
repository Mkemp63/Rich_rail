package Commands;

import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;

public class AddCommand extends Command {

    @Override
    public void useCommand(String input) {

        System.out.println(input);
        try {
            String[] commands = input.split(" ");
            String word = commands[2];
            if (commands.length == 4 && word.equals("to")) {
                String train = commands[3];
                int wagonID = Integer.parseInt(commands[1]);
                cont.connectWagon(wagonID, train);
            } else {
                JOptionPane.showMessageDialog(null, "command not recognized");
                System.out.println("command not recognized");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "command not recognized");
            System.out.println("command not recognized");
        }
    }
}
