package gongzi.dng.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import gongzi.dng.model.Count;
import gongzi.dng.model.Item;
import gongzi.dng.model.Salary;

public class Calculator {

	public static List<Count> count(List items) {
		List<Count> counts = new ArrayList<Count>();
		for (int i = 0; i < items.size(); i++) {
			Item item = (Item) items.get(i);
			Count count = new Count(item);
			// 计算开户奖
			if (Double.parseDouble(item.getShuangbian()) == 1) {
				if (Double.parseDouble(item.getQimoshizhi()) == 0 && Double.parseDouble(item.getWuxishu()) >= 10000) {
					count.setKaihujiang("30");
				} else if (Double.parseDouble(item.getQimoshizhi()) > 0) {
					if (Double.parseDouble(item.getWuxishu()) >= 10000
							&& Double.parseDouble(item.getWuxishu()) < 50000) {
						count.setKaihujiang("110");
					} else if (Double.parseDouble(item.getWuxishu()) >= 50000) {
						count.setKaihujiang("300");
					}
				}
			}
			// 计算千二
			if (Double.parseDouble(item.getQimoshizhi()) > 0 && Double.parseDouble(item.getQimoguimo()) > 0
					&& Double.parseDouble(item.getWuxishu()) >= 10000) {
				count.setQianer(0.002 * Double.parseDouble(item.getWuxishu()));
			}

			counts.add(count);
		}
		return counts;
	}

	public static List<Salary> salary(List counts) {
		List<Salary> salaries = new ArrayList<Salary>();

		for (int i = 0; i < counts.size(); i++) {
			Boolean flag = true;
			Count count = (Count) counts.get(i);
			Salary salary = new Salary(count.getYuangong(), count.getKaihujiang(), count.getQianer());
			for (int j = 0; j < salaries.size(); j++) {
				Salary s = salaries.get(j);
				if (salary.getYuangong().compareTo(s.getYuangong()) == 0) {
					s.setKaihujiang(Double.parseDouble(salary.getKaihujiang()) + Double.parseDouble(s.getKaihujiang()));
					s.setQianer(Double.parseDouble(salary.getQianer()) + Double.parseDouble(s.getQianer()));
					salaries.remove(j);
					salaries.add(s);
					flag = false;
					break;
				}
			}
			if (salaries.size() == 0 || flag) {
				salaries.add(salary);
			}
		}

		return salaries;
	}

}
