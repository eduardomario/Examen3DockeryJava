package mx.com.axity.services.facade;

import mx.com.axity.commons.to.UserTO;
import mx.com.axity.commons.to.LoginTO;

import java.util.List;

public interface IbecaFacade {

    int operation(int num1, int num2);

    List<UserTO> getAllUsers();

    void saveUser(UserTO userTO);

    void deleteUser(Long id);

    UserTO findUser(Long id);

    void updateUser(UserTO userTO);

    void saveLogin(LoginTO loginTO);

    void deleteLogin(Long id);

    LoginTO findLogin(Long id);

    void updateLogin(LoginTO loginTO);
}
