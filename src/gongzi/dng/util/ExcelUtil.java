package gongzi.dng.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.filechooser.FileSystemView;

import gongzi.dng.model.Count;
import gongzi.dng.model.Forms;
import gongzi.dng.model.Item;
import gongzi.dng.model.Salary;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ExcelUtil {

	public static List<Item> getExcel(Forms forms) {
		List<Item> items = new ArrayList();

		File file = new File(forms.getFilePath());
		String startDate = forms.getStartDate();
		String endDate = forms.getEndDate();
		try {
			// 创建输入流，读取Excel
			InputStream is = new FileInputStream(file.getAbsolutePath());
			// jxl提供的Workbook类
			Workbook wb = Workbook.getWorkbook(is);
			// Excel的页签数量
			int sheet_size = wb.getNumberOfSheets();
			for (int index = 0; index < sheet_size; index++) {
				// 每个页签创建一个Sheet对象
				Sheet sheet = wb.getSheet(index);
				if (sheet.getName().equals("明细")) {
					// for (int j = 0; j < sheet.getColumns(); j++) {
					// String cellhead = sheet.getCell(j,0).getContents();
					// System.out.print(cellhead+" ");
					// }
					// sheet.getRows()返回该页的总行数
					for (int i = 1; i < sheet.getRows(); i++) {
						// sheet.getColumns()返回该页的总列数
						if (sheet.getCell(0, i).getContents() == null || sheet.getCell(0, i).getContents() == "")
							break;
						Item item = new Item();
						for (int j = 0; j < sheet.getColumns(); j++) {
							String cellhead = sheet.getCell(j, 0).getContents();
							String cellinfo = sheet.getCell(j, i).getContents();
							if (cellinfo != null && cellinfo != "") {
								if (cellhead.equals("员工姓名")) {
									item.setYuangong(cellinfo);
								} else if (cellhead.equals("客户姓名")) {
									item.setKehu(cellinfo);
								} else if (cellhead.equals("客户资金帐号")) {
									item.setKehuzijinzhanghao(cellinfo);
								} else if (cellhead.equals("开户奖")) {
									item.setKaihujiang("0.0");
								} else if (cellhead.equals("普通账户开户日期")) {
									item.setKaihuriqi(cellinfo);
								} else if (cellhead.equals("单双边标识")) {
									item.setShuangbian(cellinfo);
								} else if (cellhead.equals("有效户标识")) {
									item.setYouxiao(cellinfo);
								} else if (cellhead.equals("考核期内客户日均市值")) {
									item.setQimoshizhi(cellinfo);
								} else if (cellhead.equals("客户期末资券规模")) {
									item.setQimoguimo(cellinfo);
								} else if (cellhead.equals("客户无系数日均资券规模")) {
									item.setWuxishu(cellinfo);
								}
							}
						}
						if (item != null) {
							if (item.getKaihuriqi().compareTo(startDate) >= 0
									&& item.getKaihuriqi().compareTo(endDate) <= 0) {
								items.add(item);
							}
						}
					}
					System.out.println(items.size());
				}
			}

			wb.close();
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		}
		return items;
	}

	public static void outItems(List items, Forms forms) {
		try {
			File desktopDir = FileSystemView.getFileSystemView().getHomeDirectory();
			String desktopPath = desktopDir.getAbsolutePath();
			System.out.println(desktopPath);
			// 打开文件
			WritableWorkbook book = Workbook
					.createWorkbook(new File(desktopPath + "//小帮手输出" + forms.getStartDate() + "工资表1.xls"));
			// 生成名为“sheet1”的工作表，参数0表示这是第一页
			WritableSheet sheet = book.createSheet("sheet1", 0);
			// 在Label对象的构造子中指名单元格位置是第一列第一行(0,0),单元格内容为string

			for (int i = 0; i < 10; i++) {
				Label label;
				switch (i) {
				case 0:
					label = new Label(i, 0, "员工姓名");
					sheet.addCell(label);
					break;
				case 1:
					label = new Label(i, 0, "客户姓名");
					sheet.addCell(label);
					break;
				case 2:
					label = new Label(i, 0, "客户资金帐号");
					sheet.addCell(label);
					break;
				case 3:
					label = new Label(i, 0, "开户奖");
					sheet.addCell(label);
					break;
				case 4:
					label = new Label(i, 0, "普通账户开户日期");
					sheet.addCell(label);
					break;
				case 5:
					label = new Label(i, 0, "单双边标识");
					sheet.addCell(label);
					break;
				case 6:
					label = new Label(i, 0, "有效户标识");
					sheet.addCell(label);
					break;
				case 7:
					label = new Label(i, 0, "考核期内客户日均市值");
					sheet.addCell(label);
					break;
				case 8:
					label = new Label(i, 0, "客户期末资券规模");
					sheet.addCell(label);
					break;
				case 9:
					label = new Label(i, 0, "客户无系数日均资券规模");
					sheet.addCell(label);
					break;
				}
			}

			for (int i = 0; i < items.size(); i++) {
				Item item = (Item) items.get(i);
				for (int j = 0; j < 10; j++) {
					Label label;
					switch (j) {
					case 0:
						label = new Label(j, i + 1, item.getYuangong());
						sheet.addCell(label);
						break;
					case 1:
						label = new Label(j, i + 1, item.getKehu());
						sheet.addCell(label);
						break;
					case 2:
						label = new Label(j, i + 1, item.getKehuzijinzhanghao());
						sheet.addCell(label);
						break;
					case 3:
						label = new Label(j, i + 1, item.getKaihujiang());
						sheet.addCell(label);
						break;
					case 4:
						label = new Label(j, i + 1, item.getKaihuriqi());
						sheet.addCell(label);
						break;
					case 5:
						label = new Label(j, i + 1, item.getShuangbian());
						sheet.addCell(label);
						break;
					case 6:
						label = new Label(j, i + 1, item.getYouxiao());
						sheet.addCell(label);
						break;
					case 7:
						label = new Label(j, i + 1, item.getQimoshizhi());
						sheet.addCell(label);
						break;
					case 8:
						label = new Label(j, i + 1, item.getQimoguimo());
						sheet.addCell(label);
						break;
					case 9:
						label = new Label(j, i + 1, item.getWuxishu());
						sheet.addCell(label);
						break;
					}
				}
			}
			book.write();
			book.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void outCounts(List Counts, Forms forms) {
		try {
			File desktopDir = FileSystemView.getFileSystemView().getHomeDirectory();
			String desktopPath = desktopDir.getAbsolutePath();
			System.out.println(desktopPath);
			// 打开文件
			WritableWorkbook book = Workbook
					.createWorkbook(new File(desktopPath + "//小帮手输出" + forms.getStartDate() + "工资表2.xls"));
			// 生成名为“sheet1”的工作表，参数0表示这是第一页
			WritableSheet sheet = book.createSheet("sheet1", 0);
			// 在Label对象的构造子中指名单元格位置是第一列第一行(0,0),单元格内容为string

			for (int i = 0; i <= 10; i++) {
				Label label;
				switch (i) {
				case 0:
					label = new Label(i, 0, "员工姓名");
					sheet.addCell(label);
					break;
				case 1:
					label = new Label(i, 0, "客户姓名");
					sheet.addCell(label);
					break;
				case 2:
					label = new Label(i, 0, "客户资金帐号");
					sheet.addCell(label);
					break;
				case 3:
					label = new Label(i, 0, "开户奖");
					sheet.addCell(label);
					break;
				case 4:
					label = new Label(i, 0, "普通账户开户日期");
					sheet.addCell(label);
					break;
				case 5:
					label = new Label(i, 0, "单双边标识");
					sheet.addCell(label);
					break;
				case 6:
					label = new Label(i, 0, "有效户标识");
					sheet.addCell(label);
					break;
				case 7:
					label = new Label(i, 0, "考核期内客户日均市值");
					sheet.addCell(label);
					break;
				case 8:
					label = new Label(i, 0, "客户期末资券规模");
					sheet.addCell(label);
					break;
				case 9:
					label = new Label(i, 0, "客户无系数日均资券规模");
					sheet.addCell(label);
					break;
				case 10:
					label = new Label(i, 0, "千二");
					sheet.addCell(label);
					break;
				}
			}

			for (int i = 0; i < Counts.size(); i++) {
				Count item = (Count) Counts.get(i);
				for (int j = 0; j <= 10; j++) {
					Label label;
					switch (j) {
					case 0:
						label = new Label(j, i + 1, item.getYuangong());
						sheet.addCell(label);
						break;
					case 1:
						label = new Label(j, i + 1, item.getKehu());
						sheet.addCell(label);
						break;
					case 2:
						label = new Label(j, i + 1, item.getKehuzijinzhanghao());
						sheet.addCell(label);
						break;
					case 3:
						label = new Label(j, i + 1, item.getKaihujiang());
						sheet.addCell(label);
						break;
					case 4:
						label = new Label(j, i + 1, item.getKaihuriqi());
						sheet.addCell(label);
						break;
					case 5:
						label = new Label(j, i + 1, item.getShuangbian());
						sheet.addCell(label);
						break;
					case 6:
						label = new Label(j, i + 1, item.getYouxiao());
						sheet.addCell(label);
						break;
					case 7:
						label = new Label(j, i + 1, item.getQimoshizhi());
						sheet.addCell(label);
						break;
					case 8:
						label = new Label(j, i + 1, item.getQimoguimo());
						sheet.addCell(label);
						break;
					case 9:
						label = new Label(j, i + 1, item.getWuxishu());
						sheet.addCell(label);
						break;
					case 10:
						if (Double.parseDouble(item.getWuxishu()) >= 10000
								&& Double.parseDouble(item.getQianer()) == 0) {
							label = new Label(j, i + 1, "理财户");
							sheet.addCell(label);
						} else {
							label = new Label(j, i + 1, item.getQianer());
							sheet.addCell(label);
						}
						break;
					}
				}
			}
			book.write();
			book.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void outSalaries(List salaries, Forms forms) {
		try {
			File desktopDir = FileSystemView.getFileSystemView().getHomeDirectory();
			String desktopPath = desktopDir.getAbsolutePath();
			System.out.println(desktopPath);
			// 打开文件
			WritableWorkbook book = Workbook
					.createWorkbook(new File(desktopPath + "//小帮手输出" + forms.getStartDate() + "工资表3.xls"));
			// 生成名为“sheet1”的工作表，参数0表示这是第一页
			WritableSheet sheet = book.createSheet("sheet1", 0);
			// 在Label对象的构造子中指名单元格位置是第一列第一行(0,0),单元格内容为string

			for (int i = 0; i < 3; i++) {
				Label label;
				switch (i) {
				case 0:
					label = new Label(i, 0, "员工姓名");
					sheet.addCell(label);
					break;
				case 1:
					label = new Label(i, 0, "开户奖");
					sheet.addCell(label);
					break;
				case 2:
					label = new Label(i, 0, "千二");
					sheet.addCell(label);
					break;
				}
			}

			for (int i = 0; i < salaries.size(); i++) {
				Salary item = (Salary) salaries.get(i);
				for (int j = 0; j < 3; j++) {
					Label label;
					switch (j) {
					case 0:
						label = new Label(j, i + 1, item.getYuangong());
						sheet.addCell(label);
						break;
					case 1:
						label = new Label(j, i + 1, item.getKaihujiang());
						sheet.addCell(label);
						break;
					case 2:
						label = new Label(j, i + 1, item.getQianer());
						sheet.addCell(label);
						break;
					}
				}
			}
			book.write();
			book.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
