import java.util.List;

/**
 * Created by zyongliu on 10/11/16.
 */
class MaxSpaceSelector implements Selector {
    private List<Parkinglot> parkinglots;

    public MaxSpaceSelector(List<Parkinglot> parkinglots) {
        this.parkinglots = parkinglots;
    }

    @Override
    public Parkinglot getAvailable() {
        Parkinglot parkinglot = parkinglots.get(0);
        for (Parkinglot p : parkinglots) {
            if (p.getSpace() > parkinglot.getSpace()) {
                parkinglot = p;
            }
        }
        return parkinglot;
    }
}
