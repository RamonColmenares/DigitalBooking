package com.example.piG1.Service;

import com.example.piG1.Exceptions.ResourceNotFoundException;
import com.example.piG1.Model.*;
import com.example.piG1.Repository.IBookingRepository;
import com.example.piG1.Service.IService.IBookingServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServices implements IBookingServices {
    protected final static Logger logger = Logger.getLogger(BookingServices.class);


    @Autowired
    public IBookingRepository bookingRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public Booking checkId(Integer id) throws ResourceNotFoundException {
        Optional<Booking> booking = bookingRepository.findById(id);
        if (booking.isEmpty()) {
            throw new ResourceNotFoundException(messageError + id);
        }
        return booking.get();
    }

    @Override
    public BookingDTO save(BookingDTO bookingDTO) {
        Booking booking = mapper.convertValue(bookingDTO, Booking.class);
        bookingRepository.save(booking);
        if (bookingDTO.getId() == null){
            bookingDTO.setId(booking.getId());
            logger.info("Reserva registrada correctamente: "+ bookingDTO);
        }else{
            logger.info("Reserva actualizada correctamente: "+ bookingDTO);
        }
        return bookingDTO;
    }

    @Override
    public BookingDTO findById(Integer id) throws ResourceNotFoundException {
        Booking booking = checkId(id);
        BookingDTO bookingDTO = mapper.convertValue(booking, BookingDTO.class);
        logger.info("La busqueda fue exitosa: id " + id);
        return bookingDTO;
    }

    @Override
    public List<BookingDTO> findAll() {
        List<BookingDTO> bookingsDTO = new ArrayList<>();
        List<Booking> bookings = bookingRepository.findAll();
        for(Booking booking: bookings){
            bookingsDTO.add(mapper.convertValue(booking, BookingDTO.class));
        }
        bookingsDTO .sort(Comparator.comparing(BookingDTO::getId)); //
        logger.info("La busqueda fue exitosa: "+ bookings);
        return bookingsDTO;
    }

    @Override
    public void delete(Integer id) throws ResourceNotFoundException {
        checkId(id);
        bookingRepository.deleteById(id);
        logger.info("Se elimino la reserva correctamente con el id("+id+")");
    }
}
