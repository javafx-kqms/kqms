package hnist.javafx.kqms.bg.controller;

import hnist.javafx.kqms.bg.mapper.KaoqinMapper;
import hnist.javafx.kqms.pojo.Kaoqin;

import java.util.Date;

public class KaoqinController {

    static private final KaoqinMapper kaoqinMapper = MapperGenerator.getKaoqinMapper();

    static public boolean getKaoqinIfExistByDateAndSection(Date date, byte courseSection) {
        return kaoqinMapper.getKaoqinIfExistByDateAndSection(date, courseSection);
    }

    static public void addKaoqin(Kaoqin kaoqin) {
        kaoqinMapper.addKaoqin(kaoqin);
    }
}
