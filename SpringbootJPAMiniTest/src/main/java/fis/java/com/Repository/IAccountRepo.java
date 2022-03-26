package fis.java.com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fis.java.com.entity.Account;

@Repository
public interface IAccountRepo extends JpaRepository<Account, Long> {

}
