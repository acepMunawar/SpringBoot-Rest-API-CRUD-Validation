
package com.example.pengeluaranNew.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.pengeluaranNew.domain.User;
import com.example.pengeluaranNew.service.UserService;
import com.example.pengeluaranNew.vo.UserRequestVO;
import com.example.pengeluaranNew.vo.UserResultVO;
import com.example.pengeluaranNew.util.UserRestUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pengeluaranku-service/api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/list")
    @ResponseBody
    public ResponseEntity<UserResultVO> getList() {
        List<User> listUser = userService.getList();
        UserResultVO resultVO = new UserResultVO();
        resultVO.setResults(listUser);
        resultVO.setMessage("User berhasil di peroleh");
        resultVO.setStatus(200);

        return UserRestUtil.getJsonResponse(resultVO);

    }

    @PostMapping(value = "/add")
    @ResponseBody
    public ResponseEntity<UserResultVO> add(@RequestBody UserRequestVO vo) {
        String result = userService.add(vo);
        UserResultVO resultVO = new UserResultVO();
        resultVO.setResults(result);
        resultVO.setMessage("User berhasil di simpan");
        resultVO.setStatus(200);

        return UserRestUtil.getJsonResponse(resultVO);

    }

    @DeleteMapping(value = "/delete")
    @ResponseBody
    public ResponseEntity<UserResultVO> delete(@RequestParam(value = "uuid") String uuid) {
        String result = userService.delete(uuid);
        UserResultVO resultVO = new UserResultVO();
        resultVO.setResults(result);
        resultVO.setMessage("User berhasil di hapus");
        resultVO.setStatus(200);
        return UserRestUtil.getJsonResponse(resultVO);
    }

    @PutMapping(value = "/edit")
    @ResponseBody
    public ResponseEntity<UserResultVO> edit(@RequestParam(value = "uuid") String uuid,
            @RequestBody UserRequestVO vo) {
        User result = userService.edit(vo, uuid);
        UserResultVO resultVO = new UserResultVO();
        resultVO.setResults(result);
        resultVO.setMessage("User berhasil di edit");
        resultVO.setStatus(200);
        return UserRestUtil.getJsonResponse(resultVO);
    }

}

  

