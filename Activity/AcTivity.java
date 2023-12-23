package Activity;

import java.util.Arrays;

public class AcTivity {
    int start, finish;

    public AcTivity(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }

    @Override
    public String toString() {
        return "[" + start + "," + finish + "]";
    }
}

