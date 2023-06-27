package com.solvd.taxiservice.db.dao.mybatis;

import com.solvd.taxiservice.db.dao.IProfileDAO;
import com.solvd.taxiservice.db.dao.IReviewDAO;
import com.solvd.taxiservice.db.model.Profile;
import com.solvd.taxiservice.db.model.Review;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ReviewDAO implements IReviewDAO {

    private final static Logger LOGGER = LogManager.getLogger(ReviewDAO.class);

    @Override
    public void create(Review review) {

    }

    @Override
    public Review getById(long id) {
        Review review = null;

        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true)){

            IReviewDAO reviewDAO = session.getMapper(IReviewDAO.class);
            review = reviewDAO.getById(id);

        } catch (IOException e) {
            LOGGER.error(e);
        }

        return review;
    }

    @Override
    public void update(Review review) {

    }

    @Override
    public void delete(Review review) {

    }

    @Override
    public List<Review> getReviewsByRideId(long id) {

        List<Review> reviews = null;

        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true)){

            IReviewDAO reviewDAO = session.getMapper(IReviewDAO.class);
            reviews = reviewDAO.getReviewsByRideId(id);

        } catch (IOException e) {
            LOGGER.error(e);
        }

        return reviews;
    }
}
