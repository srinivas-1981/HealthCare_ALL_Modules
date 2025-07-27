package com.example.demoboss.Services;

import com.example.demoboss.Model.Child;
import com.example.demoboss.repositiry.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class childSevr {
    @Autowired
    ChildRepository s;
    public List<Child> gettingdeatils() {
        return s.findAll();
    }

    public Child addchild(Child ch) {
        return s.save(ch);
    }

    public Child FindChildById(long id) {
        return s.findById(id).orElse(null);
    }

    public Child updatesChild(long id, Child child) {
        Child existing = s.findById(id)
                .orElseThrow(() -> new RuntimeException("Child not found"));
        return s.save(child);

    }


    public String deletePatientById(Long id) {

            Child child = s.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Child with ID " + id + " not found"));
            s.delete(child);
        return "deleted Succfully";

    }


}
