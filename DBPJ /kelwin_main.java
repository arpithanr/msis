import java.util.*;

public class DCS {
    Scanner sc = new Scanner(System.in);

    int getMedHistoryID(boolean diabetes, boolean deppression, boolean Migrane, boolean hyper) {

        int id = 0;
        if (diabetes) {
            id += 8;
        }

        if (deppression) {
            id += 4;
        }

        if (Migrane) {
            id += 2;
        }

        if (hyper) {
            id += 1;
        }
        return id;
    }

    int getAllergyID(boolean drug, boolean food, boolean insect, boolean dust) {
        int id = 0;
        if (drug) {
            id += 8;
        }

        if (food) {
            id += 4;
        }

        if (insect) {
            id += 2;
        }

        if (dust) {
            id += 1;
        }
        return id;
    }

    void runDCS() {
        int choice = 0;
        DBase db = new DBase();
        db.loadDriver();
        db.getConnection();
        db.getStatement();
        do {
            System.out.println("Select the required operation");
            System.out.println("1. Register Patient");
            System.out.println("2. Display all Patient");
            System.out.println("3. Search Patient details by patient ID");
            System.out.println("to close Press any other key");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    // Register Patient

                    System.out.println("Enter Patient ID");
                    int id = sc.nextInt();
                    System.out.println("Enter Patient name");
                    String name = sc.next();
                    System.out.println("Enter Patient age");
                    int age = sc.nextInt();
                    System.out.println("Enter Patient sex");
                    String sex = sc.next();
                    System.out.println("Enter Patient marital status");
                    String marriatal_status = sc.next();
                    System.out.println("Enter Patient address");
                    String address = sc.next();
                    System.out.println("Enter Patient Phone Number");
                    String phone = sc.next();
                    System.out.println("Does patient have Diabetes (true/false)");
                    boolean diabetes = sc.nextBoolean();
                    System.out.println("Does patient have depression (true/false)");
                    boolean deppression = sc.nextBoolean();
                    System.out.println("Does patient have Migrane (true/false)");
                    boolean Migrane = sc.nextBoolean();
                    System.out.println("Does patient have Hypertension (true/false)");
                    boolean hyper = sc.nextBoolean();
                    int med_hist_id = getMedHistoryID(diabetes, deppression, Migrane, hyper);

                    System.out.println("Whether patient has Drug allergy (true/false)");
                    boolean drug = sc.nextBoolean();
                    System.out.println("Whether patient has food allergy (true/false)");
                    boolean food = sc.nextBoolean();
                    System.out.println("Whether patient has insect allergy (true/false)");
                    boolean insect = sc.nextBoolean();
                    System.out.println("Whether patient has dust allergy (true/false)");
                    boolean dust = sc.nextBoolean();
                    int allegyid = getAllergyID(drug, food, insect, dust);
                    db.executeInsert("insert into demdetails values(" + id + ",\"" + name + "\"," + age + ",\""
                            + marriatal_status + "\",\"" + address + "\",\"" + phone + "\"," + med_hist_id + "," + allegyid);
                    break;

                case 2:
                    // Display all Patient
                    db.executeInsert("insert into demdetails values(6,\"name1\",20,\"male\",\"unmarried\",\"udupi\",\"4561237895\",0,0)");
                    db.executeCmd("select * from demdetails");
                    try {

                        System.out.print("patient_id\t");
                        System.out.print("name\t");
                        System.out.print("age\t");
                        System.out.print("sex\t");
                        System.out.print("marital_status\t");
                        System.out.print("address\t");
                        System.out.println("phone\t");
                        while (db.res.next()) {
                            System.out.print(db.res.getString("patient_id") + "\t");
                            System.out.print(db.res.getString("name") + "\t");
                            System.out.print(db.res.getString("age") + "\t");
                            System.out.print(db.res.getString("sex") + "\t");
                            System.out.print(db.res.getString("marital_status") + "\t");
                            System.out.print(db.res.getString("address") + "\t");
                            System.out.print(db.res.getString("phone") + "\t");
                            // System.out.print(db.res.getString("history_id") + "\t");
                            // System.out.print(db.res.getString("allergy_id") + "\t");
                            System.out.println();
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());

                    }
                    break;
                case 3: // Search Patient details by patient ID
                    int search_id = sc.nextInt();
                    db.executeCmd("select * from demdetails where patient_id = " + search_id);
                    try {

                        System.out.print("patient_id\t");
                        System.out.print("name\t");
                        System.out.print("age\t");
                        System.out.print("sex\t");
                        System.out.print("marital_status\t");
                        System.out.print("address\t");
                        System.out.println("phone\t");
                        if (db.res.next()) {
                            System.out.print(db.res.getString("patient_id") + "\t");
                            System.out.print(db.res.getString("name") + "\t");
                            System.out.print(db.res.getString("age") + "\t");
                            System.out.print(db.res.getString("sex") + "\t");
                            System.out.print(db.res.getString("marital_status") + "\t");
                            System.out.print(db.res.getString("address") + "\t");
                            System.out.print(db.res.getString("phone") + "\t");
                            // System.out.print(db.res.getString("history_id") + "\t");
                            // System.out.print(db.res.getString("allergy_id") + "\t");

                            db.executeCmd("select * from allergies where allergy_id = " + db.res.getInt("allergy_id"));
                            if (db.res.next()) {
                                System.out.print(db.res.getBoolean("drug") + "\t");
                                System.out.print(db.res.getBoolean("food") + "\t");
                                System.out.print(db.res.getBoolean("insect") + "\t");
                                System.out.print(db.res.getBoolean("dust") + "\t");
                            }

                        }
                        System.out.println();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());

                    }
                    break;

                default:
                    break;
            }
        } while (choice <= 3);
    }

    public static void main(String[] args) {
        new DCS().runDCS();
    }
}
