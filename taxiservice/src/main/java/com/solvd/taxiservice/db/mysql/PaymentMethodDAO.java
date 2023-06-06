package com.solvd.taxiservice.db.mysql;

import com.solvd.taxiservice.db.dao.IPaymentMethodDAO;
import com.solvd.taxiservice.db.model.PaymentMethod;
import com.solvd.taxiservice.db.model.Profile;
import com.solvd.taxiservice.db.utils.DBConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentMethodDAO implements IPaymentMethodDAO {
    @Override
    public void create(PaymentMethod paymentMethod) {

    }

    @Override
    public PaymentMethod getById(long id) {

        Connection connection = DBConnectionPool.getInstance().getConnection();
       PaymentMethod pm = new PaymentMethod();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Payment_methods WHERE ID=?");
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                pm.setId(resultSet.getLong("id"));
                pm.setMethod(resultSet.getString("method"));
                pm.setComment(resultSet.getString("details"));


            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }

        return pm;
    }

    @Override
    public void update(PaymentMethod paymentMethod) {

    }

    @Override
    public void delete(PaymentMethod paymentMethod) {

    }

    @Override
    public PaymentMethod getPMByPaymentId(long id) {
        Connection connection = DBConnectionPool.getInstance().getConnection();
        PaymentMethod pm = new PaymentMethod();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select * from Payment_methods\n" +
                    "where id = (select payment_method_id  from payments where id = ?);");
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                pm.setId(resultSet.getLong("id"));
                pm.setMethod(resultSet.getString("method"));
                pm.setComment(resultSet.getString("details"));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }

        return pm;
    }
}
