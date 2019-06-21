dataSource {
	pooled = true
	driverClassName = "org.postgresql.Driver"
	username = "postgres"       //Development
	password = "postgres" //Development
	dialect = "org.hibernate.dialect.PostgreSQLDialect"
	properties {
		maxActive = 20
		minEvictableIdleTimeMillis=1800000
		timeBetweenEvictionRunsMillis=1800000
		numTestsPerEvictionRun=3
		testOnBorrow=true
		testWhileIdle=true
		testOnReturn=true
		validationQuery="SELECT 1"
	}
}
hibernate {
	cache.use_second_level_cache = true
	cache.use_query_cache = true
	cache.provider_class = 'org.hibernate.cache.EhCacheProvider'
}

environments {
	development {
		dataSource {
			url = "jdbc:postgresql://localhost:5432/auditlog"
			dbCreate = "update"
			driverClassName = "org.postgresql.Driver"
			username = "postgres"
			password = "postgres" //Development
		}
	}
	uat {
		dataSource {
			url = "jdbc:postgresql://localhost:5432/auditlog"
			dbCreate = "update"
			driverClassName = "org.postgresql.Driver"
			username = "postgres"
			password = "postgres" //Development
		}
	}
	production {
		dataSource {
			driverClassName = "org.postgresql.Driver"
			dbCreate = "update"
			url = "jdbc:postgresql://localhost:5432/auditlog"
			username = "postgres"
			password = "postgres" //Development
		}
	}
}
