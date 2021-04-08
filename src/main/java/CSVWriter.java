import abstracts.AbstractFunction;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class CSVWriter {
    public static void printToFile(AbstractFunction function, double start, double step, int numberOfValues, String file) throws IOException {
        String fileName = file + ".csv";
        File csvOutputFile = new File(fileName);
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            for (double i = 0; i < numberOfValues; i++) {
                double x = start + i * step;
                pw.write(x + ";" + function.calculate(x) + "\n");
            }
        }
    }
}
