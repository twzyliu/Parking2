import java.util.ArrayList;

/**
 * Created by zyongliu on 10/11/16.
 */
public class Parker {
    private ArrayList<Parkinglot> parkinglots;

    public Parker(ArrayList<Parkinglot> parkinglots) {
        this.parkinglots = parkinglots;
    }

    public boolean park(Car car) {
        boolean canPark = false;
        for (Parkinglot parkinglot : parkinglots) {
            canPark |= parkinglot.getSpace() > 0;
        }
        return canPark;
    }

    public boolean unpark(Car car) {
        boolean canUnpark = false;
        for (Parkinglot parkinglot : parkinglots) {
            canUnpark |= parkinglot.unpark(car);
        }
        return canUnpark;
    }
}
