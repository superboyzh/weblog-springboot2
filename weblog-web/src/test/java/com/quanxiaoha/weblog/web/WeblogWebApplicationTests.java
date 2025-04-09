package com.quanxiaoha.weblog.web;

import com.quanxiaoha.weblog.common.domain.dos.UserDO;
import com.quanxiaoha.weblog.common.domain.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Slf4j
class WeblogWebApplicationTests {

//    @Test
//    void contextLoads() {
//    }
//
//    @Test
//    void testLog() {
//        log.info("这是一行 Info 级别日志");
//        log.warn("这是一行 Warn 级别日志");
//        log.error("这是一行 Error 级别日志");
//
//        // 占位符
//        String author = "犬小哈";
//        log.info("这是一行带有占位符日志，作者：{}", author);
//    }

    @Autowired
    private UserMapper userMapper;

    @Test
    void insertTest() {
        UserDO userDO = UserDO.builder()
                .username("zenghao")
                .password("123456")
                .createTime(new Date())
                .updateTime(new Date())
                .isDeleted(false)
                .build();
        userMapper.insert(userDO);
    }


    @Autowired
    private DataSource dataSource;

    @Test
    void testConnection() throws SQLException {
        try (Connection conn = dataSource.getConnection()) {
            assertTrue(conn.isValid(1)); // 验证连接有效性
        }
    }
}