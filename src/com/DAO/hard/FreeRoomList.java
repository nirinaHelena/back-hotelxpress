package com.DAO.hard;

import com.ConnectionToDB.DataBaseConnection;
import com.ShowClass.ThisRoom;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//hard 2
public class FreeRoomList {
    public static List<ThisRoom> freeRoomList(String startDate, String endDate) {
        DataBaseConnection db = new DataBaseConnection();

        // Obtenir la connexion à la base de données
        Connection connection = db.createConnection();
        List<ThisRoom> roomList=new ArrayList<>();
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
            while (resultSet.next()){
                int idRoom= resultSet.getInt("id");
                String roomCategory= resultSet.getString("room_category");
                String roomName= resultSet.getString("room_name");
                String roomUrlImg= resultSet.getString("room_url_image");
                String description= resultSet.getString("description");
                Double pricePerNight= resultSet.getDouble("price_per_night");
                Double pricePerHour= resultSet.getDouble("price_per_hour");
                int idRoomType= resultSet.getInt("id_room_type");
                int idHotel= resultSet.getInt("id_hotel");

                ThisRoom thisRoom=new ThisRoom(idRoom, roomCategory,
                        roomName, roomUrlImg, description, pricePerNight,
                        pricePerHour, idRoomType, idHotel);
                roomList.add(thisRoom);
            }
            // Fermer les ressources
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roomList;
    }
}


