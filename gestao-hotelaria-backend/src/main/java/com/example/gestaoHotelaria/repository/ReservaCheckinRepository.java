package com.example.gestaoHotelaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestaoHotelaria.entity.ReservaCheckin;

@Repository
public interface ReservaCheckinRepository extends JpaRepository<ReservaCheckin, Long>{

}
