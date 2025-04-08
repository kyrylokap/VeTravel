package com.example.vetravel.services;

import com.example.vetravel.models.Place;
import com.example.vetravel.repository.PlaceRepositoryDAO;
import org.springframework.stereotype.Service;

@Service
public class PlaceService {
    private final PlaceRepositoryDAO placeRepositoryDAO;
    public PlaceService(PlaceRepositoryDAO placeRepositoryDAO){this.placeRepositoryDAO = placeRepositoryDAO;}

    public void addPlace(Place place){
        placeRepositoryDAO.save(place);
    }
    public void deletePlace(Place place){
        placeRepositoryDAO.delete(place);
    }
    public Place findPlace(Long id){
        return placeRepositoryDAO.findById(id).orElse(null);
    }

}
