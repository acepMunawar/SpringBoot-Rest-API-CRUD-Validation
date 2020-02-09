
package com.example.pengeluaranNew.controller;

import java.util.List;

import com.example.pengeluaranNew.domain.Pengeluaran;
import com.example.pengeluaranNew.service.PengeluaranService;
import com.example.pengeluaranNew.vo.*;
import com.example.pengeluaranNew.util.RestUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pengeluaranku-service/api/v1/pengeluaran")
public class PengeluaranController {

    @Autowired
    PengeluaranService pengeluaranService;

    @GetMapping(value = "/list")
    @ResponseBody
    public ResponseEntity<ResultVO> getList() {
        List<Pengeluaran> listPengeluaran = pengeluaranService.getList();
        ResultVO resultVO = new ResultVO();
        resultVO.setResults(listPengeluaran);
        resultVO.setMessage("Pengeluaran berhasil di peroleh");
        resultVO.setStatus(200);

        return RestUtil.getJsonResponse(resultVO);

    }

    @PostMapping(value = "/add")
    @ResponseBody
    public ResponseEntity<ResultVO> add(@RequestBody PengeluaranRequestVO vo) {
        String result = pengeluaranService.add(vo);
        ResultVO resultVO = new ResultVO();
        resultVO.setResults(result);
        resultVO.setMessage("Pengeluaran berhasil di simpan");
        resultVO.setStatus(200);

        return RestUtil.getJsonResponse(resultVO);

    }

    @DeleteMapping(value = "/delete")
    @ResponseBody
    public ResponseEntity<ResultVO> delete(@RequestParam(value = "uuid") String uuid) {
        String result = pengeluaranService.delete(uuid);
        ResultVO resultVO = new ResultVO();
        resultVO.setResults(result);
        resultVO.setMessage("Pengeluaran berhasil di hapus");
        resultVO.setStatus(200);
        return RestUtil.getJsonResponse(resultVO);
    }

    @PutMapping(value = "/edit")
    @ResponseBody
    public ResponseEntity<ResultVO> edit(@RequestParam(value = "uuid") String uuid,
            @RequestBody PengeluaranRequestVO vo) {
        Pengeluaran result = pengeluaranService.edit(vo, uuid);
        ResultVO resultVO = new ResultVO();
        resultVO.setResults(result);
        resultVO.setMessage("Pengeluaran berhasil di edit");
        resultVO.setStatus(200);
        return RestUtil.getJsonResponse(resultVO);
    }

}