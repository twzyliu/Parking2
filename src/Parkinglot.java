import java.util.ArrayList;
import java.util.List;

/**
 * Created by zyongliu on 10/11/16.
 */
public class Parkinglot implements withParkingCapability {
    private int capacity;
    private int num = 0;
    private List<Car> carList = new ArrayList<>();

    public Parkinglot(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public <T> T get(Usage<T> usage) {
        return usage.get(num, capacity);
    }

    @Override
    public boolean park(Car car) {
        if (get((n, c) -> (c - n)) > 0) {
            carList.add(car);
            num += 1;
            return true;
        }
        return false;
    }

    @Override
    public boolean unpark(Car car) {
        if (carList.contains(car)) {
            carList.remove(car);
            num -= 1;
            return true;
        }
        return false;
    }

    @Override
    public String print(String pre) {
        return new Report(pre).printParkinglot(num, capacity);
    }

}
