package org.uclbrt.dao;

import java.util.List;

import org.uclbrt.entity.Daily;

public interface DailyMapper {
	List<Daily> getById(int userId);
	List<Daily> findAllDaily();
	List<Daily> findRecentDaily();
	List<Daily> findUserRecentDaily(int userId);
	List<String> getUserArchivesDate(int userId);
	
}
