package com.example.piG1.Service.IService;

import com.example.piG1.Model.Booking;
import com.example.piG1.Model.BookingDTO;
import com.example.piG1.Service.ICheckId;
import com.example.piG1.Service.IServices;

public interface IBookingServices extends IServices<BookingDTO>, ICheckId<Booking> {
}
