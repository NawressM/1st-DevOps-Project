package dsti.devops.carstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 

public class CarCRUD {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public CarCRUD(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
     
    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                                        jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
     
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
     
    public boolean insertCar(Car car) throws SQLException {
        String sql = "INSERT INTO car (brand, model, price) VALUES (?, ?, ?)";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, car.getBrand());
        statement.setString(2, car.getModel());
        statement.setFloat(3, car.getPrice());
         
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
     
    public List<Car> listAllCars() throws SQLException {
        List<Car> listCar = new ArrayList<>();
         
        String sql = "SELECT * FROM car";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            String matriculation = resultSet.getString("matriculation");
            String brand = resultSet.getString("brand");
            String model = resultSet.getString("model");
            float price = resultSet.getFloat("price");
             
            Car car = new Car(matriculation, brand, model, price);
            listCar.add(car);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listCar;
    }
     
    public boolean deleteCar(Car car) throws SQLException {
        String sql = "DELETE FROM car where matriculation = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, car.getMatriculation());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
     
    public boolean updateCar(Car car) throws SQLException {
        String sql = "UPDATE car SET brand = ?, model = ?, price = ?";
        sql += " WHERE matriculation = ?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, car.getBrand());
        statement.setString(2, car.getModel());
        statement.setFloat(3, car.getPrice());
        statement.setString(4, car.getMatriculation());
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
     
    public Car getCar(String matriculation) throws SQLException {
        Car car = null;
        String sql = "SELECT * FROM car WHERE matriculation = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, matriculation);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            String brand = resultSet.getString("brand");
            String model = resultSet.getString("model");
            float price = resultSet.getFloat("price");
             
            car = new Car(matriculation, brand, model, price);
        }
         
        resultSet.close();
        statement.close();
         
        return car;
    }
}
