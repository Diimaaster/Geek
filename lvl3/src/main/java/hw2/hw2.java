package hw2;

import java.sql.*;

public class hw2 {

    private static Connection connection;
    private static Statement stmt;
    private static ResultSet rs;
    public static void main(String[] args) throws SQLException {
        try {
            connection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwabels) {
            throwabels.printStackTrace();
        }



        deleteinfo();
        updateinfo();
        updateprice("product6",20);
        pricebetween(6000,6050);
        getPrice("product7");


        try {
            disconnect();
        }  catch (SQLException throwabeels) {
            throwabeels.printStackTrace();
        }

    }

    private static void updateprice(String product,int newprice) throws SQLException {
        stmt.executeUpdate(String.format("UPDATE Express SET good_price = '%d' WHERE good_name = '%s';", newprice, product));
    }

    private static void pricebetween(int price1,int price2) throws SQLException {
        rs = stmt.executeQuery(String.format("SELECT * FROM Express WHERE good_price BETWEEN %d AND %d;",price1,price2));
        while(rs.next()){
            System.out.println("Name: " + rs.getString("good_name") + " Price: " + rs.getString("good_price"));
        }
    }

    private static void getPrice(String product) throws SQLException {

            rs = stmt.executeQuery(String.format("SELECT * FROM Express WHERE good_name = '%10s';",product));
            System.out.println("Name: " + rs.getString("good_name") + " Price: " + rs.getString("good_price"));

    }

    private static void updateinfo() throws SQLException {
        connection.setAutoCommit(false);
        PreparedStatement pstmt = connection.prepareStatement("INSERT INTO Express (good_id, good_name, good_price) VALUES " + "(?, ?, ?)");
        for (int i = 0; i < 10000; i++) {
            pstmt.setString(1, "id" + i);
            pstmt.setString(2, "product" + i);
            pstmt.setString(3, "" + i);

            pstmt.addBatch();
        }

        pstmt.executeBatch();
        connection.setAutoCommit(true);
    }

    private static void deleteinfo() throws SQLException {
        stmt.execute("DELETE FROM Express");
    }

    private static void disconnect() throws SQLException {
        connection.close();
    }

    private static void connection() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/test.db");
        stmt = connection.createStatement();
    }
}
