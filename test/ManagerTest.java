import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by zyongliu on 10/11/16.
 */
public class ManagerTest {
    private static final int CAPACITY = 1;
    private Parker fullParker;
    private Car car;

    @Before
    public void setUp() throws Exception {
        car = new Car(0);
        Parkinglot parkinglot = new Parkinglot(CAPACITY);
        parkinglot.park(car);
        ArrayList<Parkinglot> parkinglots = new ArrayList<>();
        parkinglots.add(parkinglot);
        parkinglots.add(parkinglot);
        fullParker = new Parker(parkinglots,new DefaultSelector(parkinglots));
    }
    @Test
    public void cannot_park_when_parkers_havenot_free_parkinglot() throws Exception {
        ArrayList<Parker> pakers = new ArrayList<>();
        pakers.add(fullParker);
        pakers.add(fullParker);
        Manager manager = new Manager(pakers);
        assertThat(manager.park(car), is(false));
    }

    @Test
    public void can_park_when_parkers_have_free_parkinglot() throws Exception {
        Parkinglot parkinglot = new Parkinglot(CAPACITY);
        ArrayList<Parkinglot> parkinglots = new ArrayList<>();
        parkinglots.add(parkinglot);
        parkinglots.add(parkinglot);
        Parker parker = new Parker(parkinglots, new DefaultSelector(parkinglots));
        ArrayList<Parker> pakers = new ArrayList<>();
        pakers.add(fullParker);
        pakers.add(parker);
        Manager manager = new Manager(pakers);
        assertThat(manager.park(car), is(true));
    }

    @Test
    public void can_unpark_when_car_park_in_parkinglots() throws Exception {
        Parkinglot parkinglot = new Parkinglot(CAPACITY);
        ArrayList<Parkinglot> parkinglots = new ArrayList<>();
        parkinglots.add(parkinglot);
        Parker parker = new Parker(parkinglots, new DefaultSelector(parkinglots));
        ArrayList<Parker> pakers = new ArrayList<>();
        pakers.add(parker);
        Manager manager = new Manager(pakers);
        manager.park(car);
        assertThat(manager.unpark(car), is(true));
    }

    @Test
    public void cannot_unpark_when_car_donnot_park_in_parkinglots() throws Exception {
        Parkinglot parkinglot = new Parkinglot(CAPACITY);
        ArrayList<Parkinglot> parkinglots = new ArrayList<>();
        parkinglots.add(parkinglot);
        Parker parker = new Parker(parkinglots, new DefaultSelector(parkinglots));
        ArrayList<Parker> pakers = new ArrayList<>();
        pakers.add(parker);
        Manager manager = new Manager(pakers);
        assertThat(manager.unpark(car), is(false));
    }
}
