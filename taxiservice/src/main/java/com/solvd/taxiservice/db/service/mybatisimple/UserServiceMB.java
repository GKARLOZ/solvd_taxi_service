package com.solvd.taxiservice.db.service.mybatisimple;

import com.solvd.taxiservice.db.dao.IDriverLicenseDAO;
import com.solvd.taxiservice.db.dao.IProfileDAO;
import com.solvd.taxiservice.db.dao.IUserDAO;
import com.solvd.taxiservice.db.dao.IVehicleDAO;
import com.solvd.taxiservice.db.model.*;
import com.solvd.taxiservice.db.service.IUserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;


public class UserServiceMB implements IUserService {

    private final static Logger LOGGER = LogManager.getLogger(UserServiceMB.class);

    @Override
    public void create(User user) {


        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true)){

            session.getMapper(IProfileDAO.class).create(user.getProfile());
            session.getMapper(IVehicleDAO.class).create(user.getVehicle());
            session.getMapper(IDriverLicenseDAO.class).create(user.getDriverLicense());
            session.getMapper(IUserDAO.class).create(user);


        } catch (IOException e) {
            LOGGER.error(e);
        }



    }


    @Override
    public User getById(long id) {

        User user = null;

        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true)){

            IUserDAO userDAO = session.getMapper(IUserDAO.class);
            user = userDAO.getById(id);


        } catch (IOException e) {
            LOGGER.error(e);
        }

        return user;

    }

    @Override
    public void update(User user) {

        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true)){

            IUserDAO userDAO = session.getMapper(IUserDAO.class);
            userDAO.update(user);

        } catch (IOException e) {
            LOGGER.error(e);
        }

    }

    @Override
    public void delete(User user) {

        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true)){

            session.getMapper(IUserDAO.class).delete(user);
            session.getMapper(IProfileDAO.class).delete(user.getProfile());
            session.getMapper(IVehicleDAO.class).delete(user.getVehicle());
            session.getMapper(IDriverLicenseDAO.class).delete(user.getDriverLicense());


        } catch (IOException e) {
            LOGGER.error(e);
        }

    }

    @Override
    public User getUserbyEmail(String email) {

        User user = null;

        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true)){

            IUserDAO userDAO = session.getMapper(IUserDAO.class);
            user = userDAO.getUserByEmail(email);


        } catch (IOException e) {
            LOGGER.error(e);
        }

        return user;
    }
}
