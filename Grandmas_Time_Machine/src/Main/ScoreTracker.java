package Main;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ScoreTracker {

    private Set<String> clickedActions;

    public ScoreTracker() {
        this.clickedActions = new HashSet<>();
    }

    // Call this whenever a button is clicked
    public void registerClick(String actionCommand) {
        clickedActions.add(actionCommand);
    }

    // Get the current count of unique buttons clicked
    public int getNrOfButtonsClicked() {
        return clickedActions.size();
    }

    // Optional: check if a button was already clicked
    public boolean wasAlreadyClicked(String actionCommand) {
        return clickedActions.contains(actionCommand);
    }

    public void resetProgress() {
        clickedActions.clear();
    }



    public void saveProgressToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("buttonsClicked=" + getNrOfButtonsClicked());
            writer.newLine();
            for (String button : clickedActions) {
                writer.write(button);
                writer.newLine();
            }
            System.out.println("Progress saved to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadProgressFromFile(String filename) {
        clickedActions.clear();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.startsWith("buttonsClicked=")) {
                    // skip, we’ll recalculate from set size
                    continue;
                }
                if (!line.isEmpty()) {
                    clickedActions.add(line);
                }
            }
            System.out.println("Progress loaded from " + filename);
        } catch (FileNotFoundException e) {
            System.out.println("Save file not found. Starting fresh.");
        }
    }


}
