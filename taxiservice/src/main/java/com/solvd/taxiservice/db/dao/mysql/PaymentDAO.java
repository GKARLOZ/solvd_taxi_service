package com.solvd.taxiservice.db.dao.mysql;

import com.solvd.taxiservice.db.dao.interfaces.IDAO;
import com.solvd.taxiservice.db.model.Payment;
import com.solvd.taxiservice.db.model.Profile;
import com.solvd.taxiservice.db.model.Ride;
import com.solvd.taxiservice.db.utils.DBConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentDAO implements IDAO<Payment> {

    private final static Logger LOGGER = LogManager.getLogger(PaymentDAO.class);

    private void executeQuery(String query, Object... params){

        Connection connection = DBConnectionPool.getInstance().getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                LOGGER.info(rowsAffected + " row affected in Payment table.");
            } else {
                LOGGER.info("No rows affected in Payment table");
            }

        } catch (SQLException e) {
            LOGGER.error(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }

    }

    private Payment queryGet(String query, Object... params) {

        Connection connection = DBConnectionPool.getInstance().getConnection();
        Payment payment = new Payment();

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }

            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {

                    payment.setId(resultSet.getLong("id"));
                    payment.setPaymentStatus(resultSet.getString("payment_status"));

                }
            }

        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }
        return payment;

    }

    @Override
    public void create(Payment payment) {
        executeQuery("INSERT INTO Payments (payment_status,invoice_id,payment_method_id) VALUES (?,?,?)",payment.getPaymentStatus(),payment.getInvoice().getId(),payment.getPaymentMethod().getId());

    }

    @Override
    public Payment getById(long id) {

        Long rId = id;
        return queryGet("SELECT * FROM Payments WHERE ID=?",rId);

    }

    @Override
    public void update(Payment payment) {
        executeQuery("UPDATE Payments SET payment_status=? WHERE id = ?",payment.getPaymentStatus(),payment.getId());

    }

    @Override
    public void delete(Payment payment) {
        executeQuery("DELETE FROM Payments WHERE id = ?",payment.getId());

    }


}
