package com.mymovie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mymovie.model.Movie;
import com.mymovie.util.H2DbUtil;

public class MovieDao {

	public List<Movie> getAllMovies() {
		List<Movie> data = new ArrayList<Movie>();
		String sql = "select * from movie order by id asc";
		try (Connection conn = H2DbUtil.getDbConn();
				Statement s = conn.createStatement();
				ResultSet rs = s.executeQuery(sql);) {
			while (rs.next()) {
				Movie m = new Movie();
				m.setId(rs.getInt("ID"));
				m.setTitle(rs.getString("TITLE"));
				m.setGenre(rs.getString("GENRE"));
				m.setRating(rs.getDouble("RATING"));
				m.setReleaseDate(rs.getDate("RELEASE_DATE"));
				data.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}

	public void createMovie(Movie movie) throws SQLException {
		String sql = "insert into movie (id,title,genre,rating,release_date) values(?,?,?,?,?)";

		Connection conn = H2DbUtil.getDbConn();
		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setInt(1, movie.getId());
		ps.setString(2, movie.getTitle());
		ps.setString(3, movie.getGenre());
		ps.setDouble(4, movie.getRating());
		ps.setDate(5, new java.sql.Date(movie.getReleaseDate().getTime()));

		ps.execute();

		ps.close();
		conn.close();
	}

	public void updateMovie(Movie movie) throws SQLException {
		String sql = "update movie set title = ?, genre = ?, rating = ?, release_date = ? where id = ?";

		Connection conn = H2DbUtil.getDbConn();
		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setString(1, movie.getTitle());
		ps.setString(2, movie.getGenre());
		ps.setDouble(3, movie.getRating());
		ps.setDate(4, new java.sql.Date(movie.getReleaseDate().getTime()));
		ps.setInt(5, movie.getId());

		ps.execute();

		ps.close();
		conn.close();
	}

	public void deleteMovie(int id) throws SQLException {
		String sql = "delete from movie where id = ?";

		Connection conn = H2DbUtil.getDbConn();
		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setInt(1, id);
		ps.execute();

		ps.close();
		conn.close();
	}

	public int getNewMovieId() {
		int newId = 0;
		String sql = "select MOVIE_SEQ.nextval from dual";
		try (Connection conn = H2DbUtil.getDbConn();
				Statement s = conn.createStatement();
				ResultSet rs = s.executeQuery(sql);) {
			while (rs.next()) {
				newId = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newId;
	}
}
