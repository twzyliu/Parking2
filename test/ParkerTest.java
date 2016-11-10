import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Created by zyongliu on 10/11/16.
 */
public class ParkerTest {

    private static final int CAPACITY = 1;
    private Parkinglot fullParkinglot;
    private Car car;

    @Before
    public void setUp() throws Exception {
        car = new Car(0);
        fullParkinglot = new Parkinglot(CAPACITY);
        fullParkinglot.park(car);
    }

    @Test
    public void cannot_park_when_parkinglots_are_full() throws Exception {
        ArrayList<Parkinglot> parkinglots = new ArrayList<>();
        parkinglots.add(fullParkinglot);
        parkinglots.add(fullParkinglot);
        Parker parker = new Parker(parkinglots, new DefaultSelector(parkinglots));
        assertThat(parker.park(car), is(false));
    }

    @Test
    public void can_park_when_parkinglots_has_space() throws Exception {
        Parkinglot parkinglot = new Parkinglot(CAPACITY);
        ArrayList<Parkinglot> parkinglots = new ArrayList<>();
        parkinglots.add(fullParkinglot);
        parkinglots.add(parkinglot);
        Parker parker = new Parker(parkinglots, new DefaultSelector(parkinglots));
        assertThat(parker.park(car), is(true));
    }

    @Test
    public void can_unpark_when_car_park_in_parkinglots() throws Exception {
        Parkinglot parkinglot = new Parkinglot(CAPACITY);
        ArrayList<Parkinglot> parkinglots = new ArrayList<>();
        parkinglots.add(fullParkinglot);
        parkinglots.add(parkinglot);
        Parker parker = new Parker(parkinglots, new DefaultSelector(parkinglots));
        parker.park(car);
        assertThat(parker.unpark(car), is(true));
    }

    @Test
    public void cannot_unpark_when_car_donnot_park_in_parkinglots() throws Exception {
        Parkinglot parkinglot = new Parkinglot(CAPACITY);
        ArrayList<Parkinglot> parkinglots = new ArrayList<>();
        parkinglots.add(parkinglot);
        parkinglots.add(parkinglot);
        Parker parker = new Parker(parkinglots, new DefaultSelector(parkinglots));
        assertThat(parker.unpark(car), is(false));
    }

    @Test
    public void can_find_maxspace_parkinglot_and_park_when_parkinglots_has_space() throws Exception {
        Parkinglot parkinglot1 = new Parkinglot(CAPACITY + 1);
        Parkinglot parkinglot2 = new Parkinglot(CAPACITY);
        ArrayList<Parkinglot> parkinglots = new ArrayList<>();
        parkinglots.add(fullParkinglot);
        parkinglots.add(parkinglot1);
        parkinglots.add(parkinglot2);
        Parker parker = new Parker(parkinglots, new MaxSpaceSelector(parkinglots));
        assertThat(parker.getAvailable(), is(parkinglot1));
        assertThat(parker.park(car), is(true));
    }
}
