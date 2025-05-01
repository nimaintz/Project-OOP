package Main;

import java.util.HashSet;
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
}
