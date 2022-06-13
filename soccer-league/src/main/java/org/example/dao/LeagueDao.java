package org.example.dao;

import java.sql.SQLException;
import java.util.List;

import org.example.model.League;

public interface LeagueDao {

	
	public List<League>fetchAllLeagues()throws SQLException;
}
