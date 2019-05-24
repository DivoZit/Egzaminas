package sample;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {

    private BasicDataSource dataSource;

    public Database() {

        dataSource = new BasicDataSource();    // <---- prisijungimas prie duonbazes
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        dataSource.setUrl("jdbc:mysql://localhost:3306/egzaminas?useUnicode=yes&characterEncoding=UTF-8");
        dataSource.setValidationQuery("SELECT 1");
    }

    public void createUser(String vardas, String pavarde, String adresas, String elpastas) {
        String query = "INSERT INTO informacija (vardas, pavarde, adresas, elpastas)"
                + " VALUES (?, ?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, vardas);
            statement.setString(2, pavarde);
            statement.setString(3, adresas);
            statement.setString(4, elpastas);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectUsers(String vardas, String pavarde, String adresas, String elpastas) {
        String query = "SELECT * FROM informacija(vardas, pavarde, adresas, elpastas)"
                + " VALUES (?, ?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, vardas);
            statement.setString(2, pavarde);
            statement.setString(3, adresas);
            statement.setString(4, elpastas);
            System.out.println("Vardas: " + vardas + ", Pavarde: " + pavarde +
                    ", adresas: " + adresas + " , elpastas: " + elpastas);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public void selectUsers() {
//        String query = "SELECT * FROM informacija";
//
//        try (Connection connection = dataSource.getConnection();
//             PreparedStatement statement = connection.prepareStatement(query);
//             ResultSet resultSet = statement.executeQuery()) {
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String vardas = resultSet.getString("vardas");
//                String pavarde = resultSet.getString("pavarde");
//                String adresas = resultSet.getString("adresas");
//                String elpastas = resultSet.getString("elpastas");
//                System.out.println("ID: " + id + ", Vardas: " + vardas
//                        + ", Pavarde: " + pavarde + ", adresas: " + adresas + " , elpastas: " + elpastas);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
