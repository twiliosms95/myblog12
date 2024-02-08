package com.myblog.myblog12.payload;

import lombok.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorDetails {
    private String message;
    private Date date;
    private String uri;

}
