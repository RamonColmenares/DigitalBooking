package com.example.piG1.Model.DTO.BookingDTO;

import com.example.piG1.Model.DTO.ProductDTO.ProductDTO;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookingCompliteDTO {
    private Integer id;
    private Date startDate;
    private Date endDate;
    private ProductDTO product;
}
