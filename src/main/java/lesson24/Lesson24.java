package lesson24;

import java.sql.*;
import java.util.Scanner;

/**
 * AIT-TR, cohort 42.1, Java Basic, Lesson #23
 *
 * @version 6-Mar-24
 */

public class Lesson24 {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int action;
        int id;
        String name, groupName;

        try {
            JdbcApp.connect();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcApp.disconnect();
        }

        do {
            System.out.println("1. Add a record");
            System.out.println("2. Delete a record");
            System.out.println("3. Update a record");
            System.out.println("4. Read all records");
            System.out.println("5. Close database and EXIT");
            System.out.print("Select action: ");
            action = scanner.nextInt();
            switch (action) {
                case 1:
                    System.out.print("Enter NAME: ");
                    name = scanner.next();
                    System.out.print("Enter GROUP_NAME: ");
                    groupName = scanner.next();
                    JdbcApp.add(name, groupName, JdbcApp.stmt);
                    break;
                case 2:
                    System.out.print("Enter ID of record: ");
                    id = scanner.nextInt();
                    JdbcApp.delete(id, JdbcApp.stmt);
                    break;
                case 3:
                    System.out.print("Enter NAME for change: ");
                    name = scanner.next();
                    System.out.print("Enter new GROUP_NAME: ");
                    groupName = scanner.next();
                    JdbcApp.update(name, groupName, JdbcApp.stmt);
                    break;
                case 4:
                    JdbcApp.read(JdbcApp.stmt);
                    break;
            }

        } while (action != 5);
    }
}
