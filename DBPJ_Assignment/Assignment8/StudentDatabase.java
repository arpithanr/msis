import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentDatabase {
    private List<Student> students;

    public StudentDatabase() {
        this.students = new ArrayList<>();
        loadDataFromFile("student_details.txt");
    }

    public Student searchByRegNum(String regNum) {
        for (Student student : students) {
            if (student.getRegNum().equals(regNum)) {
                return student;
            }
        }
        return null;
    }

    private void loadDataFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 4) {
                    String name = parts[0];
                    String regNum = parts[1];
                    String course = parts[2];
                    String gpa = parts[3];
                    students.add(new Student(name, regNum, course, gpa));
                } else {
                    System.err.println("Invalid data in the file: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading from the file: " + e.getMessage());
        }
    }
}
