package Activity;

import java.util.Arrays;

public class ActivitySelectiontest {
    public static void main(String[] args) {
        // create an array of activities
        AcTivity[] activities = {
                new AcTivity(1, 3),
                new AcTivity(2, 5),
                new AcTivity(3, 4),
                new AcTivity(4, 7),
                new AcTivity(7, 10),
                new AcTivity(8, 9),
                new AcTivity(9, 11),
                new AcTivity(9, 13),
                new AcTivity(11, 12),
                new AcTivity(12, 14)
        };

        // create an instance of the ActivitySelection class
        ActivitySelection activitySelection = new ActivitySelection();

        // call the selectActivity method and print the result
        AcTivity[] result = activitySelection.selectActivity(activities);
        System.out.println(Arrays.toString(result));
    }
}
