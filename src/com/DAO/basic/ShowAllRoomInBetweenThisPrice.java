package com.DAO.basic;

import com.ConnectionToDB.DataBaseConnection;
import com.ShowClass.ThisRoom;

import javax.swing.plaf.nimbus.State;
import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ShowAllRoomInBetweenThisPrice {
    public static List<ThisRoom>
            showAllRoomBetweenThisPrice(int minValue, int maxValue){
        DataBaseConnection db=new DataBaseConnection();
        Connection connection=db.createConnection();

        List<ThisRoom> roomList=new ArrayList<>();
        try {
            String sql="SELECT room.id,room.room_category, " +
                    "room.room_name,room.price_per_night \n" +
                    "FROM room \n" +
                    "WHERE room.price_per_night " +
                    "BETWEEN "+ minValue +" and "+ maxValue+" ;";
            Statement statement= connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);

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
        }catch (SQLException e){
            e.printStackTrace();
        }
        return roomList;
    }
}
