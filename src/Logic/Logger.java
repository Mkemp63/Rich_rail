package Logic;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Logger implements Observer {
    private ArrayList<String> logs = new ArrayList<String>();
    private static Logger instance;
    private Controller cont = Controller.getInstance();
    private static final String LOG_FILE = System.getProperty("user.dir") + "/Richklog.log.txt";

    public Logger() {
        cont.addObserver(this);
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    @Override
    public void update(Observable O) {
        for (String log : cont.getLogs()) {
            if (!logs.contains(log)) {
                logs.add(log);
            }
        }
        String s = logs.get(logs.size() - 1);

        Write(s);
    }

    public void Write(String input) {
        BufferedWriter wr = null;
        System.out.println("log succesful");

        try {
            wr = new BufferedWriter(new FileWriter(LOG_FILE, true));
            wr.append(input);
            wr.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (wr != null) {
                    wr.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


}
