package com.harmonycloud.framework.adapter.inbound.ws;

import com.alibaba.fastjson.JSON;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import javax.xml.namespace.QName;

public class WebServiceClient {
    public static void main(String[] args) {
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://127.0.0.1:8080/soap/user?wsdl");
        // url为调用webService的wsdl地址
        QName name = new QName("http://com.harmonycloud.framework.adapter.outbound.cxf", "getUser");
        // namespace是命名空间，methodName是方法名
        String xmlStr = "aaaaaaaa";
        // paramvalue为参数值
        Object[] objects;
        try {
            objects = client.invoke(name, xmlStr);
            System.out.println("返回数据:" + JSON.toJSONString(objects));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
