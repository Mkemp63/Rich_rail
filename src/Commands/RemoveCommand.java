package Commands;

import javax.swing.*;

public class RemoveCommand extends Command {

    @Override
    public void useCommand(String input) {
        System.out.println(input);
        try {
            String[] commands = input.split(" ");
            String term = commands[2];
            if (commands.length == 4 && term.equals("from")) {
                String train = commands[3];
                int wagonID = Integer.parseInt(commands[1]);
                cont.disconnectWagon(wagonID, train);
            } else {
                JOptionPane.showMessageDialog(null, "command not correct");
                System.out.println("Unknown command");
            }
        } catch (Exception e) {
            System.out.println("Unknown command");
        }
    }
}
