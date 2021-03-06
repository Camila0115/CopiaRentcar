package com.ciclo3.usa.ciclo3.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.ciclo3.usa.ciclo3.model.Reservation;


@Repository
public class reservationgeRepository {

    @Autowired
    private reservationCrudRepository ReservationCrudRepository;

    public List<Reservation> getAllReservation() {
        return (List<Reservation>) ReservationCrudRepository.findAll();
    }
    public Optional<Reservation> getReservation(int id) {
        return ReservationCrudRepository.findById(id);
    }
    public Reservation saveReservation(Reservation reservation) {
        return ReservationCrudRepository.save(reservation);
    }
    public void deleteReservation(Reservation reservation){
        ReservationCrudRepository.delete(reservation);
    }
    
    public List<Reservation> ReportReservationsDate(Date dateOne, Date dateTow){
        return ReservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(dateOne, dateTow);
    }
    public List<Reservation> ReportCantState(String estado){
        return ReservationCrudRepository.findAllByStatus(estado);
    }
    
    public List<Object[]> ReportClient(){
        return ReservationCrudRepository.countClientsReport();
    }

}
