package com.DAO;

import com.ConnectionToDB.DataBaseConnection;
//hard 10
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.sql.*;
import java.util.Scanner;

public class HotelsWithAvailableRooms {

    // Supposons que la connexion à la base de données a déjà été établie et stockée dans 'conn'
    DataBaseConnection db = DataBaseConnection.getInstance();

    // Obtenir la connexion à la base de données
    Connection connection = db.getConnection();
    public  void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Entrez la date de début (AAAA-MM-JJ) : ");
            String startDateStr = scanner.nextLine();
            System.out.print("Entrez la date de fin (AAAA-MM-JJ) : ");
            String endDateStr = scanner.nextLine();

            // Conversion des chaînes de date en objets Date
            Date startDate = Date.valueOf(startDateStr);
            Date endDate = Date.valueOf(endDateStr);

            // Requête SQL pour récupérer la liste des hôtels avec des chambres libres sur la période demandée
            String sqlQuery = "SELECT hotel.id, hotel.name AS hotel_name " +
                    "FROM hotel " +
                    "WHERE hotel.id NOT IN (" +
                    "   SELECT DISTINCT hotel.id " +
                    "   FROM hotel " +
                    "   INNER JOIN room ON hotel.id = room.hotel_id " +
                    "   INNER JOIN reservation_contain ON room.id = reservation_contain.id_room " +
                    "   INNER JOIN reservation ON reservation_contain.id_reservation = reservation.id " +
                    "   WHERE (reservation.arrival <= ? AND reservation.departure >= ?) " +
                    "   OR (reservation.arrival <= ? AND reservation.departure >= ?) " +
                    "   OR (reservation.arrival >= ? AND reservation.departure <= ?) " +
                    ")";

            // Préparer la requête avec les paramètres de la période demandée
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setDate(1, startDate);
            preparedStatement.setDate(2, startDate);
            preparedStatement.setDate(3, endDate);
            preparedStatement.setDate(4, endDate);
            preparedStatement.setDate(5, startDate);
            preparedStatement.setDate(6, endDate);

            // Exécuter la requête et obtenir le résultat dans un objet ResultSet
            ResultSet resultSet = preparedStatement.executeQuery();

            // Afficher la liste des hôtels avec des chambres libres
            System.out.println("Hôtels avec des chambres libres pendant la période du " + startDate + " au " + endDate + ":");
            while (resultSet.next()) {
                int hotelId = resultSet.getInt("id");
                String hotelName = resultSet.getString("hotel_name");
                System.out.println("Hôtel ID : " + hotelId + ", Nom : " + hotelName);
            }

            // Fermer les ressources
            resultSet.close();
            preparedStatement.close();
            scanner.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
