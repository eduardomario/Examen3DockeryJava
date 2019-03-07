package mx.com.axity.services.service;

import mx.com.axity.model.LoginDO;
import mx.com.axity.model.UserDO;

import java.util.List;
import java.util.Optional;

public interface IbecaService {

    int sum(int sum1, int sum2);

    int minus(int minus1, int minus2);

    int multiplyX4(int multiply1);

    int divideX4(int divide1);

    List<UserDO> getAllUsers();

    UserDO findUser(Long id);

    void saveUser(UserDO userDO);

    void deleteUser(Long id);

    void updateUser(UserDO userDO);

    LoginDO findLogin(Long id);

    void saveLogin(LoginDO loginDO);

    void deleteLogin(Long id);

    void updateLogin(LoginDO loginDO);
}
