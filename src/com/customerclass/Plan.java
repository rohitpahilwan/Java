package com.customerclass;

public enum Plan {
	SILVER(1000),
	GOLD(2000),
	DIAMOND(5000),
	PLATINUM(10000);

	public double plancost;
	/**
	 * @return the plancost
	 */
	public double getPlancost() {
		return plancost;
	}

	/**
	 * @param plancost the plancost to set
	 */
	public void setPlancost(double plancost) {
		this.plancost = plancost;
	}

	
	
	private Plan(double cost)
	{
		this.plancost=cost;
	}
}
