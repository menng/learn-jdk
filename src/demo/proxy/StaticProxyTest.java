package demo.proxy;

public class StaticProxyTest {
    public static void main(String[] args) {
        AdminServiceImpl adminService = new AdminServiceImpl();
        AdminServiceProxy proxy = new AdminServiceProxy(adminService);
        proxy.update();
        proxy.find();
    }
}
