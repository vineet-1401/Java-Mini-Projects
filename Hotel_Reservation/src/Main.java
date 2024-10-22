

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends Reservation {

    private final static String url = "jdbc:mysql://localhost:3306/hotel_reservation";
    private final static String username = "root";
    private final static String password = "user";

    public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {

        Reservation reservation = new Reservation();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Scanner sc = new Scanner(System.in);
            int choice;
            while (true) {
                System.out.println("Hotel Management System");
                System.out.println("-----------------------");
                System.out.println("1. Create Reservation");
                System.out.println("2. View Reservation");
                System.out.println("3. Update Reservation");
                System.out.println("4. Delete Reservation");
                System.out.println("5. Search Reservation");
                System.out.println("0. Exit");
                System.out.println("-----------------------");
                System.out.print("Enter Your Choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1: {
                        reservation.CreateReservation(connection, sc);
                        break;
                    }
                    case 2: {
                        reservation.ViewReservation(connection);
                        break;
                    }
                    case 3: {
                        reservation.UpdateReservation(connection, sc);
                        break;
                    }
                    case 4: {
                        reservation.DeleteReservation(connection, sc);
                        break;
                    }
                    case 5: {
                        reservation.SearchReservation(connection, sc);
                        break;
                    }
                    case 0: {
                        reservation.exit();
                        sc.close();
                        return;
                    }
                    default: {
                        System.out.println("Please enter a valid choice");
                    }
                }
                System.out.println();

            }

        } catch (SQLException | InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }
}