package demo.proxy;

public class AdminServiceImpl implements AdminService {
    @Override
    public void update() {
        System.out.println("修改");
    }

    @Override
    public Object find() {
        System.out.println("查看");
        return new Object();
    }
}
