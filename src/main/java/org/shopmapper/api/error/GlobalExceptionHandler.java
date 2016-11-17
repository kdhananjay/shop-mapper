package org.shopmapper.api.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dhananjay Kumar.
 *
 *         Handle exceptions thrown by the application.
 *
 */

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
  private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(value = Exception.class)
  public String handleException(Exception exception) {
    exception.printStackTrace();
    logger.error("exception :" + exception.getMessage());
    return exception.getMessage();
  }

}
