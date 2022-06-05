package com.example.piG1.Model.DTO.BookingDTO;
import lombok.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookingDTO {
    private Integer id;
    private Date startDate;
    private Date endDate;
//    private List<Product> products;
}
