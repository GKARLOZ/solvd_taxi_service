package com.solvd.taxiservice.db.dao.mybatis;

import com.solvd.taxiservice.db.dao.IDriverLicenseDAO;
import com.solvd.taxiservice.db.dao.IVehicleDAO;
import com.solvd.taxiservice.db.model.DriverLicense;
import com.solvd.taxiservice.db.model.Vehicle;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

public class DriverLicenseDAO implements IDriverLicenseDAO {

    private final static Logger LOGGER = LogManager.getLogger(DriverLicenseDAO.class);

    @Override
    public void create(DriverLicense driverLicense) {

        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true)){

            session.getMapper(IDriverLicenseDAO.class).create(driverLicense);

        } catch (IOException e) {
            LOGGER.error(e);
        }


    }

    @Override
    public DriverLicense getById(long id) {
        DriverLicense driverLicense = null;

        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true)){

            IDriverLicenseDAO driverLicenseDAO = session.getMapper(IDriverLicenseDAO.class);
            driverLicense = driverLicenseDAO.getById(id);


        } catch (IOException e) {
            LOGGER.error(e);
        }

        return driverLicense;
    }

    @Override
    public void update(DriverLicense driverLicense) {

        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true)){

            session.getMapper(IDriverLicenseDAO.class).update(driverLicense);

        } catch (IOException e) {
            LOGGER.error(e);
        }

    }

    @Override
    public void delete(DriverLicense driverLicense) {

    }

    @Override
    public DriverLicense getDLByUserId(long id) {

        DriverLicense driverLicense = null;

        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true)){

            IDriverLicenseDAO driverLicenseDAO = session.getMapper(IDriverLicenseDAO.class);
            driverLicense = driverLicenseDAO.getDLByUserId(id);


        } catch (IOException e) {
            LOGGER.error(e);
        }

        return driverLicense;
    }

    @Override
    public DriverLicense getDLByLicenseNumber(String licenseNumber) {
        return null;
    }

    @Override
    public DriverLicense createAndGet(DriverLicense driverLicense) {

        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true)){

            session.getMapper(IDriverLicenseDAO.class).createAndGet(driverLicense);

        } catch (IOException e) {
            LOGGER.error(e);
        }return driverLicense;
    }
}
