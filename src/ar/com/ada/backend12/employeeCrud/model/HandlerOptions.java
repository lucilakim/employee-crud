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

            if (stmt != null) { try { stmt.close();} catch (SQLException f) { f.printStackTrace(); }}

            return id;

        } catch (SQLException e) {
            return -1;
        }
    }
}
