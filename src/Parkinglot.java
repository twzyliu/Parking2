import java.util.ArrayList;
import java.util.List;

/**
 * Created by zyongliu on 10/11/16.
 */
public class Parkinglot {
    private int capacity;
    private int num = 0;
    private List<Car> carList = new ArrayList<>();

    public Parkinglot(int capacity) {
        this.capacity = capacity;
    }

    public int getSpace() {
        return capacity - num;
    }

    public boolean park(Car car) {
        if (getSpace() > 0) {
            carList.add(car);
            num += 1;
            return true;
        }
        return false;
    }

    public boolean unpark(Car car) {
        if (carList.contains(car)) {
            carList.remove(car);
            num -= 1;
            return true;
        }
        return false;
    }
}
