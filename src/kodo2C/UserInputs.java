package kodo2C;

import java.sql.Timestamp;

public class UserInputs {
	// ユーザの入力をまとめて表現
	//
	private Boolean isPrefectureSelected;
	private Boolean isUpperLevelSelected;
	private Boolean isLowerLevelSelected;
	private Boolean isUpperDateSelected;
	private Boolean isLowerDateSelected;
	private Boolean isUpperMagniSelected;
	private Boolean isLowerMagniSelected;

	private String prefecture;
	private int upperLevel;
	private int lowerLevel;
	private Timestamp lowerDate;
	private Timestamp upperDate;
	private double upperMagni;
	private double lowerMagni;
	public UserInputs() {
		isPrefectureSelected = Boolean.FALSE;
		isUpperLevelSelected = Boolean.FALSE;
		isLowerLevelSelected = Boolean.FALSE;
		isUpperDateSelected = Boolean.FALSE;
		isLowerDateSelected = Boolean.FALSE;
		isUpperMagniSelected = Boolean.FALSE;
		isLowerMagniSelected = Boolean.FALSE;
		
	}
	
	public void setPrefectureSelected(boolean selected) {
		if(selected) {
			isPrefectureSelected=Boolean.TRUE;
		}else {
			isPrefectureSelected=Boolean.FALSE;
		}
	}
	public boolean getPrefectureSelected() {
		if(isPrefectureSelected.booleanValue()) {
			return true;
		}else {
			return false;
		}
	}
	
	public void setUpperLevelSelected(boolean selected) {
		if(selected) {
			isUpperLevelSelected=Boolean.TRUE;
		}else {
			isUpperLevelSelected=Boolean.FALSE;
		}
	}
	public boolean getUpperLevelSelected() {
		if(isUpperLevelSelected.booleanValue()) {
			return true;
		}else {
			return false;
		}
	}
	public void setLowerLevelSelected(boolean selected) {
		if(selected) {
			isLowerLevelSelected=Boolean.TRUE;
		}else {
			isLowerLevelSelected=Boolean.FALSE;
		}
	}
	public boolean getLowerLevelSelected() {
		if(isLowerLevelSelected.booleanValue()) {
			return true;
		}else {
			return false;
		}
	}
	
	public void setUpperDateSelected(boolean selected) {
		if(selected) {
			isUpperDateSelected=Boolean.TRUE;
		}else {
			isUpperDateSelected=Boolean.FALSE;
		}
	}
	public boolean getUpperDateSelected() {
		if(isUpperDateSelected.booleanValue()) {
			return true;
		}else {
			return false;
		}
	}
	
	public void setLowerDateSelected(boolean selected) {
		if(selected) {
			isLowerDateSelected=Boolean.TRUE;
		}else {
			isUpperDateSelected=Boolean.FALSE;
		}
	}
	public boolean getLowerDateSelected() {
		if(isLowerDateSelected.booleanValue()) {
			return true;
		}else {
			return false;
		}
	}
	
	public void setUpperMagniSelected(boolean selected) {
		if(selected) {
			isUpperMagniSelected=Boolean.TRUE;
		}else {
			isUpperMagniSelected=Boolean.FALSE;
		}
	}
	public boolean getUpperMagniSelected() {
		if(isUpperMagniSelected.booleanValue()) {
			return true;
		}else {
			return false;
		}
	}
	
	public void setLowerMagniSelected(boolean selected) {
		if(selected) {
			isLowerMagniSelected=Boolean.TRUE;
		}else {
			isLowerMagniSelected=Boolean.FALSE;
		}
	}
	public boolean getLowerMagniSelected() {
		if(isLowerMagniSelected.booleanValue()) {
			return true;
		}else {
			return false;
		}
	}

	public String getPrefecture() {
		return prefecture;
	}

	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}

	public int getUpperLevel() {
		return upperLevel;
	}

	public void setUpperLevel(int upperLevel) {
		this.upperLevel = upperLevel;
	}

	public int getLowerLevel() {
		return lowerLevel;
	}

	public void setLowerLevel(int lowerLevel) {
		this.lowerLevel = lowerLevel;
	}

	public Timestamp getLowerDate() {
		return lowerDate;
	}

	public void setLowerDate(Timestamp lowerDate) {
		this.lowerDate = lowerDate;
	}

	public Timestamp getUpperDate() {
		return upperDate;
	}

	public void setUpperDate(Timestamp upperDate) {
		this.upperDate = upperDate;
	}

	public double getUpperMagni() {
		return upperMagni;
	}

	public void setUpperMagni(double upperMagni) {
		this.upperMagni = upperMagni;
	}

	public double getLowerMagni() {
		return lowerMagni;
	}

	public void setLowerMagni(double lowerMagni) {
		this.lowerMagni = lowerMagni;
	}
	
	public void printInput() {
		if(getPrefectureSelected()) {
			System.out.println("都道府県:\t"+ prefecture);
		}else {
			System.out.println("都道府県:\tなし");
		}
		if(getUpperLevelSelected()) {
			System.out.println("震度上限:\t"+ RowDataMain.lvToString(Integer.toString(upperLevel)));	
		}else {
			System.out.println("震度上限:\tなし");
		}
		if(getLowerLevelSelected()) {
			System.out.println("震度下限:\t"+ RowDataMain.lvToString(Integer.toString(lowerLevel)));	
		}else {
			System.out.println("震度下限:\tなし");
		}
		if(getUpperDateSelected()) {
			System.out.println("日付上限:\t" + upperDate);	
		}else {
			System.out.println("日付上限:\tなし");
		}
		if(getLowerDateSelected()) {
			System.out.println("日付下限:\t" + lowerDate);	
		}else {
			System.out.println("日付下限:\tなし");
		}
		if(getUpperMagniSelected()) {
			System.out.println("マグニチュード上限:\t"+ upperMagni);	
		}else {
			System.out.println("マグニチュード上限:\tなし");
		}
		if(getLowerMagniSelected()) {
			System.out.println("マグニチュード下限:\t"+lowerMagni);	
		}else {
			System.out.println("マグニチュード下限:\tなし");
		}
		
	}
}
