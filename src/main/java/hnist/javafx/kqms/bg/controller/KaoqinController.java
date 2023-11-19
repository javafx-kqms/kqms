package hnist.javafx.kqms.bg.controller;

import hnist.javafx.kqms.bg.mapper.KaoqinMapper;
import hnist.javafx.kqms.pojo.Kaoqin;

import java.util.Date;
import java.util.List;

public class KaoqinController {
    static private final KaoqinMapper kaoqinMapper = MapperGenerator.getKaoqinMapper();

    static public void addKaoqin(Kaoqin kaoqin) {
        kaoqinMapper.addKaoqin(kaoqin);
    }

    static public void deleteKaoqin(Kaoqin kaoqin) {
        kaoqinMapper.deleteKaoqin(kaoqin);
    }

    static public boolean getKaoqinIfExist(Date date, byte section, String studentNo) {
        return kaoqinMapper.getKaoqinIfExist(date, section, studentNo);
    }

    static public List<Kaoqin> getKaoqin(String courseName, String studentName) {
        return kaoqinMapper.getKaoqin(courseName, studentName);
    }
}
