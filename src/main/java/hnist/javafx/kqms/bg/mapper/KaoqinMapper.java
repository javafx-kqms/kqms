package hnist.javafx.kqms.bg.mapper;

import hnist.javafx.kqms.pojo.Kaoqin;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

@Mapper
public interface KaoqinMapper {

    boolean getKaoqinIfExistByDateAndSection(Date date, byte courseSection);

    void addKaoqin(Kaoqin kaoqin);
}
