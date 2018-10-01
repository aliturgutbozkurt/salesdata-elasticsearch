package com.turkninja.util;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Collections;
import java.util.List;

@Component
public class CsvUtil {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    public <T> List<T> loadObjectList(Class<T> type, String fileName) {
        try {
            File file = new ClassPathResource(fileName).getFile();
            CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
            MappingIterator<T> readValues =
                    new CsvMapper().readerWithTypedSchemaFor(type).with(bootstrapSchema).readValues(file);
            List<T> readAll = readValues.readAll();
            return readAll;
        } catch (Exception e) {
            logger.error("Error occurred while loading object list from file " + fileName, e);
            return Collections.emptyList();
        }
    }
}
