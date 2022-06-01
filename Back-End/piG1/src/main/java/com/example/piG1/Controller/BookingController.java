package com.example.piG1.Controller;

import com.example.piG1.Exceptions.ResourceNotFoundException;
import com.example.piG1.Model.BookingDTO;
import com.example.piG1.Model.CategoryDTO;
import com.example.piG1.Service.BookingServices;
import com.example.piG1.Service.IService.ICategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    BookingServices bookingServices;

    @GetMapping
    public ResponseEntity<List<BookingDTO>> findAll(){
        return ResponseEntity.ok(bookingServices.findAll());
    }

    @PostMapping
    public ResponseEntity<BookingDTO> save(@RequestBody BookingDTO bookingDTO){
        if(bookingDTO.getId() == null)
            return ResponseEntity.status(HttpStatus.CREATED).body(bookingServices.save(bookingDTO));
        else
            return ResponseEntity.ok(bookingServices.save(bookingDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws ResourceNotFoundException {
        bookingServices.delete(id);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingDTO> findById(@PathVariable Integer id) throws ResourceNotFoundException {
        return ResponseEntity.ok(bookingServices.findById(id));
    }
}
