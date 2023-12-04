import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class TestRecord extends JFrame
{
	private DBase db = null;

	private JLabel firstNameLabel;
    private JTextField firstNameField;
    private JLabel lastNameLabel;
    private JTextField lastNameField;
    private JLabel ageLabel;
    private JTextField ageField;
    private JLabel addressLabel;
    private JTextField addressField;
    private JButton previousButton;
    private JButton nextButton;

	TestRecord()
	{
		super("View Record");
		
		try{

		setLayout(new BorderLayout());

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(5, 2));

        firstNameLabel = new JLabel("First Name:");
        formPanel.add(firstNameLabel);
        firstNameField = new JTextField();
        formPanel.add(firstNameField);

        lastNameLabel = new JLabel("Last Name:");
        formPanel.add(lastNameLabel);
        lastNameField = new JTextField();
        formPanel.add(lastNameField);

        ageLabel = new JLabel("Age:");
        formPanel.add(ageLabel);
        ageField = new JTextField();
        formPanel.add(ageField);

        addressLabel = new JLabel("Address:");
        formPanel.add(addressLabel);
        addressField = new JTextField();
        formPanel.add(addressField);

        add(formPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        previousButton = new JButton("Previous");
     	previousButton.addActionListener(new ActionListener()
     		{
     			@Override
     			public void actionPerformed(ActionEvent e){
     				System.out.println("previous");
     				previousButtonClicked();
     			}
     		});
        buttonPanel.add(previousButton);

        nextButton = new JButton("Next");
       nextButton.addActionListener(new ActionListener()
     		{
     			@Override
     			public void actionPerformed(ActionEvent e){
     				System.out.println("next");
     				nextButtonClicked();
     			}
     		});;
        buttonPanel.add(nextButton);

        add(buttonPanel, BorderLayout.SOUTH);

 
        addWindowListener(new WindowAdapter(){
        	
        	@Override
        	public void windowClosing(WindowEvent e){
        		db.closeObject();
        	}
    	});

        pack();

		getRecord();

        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

		}catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public void getRecord()
	{
		db = new DBase();
		String driverName = "com.mysql.cj.jdbc.Driver";
		String databaseNmae = "jdbc:mysql://localhost:3306/login";

		if(db.loadDriver(driverName) == 1)
		{
			System.out.println("Successfully loaded Driver......");
		}

		if(db.createConnection(databaseNmae) == 1)
		{
			System.out.println("Successfully Database connected......");
		}

		if(db.getStatement() == 1)
		{
			System.out.println("Successfully created statement object......");
		}	

		String sql ="Select * from record;";
		try {
                db.retrieveRecord(sql);

                if (db.rs.next()) {
                    String firstName = db.rs.getString(1);
                    String lastName = db.rs.getString(2);
                    int age = db.rs.getInt(3);
                    String address = db.rs.getString(4);

                    firstNameField.setText(firstName);
                   	lastNameField.setText(lastName);
                    ageField.setText(String.valueOf(age));
                    addressField.setText(address);
               }
            } catch (Exception ex) {
                ex.printStackTrace();
                System.err.println("Error retrieving first record from database.");
            }
	}

	private void previousButtonClicked() {
		try{
			 if(db.rs.isFirst())
			{
				System.out.println("First record.......");
			}else
			{
				String firstName = db.rs.getString(1);
	            String lastName = db.rs.getString(2);
	            int age = db.rs.getInt(3);
	            String address = db.rs.getString(4);

				db.rs.previous();
				firstNameField.setText(firstName);
				lastNameField.setText(lastName);
				ageField.setText(String.valueOf(age));
				addressField.setText(address);
			}
	}catch(Exception e )
	{
		System.out.println("previous" + e);
	}

    }

    private void nextButtonClicked() {
    	try{
    		 if(db.rs.isLast())
		{
			System.out.println("Last record.......");
		}else
		{
			String firstName = db.rs.getString(1);
            String lastName = db.rs.getString(2);
            int age = db.rs.getInt(3);
            String address = db.rs.getString(4);

			db.rs.next();
			firstNameField.setText(firstName);
			lastNameField.setText(lastName);
			ageField.setText(String.valueOf(age));
			addressField.setText(address);
		}
    	}catch(Exception e){
    		System.out.println("next"+e);
    	}
       
    }

	public static void main(String[] args) {
		new TestRecord();
	}
}
