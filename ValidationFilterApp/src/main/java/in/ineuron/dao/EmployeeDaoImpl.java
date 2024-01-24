package in.ineuron.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.ineuron.dto.Employee;

public class EmployeeDaoImpl implements IEmployeeDao {

	@Override
	public String insert(Employee employee) {
		final String sqlQuery="INSERT INTO employee(id, name, age,mail,mobile) VALUES (?,?,?,?,?);";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcsessions","root","Maru@841");
			if(connection!=null) {
				PreparedStatement ps=connection.prepareStatement(sqlQuery);
				if(ps!=null) {
					ps.setString(1,employee.getEid());
					ps.setString(2, employee.getEname());
					ps.setInt(3, employee.getEage());
					ps.setString(4, employee.getEmail());
					ps.setString(5, employee.getMobile());
					int rowsEffected=ps.executeUpdate();
					System.out.println("Rows Effected;"+rowsEffected);
					if(rowsEffected==1) {
						return "success";
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			return "failure";
	}
	
}
