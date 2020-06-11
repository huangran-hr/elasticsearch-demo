package com.example.elasticsearch.demo.dao;

import com.example.elasticsearch.demo.bean.DocBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ElasticRepository extends ElasticsearchRepository<DocBean, Long> {

    Page<DocBean> findByContent(String content, Pageable pageable);

    @Query("{\"match\": {\"firstCode\": {\"query\": \"?0\"}}}")
    Page<DocBean> findByFirstCode(String firstCode, Pageable pageable);

    @Query("{\"match\": {\"secordCode\": {\"query\": \"?0\"}}}")
    Page<DocBean> findBySecordCode(String secordCode, Pageable pageable);


}
