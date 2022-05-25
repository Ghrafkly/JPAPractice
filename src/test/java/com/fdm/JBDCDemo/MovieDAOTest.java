package com.fdm.JBDCDemo;

import com.fdm.ConnectionPool;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MovieDAOTest {
    MovieDAO movieDAO;
    @Mock
    ConnectionPool mockConnPool;
    @Mock
    Connection mockConn;
    @Mock
    PreparedStatement mockPS;

    @BeforeEach
    void setUp() {
        movieDAO = new MovieDAO(mockConnPool);
        when(mockConnPool.getConnection()).thenReturn(mockConn);
    }

    @Test
    void test_persists_movie_into_database() throws SQLException {
        //Arrange
        when(mockConn.prepareStatement(anyString())).thenReturn(mockPS);
        int id = 50;
        String name = "Guys";
        double ticketPrice = -20;
        Movie testMovie = new Movie(id, name, ticketPrice);
        //Act
        movieDAO.insertMovie(testMovie);
        //Assert
        verify(mockConnPool).getConnection();
        verify(mockConn).prepareStatement(anyString());
        verify(mockPS).setString(1, testMovie.getName());
        verify(mockPS).setDouble(2, testMovie.getTicketPrice());
        verify(mockPS).executeUpdate();
        verify(mockConnPool).returnConnection(mockConn);
    }
}