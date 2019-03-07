package mx.com.axity.services.facade.impl;

import mx.com.axity.commons.to.LoginTO;
import mx.com.axity.commons.to.UserTO;
import mx.com.axity.model.UserDO;
import mx.com.axity.model.LoginDO;
import mx.com.axity.services.facade.IbecaFacade;
import mx.com.axity.services.service.IbecaService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Component
public class becaFacade implements IbecaFacade {

    @Autowired
    private IbecaService becaService;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public int operation(int num1, int num2) {
        int num3 = becaService.sum(num1,num2);
        num2 = becaService.minus(num3,num1);
        int num4 = becaService.multiplyX4(num2);
        return becaService.divideX4(num4);
    }
//--------------------------------------------------------------------------
// USERS
    @Override
    public List<UserTO> getAllUsers() {
        List<UserDO> userDOList = this.becaService.getAllUsers();

        Type userTOType = new TypeToken<List<UserTO>>() {}.getType();
        List<UserTO> result = this.modelMapper.map(userDOList, userTOType);

        return result;
    }

    @Override
    public void saveUser(UserTO userTO) {
        Type userDOType = new TypeToken<UserDO>() {}.getType();
        UserDO dataSafe = this.modelMapper.map(userTO,userDOType);
        this.becaService.saveUser(dataSafe);
    }

    @Override
    public void deleteUser(Long id) {
        this.becaService.deleteUser(id);
    }

    @Override
    public UserTO findUser(Long id) {
        UserDO resultDO = this.becaService.findUser(id);

        Type userTOType = new TypeToken<UserTO>() {}.getType();
        UserTO resultTO = this.modelMapper.map(resultDO, userTOType);
        return resultTO;
    }

    @Override
    public void updateUser(UserTO userTO) {
        Type userDOType = new TypeToken<UserDO>() {}.getType();
        UserDO dataSafe = this.modelMapper.map(userTO,userDOType);
        this.becaService.saveUser(dataSafe);
    }
//--------------------------------------------------------------------------
// LOGIN
    @Override
    public void saveLogin(LoginTO loginTO) {
        Type loginDOType = new TypeToken<LoginDO>() {}.getType();
        LoginDO dataSafe = this.modelMapper.map(loginTO,loginDOType);
        this.becaService.saveLogin(dataSafe);
    }

    @Override
    public void deleteLogin(Long id) {
        this.becaService.deleteLogin(id);
    }

    @Override
    public LoginTO findLogin(Long id) {
        LoginDO resultDO = this.becaService.findLogin(id);

        Type loginTOType = new TypeToken<LoginTO>() {}.getType();
        LoginTO resultTO = this.modelMapper.map(resultDO, loginTOType);
        return resultTO;
    }

    @Override
    public void updateLogin(LoginTO loginTO) {
        Type loginDOType = new TypeToken<LoginDO>() {}.getType();
        LoginDO dataSafe = this.modelMapper.map(loginTO,loginDOType);
        this.becaService.saveLogin(dataSafe);
    }
}
