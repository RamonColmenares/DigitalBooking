package com.example.piG1.Controller;

import com.example.piG1.Exceptions.ResourceNotFoundException;
import com.example.piG1.Model.DTO.BookingDTO.BookingCompliteDTO;
import com.example.piG1.Model.DTO.BookingDTO.BookingDTO;
import com.example.piG1.Model.DTO.ProductDTO.ProductAddBookingDTO;
import com.example.piG1.Service.IService.IBookingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
}
