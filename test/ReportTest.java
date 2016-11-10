import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by zyongliu on 10/11/16.
 */
public class ReportTest {

    public static final int CAPACITY = 10;
    private Car car;
    private Parkinglot parkinglot;

    @Before
    public void setUp() throws Exception {
        car = new Car(0);
        parkinglot = new Parkinglot(CAPACITY);
        parkinglot.park(car);
        parkinglot.park(car);
        parkinglot.park(car);
    }

    @Test
    public void should_print_parkinglot_when_parkinglot_has_cars() throws Exception {
        Report report = new Report();
        report.printParkinglot(parkinglot.get((n, c) -> n), parkinglot.get((n, c) -> c));
        assertThat(report.form(), is("Parkinglot:3/10\n"));
    }

    @Test
    public void should_print_space_before_parkinglot_when_parker_print() throws Exception {
        ArrayList<withParkingCapability> parkinglots = new ArrayList<>();
        parkinglots.add(parkinglot);
        Report report = new Report();
        report.printParker(parkinglots);
        assertThat(report.form(), is("Parker\n  Parkinglot:3/10\n"));
    }

    @Test
    public void should_print_space_before_parker_when_manager_print() throws Exception {
        ArrayList<withParkingCapability> parkinglots = new ArrayList<>();
        parkinglots.add(parkinglot);
        Parker parker = new Parker(parkinglots, new DefaultSelector(parkinglots));
        ArrayList<withParkingCapability> parkers = new ArrayList<>();
        parkers.add(parker);
        Report report = new Report();
        report.printParker(parkers);
        assertThat(report.form(), is("Parker\n  Parker\n    Parkinglot:3/10\n"));
    }
}
