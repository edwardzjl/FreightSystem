package com.mango.jtt.model;

/**
 * Aug 17, 2016
 * 
 * @author HHL ������
 * 
 */
public class AirFreight {
	/**
	 * ���
	 */
	private int id;
	/**
	 * ʼ��վ
	 */
	private String originStation;
	/**
	 * Ŀ��վ--����
	 */
	private String destinationStation;
	/**
	 * Ŀ��վ����ʡ��
	 */
	private String province;
	/**
	 * �˷ѵ��� 100kg���£�Ԫ/kg��
	 */
	private double unitPriceF;
	/**
	 * �˷ѵ��� 100kg���ϣ�Ԫ/kg��
	 */
	private double unitPriceT;
	/**
	 * �������ۣ�Ԫ/kg��
	 */
	private double unitPriceDH;
	/**
	 * ���ᵥ�ۣ�Ԫ/kg��
	 */
	private double unitPriceZT;
	/**
	 * ������������֧��
	 */
	private double quantity;
	/**
	 * ����ת��Ϊ������ ����36 quantityT = quantity * 36
	 */
	private double quantityT;
	/**
	 * �̳����������� ����40 facToAirCost = quantity * 40
	 */
	private double facToAirCost;
	/**
	 * �˷� if(quantityT<100) airFreightCost=quantityT*unitPriceF
	 * if(quantityT>100) airFreightCost=quantityT*unitPriceT
	 */
	private double airFreightCost;
	/**
	 * ���շ��ʣ��̶�ֵ0.3%
	 */
	private double insuranceRate;
	/**
	 * Ͷ��������40000 insuranceCost = quantity * 40000
	 */
	private double insuranceCost;
	/**
	 * ���շ� insurance=insuranceRate*insuranceCost
	 */
	private double insurance;
	/**
	 * ��װ�� ����100 packingCost=quantity*100
	 */
	private double packingCost;
	/**
	 * ���ͷ�ʽ�����ͣ�����
	 */
	private String takeType;
	/**
	 * ���ͷ� sendCost=quantityT*unitPriceDH
	 */
	private double sendCost;
	/**
	 * ����� takeCost=quantityT*unitPriceZT
	 */
	private double takeCost;
	/**
	 * �����˷Ѻϼ� airTotalCost=facToAirCost+airFreightCost+insurance+packingCost+(
	 * sendCost����takeCost)
	 */
	private double airTotalCost;
	/**
	 * �������
	 */
	private double subsidyMileage;
	/**
	 * ��·���
	 */
	private double landMileage;
	/**
	 * ������� totalMilage=subsidyMileage+landMileage
	 */
	private double totalMilage;
	/**
	 * ���ۣ�Ԫ/�ֹ��
	 */
	private double landUnitPrice;
	/**
	 * ��·�˷�(����С����700��֧) 700/50*landUnitPrice*totalMilage
	 */
	private double landTotalCost;
	/**
	 * ����� marginCost=airTotalCost-landTotalCost
	 */
	private double marginCost;

	public AirFreight() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOriginStation() {
		return originStation;
	}

	public void setOriginStation(String originStation) {
		this.originStation = originStation;
	}

	public String getDestinationStation() {
		return destinationStation;
	}

	public void setDestinationStation(String destinationStation) {
		this.destinationStation = destinationStation;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public double getUnitPriceF() {
		return unitPriceF;
	}

	public void setUnitPriceF(double unitPriceF) {
		this.unitPriceF = unitPriceF;
	}

	public double getUnitPriceT() {
		return unitPriceT;
	}

	public void setUnitPriceT(double unitPriceT) {
		this.unitPriceT = unitPriceT;
	}

	public double getUnitPriceDH() {
		return unitPriceDH;
	}

	public void setUnitPriceDH(double unitPriceDH) {
		this.unitPriceDH = unitPriceDH;
	}

	public double getUnitPriceZT() {
		return unitPriceZT;
	}

	public void setUnitPriceZT(double unitPriceZT) {
		this.unitPriceZT = unitPriceZT;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getQuantityT() {
		return quantityT;
	}

	public void setQuantityT(double quantityT) {
		this.quantityT = quantityT;
	}

	public double getFacToAirCost() {
		return facToAirCost;
	}

	public void setFacToAirCost(double facToAirCost) {
		this.facToAirCost = facToAirCost;
	}

	public double getAirFreightCost() {
		return airFreightCost;
	}

	public void setAirFreightCost(double airFreightCost) {
		this.airFreightCost = airFreightCost;
	}

	public double getInsuranceRate() {
		return insuranceRate;
	}

	public void setInsuranceRate(double insuranceRate) {
		this.insuranceRate = insuranceRate;
	}

	public double getInsuranceCost() {
		return insuranceCost;
	}

	public void setInsuranceCost(double insuranceCost) {
		this.insuranceCost = insuranceCost;
	}

	public double getInsurance() {
		return insurance;
	}

	public void setInsurance(double insurance) {
		this.insurance = insurance;
	}

	public double getPackingCost() {
		return packingCost;
	}

	public void setPackingCost(double packingCost) {
		this.packingCost = packingCost;
	}

	public double getSendCost() {
		return sendCost;
	}

	public void setSendCost(double sendCost) {
		this.sendCost = sendCost;
	}

	public double getTakeCost() {
		return takeCost;
	}

	public void setTakeCost(double takeCost) {
		this.takeCost = takeCost;
	}

	public double getAirTotalCost() {
		return airTotalCost;
	}

	public void setAirTotalCost(double airTotalCost) {
		this.airTotalCost = airTotalCost;
	}

	public String getTakeType() {
		return takeType;
	}

	public void setTakeType(String takeType) {
		this.takeType = takeType;
	}

	public double getSubsidyMileage() {
		return subsidyMileage;
	}

	public void setSubsidyMileage(double subsidyMileage) {
		this.subsidyMileage = subsidyMileage;
	}

	public double getLandMileage() {
		return landMileage;
	}

	public void setLandMileage(double landMileage) {
		this.landMileage = landMileage;
	}

	public double getTotalMilage() {
		return totalMilage;
	}

	public void setTotalMilage(double totalMilage) {
		this.totalMilage = totalMilage;
	}

	public double getLandUnitPrice() {
		return landUnitPrice;
	}

	public void setLandUnitPrice(double landUnitPrice) {
		this.landUnitPrice = landUnitPrice;
	}

	public double getLandTotalCost() {
		return landTotalCost;
	}

	public void setLandTotalCost(double landTotalCost) {
		this.landTotalCost = landTotalCost;
	}

	public double getMarginCost() {
		return marginCost;
	}

	public void setMarginCost(double marginCost) {
		this.marginCost = marginCost;
	}

}
