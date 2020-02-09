package com.example.pengeluaranNew.service;

import java.util.List;

import com.example.pengeluaranNew.domain.Pengeluaran;
import com.example.pengeluaranNew.repository.PengeluaranRepository;
import com.example.pengeluaranNew.vo.PengeluaranRequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PengeluaranService {

    @Autowired
    PengeluaranRepository pengeluaranRepository;

    public List<Pengeluaran> getList() {
        List<Pengeluaran> listPengeluaran = pengeluaranRepository.findAll();

        return listPengeluaran;
    }

    // getlist buat ambil data

    public String add(PengeluaranRequestVO vo) {
        Pengeluaran pengeluaran = new Pengeluaran();
        pengeluaran.setName(vo.getName());
        pengeluaran.setCode(vo.getCode());
        pengeluaran.setType(vo.getType());

        pengeluaranRepository.saveAndFlush(pengeluaran);

        return "Success";
    }

    public String delete(String uuid) {
        Pengeluaran pengeluaran = pengeluaranRepository.findByUuid(uuid);
        pengeluaranRepository.delete(pengeluaran);
        return "Delete";
    }

    public Pengeluaran edit(PengeluaranRequestVO vo, String uuid) {
        Pengeluaran pengeluaran = pengeluaranRepository.findByUuid(uuid);
        pengeluaran.setCode(vo.getCode());
        pengeluaran.setName(vo.getName());
        pengeluaran.setType(vo.getType());
        Pengeluaran result = pengeluaranRepository.saveAndFlush(pengeluaran);
        return result;
    }

}