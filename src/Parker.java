import java.util.ArrayList;

/**
 * Created by zyongliu on 10/11/16.
 */
public class Parker implements withParkingCapability{
    private ArrayList<withParkingCapability> parkinglots;
    private Selector selector;

    public Parker(ArrayList<withParkingCapability> parkinglots, Selector selector) {
        this.parkinglots = parkinglots;
        this.selector = selector;
    }

    @Override
    public <T> T get(Usage<T> usage) {
        return usage.get(0, getAvailable().get((n, c) -> (c - n)));
    }

    public boolean park(Car car) {
        return getAvailable().park(car);
    }


    public withParkingCapability getAvailable() {
        return selector.getAvailable();
    }

    public boolean unpark(Car car) {
        boolean canUnpark = false;
        for (withParkingCapability parkinglot : parkinglots) {
            canUnpark |= parkinglot.unpark(car);
        }
        return canUnpark;
    }
}
