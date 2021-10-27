package model.service.Impl;

import model.repository.AttachRepo;
import model.repository.Impl.AttachRepoImpl;
import model.service.AttachService;

import java.util.List;

public class AttachServiceImpl implements AttachService {
    private AttachRepo attachRepo=new AttachRepoImpl();
    @Override
    public List<model.bean.AttachService> findAll() {
        return this.attachRepo.findAll();
    }
}
