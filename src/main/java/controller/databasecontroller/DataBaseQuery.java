package controller.databasecontroller;

import model.Hotel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataBaseQuery implements Query {
    private DataBaseConnection dataBaseConnection;

    public DataBaseQuery(DataBaseConnection dataBaseConnection) {
        this.dataBaseConnection = dataBaseConnection;
    }

    @Override
    public List<Object> getObjectList(String name) throws SQLException {
        String sql = String.format("SELECT * FROM %s", name);

        Statement statement = dataBaseConnection.getConn().createStatement();
        ResultSet rs = statement.executeQuery(sql);

        List<Object> hotels = new ArrayList<>();

        while (rs.next()) {
            Hotel hotel = new Hotel();

            hotel.setName(rs.getString(2));
            hotel.setLocation(rs.getString(3));

            hotels.add(hotel);
        }

        return hotels;
    }
}
