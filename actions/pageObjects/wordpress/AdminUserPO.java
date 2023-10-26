package pageObjects.wordpress;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.admin.AdminUserPageUI;
import utilities.MySQLConnUtils;

public class AdminUserPO extends BasePage {

	private WebDriver driver;
	
	public AdminUserPO(WebDriver driver) {
		this.driver = driver;
	}

	public int getUserNumberAtUI() {
		waitForElementVisible(driver, AdminUserPageUI.USER_TOTAL_NUMBER_TEXT);
		String totalText = getElementText(driver, AdminUserPageUI.USER_TOTAL_NUMBER_TEXT);
		return Integer.parseInt(totalText.split(" ")[0]);
	}

	public int getUserNumberAtDB() {
		Connection conn = MySQLConnUtils.getMySQLConnection();
		Statement statement;
		List<Integer> totalUsers = new ArrayList<Integer>();
		try {
			statement = conn.createStatement();
			String sql = "SELECT * FROM wp_users"; 
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				int userId = rs.getInt(1);
				totalUsers.add(userId);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return totalUsers.size();
	}
	
	// PreparedStatement
	public boolean checkTotalRecordFromDB(String user_login, String role) {
		Connection conn = MySQLConnUtils.getMySQLConnection();
		String sql = "";
		if(role.equals("roleAdmin")){
			sql = "SELECT DISTINCT * FROM wp_users where user_login = ?";
		} else {
			sql = "SELECT * FROM wp_users where user_login = ?";
		}
		List<Integer> totalUsers = new ArrayList<Integer>();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, user_login);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				int userId = rs.getInt(1);
				totalUsers.add(userId);
			}
			if(totalUsers.size() == 1) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;

	}

}
