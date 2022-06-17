package com.example.piG1.Repository;
import com.example.piG1.Model.Entity.Booking;
import com.example.piG1.Model.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface IBookingRepository extends JpaRepository<Booking,Integer> {
    @Query("select b from Booking b where " +
            "start_date <= :startDate AND end_date >= :endDate")
    List<Booking> findByDatesBetween(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);
}
