package com.solvd.taxiservice.db.service.mybatisimple;

import com.solvd.taxiservice.db.dao.*;
import com.solvd.taxiservice.db.model.Ride;
import com.solvd.taxiservice.db.model.User;
import com.solvd.taxiservice.db.service.IRideService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class RideServiceMB implements IRideService {

    private final static Logger LOGGER = LogManager.getLogger(UserServiceMB.class);


    @Override
    public void create(Ride ride) {


        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true)){

            //session.getMapper(IRideDAO.class).create(ride);


        } catch (IOException e) {
            LOGGER.error(e);
        }

    }

    @Override
    public Ride getById(long id) {
        Ride ride = null;

        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true)){

            ride = session.getMapper(IRideDAO.class).getById(id);

        } catch (IOException e) {
            LOGGER.error(e);
        }

        return ride;
    }

    @Override
    public void update(Ride ride) {

        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true)){

            session.getMapper(IRideDAO.class).update(ride);

        } catch (IOException e) {
            LOGGER.error(e);
        }


    }

    @Override
    public void delete(Ride ride) {

        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true)){

            session.getMapper(IRideDAO.class).delete(ride);

        } catch (IOException e) {
            LOGGER.error(e);
        }



    }


    @Override
    public List<Ride> getRideByUserId(long userId) {
    return null;
    }

    @Override
    public Ride getRideByTripId(long id) {
        return null;
    }
}
