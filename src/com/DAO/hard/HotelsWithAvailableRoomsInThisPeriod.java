package com.DAO.hard;

import com.ConnectionToDB.DataBaseConnection;
import com.ShowClass.ThisHotel;
//hard 10
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class HotelsWithAvailableRoomsInThisPeriod {
    public static List<ThisHotel> hotelsWithAvailableRomsInThisPeriod(String startDate, String endDate){
        DataBaseConnection db=new DataBaseConnection();
        Connection connection= db.createConnection();
        List<ThisHotel> hotelList=new ArrayList<>();
        try {
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
            preparedStatement.setDate(1, Date.valueOf(startDate));
            preparedStatement.setDate(2, Date.valueOf(startDate));
            preparedStatement.setDate(3, Date.valueOf(endDate));
            preparedStatement.setDate(4, Date.valueOf(endDate));
            preparedStatement.setDate(5, Date.valueOf(startDate));
            preparedStatement.setDate(6, Date.valueOf(endDate));

            // Exécuter la requête et obtenir le résultat dans un objet ResultSet
            ResultSet resultSet = preparedStatement.executeQuery();

            // Afficher la liste des hôtels avec des chambres libres
            System.out.println("Hôtels avec des chambres libres pendant la période du " + startDate + " au " + endDate + ":");
            while (resultSet.next()){
                int id= resultSet.getInt("id");
                String hotelName= resultSet.getString("hotel_name");
                String adress= resultSet.getString("adress");
                String city= resultSet.getString("city");
                String state= resultSet.getString("state");
                String phoneNumber= resultSet.getString("phone_number");

                ThisHotel hotel=new ThisHotel(id,hotelName,adress,
                        city,state,phoneNumber);
                hotelList.add(hotel);
            }

            // Fermer les ressources
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hotelList;
    }
}
