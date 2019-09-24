package com.sda.scheduler2.service;

import com.sda.scheduler2.entity.Grup;
import com.sda.scheduler2.repository.GrupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class GrupService {
    @Autowired
    private GrupRepository grupRepository;

    public List<Grup> getAllGrups() {
        return (List<Grup>) grupRepository.findAll();
    }

    public Grup getById(Integer GrupID) {
        Optional<Grup> optionalGrup = grupRepository.findById(GrupID);
        try {
            return optionalGrup.get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public void deleteGrup(Integer GrupID) {
        grupRepository.deleteById(GrupID);
    }

    public void updateUser(Integer GrupID, String GrupName) {
        // getting the user from the database; with the old field values
        Grup updatedGrup = new Grup();
        updatedGrup.setGrupID(GrupID);
        // setting the new username on the user
        updatedGrup.setGrupName(GrupName);

        // persisting the new values in the database
        grupRepository.save(updatedGrup);
    }
    public void save(Grup grup) {
        grupRepository.save(grup);
    }
}

