package com.harmonycloud.framework.adapter.outbound.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(targetNamespace = "http://com.harmonycloud.framework.adapter.outbound.cxf")
public interface UserService {
    @WebMethod
    public User getUser(@WebParam(name = "userId") String userId);

    @WebMethod
    @WebResult(name = "String", targetNamespace = "")
    public String getUserName(@WebParam(name = "userId") String userId);
}
