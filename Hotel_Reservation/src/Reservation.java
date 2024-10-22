import java.sql.*;
import java.util.Scanner;

public class Reservation {

    public void CreateReservation(Connection connection, Scanner sc) throws SQLException {
        System.out.print("Enter Name: ");
        String name = sc.next();
        sc.nextLine();
        System.out.print("Enter Room Number: ");
        int room_no = sc.nextInt();

        String query = "INSERT INTO reservation (name, room_no) VALUES (?, ?)";
        PreparedStatement prep = connection.prepareStatement(query);
        prep.setString(1, name);
        prep.setInt(2, room_no);

        int rowAffected = prep.executeUpdate();
        if (rowAffected > 0) {
            System.out.println("Reservation Created Successfully");
        } else {
            System.out.println("Reservation Not Created");
        }
    }

    public void ViewReservation(Connection connection) throws SQLException {
        String query = "SELECT * FROM reservation";
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(query);

        if (!result.isBeforeFirst()) { // Check if the result set is empty
            System.out.println("No Reservation Found");
            return;
        }

        while (result.next()) {
            System.out.println("Id: " + result.getInt("id") + "\t Name: " + result.getString("name") +
                    "\t Room No: " + result.getInt("room_no") + "\t Date: " + result.getDate("reservation_date"));
        }
    }

    public void UpdateReservation(Connection connection, Scanner sc) throws SQLException {
        System.out.print("Enter Id to Update: ");
        int id = sc.nextInt();
        if (CheckReservationExist(connection, id)) {
            System.out.print("Enter Name: ");
            String name = sc.next();
            System.out.print("Enter Room Number: ");
            int room_no = sc.nextInt();

            String query = "UPDATE reservation SET name=?, room_no=? WHERE id=?";
            PreparedStatement prep = connection.prepareStatement(query);
            prep.setString(1, name);
            prep.setInt(2, room_no);
            prep.setInt(3, id);

            int rowAffected = prep.executeUpdate();
            if (rowAffected > 0) {
                System.out.println("Reservation Updated Successfully");
            } else {
                System.out.println("Reservation Not Updated");
            }
        } else {
            System.out.println("No Reservation Found");
        }
    }

    public void DeleteReservation(Connection connection, Scanner sc) throws SQLException {
        System.out.print("Enter Id to Delete: ");
        int id = sc.nextInt();
        if (CheckReservationExist(connection, id)) {
            String query = "DELETE FROM reservation WHERE id=?";
            PreparedStatement prep = connection.prepareStatement(query);
            prep.setInt(1, id);

            int rowAffected = prep.executeUpdate();
            if (rowAffected > 0) {
                System.out.println("Reservation Deleted Successfully");
            } else {
                System.out.println("Reservation Not Deleted");
            }
        } else {
            System.out.println("No Reservation Found");
        }
    }

    public boolean CheckReservationExist(Connection connection, int id) throws SQLException {
        String query = "SELECT * FROM reservation WHERE id=?";
        PreparedStatement prep = connection.prepareStatement(query);
        prep.setInt(1, id);
        ResultSet result = prep.executeQuery();

        return result.next(); // Returns true if a record exists
    }

    public void SearchReservation(Connection connection, Scanner sc) throws SQLException {
        System.out.print("Enter Id to Search: ");
        int id = sc.nextInt();
        if (CheckReservationExist(connection, id)) {
            String query = "SELECT * FROM reservation WHERE id=?";
            PreparedStatement prep = connection.prepareStatement(query);
            prep.setInt(1, id);
            ResultSet result = prep.executeQuery();

            if (result.next()) {
                System.out.println("Id: " + result.getInt("id") + "\t Name: " + result.getString("name") +
                        "\t Room No: " + result.getInt("room_no") + "\t Date: " + result.getDate("reservation_date"));
            }
        } else {
            System.out.println("No Reservation Found");
        }
    }

    public void exit() throws InterruptedException {
        System.out.println("Closing Hotel Reservation Management");
        System.out.print("Exiting");
        for (int i = 0; i < 5; i++) {
            System.out.print(".");
            Thread.sleep(500);
        }
        System.out.println();
        System.out.println("Thank you.");
    }
}
