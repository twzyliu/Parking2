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

    public interface Usage<T> {
        T get(int num, int capacity);
    }

    public <T> T get(Usage<T> usage) {
        return usage.get(num, capacity);
    }

    public boolean park(Car car) {
        if (get((n, c) -> (c - n)) > 0) {
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
