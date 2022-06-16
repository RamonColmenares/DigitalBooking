package com.example.piG1.Controller;

import com.example.piG1.Exceptions.ResourceNotFoundException;
import com.example.piG1.Model.DTO.BookingDTO.BookingCompliteDTO;
import com.example.piG1.Model.DTO.BookingDTO.BookingDTO;
import com.example.piG1.Model.DTO.ProductDTO.ProductAddBookingDTO;
import com.example.piG1.Model.Entity.Booking;
import com.example.piG1.Service.IService.IBookingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/bookings")
@CrossOrigin(origins = "*")
public class BookingController {
    @Autowired
    IBookingServices iBookingServices;

    @GetMapping
    public ResponseEntity<List<BookingDTO>> findAll(){
        return ResponseEntity.ok(iBookingServices.findAll());
    }

    @PostMapping
    public ResponseEntity<BookingDTO> save(@RequestBody BookingDTO bookingDTO){
        if(bookingDTO.getId() == null)
            return ResponseEntity.status(HttpStatus.CREATED).body(iBookingServices.save(bookingDTO));
        else
            return ResponseEntity.ok(iBookingServices.save(bookingDTO));
    }

    @PostMapping ("/add")
    public ResponseEntity<BookingCompliteDTO> addBookings (@RequestBody ProductAddBookingDTO productAddBookingDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(iBookingServices.addBooking(productAddBookingDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws ResourceNotFoundException {
        iBookingServices.delete(id);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingDTO> findById(@PathVariable Integer id) throws ResourceNotFoundException {
        return ResponseEntity.ok(iBookingServices.findById(id));
    }

    @GetMapping("/findByDate")
    public ResponseEntity<List<BookingDTO>> findByDate(
            @RequestParam(name = "startDate", required = false, defaultValue = "#{new.java.util.Date()}") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam(name = "finalDate", required = false, defaultValue = "#{new.java.util.Date()}") @DateTimeFormat(pattern = "yyyy-MM-dd") Date finalDate) throws ResourceNotFoundException {
        return ResponseEntity.ok(iBookingServices.findBeetwenTwoDates(startDate, finalDate));
    }
}
