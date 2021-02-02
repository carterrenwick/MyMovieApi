package com.mymovie.service;

import java.sql.SQLException;
import java.util.List;

import com.mymovie.dao.MovieDao;
import com.mymovie.model.Movie;

public class MovieService {

	private MovieDao movieDao;

	public MovieService() {
		movieDao = new MovieDao();
	}

	public List<Movie> getAllMovies() {
		return movieDao.getAllMovies();
	}

	public Movie createMovie(Movie movie) {
		movie.setId(getNewMovieId());
		try {
			movieDao.createMovie(movie);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		return movie;
	}

	public void updateMovie(Movie movie) {
		try {
			movieDao.updateMovie(movie);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public void deleteMovie(int id) {
		try {
			movieDao.deleteMovie(id);
		} catch(SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	private int getNewMovieId() {
		return movieDao.getNewMovieId();
	}

}
