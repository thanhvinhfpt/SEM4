package com.example.demo.service.imp;

import com.example.demo.entity.Sale;
import com.example.demo.repository.SaleRepository;
import com.example.demo.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServiceImp  implements SaleService {
    @Autowired
    private SaleRepository saleRepository;
    @Override
    public List<Sale> getSales() {
        return saleRepository.findAll();
    }
}
