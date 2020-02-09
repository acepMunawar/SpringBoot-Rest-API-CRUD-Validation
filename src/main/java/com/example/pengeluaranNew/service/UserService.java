package com.example.pengeluaranNew.service;

import java.util.List;

import com.example.pengeluaranNew.domain.User;
import com.example.pengeluaranNew.repository.UserRepository;
import com.example.pengeluaranNew.vo.UserRequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getList() {
        List<User> listUser = userRepository.findAll();

        return listUser;
    }

    // getlist buat ambil data

    public String add(UserRequestVO vo) {
        User user = new User();
        user.setName(vo.getName());
        user.setAddress(vo.getAddress());
        user.setPhone(vo.getPhone());
        user.setEmail(vo.getEmail());

        userRepository.saveAndFlush(user);

        return "Success";
    }

    public String delete(String uuid) {
        User pengeluaran = userRepository.findByUuid(uuid);
        userRepository.delete(pengeluaran);
        return "Delete";
    }

    public User edit(UserRequestVO vo, String uuid) {
        User user = userRepository.findByUuid(uuid);
        user.setName(vo.getName());
        user.setAddress(vo.getAddress());
        user.setPhone(vo.getPhone());
        user.setEmail(vo.getEmail());

        userRepository.saveAndFlush(user);
        User result = userRepository.saveAndFlush(user);
        return result;
    }

}