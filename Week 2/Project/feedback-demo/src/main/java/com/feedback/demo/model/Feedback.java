package com.feedback.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Feedback{

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;

		private String productName;
		private int quality;
		private int valueForMoney;
		private int recommendation;
		private String deliveryRemark;
		private String userExperience;
		
		public Feedback() {
			super();
			// TODO Auto-generated constructor stub
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		public int getQuality() {
			return quality;
		}

		public void setQuality(int quality) {
			this.quality = quality;
		}

		public int getValueForMoney() {
			return valueForMoney;
		}

		public void setValueForMoney(int valueForMoney) {
			this.valueForMoney = valueForMoney;
		}

		public int getRecommendation() {
			return recommendation;
		}

		public void setRecommendation(int recommendation) {
			this.recommendation = recommendation;
		}

		public String getDeliveryRemark() {
			return deliveryRemark;
		}

		public void setDeliveryRemark(String deliveryRemark) {
			this.deliveryRemark = deliveryRemark;
		}

		public String getUserExperience() {
			return userExperience;
		}

		public void setUserExperience(String userExperience) {
			this.userExperience = userExperience;
		}
		
//		@Override
//		public String toString() {
//			return "Feedback [id=" + id + ", productName=" + productName + ", quality=" + quality + ", valueForMoney="
//					+ valueForMoney + ", recommendation=" + recommendation + ", deliveryRemark=" + deliveryRemark
//					+ ", userExperience=" + userExperience + "]";
//		}
		
}
