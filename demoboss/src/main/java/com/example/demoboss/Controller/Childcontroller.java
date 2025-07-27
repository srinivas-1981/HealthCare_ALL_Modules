package com.example.demoboss.Controller;

import com.example.demoboss.Model.Child;
import com.example.demoboss.Services.childSevr;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class Childcontroller {
    @Autowired
    childSevr chser;
     @GetMapping("/get")
    public List<Child> gettingdeatils(){
        return chser.gettingdeatils();
    }
    @PostMapping("/post")
    public ResponseEntity<?> postValues( @RequestBody @Valid Child ch, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        return ResponseEntity.ok(chser.addchild(ch));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> Findbyid(@PathVariable("id") long id) {
        try {
            Child child = chser.FindChildById(id);
            return ResponseEntity.ok(child);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Child not found with ID: " + id);
        }
    }


    @PutMapping("/put/{id}")
    public ResponseEntity<?> updatesChild(@PathVariable("id") long id,  @RequestBody @Valid  Child child, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        try {
            Child updated = chser.updatesChild(id, child);
            return ResponseEntity.ok(updated);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Child not found for update with ID: " + id);
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletingchild(@PathVariable("id") long id){
         chser.deletePatientById(id);
        return new ResponseEntity<>("Child deleted successfully", HttpStatus.OK);
    }

}
