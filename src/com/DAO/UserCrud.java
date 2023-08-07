package com.DAO;

public class UserCrud {
   /*
   * package ToDo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserToDo {
    // insert a new todo into the database
    public List<ToDo> insertToDo(int id, String title, String description, int priority, String deadline){
        DataBaseConnection connect = new DataBaseConnection();
        Connection connection = connect.createConnection();
        List<ToDo> todoList = new ArrayList<>();

        try{
            String sql = "insert into todo_list (id, title, description, priority, deadline) values (  id = ?, title = ?, description = ?, priority = ?, deadline = ? );";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery(sql);


            while(resultSet.next()){
                statement.setInt(1, id);
                statement.setString(2, title);
                statement.setString(3, description);
                statement.setInt(4, priority);
                statement.setString(5, deadline);

                ToDo todo = new ToDo(id, title, description, priority, deadline);
                todoList.add(todo);
            }
            resultSet.close();
            statement.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return todoList;
    }

    public ToDo findToDo(String search){
        List<ToDo> toDoList = new ArrayList<>();
        DataBaseConnection connect = new DataBaseConnection();
        Connection connection = connect.createConnection();
        int id_todo=Integer.parseInt(search);

        try {
            String sql = "select * from todo_list where title like '%"+search+"%' or id=id_todo;";
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                return new ToDo(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getString("priority"),
                        resultSet.getString("deadline")
                );

            }

            statement.close();
        }

        catch (SQLException e){
            e.printStackTrace();
        }
        return toDoList;
    }

    public List<ToDo> showAllToDo() {
        DataBaseConnection connect = new DataBaseConnection();
        Connection connection = connect.createConnection();
        List<ToDo> todoList = new ArrayList<>();

        try {
            String sql = "SELECT * FROM todo_list;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                int priority = resultSet.getInt("priority");
                String deadline = resultSet.getString("deadline");

                ToDo todo = new ToDo(id, title, description, priority, deadline);
                todoList.add(todo);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return todoList;
    }


    public String updateToDo(int id, String title, String description, int priority, String deadline) {
        DataBaseConnection connect = new DataBaseConnection();
        Connection connection = connect.createConnection();

        try {
            String sql = "UPDATE todo_list SET title = ?, description = ?, priority = ?, deadline = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, title);
            statement.setString(2, description);
            statement.setInt(3, priority);
            statement.setString(4, deadline);
            statement.setInt(5, id);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("La tâche a été mise à jour avec succès.");
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return "todo updated";
    }


    public String delete(String search){
        DataBaseConnection connect = new DataBaseConnection();
        Connection connection = connect.createConnection();
        int id_todo=Integer.parseInt(search);
        try{

            sql = "delete from todo_list where title like %"+search+"% or id="+id_todo+";";
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return "todo deleted seccesfuly";

    }

    public void quitToDo(String quit){
        DataBaseConnection connect = new DataBaseConnection();
        Connection connection = connect.createConnection();

        try{
            String sql ="exit;";
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

}

*/
}
