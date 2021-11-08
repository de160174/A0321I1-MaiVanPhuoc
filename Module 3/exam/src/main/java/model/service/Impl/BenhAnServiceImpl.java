package model.service.Impl;

import model.bean.BenhAn;
import model.repository.BenhAnRepo;
import model.repository.Impl.BenhAnRepoImpl;
import model.service.BenhAnService;

import java.util.List;

public class BenhAnServiceImpl implements BenhAnService {
    private BenhAnRepo benhAnRepo=new BenhAnRepoImpl();
    @Override
    public List<BenhAn> findAll() {
        return this.benhAnRepo.findAll();
    }

    @Override
    public BenhAn findById(String id) {
        return this.benhAnRepo.findById(id);
    }

    @Override
    public void update(BenhAn benhAn) {
        this.benhAnRepo.update(benhAn);
    }

    @Override
    public void delete(String id) {
        this.benhAnRepo.delete(id);
    }
}
