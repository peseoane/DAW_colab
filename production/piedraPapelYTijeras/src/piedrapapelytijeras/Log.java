package piedrapapelytijeras;

import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Log {
    public static void createLog() {
        try {
            File myObj = new File("stats.csv");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("Stats will be saved on a csv file..");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void registerLog(Player player, Npc npc) {

        String lineLog;

        lineLog = player.getName() + "," +  player.getLocalScore() + ","+ player.getGlobalScore() + "," + player.getAction() + ","
                + npc.getName() + "," +  npc.getLocalScore() + ","+ npc.getGlobalScore() + "," + npc.getAction() + "\n";

        try {
            Files.write(Paths.get("stats.csv"), lineLog.getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }
}
