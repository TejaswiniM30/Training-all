package com.trainings.profile;

import javax.sql.DataSource;

public interface DatabaseConfig {
	DataSource createDataSource();
}
