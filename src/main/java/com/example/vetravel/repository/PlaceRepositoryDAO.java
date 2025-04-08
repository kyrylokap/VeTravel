package com.example.vetravel.repository;

import com.example.vetravel.models.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepositoryDAO extends JpaRepository<Place,Long> {
}
