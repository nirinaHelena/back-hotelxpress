package com.DAO.medium;

import com.ConnectionToDB.DataBaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class HotelRoomsCounts {
    // TODO: line-8
    public static Map<Integer, Integer> hotelRoomsCounts(){
        DataBaseConnection db = new DataBaseConnection();
        Connection connection = db.createConnection();

        Map<Integer, Integer> totalOfRoomsByHotel=new HashMap<>();
        try {
            String sql = "SELECT hotel.id, COUNT(room.id) AS nombre_chambres " +
                    "FROM hotel " +
                    "LEFT JOIN room ON hotel.id = room.id_hotel " +
                    "GROUP BY hotel.id, hotel.hotel_name";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int hotelId = resultSet.getInt("id");
                int numberOfRoom = resultSet.getInt("nombre_chambres");
                totalOfRoomsByHotel.put(hotelId, numberOfRoom);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalOfRoomsByHotel;
    }
}



