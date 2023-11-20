package hnist.javafx.kqms.bg.mapper;

import hnist.javafx.kqms.pojo.Kaoqin;

import java.util.Date;
import java.util.List;

public interface KaoqinMapper {
    void addKaoqin(Kaoqin kaoqin);

    void addKaoqinByList(List<Kaoqin> list);

    void deleteKaoqin(Kaoqin kaoqin);

    boolean getKaoqinIfExist(Date date, byte section, String studentNo);

    List<Kaoqin> getKaoqin(String courseName, String studentName);
}
