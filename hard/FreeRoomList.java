package com.DAO;

import com.ConnectionToDB.DataBaseConnection;

import java.sql.*;
//hard 2
public class FreeRoomList {

    DataBaseConnection db = DataBaseConnection.getInstance();

    // Obtenir la connexion à la base de données
    Connection connection = db.getConnection();

    public void getFreeRoomsList(String startDate, String endDate) {
        try {
            // Récupérer la liste des chambres libres pour la période spécifiée
            String sqlQuery = "SELECT c.nom_chambre, h.nom_hotel " +
                    "FROM chambres c " +
                    "JOIN hotels h ON c.id_hotel = h.id_hotel " +
                    "WHERE c.id_chambre NOT IN " +
                    "(SELECT id_chambre FROM reservations WHERE date_debut <= ? AND date_fin >= ?);";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, endDate);
            preparedStatement.setString(2, startDate);

            ResultSet resultSet = preparedStatement.executeQuery();

            // Afficher les résultats
            while (resultSet.next()) {
                String roomName = resultSet.getString("nom_chambre");
                String hotelName = resultSet.getString("nom_hotel");
                System.out.println("Chambre libre '" + roomName + "' dans l'hôtel '" + hotelName + "'.");
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

        getFreeRoomsList(startDate, endDate);
    }
}


