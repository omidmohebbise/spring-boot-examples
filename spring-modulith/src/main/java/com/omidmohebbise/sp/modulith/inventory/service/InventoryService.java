package com.omidmohebbise.sp.modulith.inventory.service;

import com.omidmohebbise.sp.modulith.inventory.model.Inventory;
import com.omidmohebbise.sp.modulith.inventory.model.repository.InventoryJpaRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
@RequiredArgsConstructor
public class InventoryService implements ApplicationListener<InventoryService.NewPerson> {

    private final InventoryJpaRepository repository;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Transactional
    public Inventory addPerson(String name, String family) {
        var person = repository.save(new Inventory(0L, name, family));
        applicationEventPublisher.publishEvent(new NewPerson(person));
        return person;
    }

    @Override
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void onApplicationEvent(NewPerson event) {
        System.out.println("*** new person added" + event.toString());
    }


    @Getter
    public static class NewPerson extends ApplicationEvent {
        private final Long id;
        private final String fullName;

        public NewPerson(Inventory source) {
            super(source);
            this.id = source.getId();
            this.fullName = source.getName() + " " + source.getFamily();
        }


    }


}
