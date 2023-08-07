package com.DAO.medium;

import com.ConnectionToDB.DataBaseConnection;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class ReservationCountByRoomType {
    // TODO: line-4
    public static Map<String, Double> reservationCountByRoomType(){
        DataBaseConnection db = new DataBaseConnection();
        Connection connection = db.createConnection();

        Map<String, Double> totalOfreservationByRoomType = new HashMap<>();

        try {
            String sql = "SELECT room_type.type, " +
                    "COUNT(reservation.*) AS reservation_total " +
                    "FROM reservation " +
                    "INNER JOIN reservation_contain ON reservation.id = reservation_contain.id_reservation " +
                    "INNER JOIN room ON reservation_contain.id_room = room.id " +
                    "INNER JOIN room_type ON room.id_room_type = room_type.id " +
                    "GROUP BY room_type.type";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String typeOfRoom = resultSet.getString("type");
                double reservationTotal = resultSet.getDouble("reservation_total");
                totalOfreservationByRoomType.put(typeOfRoom, reservationTotal);
            }


            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalOfreservationByRoomType;
    }
}