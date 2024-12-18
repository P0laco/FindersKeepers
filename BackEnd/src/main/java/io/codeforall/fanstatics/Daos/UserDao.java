package io.codeforall.fanstatics.Daos;

import io.codeforall.fanstatics.Daos.Interfaces.UserDaoInterface;
import io.codeforall.fanstatics.Models.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends GenericDao<User> implements UserDaoInterface {

    public UserDao() {
        super(User.class);
    }
}
