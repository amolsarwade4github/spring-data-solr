package com.example.config;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@Configuration
@EnableSolrRepositories(
        basePackages = "com.example.repository",
        namedQueriesLocation = "classpath:solr-named-queries.properties")
@ComponentScan
public class SolrConfig {

    @Value("${spring.data.solr.host}")
    protected String solrUrl;

    @Bean
    public SolrClient solrClient() {
        return new HttpSolrClient.Builder(solrUrl).build();
    }

    @Bean
    public SolrTemplate solrTemplate(SolrClient client) {
        return new SolrTemplate(client);
    }

}
