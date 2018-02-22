package gongzi.dng.model;

public class Forms {
	private String filePath;
    private String startDate;
    private String endDate;
    
    public Forms(){}
    
	public Forms(String filePath, String startDate, String endDate) {
		super();
		this.filePath = filePath;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Forms [filePath=" + filePath + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
}
