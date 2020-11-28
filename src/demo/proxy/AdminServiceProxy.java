package demo.proxy;

public class AdminServiceProxy implements AdminService {

    private AdminService adminService;

    public AdminServiceProxy(AdminService adminService) {
        this.adminService = adminService;
    }

    @Override
    public void update() {
        adminService.update();
    }

    @Override
    public Object find() {
        return adminService.find();
    }
}
