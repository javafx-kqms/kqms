package hnist.javafx.kqms.bg.controller;

import hnist.javafx.kqms.bg.mapper.ManagerMapper;

public class ManagerController {
    static private final ManagerMapper managerMapper = MapperGenerator.getManagerMapper();
    static public String getPasswordByUsername(String username) {
        return managerMapper.getPasswordByUsername(username);
    }
}
