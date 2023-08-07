package com.DAO.basic;

import com.ConnectionToDB.DataBaseConnection;

import java.awt.datatransfer.DataFlavor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TotalPaymentReceivedByMobileMoney {
    public static double totalPaymentReceivedByMobileMoney(){
        DataBaseConnection db= new DataBaseConnection();
        Connection connection=db.createConnection();

        double totalPayement = 0;
        try {
            String sql="SELECT COUNT(*) AS total_payment" +
                    " FROM payment\n" +
                    "WHERE method_payment = 'mobile_money';";
            Statement statement= connection.createStatement();
            ResultSet resultSet= statement.executeQuery(sql);
            while (resultSet.next()){
                double totalPayment= resultSet.getDouble("total_payment");
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalPayement;
    }
}
