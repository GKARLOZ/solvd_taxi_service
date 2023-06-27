package com.solvd.taxiservice.db.dao.mybatis;

import com.solvd.taxiservice.db.dao.IProfileDAO;
import com.solvd.taxiservice.db.dao.IVehicleDAO;
import com.solvd.taxiservice.db.model.Profile;
import com.solvd.taxiservice.db.model.Vehicle;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

public class VehicleDAO implements IVehicleDAO {

    private final static Logger LOGGER = LogManager.getLogger(VehicleDAO.class);

    @Override
    public void create(Vehicle vehicle) {

        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true)){

            session.getMapper(IVehicleDAO.class).create(vehicle);

        } catch (IOException e) {
            LOGGER.error(e);
        }

    }

    @Override
    public Vehicle getById(long id) {
        Vehicle vehicle = null;

        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true)){

            IVehicleDAO vehicleDAO = session.getMapper(IVehicleDAO.class);
            vehicle = vehicleDAO.getById(id);



        } catch (IOException e) {
            LOGGER.error(e);
        }

        return vehicle;
    }

    @Override
    public void update(Vehicle vehicle) {

        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true)){

            IVehicleDAO vehicleDAO = session.getMapper(IVehicleDAO.class);
            vehicleDAO.update(vehicle);

        } catch (IOException e) {
            LOGGER.error(e);
        }


    }

    @Override
    public void delete(Vehicle vehicle) {

    }


    @Override
    public Vehicle getVehicleByUserId(long id) {
        Vehicle vehicle = null;

        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true)){

            IVehicleDAO vehicleDAO = session.getMapper(IVehicleDAO.class);
            vehicle = vehicleDAO.getVehicleByUserId(id);



        } catch (IOException e) {
            LOGGER.error(e);
        }

        return vehicle;
    }

    @Override
    public Vehicle getVehicleByLicensePlate(String lp) {
        return null;
    }

    @Override
    public Vehicle createAndGet(Vehicle vehicle) {

        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true)){

            session.getMapper(IVehicleDAO.class).create(vehicle);

        } catch (IOException e) {
            LOGGER.error(e);
        }return vehicle;

    }
}
