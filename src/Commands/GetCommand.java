package Commands;

import javax.swing.*;

public class GetCommand extends Command {

    @Override
    public void useCommand(String input) {
        System.out.println(input);
        try {
            String[] commands = input.split(" ");
            String type = commands[1];
            if (type.equals("train") && commands.length == 3) {
                String name = commands[2];
                cont.getSeats(name);

            } else if (type.equals("wagon") && commands.length == 3) {
                int idWagon = Integer.parseInt(commands[2]);
                cont.getWagonSeats(idWagon);
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
