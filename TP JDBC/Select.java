import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/JDBC";
        String user = "postgres";
        String password = "rihab";

        String sql = "SELECT prenom, login, statut, age FROM Acces";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("Liste des personnes dans la table Acces :");
            System.out.println("------------------------------------------");
            while (rs.next()) {
                String prenom = rs.getString("prenom");
                String login = rs.getString("login");
                String statut = rs.getString("statut");
                int age = rs.getInt("age");

                System.out.println("Prénom : " + prenom +
                        ", Login : " + login +
                        ", Statut : " + statut +
                        ", Âge : " + age);
            }

        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des données : " + e.getMessage());
        }
    }
}
