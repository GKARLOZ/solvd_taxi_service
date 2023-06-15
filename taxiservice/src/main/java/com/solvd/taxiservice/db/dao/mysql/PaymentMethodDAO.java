package com.solvd.taxiservice.db.dao.mysql;

import com.solvd.taxiservice.db.dao.interfaces.IPaymentMethodDAO;
import com.solvd.taxiservice.db.model.DriverLicense;
import com.solvd.taxiservice.db.model.PaymentMethod;
import com.solvd.taxiservice.db.model.Review;
import com.solvd.taxiservice.db.utils.DBConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentMethodDAO implements IPaymentMethodDAO {

    private final static Logger LOGGER = LogManager.getLogger(PaymentMethod.class);

    private void executeQuery(String query, Object... params){

        Connection connection = DBConnectionPool.getInstance().getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                LOGGER.info(rowsAffected + " row affected in Payment Method table.");
            } else {
                LOGGER.info("No rows affected in Payment Method table");
            }

        } catch (SQLException e) {
            LOGGER.error(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }

    }

    private PaymentMethod queryGet(String query, Object... params){

        Connection connection = DBConnectionPool.getInstance().getConnection();
        PaymentMethod pm = new PaymentMethod();
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }


            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {

                    pm.setId(resultSet.getLong("id"));
                    pm.setMethod(resultSet.getString("method"));
                    pm.setComment(resultSet.getString("comment"));
                }
            }

        } catch (SQLException e) {
            LOGGER.error(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }
        return pm;

    }


    @Override
    public void create(PaymentMethod paymentMethod) {
        executeQuery("INSERT INTO Payment_methods (methods,comment) VALUES (?,?)",paymentMethod.getMethod(),paymentMethod.getComment());

    }

    @Override
    public PaymentMethod getById(long id) {
        Long rId = id;
        return queryGet("SELECT * FROM payment_methods WHERE ID=?",rId);

    }

    @Override
    public void update(PaymentMethod paymentMethod) {
        executeQuery("UPDATE payment_methods SET method = ?,  comment= ? WHERE id = ?",paymentMethod.getMethod(),paymentMethod.getComment(),paymentMethod.getId() );

    }

    @Override
    public void delete(PaymentMethod paymentMethod) {
        executeQuery("DELETE FROM Payment_methods WHERE id = ?",paymentMethod.getId());
    }

    @Override
    public PaymentMethod getPMByPaymentId(long id) {
        Long rId = id;
        return queryGet("select * from Payment_methods where id = (select payment_method_id  from payments where id = ?);",rId);

    }
}
