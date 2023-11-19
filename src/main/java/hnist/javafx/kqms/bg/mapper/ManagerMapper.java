package hnist.javafx.kqms.bg.mapper;

import org.apache.ibatis.annotations.Param;

public interface ManagerMapper {
    boolean login(@Param("username") String username, @Param("password") String password);
}
