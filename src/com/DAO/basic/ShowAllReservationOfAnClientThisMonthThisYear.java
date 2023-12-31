package com.DAO.basic;

import com.ConnectionToDB.DataBaseConnection;
import com.ShowClass.ThisReservation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShowAllReservationOfAnClientThisMonthThisYear {
    public static List<ThisReservation>
            showAllReservationOfAnClientThisMonthThisYear(
                    int idClient, int month, int year
    ){
        DataBaseConnection db=new DataBaseConnection();
        Connection connection= db.createConnection();

        List<ThisReservation> reservationList= new ArrayList<>();

        try {
            String sql="SELECT * from reservation\n" +
                    "where id_user = " +idClient+
                    "and EXTRACT(month from date_reservation) = "+
                    month+
                    "  and EXTRACT(year from date_reservation) = "+
                    year+";";
            Statement statement=connection.createStatement();
            ResultSet resultSet= statement.executeQuery(sql);

            while (resultSet.next()){
                int idReservation= resultSet.getInt("id");
                Timestamp arrival= resultSet.getTimestamp("arrival");
                Timestamp departure= resultSet.getTimestamp("departure");
                Timestamp dateReservation= resultSet.getTimestamp("date_reservation");

                ThisReservation reservation= new ThisReservation(idReservation,
                        arrival, departure, dateReservation);
                reservationList.add(reservation);
            }
            resultSet.close();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return reservationList;
    }
}
