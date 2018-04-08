package org.uclbrt.dao;

import org.uclbrt.entity.Daily;

public interface DailyMapper {
	Daily findAllDaily(int userId);
}
