package hnist.javafx.kqms.bg.controller;

import hnist.javafx.kqms.bg.mapper.KaoqinMapper;
import hnist.javafx.kqms.bg.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MapperGenerator {

    private static final SqlSession sqlSession = init();

    private static SqlSession init() {
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        return sqlSessionFactory.openSession(true);
    }

    public static StudentMapper getStudentMapper() {
        return sqlSession.getMapper(StudentMapper.class);
    }

    public static KaoqinMapper getKaoqinMapper() {
        return sqlSession.getMapper(KaoqinMapper.class);
    }
}
