package com.omidmohebbise.sp.modulith.order.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "orders")
public class Order {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String customerFullName;
    private String description;
    private LocalDate orderDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<OrderItem> orderItems;

    public Order (String customerFullName, String description, List<OrderItem> orderItems){
        this.setOrderDate(LocalDate.now());
        this.setDescription(description);
        this.setCustomerFullName(customerFullName);
        orderItems.forEach(item->item.setOrder(this));
        this.setOrderItems(orderItems);
    }
}
