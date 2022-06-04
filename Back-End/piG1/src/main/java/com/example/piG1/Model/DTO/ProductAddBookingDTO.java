package com.example.piG1.Model.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductAddBookingDTO {
    private Integer productId;
    private BookingDTO booking;
}
