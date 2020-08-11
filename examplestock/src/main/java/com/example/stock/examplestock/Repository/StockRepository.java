package com.example.stock.examplestock.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.stock.examplestock.Stock;

public interface StockRepository extends CrudRepository <Stock,Integer> {

}
