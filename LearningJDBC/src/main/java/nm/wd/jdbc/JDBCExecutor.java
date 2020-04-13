package nm.wd.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExecutor {
    public static void main(String[] args) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost",
                "hplussport", "postgres", "P@ssword0");

        try {
            Connection connection = dcm.getConnection();

//            //using a driver
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM CUSTOMER");
//            while (resultSet.next()) {
//                System.out.println(resultSet.getInt(1));
//            }

            CustomerDAO customerDAO = new CustomerDAO(connection);
            Customer customer = new Customer();
            customer.setFirstName("kurt");
            customer.setLastName("cobain");
            customer.setEmail("kurt.cobain@gomail.com");
            customer.setPhone("+60128443756");
            customer.setAddress("1234 Main St");
            customer.setCity("Mount Vernon");
            customer.setState("VA");
            customer.setZipCode("22121");

            customerDAO.create(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
