package com.example;

import javax.annotation.sql.DataSourceDefinition;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@DataSourceDefinition(name = "java:global/jdbc/local-db", 
className = "com.mysql.cj.jdbc.MysqlDataSource",
serverName = "localhost", 
portNumber = 3306,
databaseName = "wrongMove",
user = "Ewen",
password = "ABCabc123!",
properties = {"useSSL=false"})
@ApplicationPath("wrongmove")
public class RestApplication extends Application {
    
}
