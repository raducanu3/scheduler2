package com.sda.scheduler2.service;

import com.sda.scheduler2.entity.User;
import com.sda.scheduler2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public User getById(Integer UserID) {
        Optional<User> optionalUser = userRepository.findById(UserID);
        try {
            return optionalUser.get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public void deleteUser(Integer UserID) {
        userRepository.deleteById(UserID);
    }

    public void updateUser(Integer UserID, String Username, String Password, String FirstName, String LastName,
                           Date BirthDate, Integer GrupId) {
        // getting the user from the database; with the old field values
        User updatedUser = new User();
        updatedUser.setIdUser(UserID);
        //Grup g = grupRepository.getById(GrupId);
        // setting the new username on the user
        updatedUser.setUsername(Username);
        updatedUser.setPassword(Password);
        updatedUser.setFirstName(FirstName);
        updatedUser.setLastName(LastName);
        updatedUser.setBirthDate(BirthDate);
        //updatedUser.setGrup(g);
        // persisting the new values in the database
        userRepository.save(updatedUser);
    }
    public void save(User user) {
        userRepository.save(user);
    }
}

