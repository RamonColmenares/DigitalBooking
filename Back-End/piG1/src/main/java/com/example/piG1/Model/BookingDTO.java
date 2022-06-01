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
    public Integer id;
    public Date startDate;
    public Date endDate;
    public List<Product> products;
}
