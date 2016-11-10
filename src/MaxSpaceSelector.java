import java.util.List;

/**
 * Created by zyongliu on 10/11/16.
 */
class MaxSpaceSelector implements Selector {
    private List<withParkingCapability> parkinglots;

    public MaxSpaceSelector(List<withParkingCapability> parkinglots) {
        this.parkinglots = parkinglots;
    }

    @Override
    public withParkingCapability getAvailable() {
        withParkingCapability parkinglot = parkinglots.get(0);
        for (withParkingCapability p : parkinglots) {
            if ((int) p.get((n1, c1) -> (c1 - n1)) > parkinglot.get((n, c) -> (c - n))) {
                parkinglot = p;
            }
        }
        return parkinglot;
    }
}
