package gongzi.dng.control;

import java.util.List;

import gongzi.dng.model.Count;
import gongzi.dng.model.Forms;
import gongzi.dng.model.Item;
import gongzi.dng.model.Salary;
import gongzi.dng.util.Calculator;
import gongzi.dng.util.ExcelUtil;

public class Control01 {
	private static Forms forms; 
    private static List<Count> counts;
    private static List<Salary> salaries;
    private static List<Item> items;
    
    public static void getExcel(Forms forms){
    	items = ExcelUtil.getExcel(forms);
    }
    
    public static void getCounts(){
    	counts = Calculator.count(items);
    }
    
    public static void getSalaries(){
    	salaries = Calculator.salary(counts);
    }
    
    public static void outItems(){
    	ExcelUtil.outItems(items,forms);
    }
    
    public static void outCounts(){
    	ExcelUtil.outCounts(counts,forms);
    }
    
    public static void outSalaries(){
    	ExcelUtil.outSalaries(salaries,forms);
    }
    
	public static void setForms(Forms forms) {
		Control01.forms = forms;
		System.out.println(forms.toString());
	}
    
	public static void excute(Forms forms){
		setForms(forms);
		getExcel(forms);
		outItems();    
		
		getCounts();
		outCounts();
		
		getSalaries();
		outSalaries();
	}
}
