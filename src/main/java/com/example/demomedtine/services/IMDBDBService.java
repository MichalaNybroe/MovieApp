package com.example.demomedtine.services;

import com.example.demomedtine.repositories.DBManager;
import com.example.demomedtine.repositories.Movie;

import java.sql.*;
import java.util.ArrayList;

public class IMDBDBService {
    public static String findColumnValueFromQuery(String query, String columnlabel) {
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                return resultSet.getString(columnlabel);
            //connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Movie> getMoviesFromQuery(String query) {
        ArrayList<Movie> movies = new ArrayList<>();

        Connection c = DBManager.getConnection();
        PreparedStatement preparedStatement;

        String title;
        String year;
        int length;
        String subject;
        int popularity;
        String awards;

        try {
            preparedStatement = c.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                resultSet.getInt("ID");
                title = resultSet.getString("title");
                year = resultSet.getString("year");
                length = resultSet.getInt("length");
                subject = resultSet.getString("subject");
                popularity = resultSet.getInt("popularity");
                awards = resultSet.getString("awards");

                movies.add(new Movie(title, year, length, subject, popularity, awards));
            }
            return movies;
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return movies;
    }

    public static int countAwards(String query) {
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement;

        try {
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return 0;
    }

    public static Movie advanced(String title, String year, int length, String subject, int popularity, String awards) {
        String insert = "INSERT INTO movies(title, year, length, subject, popularity, awards)";
        insert += " VALUES (?,?,?,?,?,?)";
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1,title);
            preparedStatement.setString(2,year);
            preparedStatement.setInt(3,length);
            preparedStatement.setString(4,subject);
            preparedStatement.setInt(5,popularity);
            preparedStatement.setString(6,awards);
            preparedStatement.executeUpdate();

            return new Movie(title, year, length, subject, popularity, awards);
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return null;

        /*
        String insert = "INSERT INTO movies(title, year, length, subject, popularity, awards) VALUES (?,?,?,?,?,?)";
        Connection connection;
        PreparedStatement statement;
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(insert);
            statement.setString(1,"Sorrow, The");
            statement.setString(2,"1990");
            statement.setInt(3,100);
            statement.setString(4,"Drama");
            statement.setInt(5,35);
            statement.setString(6,"Yes");
            statement.executeUpdate();
        } catch (SQLException err) {
            err.printStackTrace();
        }
         */
    }

    public static String displayComediesThatWon(String query) {
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString(1);
            }
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return null;
    }
}
