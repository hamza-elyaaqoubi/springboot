package fr.ws.service;

import fr.ws.bean.User;
import fr.ws.config.AfterSaleProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private AfterSaleProperties afterSaleProperties;

    public List<User> getUsers() {
        User user1 = new User(1, "Hamza", 20, afterSaleProperties.getVsa().getAuthorisedCountries(), afterSaleProperties.getCancel().getAuthorisedCountries());
        User user2 = new User(2, "Mimi", 30, afterSaleProperties.getVsa().getAuthorisedCountries(), afterSaleProperties.getCancel().getAuthorisedCountries());

        List<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);

        return users;
    }

    public List<User> addUser(String id, String name, String age) {
        List<User> users = getUsers();
        users.add(new User(Integer.valueOf(id), name, Integer.valueOf(age), afterSaleProperties.getVsa().getAuthorisedCountries(), afterSaleProperties.getCancel().getAuthorisedCountries()));
        return users;
    }

    public List<User> addUser(User user) {
        List<User> users = getUsers();
        users.add(user);
        return users;
    }

}
