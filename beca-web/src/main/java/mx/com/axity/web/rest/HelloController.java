package mx.com.axity.web.rest;

import io.swagger.annotations.Api;
import mx.com.axity.commons.to.UserTO;
import mx.com.axity.commons.to.LoginTO;
import mx.com.axity.model.UserDO;
import mx.com.axity.model.LoginDO;
import mx.com.axity.services.facade.IbecaFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
@RequestMapping("beca")
@Api(value="beca", description="Operaciones con beca")
public class HelloController {

    static final Logger LOG = LogManager.getLogger(HelloController.class);

    //@Autowired
    //RestTemplate restTemplate;

    @Autowired
    IbecaFacade IbecaFacade;
//--------------------------------------------------------------------------
// USERS
    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<UserTO>> getAllUsers() {
        LOG.info("Se invoca /users");
        List<UserTO> users = this.IbecaFacade.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/setUsers", method = RequestMethod.POST, produces = "application/json")
        public ResponseEntity<UserTO> saveUser(@RequestBody UserTO userTO) {
            LOG.info("Se invoca /setUsers");
            this.IbecaFacade.saveUser(userTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/deleteUsers", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<UserTO> deleteUser(@RequestParam Long id) {
        LOG.info("Se invoca /deleteUsers");
        this.IbecaFacade.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/findUsers", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<UserTO> findUser(@RequestParam Long id) {
        LOG.info("Se invoca /findUsers");
        UserTO user = this.IbecaFacade.findUser(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/updateUsers", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<UserTO> updateUser(@RequestBody UserTO userTO) {
        LOG.info("Se invoca /updateUsers");
        this.IbecaFacade.saveUser(userTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//--------------------------------------------------------------------------
// LOGIN

    @RequestMapping(value = "/setLogin", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<LoginTO> saveLogin(@RequestBody LoginTO loginTO) {
        LOG.info("Se invoca /setLogin");
        this.IbecaFacade.saveLogin(loginTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/deleteLogin", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<LoginTO> deleteLogin(@RequestParam Long id) {
        LOG.info("Se invoca /deleteLogin");
        this.IbecaFacade.deleteLogin(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/findLogin", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<LoginTO> findLogin(@RequestParam Long id) {
        LOG.info("Se invoca /findLogin");
        LoginTO login = this.IbecaFacade.findLogin(id);
        return new ResponseEntity<>(login, HttpStatus.OK);
    }

    @RequestMapping(value = "/updateLogin", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<LoginTO> updateLogin(@RequestBody LoginTO loginTO) {
        LOG.info("Se invoca /updateLogin");
        this.IbecaFacade.saveLogin(loginTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity test() {
        LOG.info("Se invoca /test");
        return new ResponseEntity<>("Prueba Ok", HttpStatus.OK);
    }

    @RequestMapping(value = "/operation", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity operation() {
        LOG.info("Se invoca /operation");
        int result = this.IbecaFacade.operation(5,10);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
