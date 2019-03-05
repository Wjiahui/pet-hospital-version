package com.cui.phs.controller;

import com.cui.phs.entity.CaseEntity;
import com.cui.phs.entity.DiseaseEntity;
import com.cui.phs.entity.ImageEntity;
import com.cui.phs.mapper.CaseMapper;
import com.cui.phs.mapper.DiseaseMapper;
import com.cui.phs.mapper.UserMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class UserControllerTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    @Autowired
    UserMapper userMapper;

    @Autowired
    DiseaseMapper diseaseMapper;

    @Autowired
    CaseMapper caseMapper;

    @Test
    public void test_userID_not_exist() {
        String name = "wwww";
        String nameMapper = userMapper.checkUsername(name);
        System.out.println(nameMapper);
    }

    @Test
    public void test_diseaseStudyID_not_exist(){
        int disease = 300;
        DiseaseEntity dis = diseaseMapper.findDisease(disease);
        ImageEntity image = diseaseMapper.findImage(disease);
        System.out.println(dis);
        System.out.println(image);
    }

    @Test
    public void test_invalid(){
        String name="123we";
        String nameMapper = userMapper.checkUsername(name);
        System.out.println(nameMapper);
        int disease = 00;
        DiseaseEntity dis = diseaseMapper.findDisease(disease);
        ImageEntity image = diseaseMapper.findImage(disease);
        System.out.println(dis.getDescription());
        System.out.println(image.getUrl());

    }

    @Test
    public void test_examination_not_exist(){
        int exam=100;
        List<CaseEntity> list = caseMapper.findCaseByDisease(exam);

    }

    @Test
    public void test_room_not_exist(){
        int roonNum=20;
        CaseEntity caseroom = caseMapper.findCase(roonNum);
        System.out.print(caseroom.getDescription());
    }
}