package test;

import java.sql.*;

public class ConnectTest {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
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
		    System.out.println("�������ݿ�ɹ�");
		    
		    //�洢����
		    /*
		    CallableStatement ic=conn.prepareCall("{call p_Idormitory(?,?,?)}");
            ic.setString(1, "10201");
            ic.setString(2, "879901");
            ic.setInt(3,4);
            ic.execute();
            System.out.println("��ӳɹ�");
            */
		    
		  //sql���
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
		    
		    //��ֹע���sq���
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
		   System.out.print("����ʧ��");
		  }    
	}

}
