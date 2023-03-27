import java.io.IOException;
import java.util.List;

public class LoaderExample {
    public String filePath = "uploads.csv";

    public static void main(String[] args) {
        String filePath = "uploads.csv";
        FootagesAndReportersLoader loader = new FootagesAndReportersLoader();
        try {
            System.out.println("loading from "+ filePath);
            List<FootageAndReporter> footagesAndReporters = loader.loadFootagesAndReporters(filePath);
            for(FootageAndReporter footageAndReporter : footagesAndReporters) {
                System.out.print("\tFootage: " + footageAndReporter.getFootage());
                System.out.println("\tReporter: " + footageAndReporter.getReporter());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


