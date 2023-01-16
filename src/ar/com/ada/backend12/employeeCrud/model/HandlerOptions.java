package ar.com.ada.backend12.employeeCrud.model;

import java.sql.*;

public class HandlerOptions {
    public HandlerOptions() {
    }

    public int insertEmployee(Connection conn, String firstName, String lastName, String di, java.util.Date birthDate, int department, int salary) {
        int id = 0;
        //2 - Prepare our query, be it select, delete, etc.
        String sql = "INSERT INTO EMPLOYEE (FIRST_NAME, LAST_NAME, DI, BIRTH_DATE, DEPARTMENT, SALARY) VALUES (?,?,?,?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, di);
            stmt.setDate(4, new java.sql.Date(birthDate.getTime()));
            stmt.setInt(5, department);
            stmt.setInt(6, salary);

            //3 - Execute our query
            stmt.executeUpdate();

            ResultSet result = stmt.getGeneratedKeys();
            if (result.next()) {
                id = result.getInt(1);
            }
            return id;
        } catch (SQLException e) {
            return -1;
        } finally {
            if (stmt != null) { try { stmt.close();} catch (SQLException f) { f.printStackTrace(); }}
        }
    }

    public void printAllEmployees(Connection conn) throws SQLException{
        //2 - Prepare our query, be it select, delete, etc.
        String sql = "SELECT * FROM EMPLOYEE";
        Statement stmt = conn.createStatement();

        //3 - Execute our query
        ResultSet rs = stmt.executeQuery(sql);

        //4 - Optional Process results of our query
        System.out.println("\nID    Name    Last Name     DI      Bith_of_Date D_Id     Hiring_Date      Salary ");
        while (rs.next()) {
            int id = rs.getInt("ID");
            String name = rs.getString("FIRST_NAME");
            String lastName = rs.getString("LAST_NAME");
            String di = rs.getString("DI");
            Date birth = rs.getDate("BIRTH_DATE");
            int department = rs.getInt("DEPARTMENT");
            Timestamp hiringDate = rs.getTimestamp("HIRING_DATE");
            int salary = rs.getInt("SALARY");
            System.out.println(id + ", '" + name + "', '" + lastName + "', '" + di + "', '" + birth + "', " + department + ", '" + hiringDate + "', $" + salary + ";");
        }
        if (stmt != null) { try { stmt.close();} catch (SQLException f) { f.printStackTrace(); }}
    }

    public void printAnEmployee(Connection conn, int id) throws SQLException {
        //2 - Prepare our query, be it select, delete, etc.
        String sql = "SELECT ID, FIRST_NAME, LAST_NAME, DI, BIRTH_DATE, DEPARTMENT, HIRING_DATE, SALARY FROM EMPLOYEE WHERE ID =  + ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);

        //3 - Execute our query
        ResultSet rs = stmt.executeQuery();

        //4 - Optional Process results of our query
        while (rs.next()) {
            id = rs.getInt("ID");
            String name = rs.getString("FIRST_NAME");
            String lastName = rs.getString("LAST_NAME");
            String di = rs.getString("DI");
            Date birth = rs.getDate("BIRTH_DATE");
            int department = rs.getInt("DEPARTMENT");
            Timestamp hiringDate = rs.getTimestamp("HIRING_DATE");
            int salary = rs.getInt("SALARY");

            System.out.println("\nID    Name    Last Name     DI      Bith_of_Date D_Id     Hiring_Date      Salary ");
            System.out.println(id + ", '" + name + "', '" + lastName + "', '" + di + "', '" + birth + "', " + department + ", '" + hiringDate + "', $" + salary + ";");
        }
        if (stmt != null) { try { stmt.close();} catch (SQLException f) { f.printStackTrace(); }}
    }

    public int updateEmployee(Connection conn, String firstName, String lastName, String di, java.util.Date birthDate, int department, int salary, int id) {
        //2 - Prepare our query, be it select, delete, etc.
        String sql = "UPDATE EMPLOYEE SET FIRST_NAME = ?, LAST_NAME = ? , DI = ?, BIRTH_DATE = ?, DEPARTMENT = ?, SALARY = ? WHERE ID = ?";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, di);
            stmt.setDate(4, new java.sql.Date(birthDate.getTime()));
            stmt.setInt(5, department);
            stmt.setInt(6, salary);
            stmt.setInt(7, id);

            //3 - Execute our query
            stmt.executeUpdate();
            return 1;

        } catch (SQLException e) {
            System.out.println("ERROR! An error occurred while trying to update the user.");
            e.printStackTrace();
        return -1;

    } finally {
        if (stmt != null) { try { stmt.close();} catch (SQLException f) { f.printStackTrace(); }}
    }
    }

    public int deleteEmployee(Connection conn, int id) {
        //2 - Prepare our query, be it select, delete, etc.
        String sql = "DELETE FROM EMPLOYEE WHERE ID = ?";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            //3 - Execute our query
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            System.out.println("ERROR! An error occurred while trying to delete the user.");
            e.printStackTrace();
            return -1;
        } finally {
            if (stmt != null) { try { stmt.close();} catch (SQLException f) { f.printStackTrace(); }}
        }
    }
}
