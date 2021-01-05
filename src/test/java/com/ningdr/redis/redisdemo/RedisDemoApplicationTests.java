package com.ningdr.redis.redisdemo;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;

import java.util.Set;

@SpringBootTest
class RedisDemoApplicationTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisDemoApplicationTests.class);

    private static final String SET1 = "set1";

    private static final String SET2 = "set2";

    @Autowired
    private SetOperations<String, Object> setOperations;

    @Autowired
    private RedisTemplate<?, ?> redisTemplate;

    @Test
    void contains() {
        setOperations.add(SET1, "aaa");
        Boolean bool = setOperations.isMember(SET1, "aaa");
        LOGGER.info("集合是否包含目标key：bool=[{}]", bool);
        Set<Object> members = setOperations.members(SET1);
        if (members != null) {
            for (Object obj : members) {
                LOGGER.info("集合成员：obj=[{}]", obj.toString());
            }
        }
    }

    @Test
    void difference() {

        setOperations.add(SET2, "ggg", "ccc", "ddd", "eee");
        setOperations.add(SET1, "bbb", "ccc", "ddd", "fff");
        Long num = setOperations.differenceAndStore(SET2, SET1, SET2);
        LOGGER.info("集合成员：num=[{}]", num);
        // 合并
        setOperations.unionAndStore(SET1, SET1, SET2);

        Set<Object> members = setOperations.members(SET2);
        if (members != null) {
            for (Object obj : members) {
                LOGGER.info("集合成员：obj=[{}]", obj.toString());
            }
        }

    }

}
