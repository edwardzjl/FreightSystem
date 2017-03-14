package com.mango.jtt.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.mango.jtt.container.AirContainer;
import com.mango.jtt.model.AirFreight;

/**
 * Aug 17, 2016
 * 
 * @author HHL �ļ�������
 * 
 */
public class FileUtil {

	/**
	 * ��excel�ж�ȡ���ݣ�ת���ɶ��󣬲����浽map��
	 */
	public static void initData() {
		readAirExcel(FreightConst.AIREXCELNAME);

	}

	/**
	 * ��ȡ��������
	 */
	private static void readAirExcel(String fileName) {
		boolean isE2007 = false; // �ж��Ƿ���excel2007��ʽ
		if (fileName.endsWith("xlsx")) {
			isE2007 = true;
		}

		Workbook wb = null;
		try {
			InputStream input = new FileInputStream(new File(UrlUtil
					.getRootUrl()
					+ "data/" + fileName)); // ����������
			// �����ļ���ʽ(2003����2007)����ʼ��
			if (isE2007) {
				wb = new XSSFWorkbook(input);
			} else {
				wb = new HSSFWorkbook(input);
			}
			Sheet sheet = wb.getSheet(FreightConst.AIRSHEETNAME); // ���ָ�����Ƶı�
			// testSheet(sheet);
			// �ӵ����п�ʼȡֵ����0��ʼ��
			for (int j = FreightConst.ROWNUMBER; j < sheet
					.getPhysicalNumberOfRows(); j++) {
				Row row = sheet.getRow(j);
				AirFreight af = new AirFreight();
				af.setId((int) row.getCell(FreightConst.ID)
						.getNumericCellValue());
				af.setOriginStation(row.getCell(FreightConst.ORIGINSTATION)
						.getStringCellValue());
				af.setDestinationStation(row.getCell(
						FreightConst.DESTINATIONSTATION).getStringCellValue());
				af.setProvince(row.getCell(FreightConst.PROVINCE)
						.getStringCellValue());
				af.setUnitPriceF(row.getCell(FreightConst.UNITPRICEF)
						.getNumericCellValue());
				af.setUnitPriceT(row.getCell(FreightConst.UNITPRICET)
						.getNumericCellValue());
				af.setUnitPriceDH(row.getCell(FreightConst.UNITPRICEDH)
						.getNumericCellValue());
				af.setUnitPriceZT(row.getCell(FreightConst.UNITPRICEZT)
						.getNumericCellValue());
				af.setSubsidyMileage(row.getCell(FreightConst.SUBSIDYMILEAGE)
						.getNumericCellValue());
				af.setLandMileage(row.getCell(FreightConst.LANDMILEAGE)
						.getNumericCellValue());
				af.setLandUnitPrice(row.getCell(FreightConst.LANDUNITPRICE)
						.getNumericCellValue());

				// �������Ϣ����container�У� �˷���Ϣ
				AirContainer.airFreightMap.put(af.getOriginStation() + "-"
						+ af.getDestinationStation() + "-" + af.getProvince(),
						af);
				// Ŀ�ĵ�
				// AirContainer.airCityList.add(af.getDestinationStation());
				// Ŀ�ĵ�ʡ��
				// AirContainer.airProvinceList.add(af.getProvince());
				// Ŀ�ĵغ�ʡ��
				AirContainer.cityProvinceList.add(af.getDestinationStation()
						+ "-" + af.getProvince());
			}
			// ��Ŀ�ĵغͶ�Ӧ��ʡ�ݶ�Ӧ����
			// AirContainer.citySelector();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (wb != null) {
				try {
					wb.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	// private static void testSheet(Sheet sheet) {
	// Iterator<Row> rows = sheet.rowIterator(); // ��õ�һ�����ĵ�����
	// while (rows.hasNext()) {
	// Row row = rows.next(); // ���������
	// System.out.println("Row #" + row.getRowNum()); // ����кŴ�0��ʼ
	// Iterator<Cell> cells = row.cellIterator(); // ��õ�һ�еĵ�����
	// while (cells.hasNext()) {
	// Cell cell = cells.next();
	// System.out.println("Cell #" + cell.getColumnIndex());
	// switch (cell.getCellType()) { // ����cell�е��������������
	// case HSSFCell.CELL_TYPE_NUMERIC:
	// System.out.println(cell.getNumericCellValue());
	// break;
	// case HSSFCell.CELL_TYPE_STRING:
	// System.out.println(cell.getStringCellValue());
	// break;
	// case HSSFCell.CELL_TYPE_BOOLEAN:
	// System.out.println(cell.getBooleanCellValue());
	// break;
	// case HSSFCell.CELL_TYPE_FORMULA:
	// System.out.println(cell.getCellFormula());
	// break;
	// default:
	// System.out.println("unsuported sell type");
	// break;
	// }
	// }
	// }
	// }

	// /**
	// * @param args
	// */
	// public static void main(String[] args) {
	// readAirExcel(AIREXCELNAME);
	// }

}
