package model.service.Impl;

import model.repository.Impl.ServiceRepoImpl;
import model.repository.ServiceRepo;
import model.service.Service;

import java.util.List;

public class ServiceImpl implements Service {
    private ServiceRepo serviceRepo=new ServiceRepoImpl();
    @Override
    public List<model.bean.Service> findAll() {
        return this.serviceRepo.findAll();
    }

    @Override
    public void create(model.bean.Service service) {
        this.serviceRepo.create(service);
    }
}
