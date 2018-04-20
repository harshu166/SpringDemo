package com.fico.demo.dal.exception;

public class ServiceException extends Exception {

  /**
   * 
   */
  private static final long serialVersionUID = 453115711084080405L;

  public ServiceException() {
    super();
  }

  public ServiceException(String message, Throwable cause) {
    super(message, cause);
  }

  public ServiceException(String message) {
    super(message);
  }

  public ServiceException(Throwable cause) {
    super(cause);
  }

}
