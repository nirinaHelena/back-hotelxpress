package com.DAO.basic;

import com.ConnectionToDB.DataBaseConnection;
import com.ShowClass.ThisRoom;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ShowAllRoomForType {

    // TODO: it don't find room type standard: la colonne standard n'existe pas
    public static List<ThisRoom> showAllRoomForTypeInHotel
            (String roomType, String hotelName){
        DataBaseConnection db = new DataBaseConnection();
        Connection connection= db.createConnection();

        List<ThisRoom> roomList=new ArrayList<>();
        try {
            String sql="SELECT r.* FROM room AS r\n" +
                    "INNER JOIN room_type AS rt\n" +
                    "ON r.id_room_type = rt.id\n" +
                    "INNER JOIN hotel AS h\n" +
                    "ON r.id_hotel = h.id\n" +
                    "WHERE rt.type="+roomType+" AND h.hotel_name="+hotelName+";";
            Statement statement= connection.createStatement();
            ResultSet resultSet= statement.executeQuery(sql);

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
        } catch (SQLException e){
            e.printStackTrace();
        }
        return roomList;
    }

    public static void main(String[] args) {
        System.out.println(
                ShowAllRoomForType.showAllRoomForTypeInHotel(
                        "standard", "MacGyver and Sons"));
    }
}
