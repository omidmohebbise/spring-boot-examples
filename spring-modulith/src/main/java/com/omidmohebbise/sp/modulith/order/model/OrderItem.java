package com.omidmohebbise.sp.modulith.order.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "orderitems")
public class OrderItem {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String title;

    @ManyToOne(cascade = CascadeType.ALL)
    private Order order;

    public OrderItem(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}
