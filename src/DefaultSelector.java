import java.util.List;

/**
 * Created by zyongliu on 10/11/16.
 */
class DefaultSelector implements Selector {
    private List<Parkinglot> parkinglots;

    public DefaultSelector(List<Parkinglot> parkinglots) {
        this.parkinglots = parkinglots;
    }

    @Override
    public Parkinglot getAvailable() {
        Parkinglot parkinglot = parkinglots.get(0);
        for (Parkinglot p : parkinglots) {
            if (p.get((n, c) -> (c - n)) > 0) {
                parkinglot = p;
            }
        }
        return parkinglot;
    }
}

