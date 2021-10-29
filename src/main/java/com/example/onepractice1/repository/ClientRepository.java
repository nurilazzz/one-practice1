package com.example.onepractice1.repository;

import com.example.onepractice1.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

}