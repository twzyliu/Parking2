import java.util.List;

/**
 * Created by zyongliu on 10/11/16.
 */
class DefaultSelector implements Selector {
    private List<withParkingCapability> parkinglots;

    public DefaultSelector(List<withParkingCapability> parkinglots) {
        this.parkinglots = parkinglots;
    }

    @Override
    public withParkingCapability getAvailable() {
        withParkingCapability parkinglot = parkinglots.get(0);
        for (withParkingCapability p : parkinglots) {
            if (p.get((n, c) -> (c - n)) > 0) {
                parkinglot = p;
            }
        }
        return parkinglot;
    }
}

