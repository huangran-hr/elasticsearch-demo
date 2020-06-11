package com.example.elasticsearch.demo.controller;

import com.example.elasticsearch.demo.bean.ChildBean;
import com.example.elasticsearch.demo.bean.DocBean;
import com.example.elasticsearch.demo.service.IElasticService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Log4j2
@RestController
@RequestMapping("/elastic")
public class ElasticController {

    @Autowired
    private IElasticService elasticService;

    @GetMapping("/init")
    public void init(){
//        elasticService.createIndex();
        List<DocBean> list =new ArrayList<>();
        List<String> codes = new ArrayList<String>();
        codes.add("code1");
        codes.add("code2");

        List<String> codes1 = new ArrayList<String>();
        codes.add("code3");
        codes.add("code4");

        List<String> codes2 = new ArrayList<String>();
        codes.add("code5");
        codes.add("code6");

        List<ChildBean> childBeans = new ArrayList<ChildBean>();
        for (int i=0; i<3 ; i++){
            ChildBean childBean = new ChildBean();
            childBean.setFirstInfo("firstInfo" + i);
            childBean.setSecordInfo("secordInfo" + i);
            List<String> childCodes = new ArrayList<String>();
            childCodes.add("childCode"+i);
            childCodes.add("childCode"+i+1);
            childBean.setCodes(childCodes);
            childBeans.add(childBean);
        }

        list.add(new DocBean(1L,"111","sec_111","内容111",1,codes,childBeans));
        list.add(new DocBean(2L,"222","sec_222","内容222",1,codes1,childBeans));
        list.add(new DocBean(3L,"333","sec_333","内容333",1,codes2,childBeans));
        elasticService.saveAll(list);

    }

    @GetMapping("/all")
    public Iterator<DocBean> all(){
        return elasticService.findAll();
    }

    @GetMapping("/content/{content}")
    public Page<DocBean> getByContent(@PathVariable("content") String content){
        Page<DocBean> docBean =  elasticService.findByContent(content);
        return docBean;
    }

    @GetMapping("/firstCode/{firstCode}")
    public Page<DocBean> getByFirstCode(@PathVariable("firstCode") String firstCode){
        Page<DocBean> docBean =  elasticService.findByFirstCode(firstCode);
        return docBean;
    }

}
