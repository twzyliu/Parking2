import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by zyongliu on 10/11/16.
 */
public class ParkinglotTest {

    private static final int CAPACITY = 1;
    private Car car;

    @Before
    public void setUp() throws Exception {
        car = new Car(0);
    }

    @Test
    public void can_park_when_parkinglot_has_space() throws Exception {
        Parkinglot parkinglot = new Parkinglot(CAPACITY);
        assertThat(parkinglot.park(car), is(true));
    }

    @Test
    public void cannot_park_when_parkinglot_hasnot_space() throws Exception {
        Parkinglot parkinglot = new Parkinglot(CAPACITY);
        parkinglot.park(car);
        assertThat(parkinglot.get((n, c) -> (c - n)), is(0));
        assertThat(parkinglot.park(car), is(false));
    }

    @Test
    public void can_unpark_when_car_is_in_the_parkinglot() throws Exception {
        Parkinglot parkinglot = new Parkinglot(CAPACITY);
        parkinglot.park(car);
        assertThat(parkinglot.unpark(car), is(true));
    }

    @Test
    public void cannot_unpark_when_car_isnot_in_the_parkinglot() throws Exception {
        Parkinglot parkinglot = new Parkinglot(CAPACITY);
        assertThat(parkinglot.unpark(car), is(false));
    }
}
