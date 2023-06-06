package com.solvd.taxiservice.db.mysql;

import com.solvd.taxiservice.db.dao.IInvoiceDAO;
import com.solvd.taxiservice.db.model.Invoice;
import com.solvd.taxiservice.db.model.Payment;
import com.solvd.taxiservice.db.model.Trip;
import com.solvd.taxiservice.db.utils.DBConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InvoiceDAO implements IInvoiceDAO {
    @Override
    public void create(Invoice invoice) {

    }

    @Override
    public Invoice getById(long id) {

        Connection connection = DBConnectionPool.getInstance().getConnection();
        Invoice invoice = new Invoice();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM invoices WHERE ID=?");
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                invoice.setId(resultSet.getLong("id"));
                invoice.setTaxAmount(resultSet.getDouble("tax_amount"));
                invoice.setTotalAmount(resultSet.getDouble("total_amount"));


            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }

        return invoice;
    }

    @Override
    public void update(Invoice invoice) {

    }

    @Override
    public void delete(Invoice invoice) {

    }

    @Override
    public Invoice getInvoiceByPaymentId(long id) {
        Connection connection = DBConnectionPool.getInstance().getConnection();
        Invoice invoice = new Invoice();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select * from Invoices\n" +
                    "where id = (select invoice_id  from payments where id = ?);");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                invoice.setId(resultSet.getLong("id"));
                invoice.setTaxAmount(resultSet.getDouble("tax_amount"));
                invoice.setTotalAmount(resultSet.getDouble("total_amount"));


            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }

        return invoice;
    }
}
