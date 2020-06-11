package com.example.elasticsearch.demo.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class ChildBean {

    @Field(type = FieldType.Keyword)
    private String firstInfo;

    @Field(type = FieldType.Keyword)
    private String secordInfo;

    @Field(type = FieldType.Text)
    private List<String> codes;


    public ChildBean(String firstInfo, String secordInfo, List<String> codes){
        this.firstInfo=firstInfo;
        this.secordInfo=secordInfo;;
        this.codes=codes;
    }
}
