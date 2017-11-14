package com.tiksoft.shop.dao.repository;

import com.tiksoft.shop.dao.JdbcDao;
import com.tiksoft.shop.dao.model.Authority;
import com.tiksoft.shop.dao.model.User;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
@Transactional
public class UserRepositoryImpl extends JdbcDao implements UserRepository {

    private final String query = "SELECT u.id, u.phone_number, u.first_name, u.last_name, u.password, u.email, u.enabled, a.name role_name from core.user_authority ua\n" +
            "  INNER JOIN core.users u on ua.user_id=u.id\n" +
            "  INNER JOIN core.authority a on ua.authority_id=a.id";

    @Override
    public User findByUsername(String username) {
        List<User> userList = jdbcTemplate.query(query + " where u.phone_number=?", new Object[] {username}, new EmployeeMapExtractor());
        return !userList.isEmpty() ? userList.get(0) : null;
    }

    @Override
    public List<User> findAll() {
        List<User> userList = jdbcTemplate.query(query, new EmployeeMapExtractor());
        return userList;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public User findById(Long id) {
        List<User> userList = jdbcTemplate.query(query + " where u.id=?", new Object[] {id}, new EmployeeMapExtractor());
        return !userList.isEmpty() ? userList.get(0) : null;
    }

    private static class EmployeeMapExtractor implements ResultSetExtractor<List<User>> {
        @Override
        public List<User> extractData(ResultSet resultSet) throws SQLException {
            List<User> userList = new ArrayList<>();
            Map<Long, List<Authority>> map = new HashMap<>();
            while(resultSet.next()) {
                Long userId = resultSet.getLong("id");
                Authority authority = new Authority(resultSet.getString("role_name"));
                if (map.get(userId) == null) {
                    map.put(userId, new ArrayList<>());
                    userList.add(mapUser(resultSet));
                }
                map.get(userId).add(authority);
            }
            userList.forEach(user -> user.setAuthorities(map.get(user.getId())));
            return userList;
        }

        private User mapUser(ResultSet resultSet) throws SQLException {
            User user = new User();
            user.setId(resultSet.getLong("id"));
            user.setPassword(resultSet.getString("password"));
            user.setUsername(resultSet.getString("phone_number"));
            user.setFirstName(resultSet.getString("first_name"));
            user.setLastName(resultSet.getString("last_name"));
            user.setEmail(resultSet.getString("email"));
            user.setPhoneNumber(resultSet.getString("phone_number"));
            user.setEnabled(resultSet.getBoolean("enabled"));
            return user;
        }
    }
}
