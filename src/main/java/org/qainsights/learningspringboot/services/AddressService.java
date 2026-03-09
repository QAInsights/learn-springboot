package org.qainsights.learningspringboot.services;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.qainsights.learningspringboot.repositories.AddressRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressService {
    private AddressRepository addressRepository;

    private EntityManager entityManager;

    public void getAddressById() {

        var address = addressRepository.findById(3).orElseThrow();
        System.out.println(address.getCity());

    }

}
