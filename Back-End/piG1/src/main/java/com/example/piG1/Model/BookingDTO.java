package com.example.piG1.Model;
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
    public Date startDate;
    public Date endDate;
    private List<Product> products;
}
