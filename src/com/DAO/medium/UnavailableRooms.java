package com.DAO.medium;

import com.ConnectionToDB.DataBaseConnection;
import com.ShowClass.ThisRoom;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UnavailableRooms {
    // TODO: line-9
    public static List<ThisRoom> unavailableRooms(){
        DataBaseConnection db = new DataBaseConnection();
        Connection connection = db.createConnection();

        List<ThisRoom> roomList=new ArrayList<>();
        try {
            String sql = "SELECT room.id, room.room_name " +
                    "FROM room " +
                    "INNER JOIN reservation_contain " +
                    "ON room.id = reservation_contain.id_room " +
                    "INNER JOIN reservation " +
                    "ON reservation_contain.id_reservation = reservation.id " +
                    "WHERE NOW() BETWEEN reservation.arrival AND reservation.departure";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

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
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roomList;
    }
}




