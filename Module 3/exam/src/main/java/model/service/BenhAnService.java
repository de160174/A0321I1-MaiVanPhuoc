package model.service;

import model.bean.BenhAn;

import java.util.List;

public interface BenhAnService {
    List<BenhAn> findAll();

    BenhAn findById(String id);

    void update(BenhAn benhAn);

    void delete(String id);
}
