package com.solvd.taxiservice.db.dao.mysql;

import com.solvd.taxiservice.db.dao.interfaces.IInvoiceDAO;
import com.solvd.taxiservice.db.model.DriverLicense;
import com.solvd.taxiservice.db.model.Invoice;
import com.solvd.taxiservice.db.model.Ride;
import com.solvd.taxiservice.db.utils.DBConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InvoiceDAO implements IInvoiceDAO {

    private final static Logger LOGGER = LogManager.getLogger(Invoice.class);

    private void executeQuery(String query, Object... params){

        Connection connection = DBConnectionPool.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query);

            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                LOGGER.info(rowsAffected + " row affected in Invoices table.");
            } else {
                LOGGER.info("No rows affected in Invoices table");
            }

        } catch (SQLException e) {
            LOGGER.error(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }

    }

    private Invoice queryGet(String query, Object... params) {

        Connection connection = DBConnectionPool.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        Invoice invoice = new Invoice();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Invoices WHERE ID=?");

            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                invoice.setId(resultSet.getLong("id"));
                invoice.setTaxAmount(resultSet.getDouble("tax_amount"));
                invoice.setTotalAmount(resultSet.getDouble("total_amount"));



            }

        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }
        return invoice;

    }

    @Override
    public void create(Invoice invoice) {
        executeQuery("INSERT INTO Invoices (tax_amount,total_amount) VALUES (?,?)",invoice.getTaxAmount(),invoice.getTotalAmount());

    }

    @Override
    public Invoice getById(long id) {

        Long rId = id;
        return queryGet("SELECT * FROM Invoices WHERE ID=?",rId);

    }

    @Override
    public void update(Invoice invoice) {
        executeQuery("UPDATE Invoices SET tax_amount = ?, total_amount = ? WHERE id = ?", invoice.getTaxAmount(), invoice.getTotalAmount(),invoice.getId());

    }

    @Override
    public void delete(Invoice invoice) {
        executeQuery("DELETE FROM Invoices WHERE id = ?",invoice.getId());

    }

    @Override
    public Invoice getInvoiceByPaymentId(long id) {

        Long rId = id;
        return queryGet("select * from Invoices where id = (select invoice_id  from payments where id = ?);",rId);

    }
}
