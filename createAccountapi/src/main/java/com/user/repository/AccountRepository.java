package com.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.user.entity.AccountEntity;
public interface AccountRepository  extends JpaRepository<AccountEntity, Long>{

	

	AccountEntity findByEmail(String email);
	
	Optional<AccountEntity> findByPhone (String phone);

}

//package com.user.repository;
//
//import com.user.entity.AccountEntity;
//import org.springframework.data.jpa.repository.JpaRepository;
//import java.util.Optional;
//
//public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
//    Optional<AccountEntity> findByEmail(String email);
//    Optional<AccountEntity> findByPhone(String phone);
//}
//
