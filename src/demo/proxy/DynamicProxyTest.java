package demo.proxy;

import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    public static void main(String[] args) {
        AdminService adminService = new AdminServiceImpl();
        AdminService proxy = (AdminService) Proxy.newProxyInstance(adminService.getClass().getClassLoader(),
                adminService.getClass().getInterfaces(),
                (proxy1, method, args1) -> method.invoke(adminService, args1));
        proxy.find();
        proxy.update();
    }
}
