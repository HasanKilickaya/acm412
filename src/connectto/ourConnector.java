package connectto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class ourConnector {

	ArrayList<datamodel> dataContainer;
	
	 Connection connect = null;
     Statement statement = null;
     
     ResultSet resultSet = null;

	public ourConnector() {
		dataContainer=new ArrayList<datamodel>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			try {
				connect = DriverManager
				        .getConnection("jdbc:mysql://localhost/vizesonrasi?"
				                        + "user=root&password=qweqwe");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	public void insertItem(String topic,String content)
	{
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connect
			        .prepareStatement("insert into  vizesonrasi.first values (default, ?, ?)");
			preparedStatement.setString(1, "topic");
            preparedStatement.setString(2, "content");
            
            preparedStatement.executeUpdate();
            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//insertitem
	
	public ArrayList<datamodel> getitems()
	{
		ArrayList<datamodel> dummy=new ArrayList<datamodel>();
		try {
			PreparedStatement preparedStatement2 = connect
			        .prepareStatement("select * from vizesonrasi.first");
			resultSet = preparedStatement2.executeQuery();
			while(resultSet.next())
			{
				datamodel d=new datamodel();
				d.setTopic(resultSet.getString("topic"));
				d.setContent(resultSet.getString("content"));
				dummy.add(d);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dummy;
	}//getitems
}
