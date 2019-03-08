package mx.com.axity.persistence;

import mx.com.axity.model.LoginDO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LoginDAO extends CrudRepository<LoginDO, Long> {

    List<LoginDO> findByUsername(String username);
}
