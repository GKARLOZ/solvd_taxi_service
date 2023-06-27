package com.solvd.taxiservice.db.dao.mybatis;

import com.solvd.taxiservice.db.dao.IRideTypeDAO;
import com.solvd.taxiservice.db.dao.IVehicleDAO;
import com.solvd.taxiservice.db.model.RideType;
import com.solvd.taxiservice.db.model.Vehicle;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

public class RideTypeDAO implements IRideTypeDAO {

    private final static Logger LOGGER = LogManager.getLogger(RideTypeDAO.class);

    @Override
    public void create(RideType rideType) {

    }

    @Override
    public RideType getById(long id) {
        RideType rideType = null;

        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true)){

            IRideTypeDAO rideTypeDAO = session.getMapper(IRideTypeDAO.class);
            rideType = rideTypeDAO.getById(id);




        } catch (IOException e) {
            LOGGER.error(e);
        }

        return rideType;
    }

    @Override
    public void update(RideType rideType) {

    }

    @Override
    public void delete(RideType rideType) {

    }

    @Override
    public RideType getRideTypeByRideId(Long id) {
        RideType rideType = null;

        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true)){

            IRideTypeDAO rideTypeDAO = session.getMapper(IRideTypeDAO.class);
            rideType = rideTypeDAO.getRideTypeByRideId(id);




        } catch (IOException e) {
            LOGGER.error(e);
        }

        return rideType;
    }
}
