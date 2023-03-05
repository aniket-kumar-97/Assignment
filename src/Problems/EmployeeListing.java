package Problems;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class EmployeeListing {

    public void parseFile() {
        Path curremtWorkingDirectoryPath = Paths.get("").toAbsolutePath();
        Path filePath = Paths.get(curremtWorkingDirectoryPath + "/employees.csv");

        FileWriter writerForManager = null;
        FileWriter writerForSingleNameEmployee = null;

        if(Files.exists(filePath)) {
            try(Stream<String> lines= Files.lines(filePath)) {

                writerForManager = new FileWriter("manager.csv");
                writerForManager.write(generateHeader());

                writerForSingleNameEmployee = new FileWriter("single_name_employees.csv");
                writerForSingleNameEmployee.write(generateHeader());

                List<List<String>> valuesFromFile = lines
                        .skip(1)
                        .map((line) -> Arrays.asList(line.split(",")))
                        .toList();

                List<String> valuesForManagers = valuesFromFile
                        .stream()
                        .map(this::filterData)
                        .filter(Objects::nonNull)
                        .toList();


                List<String> valuesForSingleNameEmployee = valuesFromFile
                        .stream()
                        .map(this::filterDataForSingleNameEmployee)
                        .filter(Objects::nonNull)
                        .toList();

                writerForManager.write(String.join("", valuesForManagers));
                writerForManager.close();

                writerForSingleNameEmployee.write(String.join("", valuesForSingleNameEmployee));
                writerForSingleNameEmployee.close();

            } catch (Exception e) {
                System.out.println("Error ::"+ Arrays.toString(e.getStackTrace()));
            }
        }
    }

    private String filterDataForSingleNameEmployee(List<String> row) {
        StringBuilder values = new StringBuilder();
        if(row.get(0).split(" ").length == 1) {
            values.append(row.get(0))
                    .append(",")
                    .append(row.get(1))
                    .append(",")
                    .append(row.get(2))
                    .append("\n");
        } else {
            return null;
        }

        return values.toString();
    }

    public String filterData(List<String> row) {
        StringBuilder sb = new StringBuilder();
        if (row.get(1).equalsIgnoreCase("manager") && row.get(2).equalsIgnoreCase("r&d")) {
            sb.append(row.get(0))
                    .append(",")
                    .append(row.get(1))
                    .append(",")
                    .append(row.get(2))
                    .append("\n");
        } else {
            return null;
        }
        return sb.toString();
    }

    public String generateHeader() {
        StringBuilder header = new StringBuilder();
        header.append("Name")
                .append(",")
                .append("Role")
                .append(",")
                .append("Division")
                .append("\n");
        return header.toString();
    }
    public static void main(String[] args) {
        EmployeeListing employeeListing = new EmployeeListing();
        employeeListing.parseFile();
    }
}
