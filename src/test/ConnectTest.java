package test;

import java.sql.*;

public class ConnectTest {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Statement stmt;
		PreparedStatement prep;
		ResultSet rs;
		String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		  String dbURL="jdbc:sqlserver://localhost:1434;DatabaseName=sys_dormitory";
		  String userName="sa";
		  String userPwd="123456";
		  
		  try
		  {
		   Class.forName(driverName);
		   Connection conn=DriverManager.getConnection(dbURL,userName,userPwd);
		    System.out.println("连接数据库成功");
		    
		    //存储过程
		    /*
		    CallableStatement ic=conn.prepareCall("{call p_Idormitory(?,?,?)}");
            ic.setString(1, "10201");
            ic.setString(2, "879901");
            ic.setInt(3,4);
            ic.execute();
            System.out.println("添加成功");
            */
		    
		  //sql语句
            /*
            String sql="select * from student";
		    stmt=conn.createStatement();
		    rs=stmt.executeQuery(sql);
		    while(rs.next())
		    {
		    	int id=rs.getInt("Sno");
		    	String name=rs.getString("Sname");
		    	System.out.println("Sno:"+id+"\tSname:"+name);
		    }
		    */
		    
		    //防止注入的sq语句
		    String sql="select * from dormitory where dno=? ";
		    prep=conn.prepareStatement(sql);
		    prep.setString(1,"10205");
		    rs=prep.executeQuery();
		    while(rs.next())
		    {
		    	String name=rs.getString("dno");
		    	System.out.println("1");
		    	System.out.println("dno:"+name);
		    }
		    
		  }
		  catch(Exception e)
		  {
		   e.printStackTrace();
		   System.out.print("连接失败");
		  }    
	}

}
