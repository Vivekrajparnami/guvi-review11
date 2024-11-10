import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        // Replace "mysql" with your actual database name if different
        String url = "jdbc:mysql://localhost:3306/mysql";
        String user = "root";
        String password = "raj1122";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO songs (artist_name, release_date) VALUES (?, ?)")) {

            // Inserting a new song
            stmt.setString(1, "Artist 1");
            stmt.setDate(2, java.sql.Date.valueOf("2023-11-10"));
            stmt.executeUpdate();

            // Inserting another song
            stmt.setString(1, "Artist 2");
            stmt.setDate(2, java.sql.Date.valueOf("2024-05-22"));
            stmt.executeUpdate();

            System.out.println("Songs inserted successfully.");
        } catch (SQLException e) {

            System.out.println("Error: " + e.getMessage());  // Print error message for debugging
        }
    }
}