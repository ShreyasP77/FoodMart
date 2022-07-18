package service;

import data.UserDao;
import models.Order;
import java.util.List;
public class OrderService {
    private static OrderService instance = null;

    private OrderService() {
    }

    public static OrderService getInstance(){
        if(instance==null)
            instance = new OrderService();
        return instance;
    }

    UserDao userDao = UserDao.getInstance();

    public Order placeOrder(String name,Integer quantity){
        if(quantity<=0){
            System.out.println("Invalids quantity\n");
            return null;
        }
        return userDao.placeOrder(name,quantity);
    }

    public List<Order> listOrders(){

        return userDao.listOrders();
    }
}
