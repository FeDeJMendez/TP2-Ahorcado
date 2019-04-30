package LabV2.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.util.Objects;
import org.apache.commons.dbutils.DbUtils;
import java.sql.*;
import java.util.Calendar;

public class BDGanador {
    private static final String TABLE = "ganadores";
    private Statement stmt = null;
    private Connection conn = null;
    private ResultSet rs = null;
    private PreparedStatement pStmt = null;

    public int setGanador(String nombreJugador, String apellidoJugador, String palabraGanadora) throws NullPointerException{
        int affectedRows = 0;
        try {
            conn = Conexion.getInstance().getConnection();
            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
            String sql;
            sql = "INSERT INTO " + TABLE + " (nombre_Ganador, apellido_Ganador, fecha, palabraGanadora)"+ "VALUES (?, ?, ?, ?)";
            pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, nombreJugador);
            pStmt.setString(2,apellidoJugador);
            pStmt.setDate(3, startDate);
            pStmt.setString(4,palabraGanadora);
            affectedRows = pStmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error connecting to database");
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(pStmt);
            DbUtils.closeQuietly(conn);
        }
        return affectedRows;
    }
}