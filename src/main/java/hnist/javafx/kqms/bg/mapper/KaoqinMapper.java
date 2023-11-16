package hnist.javafx.kqms.bg.mapper;

import hnist.javafx.kqms.pojo.Kaoqin;

import java.util.Date;

public interface KaoqinMapper {

    boolean getKaoqinIfExistByDateAndSection(Date date, byte courseSection);

    void addKaoqin(Kaoqin kaoqin);
}
