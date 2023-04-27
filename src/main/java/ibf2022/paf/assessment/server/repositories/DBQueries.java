package ibf2022.paf.assessment.server.repositories;

public class DBQueries {
    public static final String FIND_USER_BY_USERNAME = "select * from user where username = ?;";
    public static final String INSERT_NEW_USER = """
        insert into user
        (user_id, username, name)    
        values 
        ( ? , ?, ?);
            """;

    public static final String INSERT_TASK = "INSERT INTO `task` (`description`, `priority`, `due_date`) VALUES ( ? , ?, ?);";
}
