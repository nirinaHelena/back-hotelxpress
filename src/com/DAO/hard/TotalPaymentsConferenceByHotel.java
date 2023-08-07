package com.DAO.hard;
//hard 7
import com.ConnectionToDB.DataBaseConnection;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class TotalPaymentsConferenceByHotel {

    static DataBaseConnection db=new DataBaseConnection();
    static Connection connection= db.createConnection();
    public static Map<String, Double> getTotalPaymentsConferenceByHotel(String startDate, String endDate) {
        Map<String, Double> totalPaymentsByHotel = new HashMap<>();
        try {
            // Requête SQL pour récupérer le total des paiements encaissés pour les locations de salle de conférence
            // uniquement au cours d'une période donnée, pour chaque hôtel
            String sqlQuery = "SELECT hotel.name AS hotel_name, " +
                    "COALESCE(SUM(paiement.amount_paid), 0) AS total_amount_paid " +
                    "FROM paiement " +
                    "INNER JOIN reservation ON paiement.id_reservation = reservation.id " +
                    "INNER JOIN reservation_contain ON reservation.id = reservation_contain.id_reservation " +
                    "INNER JOIN room ON reservation_contain.id_room = room.id " +
                    "INNER JOIN hotel ON room.id_hotel = hotel.id " +
                    "WHERE reservation.arrival BETWEEN ? AND ? " +
                    "AND room.room_category = 'conference_room' " +
                    "GROUP BY hotel.name";

            // Préparer la requête avec les paramètres de la période de réservation
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setDate(1, Date.valueOf(startDate));
            preparedStatement.setDate(2, Date.valueOf(endDate));
            // Obtenir la connexion à la base de données
            // Exécuter la requête et obtenir le résultat dans un objet ResultSet
            ResultSet resultSet = preparedStatement.executeQuery();

            // Traitement des résultats
            while (resultSet.next()) {
                String hotelName = resultSet.getString("hotel_name");
                double totalAmountPaid = resultSet.getDouble("total_amount_paid");
                totalPaymentsByHotel.put(hotelName, totalAmountPaid);
            }

            // Fermer les ressources
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return totalPaymentsByHotel;
    }


}
