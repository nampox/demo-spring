package com.example.demosprinng.service;

import com.example.demosprinng.entity.Cart;
import com.example.demosprinng.entity.User;
import com.example.demosprinng.repository.CartRepository;
import com.example.demosprinng.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    CartRepository cartRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User createUser(User user){
        Cart cart = new Cart();
        cartRepository.save(cart);
        cart.setQuantityTotalProduct(0);
        cart.setTotalPrice(0);
        user.setCartId(cart.getId());
        return userRepository.save(user);
    }

    public String deleteUser(Long id){
        try {
            User user = userRepository.findById(id).get();
            userRepository.delete(user);
            return "Delete success";
        }
        catch (Exception exception){
            return "User ko con tai";
        }
    }

    public User update(User userUpdate){
        User user = userRepository.findById(userUpdate.getId()).get();
        user.setName(userUpdate.getName());
        user.setEmail(userUpdate.getEmail());
        user.setPhone(userUpdate.getPhone());
        userRepository.save(user);
        return user;
    }
}
