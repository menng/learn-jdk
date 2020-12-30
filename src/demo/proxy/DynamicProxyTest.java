package demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    public static void main(String[] args) {
        // 保存代理类的字节码文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        // 方式1
        AdminService adminService = new AdminServiceImpl();
        AdminService proxy = (AdminService) Proxy.newProxyInstance(adminService.getClass().getClassLoader(),
                adminService.getClass().getInterfaces(),
                (proxy1, method, args1) -> method.invoke(adminService, args1));
        System.out.println(proxy.getClass());
        proxy.find();
        proxy.update();

        // 方式二
        AdminService adminService1 = new AdminServiceImpl();
        InvocationHandler invocationHandler = new AdminServiceInvocation(adminService1);
        AdminService personProxy = (AdminService) new AdminServiceDynamicProxy(adminService1, invocationHandler).getProxy();
        System.out.println(personProxy.getClass());
        personProxy.find();
        personProxy.update();


    }
}
