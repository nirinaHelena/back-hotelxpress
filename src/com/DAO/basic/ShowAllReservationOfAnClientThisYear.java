package com.DAO.basic;

import com.ConnectionToDB.DataBaseConnection;
import com.ShowClass.ThisReservation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShowAllReservationOfAnClientThisYear {
        public static List<ThisReservation>
        showAllReservationOfAnClientThisYear(
                int idClient, int year
        ){
            DataBaseConnection db=new DataBaseConnection();
            Connection connection= db.createConnection();

            List<ThisReservation> reservationList= new ArrayList<>();

            try {
                String sql="SELECT count(reservation.*) " +
                        "AS total_of_reservation from reservation\n" +
                        "where id_user = " +idClient+
                        " and EXTRACT(year from date_reservation) = "+year+";";
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
