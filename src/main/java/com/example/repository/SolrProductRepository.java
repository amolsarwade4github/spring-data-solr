package com.example.repository;

import com.example.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import java.util.List;

public interface SolrProductRepository extends SolrCrudRepository<Product, String> {

    List<Product> findByName(String name);

    @Query("id:*?0* OR name:*?0*")
    Page<Product> findByCustomQuery(String searchItem, Pageable pageable);

    @Query(name = "Product.findByNamedQuery")
    Page<Product> findByNamedQuery(String searchItem, Pageable pageable);

}
