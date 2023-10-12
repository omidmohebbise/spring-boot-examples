package com.omidmohebbise.sp.modulith.order.service;

import com.omidmohebbise.sp.modulith.order.model.Order;
import com.omidmohebbise.sp.modulith.order.model.OrderItem;
import com.omidmohebbise.sp.modulith.order.model.repository.OrderJpaRepository;
import com.omidmohebbise.sp.modulith.order.service.dto.OrderDTO;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class OrderService
//        implements ApplicationListener<OrderService.NewPerson>
{

    private final OrderJpaRepository repository;
//    private final ApplicationEventPublisher applicationEventPublisher;


    private final EntityManager entityManager;
    @Transactional
    public Order addOrder(OrderDTO newOrder) {
        var orderItems = newOrder.orderItems().stream().map(orderItem ->
                new OrderItem(orderItem.id(), orderItem.title())).toList();
        var order = new Order(newOrder.customerFullName(), newOrder.description(), orderItems);
        entityManager.merge(order);
       return repository.save(order);

    }

//    @Override
//    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
//    public void onApplicationEvent(NewPerson event) {
//        System.out.println("*** new person added" + event.toString());
//    }


//    @Getter
//    public static class NewPerson extends ApplicationEvent {
//        private final Long id;
//        private final String fullName;
//
//        public NewPerson(OrderItem source) {
//            super(source);
//            this.id = source.getId();
//            this.fullName = source.getName() + " " + source.getFamily();
//        }
//
//
//    }


}
