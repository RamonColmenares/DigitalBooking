package com.example.piG1.Repository;
import com.example.piG1.Model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookingRepository extends JpaRepository<Booking,Integer> {
}
