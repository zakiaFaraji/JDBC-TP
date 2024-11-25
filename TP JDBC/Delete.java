import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete {
    public static void main(String[] args) {
        // Informations de connexion à la base de données
        String url = "jdbc:postgresql://localhost:5432/JDBC";
        String user = "postgres";
        String password = "rihab";

        // Demande à l'utilisateur l'ID de la ligne à supprimer
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez l'ID de la ligne à supprimer : ");
        int idToDelete = scanner.nextInt(); // Lecture de l'ID fourni par l'utilisateur

        // Requête SQL pour supprimer une ligne de la table
        String sql = "DELETE FROM Acces WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Remplir le paramètre de la requête SQL
            pstmt.setInt(1, idToDelete);

            // Exécuter la suppression
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("La ligne avec l'ID " + idToDelete + " a été supprimée avec succès.");
            } else {
                System.out.println("Aucune ligne trouvée avec l'ID " + idToDelete + ".");
            }

        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression : " + e.getMessage());
        } finally {
            scanner.close(); // Fermer le scanner
        }
    }
}
