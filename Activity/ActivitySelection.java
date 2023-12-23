package Activity;

import java.util.Arrays;

public class ActivitySelection {
    public AcTivity[] selectActivity(AcTivity[] activities) {
        // sort activities by finish time
        Arrays.sort(activities, (a, b) -> a.finish - b.finish);

        // initialize the selected array and the index of the last selected activity
        AcTivity[] selected = new AcTivity[activities.length];
        int index = 0;

        // select the first activity
        selected[index] = activities[0];

        // iterate over the remaining activities
        for (int i = 1; i < activities.length; i++) {
            // if the start time of the current activity is greater than or equal to the finish time of the last selected activity
            if (activities[i].start >= selected[index].finish) {
                // select the current activity and update the index
                index++;
                selected[index] = activities[i];
            }
        }

        // return the selected activities up to the index
        return Arrays.copyOf(selected, index + 1);
    }
}
