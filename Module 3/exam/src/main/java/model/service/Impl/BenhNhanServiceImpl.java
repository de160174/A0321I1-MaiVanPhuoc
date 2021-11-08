package model.service.Impl;

import model.bean.BenhNhan;
import model.repository.BenhNhanRepo;
import model.repository.Impl.BenhNhanRepoImpl;
import model.service.BenhNhanService;

import java.util.List;

public class BenhNhanServiceImpl implements BenhNhanService {
    private BenhNhanRepo benhNhanRepo=new BenhNhanRepoImpl();
    @Override
    public List<BenhNhan> findAll() {
        return this.benhNhanRepo.findAll();
    }
}
