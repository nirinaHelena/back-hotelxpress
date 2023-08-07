package com.DAO;

import com.ConnectionToDB.DataBaseConnection;

import java.sql.*;
//hard 4
public class TotalPaymentsPerHotel {

    DataBaseConnection db = DataBaseConnection.getInstance();

    // Obtenir la connexion à la base de données
    Connection connection = db.getConnection();

    public void getTotalPaymentsPerHotel(int year) {
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
            while (resultSet.next()) {
                String hotelName = resultSet.getString("nom_hotel");
                double totalPayments = resultSet.getDouble("total_paiements");
                System.out.println("Total des paiements encaissés en " + year + " pour l'hôtel '" + hotelName + "': " + totalPayments);
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
        int year = 2023; // Année spécifiée
        getTotalPaymentsPerHotel(year);
    }
}

