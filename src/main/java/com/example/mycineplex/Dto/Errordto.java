package com.example.mycineplex.Dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Data
@Builder

public class Errordto {
    private int errorcode;
    private String message;
    private Date erorrdate;
}
