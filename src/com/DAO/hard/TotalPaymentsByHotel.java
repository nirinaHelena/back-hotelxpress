package com.DAO.hard;

import com.ConnectionToDB.DataBaseConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class TotalPaymentsByHotel {
    // hard 6
    static DataBaseConnection db=new DataBaseConnection();
    static Connection connection= db.createConnection();

    public static Map<String, Double> getTotalPaymentsByHotel(String startDate, String  endDate) {
        Map<String, Double> totalPaymentsByHotel = new HashMap<>();
        try {
            // Requête SQL pour récupérer le total des paiements encaissés pour les locations de chambre
            // uniquement au cours d'une période donnée, pour chaque hôtel
            String sqlQuery = "SELECT hotel.name AS hotel_name, " +
                    "COALESCE(SUM(paiement.amount_paid), 0) AS total_amount_paid " +
                    "FROM reservation " +
                    "INNER JOIN hotel ON reservation.hotel_id = hotel.id " +
                    "LEFT JOIN paiement ON reservation.id = paiement.id_reservation " +
                    "WHERE reservation.arrival BETWEEN ? AND ? " +
                    "GROUP BY hotel.name";

            // Préparer la requête avec les paramètres de la période de réservation
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setDate(1, Date.valueOf(startDate));
            preparedStatement.setDate(2, Date.valueOf(endDate));

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


