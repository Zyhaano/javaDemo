package com.bangcle;

import com.bangcle.User;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface UserService {
  @WebMethod
  public String getName(@WebParam(name = "userId") String userId);
  @WebMethod
  public User getUser(String userId);

}
