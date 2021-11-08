package model.repository;

import model.bean.BenhAn;

import java.util.List;

public interface BenhAnRepo {
    List<BenhAn> findAll();

    BenhAn findById(String id);

    void update(BenhAn benhAn);

    void delete(String id);
}
