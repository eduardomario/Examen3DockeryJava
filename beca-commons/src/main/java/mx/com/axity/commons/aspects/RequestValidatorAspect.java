package mx.com.axity.commons.aspects;

import mx.com.axity.commons.exceptions.BusinessException;
import mx.com.axity.commons.to.ErrorTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.NoSuchElementException;

@Aspect
@Configuration
public class RequestValidatorAspect {

    static final Logger LOG = LogManager.getLogger(RequestValidatorAspect.class);

    @Around(value = "execution(* mx.com.axity.web.rest.*.*(..))  && args(..)")
    public ResponseEntity execute(ProceedingJoinPoint joinPoint) {
        ResponseEntity result;
        try {
            LOG.info("Access");
            LOG.info(String.format("Execution: %s", joinPoint.getSignature()));
            result = (ResponseEntity) joinPoint.proceed();
            return result;
        }catch (Throwable e) {
            ErrorTO errorTO = new ErrorTO();
            if(e instanceof NoSuchElementException){
                errorTO.setErrorCode((long) 1);
                errorTO.setErrorMessage("Error 1: Error al Intentar encontrar Dato");
                //return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            else if(e instanceof NullPointerException){
                errorTO.setErrorCode((long) 2);
                errorTO.setErrorMessage("Error 2: Error Dato Nulo");
            }
            else{
                errorTO.setErrorCode((long) 3);
                errorTO.setErrorMessage("Error 3: Error en la Base de Datos");
            }
            LOG.info("Exception Ocurred");
            LOG.info("Execution: {}", joinPoint.getSignature());
            LOG.info("Exception: {}", e.getMessage());
            LOG.info("++++++++++++++++++");
            LOG.info(e.toString());
            return new ResponseEntity<>(errorTO, HttpStatus.OK);
            //throw new BusinessException("Error", e);
        }
    }
}
