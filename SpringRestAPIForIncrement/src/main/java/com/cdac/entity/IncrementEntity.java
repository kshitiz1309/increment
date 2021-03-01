package com.cdac.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="increment_number")
public class IncrementEntity implements Serializable {
		private static final long serialVersionUID = 1L;
		
		@Id
		Integer id;

		@Column(name="number")
		Integer number;
		
		
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		
		
		public Integer getNumber() {
			return number;
		}

		public void setNumber(Integer number) {
			this.number = number;
		}

		public IncrementEntity() {
			 
		}
		
		
		public IncrementEntity(Integer id) {
			super();
			this.id = id;
		}
}
