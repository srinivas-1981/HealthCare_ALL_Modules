package com.example.demoboss.repositiry;

import com.example.demoboss.Model.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildRepository extends JpaRepository<Child,Long> {
}
