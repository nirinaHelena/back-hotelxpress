package com.DAO.basic;

import com.ConnectionToDB.DataBaseConnection;
import com.ShowClass.ThisHotel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ShowAllHotelInGivenCity {
    public static List<ThisHotel>
            showAllHotelInGivenCity(String City){
        DataBaseConnection db=new DataBaseConnection();
        Connection connection= db.createConnection();

        List<ThisHotel> hotelList= new ArrayList<>();

        try {
            String sql="select * from hotel where city = "+City+";";
            Statement statement= connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);

            while (resultSet.next()){
                int id= resultSet.getInt("id");
                String hotelName= resultSet.getString("hotel_name");
                String adress= resultSet.getString("adress");
                String thisCity= resultSet.getString("city");
                String state= resultSet.getString("state");
                String phoneNumber= resultSet.getString("phone_number");

                ThisHotel hotel=new ThisHotel(id,hotelName,adress,
                        thisCity,state,phoneNumber);
                hotelList.add(hotel);
            }
            resultSet.close();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return hotelList;
    }
}
