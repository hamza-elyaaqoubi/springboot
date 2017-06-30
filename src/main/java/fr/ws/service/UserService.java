package fr.ws.service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import fr.ws.ConnectDb;
import fr.ws.bean.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<User> getUsers() {
        List<User> users = new ArrayList<User>();
        DBCollection table = ConnectDb.getInstance().getCollection("users");

        return buildUsersFromDB(table.find());
    }

    public List<User> addUser(String name, String age) {
        List<User> users = new ArrayList<User>();
        DBCollection table = ConnectDb.getInstance().getCollection("users");
        BasicDBObject document = new BasicDBObject();
        document.put("name", name);
        document.put("age", age);
        table.insert(document);

        return buildUsersFromDB(table.find());
    }

    public List<User> removeUser(String id) {
        List<User> users = new ArrayList<User>();
        DBCollection table = ConnectDb.getInstance().getCollection("users");

        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("_id", new ObjectId(id));
        table.remove(searchQuery);

        return buildUsersFromDB(table.find());
    }

    public boolean removeAll() {
        try {
            DBCollection table = ConnectDb.getInstance().getCollection("users");
            table.drop();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private List<User> buildUsersFromDB(DBCursor dbCursor) {
        List<User> users = new ArrayList<User>();
        List<DBObject> dbObjects = dbCursor.toArray();
        for (DBObject dbo : dbObjects) {
            users.add(mongoTemplate.getConverter().read(User.class, dbo));
        }
        return users;
    }
}
