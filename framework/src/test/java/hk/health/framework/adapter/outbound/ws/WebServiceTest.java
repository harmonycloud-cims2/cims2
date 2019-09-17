package hk.health.framework.adapter.outbound.ws;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebServiceTest {
    @Test
    public void cxf() {
        // 创建动态客户端
       /* JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://127.0.0.1:7739/soap/user?wsdl");
        // 需要密码的情况需要加上用户名和密码
        // client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME, PASS_WORD));
        Object[] objects = new Object[0];
        try {
            // invoke("方法名",参数1,参数2,参数3....);
            objects = client.invoke("getUser", "userId=45");

            System.out.println("返回数据:" + JSON.toJSONString(objects));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }*/
    }
}
