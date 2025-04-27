package com.practice.csvtojson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CsvToJson {

    @Autowired
    private RestTemplate restTemplate;

    public Map<String, Object> convertCsvToJson(boolean header) throws IOException {
        String csvFile = "src/main/resources/irisPredict128.csv";
//        String csvFile = "src/main/resources/string.csv";

//        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
//        String firstLine = reader.readLine(); // Read first line to detect delimiter
//        if (firstLine == null) {
//            reader.close();
//            throw new IOException("Empty CSV file.");
//        }
//        char delimiter = detectDelimiter(firstLine);
//        if (!header) {
//            reader.close();
//            reader = new BufferedReader(new FileReader(csvFile));
//        }
        List<List<Object>> instances = new ArrayList<>();
//        try (CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.builder().setDelimiter(delimiter).build())) {
        try (CSVParser csvParser = CSVParser.builder().setReader(reader).setFormat(CSVFormat.DEFAULT.builder().setSkipHeaderRecord(header).get())
            .get()) {
            for (CSVRecord record : csvParser) {
                List<Object> row = new ArrayList<>();
                for (String value : record) {
                    row.add(parseValue(value));
                }
                instances.add(row);
            }
        }
        Map<String, Object> result = new HashMap<>();
        
        instances.remove(0);
        result.put("instances", instances);
        System.out.println(result);
        return result;
    }

    public Map<String, Object> readJson(boolean header) throws StreamReadException, DatabindException, IOException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        InputStream inputStream = CsvToJson.class.getResourceAsStream("/jsonfile.json");
//        Reader reader = new InputStreamReader(inputStream);
//        if (inputStream == null) {
//            throw new RuntimeException("File not found");
//        }
//        Map<String, Object> jsonMap = objectMapper.readValue(reader, new TypeReference<Map<String, Object>>() {
//        });
//        System.out.println(jsonMap);
//        return jsonMap;

        Map<String, Object> map = new HashMap<>();
        map.put("names", Arrays.asList("sai", "teja"));
        JSONObject jsonObject = new JSONObject(map);
        RequestEntity<?> requestEntity = RequestEntity.post("http://abc.com").body(jsonObject);
        System.out.println(requestEntity);
        restTemplate.exchange(requestEntity, Object.class);
        return map;
    }

    private static char detectDelimiter(String firstLine) {
        if (firstLine.contains(",")) {
            return ',';
        } else if (firstLine.contains(";")) {
            return ';';
        } else if (firstLine.contains("\t")) {
            return '\t';
        }
        return ',';
    }

    private static Object parseValue(String value) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }
        if (value.matches("^-?\\d+$")) {
            return Integer.parseInt(value);
        }
        if (value.matches("^-?\\d*\\.\\d+$")) {
            return Double.parseDouble(value);
        }
        return value;
    }

//
//    public static void main(String[] args) {
//        String csvFile = "src/main/resources/irisPredict128.csv"; // Update with the actual file path
//        List<double[]> instances = new ArrayList<>();
//
//        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                String[] values = line.split(",");
//                double[] row = new double[values.length];
//                for (int i = 0; i < values.length; i++) {
//                    row[i] = Double.parseDouble(values[i]);
//                }
//                instances.add(row);
//            }
//            
//            ObjectMapper objectMapper = new ObjectMapper();
//            String jsonOutput = objectMapper.writeValueAsString(instances);
//            
//            System.out.println("{\"instances\":" + jsonOutput + "}");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
////        
////        List<List<String>> data = new ArrayList<>();
////
////        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
////            String line;
////            while ((line = br.readLine()) != null) {
////                String[] values = line.split(",");
////                List<String> row = new ArrayList<>();
////                for (String value : values) {
////                    row.add(value.trim());
////                }
////                data.add(row);
////            }
////
////            ObjectMapper objectMapper = new ObjectMapper();
////            String writeValueAsString = objectMapper.writeValueAsString(data);
////            Map<String, String> instances = new HashMap<>();
////            instances.put("instances", writeValueAsString);
////            System.out.println(instances);
////        } catch (Exception e) {
////            throw new RuntimeException("Error processing CSV", e);
////        }
//    }
}
