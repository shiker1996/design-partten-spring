package com.example.designpattern.Visitor;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDataSource;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@RestController
public class VisitorController {

	@Resource
	VisitorGenerator visitorGenerator;
	@Resource
	ListVisitor listVisitor;

	@GetMapping("visitor")
	public String visitor(){
		try {
			System.out.println("Making root entries...");
			VDirectory rootdir = visitorGenerator.genDirectory("root");
			VDirectory bindir = visitorGenerator.genDirectory("bin");
			VDirectory tmpir = visitorGenerator.genDirectory("tmp");
			VDirectory usrdir = visitorGenerator.genDirectory("usr");
			rootdir.add(bindir);
			rootdir.add(tmpir);
			rootdir.add(usrdir);
			bindir.add(visitorGenerator.genFile("vi", 10000));
			bindir.add(visitorGenerator.genFile("latex", 20000));
			rootdir.accept(listVisitor);

			System.out.println("");
			System.out.println("Making user entries...");
			VDirectory yuki = visitorGenerator.genDirectory("yuki");
			VDirectory hanako = visitorGenerator.genDirectory("hanako");
			VDirectory tomura = visitorGenerator.genDirectory("tomura");
			usrdir.add(yuki);
			usrdir.add(hanako);
			usrdir.add(tomura);
			yuki.add(visitorGenerator.genFile("diary.html", 100));
			yuki.add(visitorGenerator.genFile("Composite.java", 200));
			hanako.add(visitorGenerator.genFile("memo.tex", 300));
			tomura.add(visitorGenerator.genFile("game.doc", 400));
			tomura.add(visitorGenerator.genFile("junk.mail", 500));
			rootdir.accept(listVisitor);

		} catch (FileTreatmentException e) {
			// TODO: handle exception
		}
		return "SUCCESS";
	}

	@RequestMapping("test")
	public void test(){
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		System.out.println("Done.");

		//
		// Then, we set up the PoolingDataSource.
		// Normally this would be handled auto-magically by
		// an external configuration, but in this example we'll
		// do it manually.
		//
		System.out.println("Setting up data source.");
		DataSource dataSource = setupDataSource("jdbc:mysql://localhost:3306/db");
		System.out.println("Done.");

		//
		// Now, we can use JDBC DataSource as we normally would.
		//
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;

		try {
			System.out.println("Creating connection.");
			conn = dataSource.getConnection();
			System.out.println("Creating statement.");
			stmt = conn.createStatement();
			System.out.println("Executing statement.");
			rset = stmt.executeQuery("select 1=1");
			System.out.println("Results:");
			int numcols = rset.getMetaData().getColumnCount();
			while(rset.next()) {
				for(int i=1;i<=numcols;i++) {
					System.out.print("\t" + rset.getString(i));
				}
				System.out.println("");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try { if (rset != null) rset.close(); } catch(Exception e) { }
			try { if (stmt != null) stmt.close(); } catch(Exception e) { }
			try { if (conn != null) conn.close(); } catch(Exception e) { }
		}
	}


	public static DataSource setupDataSource(String connectURI) {
		ConnectionFactory connectionFactory =
				new DriverManagerConnectionFactory(connectURI,null);
		PoolableConnectionFactory poolableConnectionFactory =
				new PoolableConnectionFactory(connectionFactory, null);
		ObjectPool<PoolableConnection> connectionPool =
				new GenericObjectPool<>(poolableConnectionFactory);
		poolableConnectionFactory.setPool(connectionPool);
		PoolingDataSource<PoolableConnection> dataSource =
				new PoolingDataSource<>(connectionPool);
		return dataSource;
	}
}
