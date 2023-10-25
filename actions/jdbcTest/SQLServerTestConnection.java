package jdbcTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLServerTestConnection {

	public static Connection getMyConnection() throws SQLException, ClassNotFoundException {
		return SQLServerConnUtils.getSQLServerConnection();
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		System.out.println("Get connection... ");

		// Lấy ra đối tượng Connection kết nối vào database.
		Connection conn = SQLServerTestConnection.getMyConnection();

		System.out.println("Opened connection: " + conn);
		
		// Tạo ra 1 đối tượng của Statement
		Statement statement = conn.createStatement(); // Statement : create object

		String sql = "SELECT * FROM [automationtest].[dbo].[BRANCH];";
		String insertSql = "INSERT INTO [automationtest].[dbo].[BRANCH] ([ADDRESS],[CITY],[NAME],[STATE],[ZIP_CODE]) values ('35 Trần Cao Vân', 'HCM', 'Autotest', 'HCM', '5500');";
		String paramSql = "Select Emp_Id, First_Name, Title, Dept_Id from [automationtest].[dbo].[employee] where title like ? and dept_Id=?";
		String updateType = "ALTER TABLE [automationtest].[dbo].[BRANCH] ALTER COLUMN ADDRESS VARCHAR(50) ";
		
		statement.executeUpdate(updateType); // update affected = 0           //Statement : run query
		
		int rowCount = statement.executeUpdate(insertSql); //insert/delete affected = 1
		System.out.println("Row Count affected = " + rowCount);
		
		// Thực thi câu lệnh SQL trả về đối tượng ResultSet.
		ResultSet rs = statement.executeQuery(sql);   //select no affected
		while (rs.next()) {
			// Di chuyển con trỏ xuống bản ghi kế tiếp.
			int branchId = rs.getInt("Branch_Id");
			String address = rs.getString(2);
			String city = rs.getString("CITY");

			System.out.println("--------------------");
			System.out.println(branchId);
			System.out.println(address);
			System.out.println(city);
			System.out.println(rs.getString("name"));
			System.out.println(rs.getString("state"));
			System.out.println(rs.getString("zip_code"));
		}
		
		PreparedStatement pstm = conn.prepareStatement(paramSql); // PreparedStatement : create object + run query concurrency
		pstm.setString(1, "%ent");
		pstm.setInt(2, 3);
		
		 rs = pstm.executeQuery();

		// Duyệt trên kết quả trả về
		while (rs.next()) {
			System.out.println("-------------------- 2---");
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getInt(4));
		}
		// Đóng kết nối
		conn.close();
		System.out.println("---------- Closed connection ----------");
	}

}