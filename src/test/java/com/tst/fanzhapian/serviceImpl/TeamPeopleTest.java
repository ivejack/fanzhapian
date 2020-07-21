package com.tst.fanzhapian.serviceImpl;

import com.tst.fanzhapian.entity.TTeam;
import com.tst.fanzhapian.entity.TTeampeople;
import com.tst.fanzhapian.entity.TTeamproject;
import com.tst.fanzhapian.mapper.TTeamMapper;
import com.tst.fanzhapian.mapper.TTeampeopleMapper;
import com.tst.fanzhapian.mapper.TTeamprojectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TeamPeopleTest {
    @Autowired
    private TTeampeopleMapper tTeampeopleMapper;
    @Autowired
    private TTeamprojectMapper tTeamprojectMapper;
    @Autowired
    private TTeamMapper tTeamMapper;

    @Test
    public void test1(){
//        List<TTeampeople> myTeamPeople = tTeampeopleMapper.getMyTeamPeople("2");
//        myTeamPeople.forEach(System.out::println);
//        List<TTeamproject> myProject = tTeamprojectMapper.getMyProject("1");
//        myProject.forEach(System.out::println);
//        TTeam teamidByUserid = tTeamMapper.getTeamidByUserid("2");
//        System.out.println(teamidByUserid);
        tTeamMapper.getTeamList(null).forEach(System.out::println);
    }
}
