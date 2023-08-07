package com.DAO;

import com.ConnectionToDB.DataBaseConnection;
import com.ShowClass.ThisPromotion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ShowAllPromotionPerSeason {
    public static List<ThisPromotion> showAllPromotionPerSeason(){
        DataBaseConnection db=new DataBaseConnection();
        Connection connection=db.createConnection();

        List<ThisPromotion> promotionList=new ArrayList<>();
        try {
            String sql =" select p.* from promotion as p " +
                    "inner join have_promotion as hp " +
                    "on hp.id_promotion= p.id inner join hotel as h " +
                    "on hp.id_hotel= h.id_hotel" +
                    "where p.start_date <= current_date" +
                    "and p.end_date>=current_date;";
            Statement statement=connection.createStatement();
            ResultSet resultSet= statement.executeQuery(sql);

            while (resultSet.next()){
                int idPromotion= resultSet.getInt("id");
                LocalDate startDate= resultSet.getDate("start_date").toLocalDate();
                LocalDate endDate= resultSet.getDate("end_date").toLocalDate();
                double reduction= resultSet.getDouble("reduction");
                String description= resultSet.getString("description");

                ThisPromotion thisPromotion=new ThisPromotion(idPromotion,
                        startDate, endDate, reduction, description);
                promotionList.add(thisPromotion);
            }
            resultSet.close();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return promotionList;
    }
}