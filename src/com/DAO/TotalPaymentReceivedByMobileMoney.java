package com.DAO;

import com.ConnectionToDB.DataBaseConnection;

import java.awt.datatransfer.DataFlavor;
import java.sql.Connection;

public class TotalPaymentReceivedByMobileMoney {
    public static double totalPaymentReceivedByMobileMoney(){
        DataBaseConnection db= new DataBaseConnection();
        Connection connection=db.createConnection();

        double totalPayement;
        try {
            String sql="SELECT COUNT(*) AS total_payment" +
                    " FROM payment\n" +
                    "WHERE method_payment = 'mobile_money';";
            S
        }
    }
}
