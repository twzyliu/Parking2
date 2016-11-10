import java.util.List;

/**
 * Created by zyongliu on 10/11/16.
 */
public class MaxRetioSelector implements Selector {
    private List<Parkinglot> parkinglots;

    public MaxRetioSelector(List<Parkinglot> parkinglots) {
        this.parkinglots = parkinglots;
    }

    @Override
    public Parkinglot getAvailable() {
        Parkinglot parkinglot = parkinglots.get(0);
        for (Parkinglot p : parkinglots) {
            if ((double) p.get((n1, c1) -> (c1 - n1) / c1) > (double) parkinglot.get((n, c) -> (c - n) / c)) {
                parkinglot = p;
            }
        }
        return parkinglot;
    }
}
