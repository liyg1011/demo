package com.demo;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 导出excel工具类
 * TODO: 该工具类可优化
 */
public class ExportExcelUtils {

    /**
     * 导出excel数据
     * @param header excel头信息
     * @param body 数据，类型是实体类
     * @return excel文档
     */
    public static HSSFWorkbook byBean(LinkedHashMap<String, Object> header, List<Object> body) {
        List<Map> list = new ArrayList<>();
        for (Object object : body) {
            list.add(BeanToMapUtils.convertBean(object));
        }
        return byMap(header, list);
    }

    /**
     * 导出excel数据
     * @param header excel头信息
     * @param body 数据，类型是实体类
     * @return excel文档
     */
    public static HSSFWorkbook byMap(LinkedHashMap<String, Object> header, List<Map> body) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
        HSSFRow row = sheet.createRow(0);
        // 设置表头
        for (Map.Entry head : header.entrySet()) {
            createCell(row).setCellValue(head.getValue() == null ? "" : head.getValue() + "");
        }
        // 设置表体
        for (Map map : body) {
            row = createRow(sheet);
            for (Map.Entry head : header.entrySet()) {
                createCell(row).setCellValue(map.get(head.getKey()) == null ? "" : map.get(head.getKey()) + "");
            }
        }
        return workbook;
    }

    /**
     * 在某一个excel文档中添加数据
     * @param workbook 要添加的文档
     * @param header excel头信息
     * @param body 数据，类型是实体类
     * @return excel文档
     */
    public static HSSFWorkbook addeCell(HSSFWorkbook workbook, LinkedHashMap<String, String> header, Map body) {
        HSSFSheet sheet = (HSSFSheet) workbook.sheetIterator().next();
        // 设置表体
        HSSFRow row = createRow(sheet);
        for (Map.Entry head : header.entrySet()) {
            createCell(row).setCellValue(body.get(head.getKey()) == null ? "" : body.get(head.getKey()) + "");
        }
        return workbook;
    }

    /**
     * excel的一行
     * @param sheet 文件博
     * @return 结果
     */
    private static HSSFRow createRow(HSSFSheet sheet) {
        return sheet.createRow(sheet.getLastRowNum() + 1);
    }

    /**
     * excel的一格
     * @param row 行
     * @return 结果
     */
    private static HSSFCell createCell(HSSFRow row) {
        int t = row.getLastCellNum();
        if (t < 0) {
            return row.createCell(t + 1);
        } else {
            return row.createCell(t);
        }
    }

}
