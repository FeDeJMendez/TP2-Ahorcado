package LabV2.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.util.Objects;
import org.apache.commons.dbutils.DbUtils;
import java.sql.*;

public class BDPalabra {
    private static final String TABLE = "palabras";
    private Statement stmt = null;
    private Connection conn = null;
    private ResultSet rs = null;
    private PreparedStatement pStmt = null;

    public String getPalabra(){ // Devuelve una de las 10 palabras de la BD al azar

        String palabra = " ";

        try {
            conn = Conexion.getInstance().getConnection();
            stmt = conn.createStatement();
            String sql;
            Integer idAleatorio = (int)(Math.random() * 10);
            if (idAleatorio == 0) idAleatorio++;// Indice aleatorio de 1 a 10 (Hay 10 palabras en la BD)
            sql = "SELECT palabra FROM " + TABLE + " WHERE id_Palabra = " + Integer.toString(idAleatorio) + ";";
            rs = stmt.executeQuery(sql);

            while(rs.next()) {
                palabra = rs.getString("palabra");
            }

        } catch (SQLException e) {
            System.out.println("Error connecting to database");
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(rs);
            DbUtils.closeQuietly(stmt);
            DbUtils.closeQuietly(conn);
        }

        return palabra;
    }
}
