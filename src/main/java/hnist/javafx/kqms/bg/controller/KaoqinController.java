package hnist.javafx.kqms.bg.controller;

import hnist.javafx.kqms.bg.mapper.KaoqinMapper;
import hnist.javafx.kqms.pojo.Kaoqin;

import java.util.Date;

public class KaoqinController {

    KaoqinMapper kaoqinMapper = MapperGenerator.getKaoqinMapper();

    public boolean getKaoqinIfExistByDateAndSection(Date date, byte courseSection) {
        return kaoqinMapper.getKaoqinIfExistByDateAndSection(date, courseSection);
    }

    public void addKaoqin(Kaoqin kaoqin) {
        kaoqinMapper.addKaoqin(kaoqin);
    }
}
