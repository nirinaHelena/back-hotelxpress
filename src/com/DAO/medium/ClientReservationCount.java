package com.DAO.medium;

import com.ConnectionToDB.DataBaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// TODO: line 2
public class ClientReservationCount {
    public static int  clientReservationCount(int idClient){
        DataBaseConnection db = new DataBaseConnection();
        Connection connection = db.createConnection();
        int count = 0;

        try {
            String sql = "select count(reservation.id) as reservation_count\n" +
                    "from \"user\"\n" +
                    "inner join reservation on reservation.id_user= \"user\".id\n" +
                    "where \"user\".id_user_type= 1 and \"user\".id="+idClient+";";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                 count = resultSet.getInt("reservation_count");
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
