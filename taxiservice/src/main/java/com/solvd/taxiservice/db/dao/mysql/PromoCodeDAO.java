package com.solvd.taxiservice.db.dao.mysql;

import com.solvd.taxiservice.db.dao.IPromoCodeDAO;
import com.solvd.taxiservice.db.model.PromoCode;
import com.solvd.taxiservice.db.utils.DBConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PromoCodeDAO implements IPromoCodeDAO {

    private final static Logger LOGGER = LogManager.getLogger(PromoCode.class);

    private void executeQuery(String query, Object... params){

        Connection connection = DBConnectionPool.getInstance().getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                LOGGER.info(rowsAffected + " row affected in PromoCode table.");
            } else {
                LOGGER.info("No rows affected in PromoCode table");
            }

        } catch (SQLException e) {
            LOGGER.error(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }

    }

    private PromoCode queryGet(String query, Object... params) {

        Connection connection = DBConnectionPool.getInstance().getConnection();
        PromoCode promoCode = new PromoCode();
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            try(ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {

                    promoCode.setId(resultSet.getLong("id"));
                    promoCode.setCode(resultSet.getString("code"));
                    promoCode.setDiscount(resultSet.getDouble("discount"));
                    promoCode.setExpirationDate(resultSet.getDate("expiration_date"));


                }
            }

        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }
        return promoCode;

    }


    @Override
    public void create(PromoCode promoCode) {
        executeQuery("INSERT INTO Promo_codes (code,discount,expiration_date) VALUES (?,?,?)",promoCode.getCode(),promoCode.getDiscount(),promoCode.getExpirationDate());

    }

    @Override
    public PromoCode getById(long id) {

        Long rId = id;
        return queryGet("SELECT * FROM Promo_codes WHERE ID=?",rId);

    }

    @Override
    public void update(PromoCode promoCode) {
        executeQuery("UPDATE Promo_codes SET code=? discount=? expiration_date=? WHERE id = ?",promoCode.getCode(),promoCode.getDiscount(),promoCode.getExpirationDate(),promoCode.getId());

    }

    @Override
    public void delete(PromoCode promoCode) {
        executeQuery("DELETE FROM Promo_Codes WHERE id = ?",promoCode.getCode());

    }

    @Override
    public PromoCode getPromoCodeByTripId(long id) {

        Long rId = id;
        return queryGet("select * from Promo_codes where id = (select promo_id  from Trips where id = ?);",rId);

    }
}
