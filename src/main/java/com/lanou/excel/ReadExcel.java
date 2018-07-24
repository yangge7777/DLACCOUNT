package com.lanou.excel;

import com.lanou.account.bean.Account;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MultipartDataSource;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 18/7/20.
 * ░░░░░░░░░░░░░░░░░░░░░░░░▄░░
 * ░░░░░░░░░▐█░░░░░░░░░░░▄▀▒▌░
 * ░░░░░░░░▐▀▒█░░░░░░░░▄▀▒▒▒▐
 * ░░░░░░░▐▄▀▒▒▀▀▀▀▄▄▄▀▒▒▒▒▒▐
 * ░░░░░▄▄▀▒░▒▒▒▒▒▒▒▒▒█▒▒▄█▒▐
 * ░░░▄▀▒▒▒░░░▒▒▒░░░▒▒▒▀██▀▒▌
 * ░░▐▒▒▒▄▄▒▒▒▒░░░▒▒▒▒▒▒▒▀▄▒▒
 * ░░▌░░▌█▀▒▒▒▒▒▄▀█▄▒▒▒▒▒▒▒█▒▐
 * ░▐░░░▒▒▒▒▒▒▒▒▌██▀▒▒░░░▒▒▒▀▄
 * ░▌░▒▄██▄▒▒▒▒▒▒▒▒▒░░░░░░▒▒▒▒
 * ▀▒▀▐▄█▄█▌▄░▀▒▒░░░░░░░░░░▒▒▒
 * My Dear Taoism's Friend .Please SitDown.
 */
public class ReadExcel {
    //总行数
    private int totalRows = 0;
    //总条数
    private int totalCells = 0;
    //错误信息接收器
    private String errorMsg;
    //构造方法
    public ReadExcel(){}
    //获取总行数
    public int getTotalRows(){
        return totalRows;
    }
    //获取总列数
    public int getTotalCells() {
        return totalCells;
    }
    //获取错误信息
    public String getErrorInfo() {
        return errorMsg;
    }


    //读EXCEL文件 获取信息集合
    public List<Account> getExcelInfo(MultipartFile mFile){
        String fileName = mFile.getOriginalFilename();//获取文件名
        List<Account> accountList = null;
        try {
            if (!validateExcel(fileName)) {// 验证文件名是否合格
                return null;
            }
            boolean isExcel2003 = true;// 根据文件名判断文件是2003版本还是2007版本
            if (isExcel2007(fileName)) {
                isExcel2003 = false;
            }
            accountList   = createExcel(mFile.getInputStream(), isExcel2003);
        }catch (Exception e){
            e.printStackTrace();
        }

        return accountList;
    }
    /**
     * 根据excel里面的内容读取客户信息
     *  输入流
     *  excel是2003还是2007版本
     */
    public List<Account> createExcel(InputStream is, boolean isExcel2003) {
        List<Account> accountList = null;
        try{
            Workbook wb = null;
            if (isExcel2003) {// 当excel是2003时,创建excel2003
                wb = new HSSFWorkbook(is);
            } else {// 当excel是2007时,创建excel2007
                wb = new XSSFWorkbook(is);
            }
            accountList   = readExcelValue(wb);// 读取Excel里面客户的信息
        } catch (IOException e) {
            e.printStackTrace();
        }
        return accountList;
    }
    //读取excel里面客户的信息
    private List<Account> readExcelValue(Workbook wb) {
        // 得到第一个shell
        Sheet sheet = wb.getSheetAt(0);
        // 得到Excel的行数
        this.totalRows = sheet.getPhysicalNumberOfRows();
        // 得到Excel的列数(前提是有行数)
        if (totalRows > 1 && sheet.getRow(0) != null) {
            this.totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
        }
        List<Account> accountList = new ArrayList<Account>();
        for (int r = 1; r < totalRows; r++) {
            Row row = sheet.getRow(r);
            if (row==null){
                continue;
            }
            Account account = new Account();

            // 循环Excel的列
            for (int c = 0; c < this.totalCells; c++) {
                Cell cell = row.getCell(c);
                if (null!=cell){
                    if (c==0){
                            if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                                account.setid(String.valueOf(cell.getNumericCellValue()));
                            }else {
                                account.setid(String.valueOf(cell.getNumericCellValue()));
                            }
                    }
                    else if (c==1){
                        if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                            account.setRecommender_id(String.valueOf(cell.getNumericCellValue()));
                        }else {
                            account.setRecommender_id(String.valueOf(cell.getNumericCellValue()));
                        }
                    }
                    else if (c==2){
                        if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                            account.setLogin_name(String.valueOf(cell.getNumericCellValue()));
                        }else {
                            account.setLogin_name(String.valueOf(cell.getNumericCellValue()));
                        }
                    }
                    else if (c==3){
                        if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                            account.setLogin_passwd(String.valueOf(cell.getNumericCellValue()));
                        }else {
                            account.setLogin_passwd(String.valueOf(cell.getNumericCellValue()));
                        }
                    }
                    else if (c==4){
                        if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                            account.setStatus(String.valueOf(cell.getNumericCellValue()));
                        }else {
                            account.setStatus(String.valueOf(cell.getNumericCellValue()));
                        }
                    }
                    else if (c==5){
                        if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                            account.setCreate_date(String.valueOf(cell.getNumericCellValue()));
                        }else {
                            account.setCreate_date(String.valueOf(cell.getNumericCellValue()));
                        }
                    }
                    else if (c==6){
                        if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                            account.setPause_date(String.valueOf(cell.getNumericCellValue()));
                        }else {
                            account.setPause_date(String.valueOf(cell.getNumericCellValue()));
                        }
                    }
                    else if (c==7){
                        if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                            account.setClose_date(String.valueOf(cell.getNumericCellValue()));
                        }else {
                            account.setClose_date(String.valueOf(cell.getNumericCellValue()));
                        }
                    }
                    else if (c==8){
                        if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                            account.setReal_name(String.valueOf(cell.getNumericCellValue()));
                        }else {
                            account.setReal_name(String.valueOf(cell.getNumericCellValue()));
                        }
                    }
                    else if (c==9){
                        if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                            account.setidcard_no(String.valueOf(cell.getNumericCellValue()));
                        }else {
                            account.setidcard_no(String.valueOf(cell.getNumericCellValue()));
                        }
                    }
                    else if (c==10){
                        if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                            account.setBirthdate(String.valueOf(cell.getNumericCellValue()));
                        }else {
                            account.setBirthdate(String.valueOf(cell.getNumericCellValue()));
                        }
                    }
                    else if (c==11){
                        if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                            account.setGender(String.valueOf(cell.getNumericCellValue()));
                        }else {
                            account.setGender(String.valueOf(cell.getNumericCellValue()));
                        }
                    }
                    else if (c==12){
                        if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                            account.setOccupation(String.valueOf(cell.getNumericCellValue()));
                        }else {
                            account.setOccupation(String.valueOf(cell.getNumericCellValue()));
                        }
                    }
                    else if (c==13){
                        if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                            account.setTelephone(String.valueOf(cell.getNumericCellValue()));
                        }else {
                            account.setTelephone(String.valueOf(cell.getNumericCellValue()));
                        }
                    }
                    else if (c==14){
                        if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                            account.setEmail(String.valueOf(cell.getNumericCellValue()));
                        }else {
                            account.setEmail(String.valueOf(cell.getNumericCellValue()));
                        }
                    }
                    else if (c==15){
                        if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                            account.setMailaddress(String.valueOf(cell.getNumericCellValue()));
                        }else {
                            account.setMailaddress(String.valueOf(cell.getNumericCellValue()));
                        }
                    }
                    else if (c==16){
                        if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                            account.setZipcode(String.valueOf(cell.getNumericCellValue()));
                        }else {
                            account.setZipcode(String.valueOf(cell.getNumericCellValue()));
                        }
                    }
                    else if (c==17){
                        if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                            account.setQq(String.valueOf(cell.getNumericCellValue()));
                        }else {
                            account.setQq(String.valueOf(cell.getNumericCellValue()));
                        }
                    }
                    else if (c==18){
                        if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                            account.setLast_login_time(String.valueOf(cell.getNumericCellValue()));
                        }else {
                            account.setLast_login_time(String.valueOf(cell.getNumericCellValue()));
                        }
                    }
                    else if (c==19){
                        if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                            account.setLast_login_ip(String.valueOf(cell.getNumericCellValue()));
                        }else {
                            account.setLast_login_ip(String.valueOf(cell.getNumericCellValue()));
                        }
                    }
                }
            }
        accountList.add(account);
        }
        return accountList;
    }


    // 验证EXCEL文件
    public boolean validateExcel(String filePath) {
        if (filePath == null || !(isExcel2003(filePath) || isExcel2007(filePath))) {
            errorMsg = "文件名不是excel格式";
            return false;
        }
        return true;
    }
    // @描述：是否是2003的excel，返回true是2003
    public static boolean isExcel2003(String filePath)  {
        return filePath.matches("^.+\\.(?i)(xls)$");
    }

    //@描述：是否是2007的excel，返回true是2007
    public static boolean isExcel2007(String filePath)  {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }





}
