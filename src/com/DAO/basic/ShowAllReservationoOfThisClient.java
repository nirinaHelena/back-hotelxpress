package com.DAO.basic;

import com.ConnectionToDB.DataBaseConnection;
import com.ShowClass.ThisPromotion;
import com.ShowClass.ThisReservation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShowAllReservationoOfThisClient {
    public static List<ThisReservation> showAllReservationOfThisClient(int idClient){
        DataBaseConnection db=new DataBaseConnection();
        Connection connection=db.createConnection();

        List<ThisReservation> reservationList=new ArrayList<>();
        try {
            String sql="select * from reservation inner join client on " +
                    "client.id_client=reservation.id_user where id_client= "+idClient+";";
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
