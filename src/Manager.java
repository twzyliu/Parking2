import java.util.ArrayList;

/**
 * Created by zyongliu on 10/11/16.
 */
public class Manager {
    private ArrayList<Parker> parks;

    public Manager(ArrayList<Parker> pakers) {
        this.parks = pakers;
    }

    public boolean park(Car car) {
        boolean canPark = false;
        for (Parker p : parks) {
            canPark |= p.park(car);
        }
        return canPark;
    }

    public boolean unpark(Car car) {
        boolean canPark = false;
        for (Parker p : parks) {
            canPark |= p.unpark(car);
        }
        return canPark;
    }
}
