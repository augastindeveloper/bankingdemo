package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.AccountDetails;
@Repository
public interface  AccountDetailsRepository extends JpaRepository<AccountDetails, Long>{

}
