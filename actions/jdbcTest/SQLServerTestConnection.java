package jdbcTest;

import java.sql.Connection;
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
		Statement statement = conn.createStatement();

		String sql = "SELECT * FROM [automationtest].[dbo].[BRANCH];";
		String insertSql = "INSERT INTO [automationtest].[dbo].[BRANCH] ([ADDRESS],[CITY],[NAME],[STATE],[ZIP_CODE]) values ('35 Le Lai', 'Hồ Chí Minh', 'Autotest', 'HCM', '5500');";
		
		int rowCount = statement.executeUpdate(insertSql);
		System.out.println("Row Count affected = " + rowCount);
		
		// Thực thi câu lệnh SQL trả về đối tượng ResultSet.
		ResultSet rs = statement.executeQuery(sql);

		// Duyệt trên kết quả trả về
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
		// Đóng kết nối
		conn.close();
		System.out.println("---------- Closed connection ----------");
	}

}