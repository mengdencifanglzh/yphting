package com.accp.vo.lzh;

import java.util.Date;

public class logisticsVO {
	private String orderID;
	private String title;
	private Date orderTime;
	private int price;
	private int delivery;
	private int auditStatus;
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDelivery() {
		return delivery;
	}
	public void setDelivery(int delivery) {
		this.delivery = delivery;
	}
	public int getAuditStatus() {
		return auditStatus;
	}
	public void setAuditStatus(int auditStatus) {
		this.auditStatus = auditStatus;
	}
	public logisticsVO(String orderID, String title, Date orderTime, int price, int delivery, int auditStatus) {
		super();
		this.orderID = orderID;
		this.title = title;
		this.orderTime = orderTime;
		this.price = price;
		this.delivery = delivery;
		this.auditStatus = auditStatus;
	}
	public logisticsVO() {}
}
