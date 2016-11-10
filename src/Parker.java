import java.util.ArrayList;

/**
 * Created by zyongliu on 10/11/16.
 */
public class Parker {
    private ArrayList<Parkinglot> parkinglots;
    private Selector selector;

    public Parker(ArrayList<Parkinglot> parkinglots, Selector selector) {
        this.parkinglots = parkinglots;
        this.selector = selector;
    }

    public boolean park(Car car) {
        return getAvailable().park(car);
    }


    public Parkinglot getAvailable() {
        return selector.getAvailable();
    }

    public boolean unpark(Car car) {
        boolean canUnpark = false;
        for (Parkinglot parkinglot : parkinglots) {
            canUnpark |= parkinglot.unpark(car);
        }
        return canUnpark;
    }
}
