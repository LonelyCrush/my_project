package com.xzit.myself.d240816;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 该类用于：
 * </p>
 *
 * @author leizf
 * @since 2024-08-16 18:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

//    @JsonProperty(value = "Name")
    private String name;

    private Integer age;

//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @JsonSerialize(using = MySerializer.class)
    @JsonDeserialize(using = MyDeserializer.class)
    private LocalDateTime birthDate;

    private BigDecimal amount;
}
