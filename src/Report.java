import java.util.ArrayList;

/**
 * Created by zyongliu on 10/11/16.
 */
public class Report {
    private String pre;
    private String report;

    public Report(String pre) {
        this.pre = pre;
        this.report = "";
    }

    public Report() {
        this.pre = "";
        this.report = "";
    }

    public String printParkinglot(int num, int capacity) {
        report += pre + "Parkinglot:" + num + "/" + capacity + "\n";
        return report;
    }

    public String printParker(ArrayList<withParkingCapability> parkinglots) {
        report += pre + "Parker\n";
        pre += "  ";
        for (withParkingCapability w : parkinglots) {
            report += w.print(pre);
        }
        return report;
    }

    public String form() {
        System.out.print(report);
        return report;
    }
}
