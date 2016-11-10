/**
 * Created by zyongliu on 10/11/16.
 */
public interface withParkingCapability {
    <T> T get(Usage<T> usage);

    boolean park(Car car);
    boolean unpark(Car car);

    String print(String pre);

    interface Usage<T> {
        T get(int num, int capacity);
    }
}
