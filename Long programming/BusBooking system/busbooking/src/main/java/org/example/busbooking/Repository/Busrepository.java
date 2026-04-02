package org.example.busbooking.Repository;

import org.example.busbooking.Entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Busrepository extends JpaRepository<Bus, Integer> {
}