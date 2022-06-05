package com.example.piG1.Service.IService;

import com.example.piG1.Exceptions.ResourceNotFoundException;
import com.example.piG1.Model.DTO.BookingDTO.BookingCompliteDTO;
import com.example.piG1.Model.Entity.Booking;
import com.example.piG1.Model.DTO.BookingDTO.BookingDTO;
import com.example.piG1.Model.DTO.ProductDTO.ProductAddBookingDTO;
import com.example.piG1.Service.ICheckId;

import java.util.List;

public interface IBookingServices extends  ICheckId<Booking> {
    public void saveBookings(List<Booking> bookingsList);
    BookingDTO save(BookingDTO bookingDTO);
    BookingDTO findById(Integer id) throws ResourceNotFoundException;
    List<BookingDTO> findAll();
    void delete(Integer id) throws ResourceNotFoundException;
    BookingCompliteDTO addBooking (ProductAddBookingDTO productAddBookingDTO);
}
