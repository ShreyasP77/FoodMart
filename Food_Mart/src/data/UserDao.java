package data;

import models.*;
import constants.Gender;
import service.OrderService;
import utils.IdGenerator;

import java.util.HashMap;

public class UserDao {

    private static UserDao userDao = null;

    private UserDao() {
    }

    public static UserDao getInstance(){
        if(userDao==null)
            userDao = new UserDao();
        return userDao;
    }

    private HashMap<Integer,User> userHashMap = new HashMap<>();
    private HashMap<Long,Integer> phoneNumberMap = new HashMap<>();
    private HashMap<String,Restaurant> restaurantNameMap = new HashMap<>();

    private User loggedInUser = null;//keeping logged in user, initially no user is logged in.

    public User registerUser (Long phone,String name,Long pinCode,Gender gender){
        if(phoneNumberMap.containsKey(phone)){
            User user = userHashMap.get(phoneNumberMap.get(phone));
            System.out.println("User Already exists with phone number"+ phone + "with user Id: "+user.getId()+"\n");
            return user;
        }

//      if a new user
        User user = new User(IdGenerator.getId(),phone,pinCode,name,gender);
        phoneNumberMap.put(phone, user.getId());
        System.out.println("Successfully created user with user id: "+ user.getId()+"\n");
        return user;
    }

    public User login(Long phone){
//        if the user is not registered.
        if (!phoneNumberMap.containsKey(phone)) {
            System.out.println("No user exists with ph number - "+phone+"\n");
            return null;
        }
//        if the user is registered user.
        User user = userHashMap.get(phoneNumberMap.get(phone));
        loggedInUser = user;
        System.out.println("Successfully logged in user with user id: "+user.getId()+"\n");

        return user;
    }
}
