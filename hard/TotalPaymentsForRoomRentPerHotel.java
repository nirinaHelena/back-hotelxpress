package com.DAO;

import com.ConnectionToDB.DataBaseConnection;

import java.sql.*;

public class TotalPaymentsForRoomRentPerHotel {
// hard 5
    DataBaseConnection db = DataBaseConnection.getInstance();

    // Obtenir la connexion à la base de données
    Connection connection = db.getConnection();

    public void getTotalPaymentsForRoomRentPerHotel(String startDate, String endDate) {
        try {
            // Récupérer le total des paiements encaissés pour les locations de chambre pour chaque hôtel au cours de la période spécifiée
            String sqlQuery = "SELECT h.nom_hotel, SUM(p.montant) AS total_paiements " +
                    "FROM hotels h " +
                    "JOIN reservations r ON h.id_hotel = r.id_hotel " +
                    "JOIN paiements p ON r.id_reservation = p.id_reservation " +
                    "WHERE r.date_debut >= ? AND r.date_fin <= ? " +
                    "GROUP BY h.nom_hotel;";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, startDate);
            preparedStatement.setString(2, endDate);

            ResultSet resultSet = preparedStatement.executeQuery();

            // Afficher les résultats
            while (resultSet.next()) {
                String hotelName = resultSet.getString("nom_hotel");
                double totalPayments = resultSet.getDouble("total_paiements");
                System.out.println("Total des paiements encaissés pour les locations de chambre de l'hôtel '" + hotelName + "' pendant la période du " + startDate + " au " + endDate + ": " + totalPayments);
            }

            // Fermer les ressources
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void main(String[] args) {
        String startDate = "2023-08-10"; // Date de début de la période
        String endDate = "2023-08-15"; // Date de fin de la période
        getTotalPaymentsForRoomRentPerHotel(startDate, endDate);
    }
}

