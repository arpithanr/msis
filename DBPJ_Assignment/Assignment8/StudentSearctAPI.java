import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentSearchAppUI extends JFrame {
    private JTextField regNumField;
    private JLabel nameLabel, regNumLabel, courseLabel,gpaLabel;

    private StudentDatabase studentDatabase;

    public StudentSearchAppUI() {
        super("Student Search Application");

        studentDatabase = new StudentDatabase();

        regNumField = new JTextField(10);

        nameLabel = new JLabel("Name:");
        regNumLabel = new JLabel("Reg No:");
        courseLabel = new JLabel("Course:");
        gpaLabel = new JLabel("GPA:");

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchButtonClicked();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 6));

        panel.add(new JLabel()); 
        panel.add(new JLabel()); 
        panel.add(new JLabel()); 
        panel.add(new JLabel()); 
        panel.add(new JLabel()); 

        panel.add(new JLabel()); 
        panel.add(new JLabel("Reg. No:"));
        panel.add(regNumField);
        panel.add(searchButton);
        panel.add(new JLabel()); 

        panel.add(new JLabel()); 
        panel.add(new JLabel()); 
        panel.add(nameLabel);
        panel.add(new JLabel());
        panel.add(new JLabel()); 

        panel.add(new JLabel()); 
        panel.add(new JLabel()); 
        panel.add(regNumLabel);
        panel.add(new JLabel()); 
        panel.add(new JLabel()); 

        panel.add(new JLabel()); 
        panel.add(new JLabel()); 
        panel.add(courseLabel);
        panel.add(new JLabel()); 
        panel.add(new JLabel()); 

        panel.add(new JLabel()); 
        panel.add(new JLabel()); 
        panel.add(gpaLabel);
        panel.add(new JLabel()); 
        panel.add(new JLabel()); 


        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(panel, BorderLayout.NORTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void searchButtonClicked() {
        String regNum = regNumField.getText();
        Student foundStudent = studentDatabase.searchByRegNum(regNum);

        if (foundStudent != null) {
            nameLabel.setText("Name: " + foundStudent.getName());
            regNumLabel.setText("Reg. No.: " + foundStudent.getRegNum());
            courseLabel.setText("Course: " + foundStudent.getCourse());
            gpaLabel.setText("Course: " + foundStudent.getGpa());
        }else{
            nameLabel.setText("Not Found");
            regNumLabel.setText("");
            courseLabel.setText("");
            gpaLabel.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StudentSearchAppUI();
            }
        });
    }
}
