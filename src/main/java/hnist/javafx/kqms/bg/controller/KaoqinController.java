package hnist.javafx.kqms.bg.controller;

import hnist.javafx.kqms.bg.mapper.KaoqinMapper;
import hnist.javafx.kqms.pojo.Kaoqin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
public class KaoqinController {

    @Autowired
    KaoqinMapper kaoqinMapper;

    public boolean getKaoqinIfExistByDateAndSection(Date date, byte courseSection) {
        return kaoqinMapper.getKaoqinIfExistByDateAndSection(date, courseSection);
    }

    public void addKaoqin(Kaoqin kaoqin) {
        kaoqinMapper.addKaoqin(kaoqin);
    }
}
