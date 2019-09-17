package hk.health.framework.adapter.outbound.ws;

import org.springframework.stereotype.Component;

import javax.jws.WebService;

@WebService(serviceName = "UserService",//对外发布的服务名
        targetNamespace = "com.harmonycloud.framework.adapter.outbound.cxf",//指定你想要的名称空间，通常使用使用包名反转
        endpointInterface = "hk.health.framework.adapter.outbound.ws.UserService")
//服务接口全路径, 指定做SEI（Service EndPoint Interface）服务端点接口
@Component
public class UserServiceImpl implements UserService {
    @Override
    public User getUser(String userId) {
        User user = new User();
        user.setUserId(userId);
        user.setEmail("shuyoupeng@harmonycloud.cn");
        user.setUserName("彭书友");
        return user;
    }

    @Override
    public String getUserName(String userId) {

        return userId;
    }
}
