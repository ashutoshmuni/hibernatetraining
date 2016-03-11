package com.test;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EmployeePK implements Serializable {
	
	@Column(name="EMP_ID")
	private Long employeeId;
	@Column(name="COMPANY_ID")
	private Long companyId;
	
	public EmployeePK(Long employeeId, Long companyId) {
		this.employeeId = employeeId;
		this.companyId = companyId;
	}
	
	@Override
	public boolean equals(Object obj) {
		EmployeePK empPK = (EmployeePK)obj;
		if (this.employeeId==empPK.employeeId && this.companyId==empPK.companyId)
			return true;
		return false;
	}
	public int hashCode() {
		return this.employeeId.hashCode() + this.companyId.hashCode();
	}
}
