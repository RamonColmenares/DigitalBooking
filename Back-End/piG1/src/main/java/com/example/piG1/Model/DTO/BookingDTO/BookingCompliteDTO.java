package com.example.piG1.Model.DTO.BookingDTO;

import com.example.piG1.Model.DTO.ProductDTO.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookingCompliteDTO {
    private Integer id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    private Time hour;
    private ProductDTO product;
}
