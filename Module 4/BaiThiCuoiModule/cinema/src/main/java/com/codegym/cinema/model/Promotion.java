package com.codegym.cinema.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "promotions")
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tiêu đề không được để trống")
    private String title;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future(message = "Thời gian bắt đầu phải lớn hơn hiện tại")
    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future(message = "Thời gian kết thúc phải lớn hơn hiện tại")
    private LocalDate endDate;

    @Min(value = 10000, message = "Mức giảm giá phải lớn hơn 10.000 VNĐ")
    private Long discount;

    @NotBlank(message = "Chi tiết không được để trống")
    private String description;
}
