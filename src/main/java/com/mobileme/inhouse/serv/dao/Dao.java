package com.mobileme.inhouse.serv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.mobileme.inhouse.serv.api.HSRespPrefs;
import com.mobileme.inhouse.serv.utils.ResourceStore;

@Repository
public class Dao {

	private static Connection con = null;
	
	public static Connection getCon() throws NamingException, SQLException {
		if (con == null) {
		    DataSource datasource = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/PostgreSQLDS");
		    con = datasource.getConnection();
		}
		return con; 
	}
	
	public ResultSet getResultSet(String q) {
		try {
			PreparedStatement ps = getCon().prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return null;
	}

	public String getPrefValue(String name) {
		String res = null;
		ResultSet rs = getResultSet("select value from prefs where name = '"+name+"';");
		
		try {
			while (rs.next()) {
				res = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();			
		}
		return res;
	}
	
	public HSRespPrefs getPrefs() {
		HSRespPrefs res = new HSRespPrefs();
		res.setApiVersion(getPrefValue("api_version"));
		res.setCompanyinfo(getPrefValue("company_name"));;
		return res;
	}
	
	@PostConstruct
	public void tryInitDatabase() {
		System.out.println("tryInitDatabase");
		try {
			String q = "select count(1) from prefs;";
			
			PreparedStatement ps = getCon().prepareStatement(q);
			ps.executeQuery();
		} catch (Exception e) {
			System.out.println("error in select 1 = "+e.getMessage());
			// в случае ошибки - пересоздать все					
			String q2 = ResourceStore.getQuery("init/init.sql");
			try {
				PreparedStatement ps = getCon().prepareStatement(q2);
				ps.executeQuery();
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
		
	}
	
}
