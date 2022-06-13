package org.example.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.example.factory.MyConnectionFactory;
import org.example.model.League;

public class LeagueDaoImpl implements LeagueDao {
	
	private Connection connection;
	private ResultSet resultSet;
	private Statement statement;
	private List<League> list;

	
	{
		try {
			
			connection=MyConnectionFactory.getMyConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<League> fetchAllLeagues() throws SQLException {
		// TODO Auto-generated method stub
		list=new ArrayList<League>();
		statement=connection.createStatement();
		resultSet=statement.executeQuery("select * from league_table");
		while(resultSet.next())
		{
			list.add(new League(resultSet.getInt("year"), resultSet.getString("season"), resultSet.getString("title")));
		}
		return list;
	}

}
