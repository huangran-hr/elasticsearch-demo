package com.example.elasticsearch.demo.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@Document(indexName = "ems", shards = 1, replicas = 0)
public class DocBean {

    @Id
    private Long id;

    @Field(type = FieldType.Keyword)
    private String firstCode;

    @Field(type = FieldType.Keyword)
    private String secordCode;

    @Field(type = FieldType.Text)
    private String content;

    @Field(type = FieldType.Integer)
    private Integer type;

    @Field(type = FieldType.Keyword)
    private List<String> codes;

    @Field(type = FieldType.Object)
    private List<ChildBean> childBeans;

    public DocBean(Long id,String firstCode,String secordCode,String content,Integer type,List<String> codes,List<ChildBean> childBeans){
        this.id=id;
        this.firstCode=firstCode;
        this.secordCode=secordCode;
        this.content=content;
        this.type=type;
        this.codes=codes;
        this.childBeans=childBeans;
    }
}
