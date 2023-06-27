package com.solvd.taxiservice.db.dao.mybatis;

import com.solvd.taxiservice.db.dao.*;
import com.solvd.taxiservice.db.model.Profile;
import com.solvd.taxiservice.db.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

public class ProfileDAO implements IProfileDAO {

    private final static Logger LOGGER = LogManager.getLogger(UserDAO.class);

    @Override
    public void create(Profile profile) {

        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true)){

            session.getMapper(IProfileDAO.class).create(profile);

        } catch (IOException e) {
            LOGGER.error(e);
        }



    }

    @Override
    public Profile getById(long id) {
        Profile profile = null;

        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true)){

            IProfileDAO profileDAO = session.getMapper(IProfileDAO.class);
            profile = profileDAO.getById(id);


        } catch (IOException e) {
            LOGGER.error(e);
        }

        return profile;
    }

    @Override
    public void update(Profile profile) {

        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true)){

            IProfileDAO profileDAO = session.getMapper(IProfileDAO.class);
            profileDAO.update(profile);



        } catch (IOException e) {
            LOGGER.error(e);
        }

    }

    @Override
    public void delete(Profile profile) {

    }

    @Override
    public Profile getProfileByUserId(long id) {
        Profile profile = null;

        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true)){

            IProfileDAO profileDAO = session.getMapper(IProfileDAO.class);
            profile = profileDAO.getProfileByUserId(id);


        } catch (IOException e) {
            LOGGER.error(e);
        }

        return profile;
    }

    @Override
    public Profile getProfileByName(String Name) {
        return null;
    }

    @Override
    public Profile createAndGet(Profile profile) {

        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true)){

            session.getMapper(IProfileDAO.class).create(profile);

        } catch (IOException e) {
            LOGGER.error(e);
        }return  profile;

    }
}
