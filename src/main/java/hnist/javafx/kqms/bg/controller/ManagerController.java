package hnist.javafx.kqms.bg.controller;

import hnist.javafx.kqms.bg.mapper.ManagerMapper;

public class ManagerController {
    static private final ManagerMapper managerMapper = MapperGenerator.getManagerMapper();
    static public boolean login(String username, String password) {
        return managerMapper.login(username, password);
    }
}
