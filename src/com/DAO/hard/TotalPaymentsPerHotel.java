package com.DAO.hard;

import com.ConnectionToDB.DataBaseConnection;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

//hard 4
public class TotalPaymentsPerHotel {

    static DataBaseConnection db=new DataBaseConnection();
    static Connection connection= db.createConnection();

    public static Map<String , Double> getTotalPaymentsPerHotel(int year) {
        Map<String , Double> paymentPerHotel=new HashMap<>();
        try {
            // Récupérer le total des paiements encaissés pour chaque hôtel au cours de l'année spécifiée
            String sqlQuery = "SELECT h.nom_hotel, SUM(p.amountPaid) AS total_payment " +
                    "FROM hotel h " +
                    "JOIN payment p ON h.id_hotel = p.id_hotel " +
                    "WHERE YEAR(p.date_paiement) = ? " +
                    "GROUP BY h.nom_hotel;";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, year);

            ResultSet resultSet = preparedStatement.executeQuery();

            // Afficher les résultats
            while (resultSet.next()){
                String nomHotel=resultSet.getString("nom_hotel");
                Double totalPayment= resultSet.getDouble("total_payment");
                paymentPerHotel.put(nomHotel, totalPayment);
            }

            // Fermer les ressources
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paymentPerHotel;
    }
}

