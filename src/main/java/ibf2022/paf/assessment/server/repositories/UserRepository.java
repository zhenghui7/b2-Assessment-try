package ibf2022.paf.assessment.server.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import ibf2022.paf.assessment.server.models.User;
import static ibf2022.paf.assessment.server.repositories.DBQueries.*;

// TODO: Task 3
@Repository
public class UserRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Optional<User> findUserByUsername(String username) {

        List<User> users = new ArrayList<>();
        SqlRowSet rs = jdbcTemplate.queryForRowSet(FIND_USER_BY_USERNAME, username);
        while (rs.next()) {
            users.add(User.createFromRs(rs));
        }
        if (users.isEmpty()) {
            return Optional.empty();
        }
        User foundUser = users.get(0);
        return Optional.of(foundUser);
    }

    public String insertUser(User user) {

        String genUid = UUID.randomUUID().toString().substring(0, 8);

        boolean update = jdbcTemplate.update(INSERT_NEW_USER, genUid, user.getUsername(), user.getName()) > 0;
        return genUid;
    }
}
