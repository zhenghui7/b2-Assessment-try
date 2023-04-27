package ibf2022.paf.assessment.server.models;

import org.springframework.jdbc.support.rowset.SqlRowSet;

// Do not change this class

public class User {

	private String userId;
	private String username;
	private String name;	//maybe to set name to "" first?

	public User() { }

	public String getUserId() { return this.userId; }
	public void setUserId(String userId) { this.userId = userId; }

	public String getUsername() { return this.username; }
	public void setUsername(String username) { this.username = username; }

	public String getName() { return this.name; }
	public void setName(String name) { this.name = name; }

	@Override
	public String toString() {
		return "user_id: %s, username: %s, name: %s"
				.formatted(userId, username, name);
	}

    public static User createFromRs(SqlRowSet rs) {
		User u = new User();
		// user_id, username, name
		u.setName(rs.getString("user_id"));
		u.setUserId(rs.getString("username"));
		u.setUsername(rs.getString("name"));
        return u;
    }
}
