package com.solvd.taxiservice.db.mysql;

import com.solvd.taxiservice.db.dao.IDAO;
import com.solvd.taxiservice.db.dao.IPromoCodeDAO;
import com.solvd.taxiservice.db.model.PromoCode;
import com.solvd.taxiservice.db.utils.DBConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PromoCodeDAO implements IPromoCodeDAO {
    @Override
    public void create(PromoCode promoCode) {

    }

    @Override
    public PromoCode getById(long id) {

        Connection connection = DBConnectionPool.getInstance().getConnection();
        PromoCode promoCode = new PromoCode();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM promo_codes WHERE ID=?");
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                promoCode.setId(resultSet.getLong("id"));
                promoCode.setCode(resultSet.getString("code"));
                promoCode.setDiscount(resultSet.getDouble("discount"));
                promoCode.setExpirationDate(resultSet.getDate("expiration_date"));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }

        return promoCode;

    }

    @Override
    public void update(PromoCode promoCode) {

    }

    @Override
    public void delete(PromoCode promoCode) {

    }

    @Override
    public PromoCode getPromoCodeByTripId(long id) {
        Connection connection = DBConnectionPool.getInstance().getConnection();
        PromoCode promoCode = new PromoCode();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select * from Promo_codes\n" +
                    "where id = (select promo_id  from Trips where id = ?);");
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                promoCode.setId(resultSet.getLong("id"));
                promoCode.setCode(resultSet.getString("code"));
                promoCode.setDiscount(resultSet.getDouble("discount"));
                promoCode.setExpirationDate(resultSet.getDate("expiration_date"));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }

        return promoCode;



    }
}
