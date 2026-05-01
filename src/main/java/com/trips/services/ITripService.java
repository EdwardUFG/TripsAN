package com.trips.services;

import java.util.List;

import com.trips.models.Trip;

public interface ITripService {

    List<Trip> buscarTodos();
    Trip buscarPorId(Integer idTrip);
    
}
