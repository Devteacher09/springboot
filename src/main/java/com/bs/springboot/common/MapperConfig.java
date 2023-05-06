package com.bs.springboot.common;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.bs.springboot.model.mapper")
public class MapperConfig {}
