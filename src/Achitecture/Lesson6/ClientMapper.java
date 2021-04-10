package Achitecture.Lesson6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ClientMapper {
    Connection connection;
    public ClientMapper(Connection connection){
        this.connection = connection;
    }

    public ClientMapper deleteByName(String name){
        String query = "DELETE FROM potentialclients " +
                String.format(" WHERE AccountName = '%s';",name);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this;
    }
    public ClientMapper insert(UUID id, String name, String contact, String phoneNumber, double capital){
        if(id == null){
            id = UUID.randomUUID();
        }
        String query = "INSERT potentialclients(Id, AccountName, Contact,PhoneNumber,Capital) VALUES(?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,id.toString());
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, contact);
            preparedStatement.setString(4, phoneNumber);
            preparedStatement.setDouble(5, capital);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this;
    }
    public void updateClientCapital(String id, double capital) {
        String query = "UPDATE potentialclients SET Capital = ? WHERE Id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setDouble(1, capital);
            preparedStatement.setString(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Client> findClientByContactName(String name){
        String query = String.format("SELECT * FROM potentialclients WHERE Contact = '%s'",name);

        List<Client> clients = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery(query);
            while (rs.next()) {
                clients.add(new Client().setId(rs.getString(1))
                                        .setName(rs.getString(2))
                                        .setContact(rs.getString(3))
                                        .setPhoneNumber(rs.getString(4))
                                        .setCapital(rs.getDouble(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public  int getCountPotentialClient() {
        String query = "SELECT COUNT(*) FROM potentialclients";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }
}
