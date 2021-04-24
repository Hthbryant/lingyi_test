package com.lingyi.common.utils;

import com.lingyi.entity.Player;
import org.apache.poi.hssf.usermodel.*;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Description
 * @Author v_thhuang
 * @Date 2021/4/23
 **/
public class ExcelUtil {

    public static void main(String[] args) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        Map<String, List<String>> player = getPlayer();
        String[] title = excelTitle();
        String date = df.format(new Date());
        createExcel(player,title,date);
    }

    /**
     * 初始化数据，将会被存储到excel表格中
     *
     * @return
     * @throws Exception
     */
    private static Map<String, List<String>> getPlayer() {
        List<Player> list = new ArrayList<Player>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd-HH-mm-ss");

        try {
            Player user1 = new Player(1001,"科比", 40, 3000);
            Player user2 = new Player(1002,"库里", 35, 2700);
            Player user3 = new Player(1003,"詹姆斯", 38,2800);

            list.add(user1);
            list.add(user2);
            list.add(user3);

            for (int i = 0; i < list.size(); i++) {
                ArrayList<String> members = new ArrayList<>();
                members.add(list.get(i).getId()+"");
                members.add(list.get(i).getName());
                members.add(list.get(i).getAge() + "");
                members.add(list.get(i).getPrice() + "");
                map.put(list.get(i).getId() + "", members);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }


    /**
     * 创建excel title
     */
    public static String[] excelTitle() {
        String[] strArray = { "编号", "姓名", "年龄", "薪资" };
        return strArray;
    }

    /**
     * @功能：手工构建一个简单格式的Excel
     */
    public static void createExcel(Map<String, List<String>> map, String[] strArray,String date) {
        // 第一步，创建一个webbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet("sheet1");
        sheet.setDefaultColumnWidth(20);// 默认列宽
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        HSSFRow row = sheet.createRow((int) 0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        // 创建一个居中格式
        //style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        // 添加excel title
        HSSFCell cell = null;
        for (int i = 0; i < strArray.length; i++) {
            cell = row.createCell((short) i);
            cell.setCellValue(strArray[i]);
            cell.setCellStyle(style);
        }

        // 第五步，写入实体数据 实际应用中这些数据从数据库得到,list中字符串的顺序必须和数组strArray中的顺序一致
        int i = 0;
        for (String str : map.keySet()) {
            row = sheet.createRow((int) i + 1);
            List<String> list = map.get(str);

            // 第四步，创建单元格，并设置值
            for (int j = 0; j < strArray.length; j++) {
                row.createCell((short) j).setCellValue(list.get(j));
            }

            // 第六步，将文件存到指定位置
            try {
                FileOutputStream fout = new FileOutputStream("D:/huang/excel/player_"+date+".xls");
                wb.write(fout);
                fout.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            i++;
        }
    }

}
