package Data.Access.Object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersonDetails_DAO 
{
	public static int insertPersonDetails(BeanOfPersonDetails person)
	{
		int updateNumber = 0;
		try
		{
			Connection con = connectToDataBase.dataBaseConnection();
			PreparedStatement ps = con.prepareStatement("INSERT INTO PERSONDETAILS VALUES(?,?,?,?,?)");
			ps.setString(1, person.getName());
			ps.setInt(2, person.getId());
			ps.setLong(3, person.getMobile());
			ps.setString(4, person.getGender());
			ps.setString(5, person.getHobbies()+" ");
			updateNumber = ps.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return updateNumber;
		
	}

}
