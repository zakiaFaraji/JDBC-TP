import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Update {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/JDBC";
        String user = "postgres";
        String password = "rihab";

        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez l'ID de la personne : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Entrez le nouveau statut : ");
        String newStatus = scanner.nextLine();

        String sql = "UPDATE Acces SET statut = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, newStatus);
            pstmt.setInt(2, id);

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Le statut a été mis à jour avec succès pour l'ID " + id);
            } else {
                System.out.println("Aucune personne trouvée avec l'ID " + id);
            }

        } catch (SQLException e) {
            System.out.println("Erreur lors de la mise à jour : " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
