package com.solvd.taxiservice.db.mysql;

import com.solvd.taxiservice.db.dao.IDAO;
import com.solvd.taxiservice.db.model.Payment;
import com.solvd.taxiservice.db.utils.DBConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentDAO implements IDAO<Payment> {
    @Override
    public void create(Payment payment) {

    }

    @Override
    public Payment getById(long id) {
        Connection connection = DBConnectionPool.getInstance().getConnection();
       Payment payment = new Payment();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Payments WHERE ID=?");
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                payment.setId(resultSet.getLong("id"));
                payment.setPaymentStatus(resultSet.getString("payment_status"));



            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }

        return payment;
    }

    @Override
    public void update(Payment payment) {

    }

    @Override
    public void delete(Payment payment) {

    }


}
