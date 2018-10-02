package com.turkninja.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.turkninja.domain.saledata.SaleDataEntity;
import com.turkninja.repositories.SaleDataElasticRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BootstrapManager {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    SaleDataElasticRepository saleDataElasticRepository;

    @Value("${sales-data.csv.file.path}")
    private String saleDataCsvFilePath;



    private final CsvUtil csvUtil;

    public BootstrapManager(CsvUtil csvUtil) {
        this.csvUtil=csvUtil;
    }

    public void loadCsvSalesData() {

        List<SaleDataEntity> saleDatas = readCsvSalesDataFromFile(saleDataCsvFilePath);

        saleDataElasticRepository.deleteIndex("salesdata");

        for(SaleDataEntity saleData : saleDatas) {
            try {
                saleDataElasticRepository.index(saleData, "salesdata","salesdata");
            } catch (JsonProcessingException e) {
                logger.error("Error inedixing bean",saleData.getName());
            }
        }

        logger.info("{} sales Csv Data loaded successfully");
    }

    public List<SaleDataEntity> readCsvSalesDataFromFile(String filename){
        return csvUtil.loadObjectList(SaleDataEntity.class, filename);
    }
}
