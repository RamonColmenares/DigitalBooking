package com.example.piG1.model;
import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ImageDTO {
    public Integer id;
    public String title;
    public String url;
}
