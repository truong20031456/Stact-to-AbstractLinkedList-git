class Event {
    String title;
    // other event details...
}

class Main1 {
    public static void main(String[] args) {
        int MAX_ITEMS = 5;
        Event[] schedule = new Event[MAX_ITEMS]; // Array to store events

        // Adding events
        schedule[0] = new Event();
        schedule[0].title = "Meeting at 10 AM";

        schedule[1] = new Event();
        schedule[1].title = "Lunch Break at 12 PM";

        schedule[4] = new Event();
        schedule[4].title = "Gym Session at 4 PM";

        // Accessing an event
        Event meeting = schedule[0];

        // Updating an event
        schedule[1].title = "Lunch at 12:30 PM";

        // Deleting an event (making the slot available)
        schedule[4] = null; // Removing the gym session

        // Finding free slots (finding empty slots in the array)
        for (Event event : schedule) {
            if (event == null) {
                // Slot is available for scheduling
            }
        }
    }
}
