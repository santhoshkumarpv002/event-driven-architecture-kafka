package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor@NoArgsConstructor@Data
public class OrderEvent {
    

private String orderStatus;
private String Message;
private Order order;

}
