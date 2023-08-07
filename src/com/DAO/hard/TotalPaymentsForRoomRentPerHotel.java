package com.DAO.hard;

import com.ConnectionToDB.DataBaseConnection;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class TotalPaymentsForRoomRentPerHotel {
// hard 5
static DataBaseConnection db=new DataBaseConnection();
    static Connection connection= db.createConnection();

    public static Map<String, Double> getTotalPaymentsForRoomRentPerHotel(String startDate, String endDate) {
        Map<String, Double> paymentOfRoomPerHotel=new HashMap<>();
        try {
            // Récupérer le total des paiements encaissés pour les locations de chambre
            // pour chaque hôtel au cours de la période spécifiée
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
                String hotelName= resultSet.getString("nom_hotel");
                Double totalPaiments= resultSet.getDouble("total_paiments");
                paymentOfRoomPerHotel.put(hotelName, totalPaiments);
            }

            // Fermer les ressources
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paymentOfRoomPerHotel;

    }
}

