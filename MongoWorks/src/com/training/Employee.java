package com.training;

import com.mongodb.BasicDBObject;

public class Employee extends BasicDBObject{
	public int empId;
	public String empName;
		public String empEmail;
		public String empSal;
		public int getEmpId() {
			return empId;
		}
		public void setEmpId(int empId) {
			this.put("empid", empId);
			this.empId = empId;
		}
		public String getEmpName() {
			
			return empName;
		}
		public void setEmpName(String empName) {
			this.put("empname", empName);

			this.empName = empName;
		}
		public String getEmpEmail() {
			return empEmail;
		}
		public void setEmpEmail(String empEmail) {
			this.put("empemail", empEmail);

			this.empEmail = empEmail;
		}
		public String getEmpSal() {
			return empSal;
		}
		public void setEmpSal(String empSal) {
			this.put("empsal", empSal);

			this.empSal = empSal;
		}
		public Employee(int empId, String empName, String empEmail, String empSal) {
			super();
			this.empId = empId;
			this.empName = empName;
			this.empEmail = empEmail;
			this.empSal = empSal;
		}
		public Employee() {
			super();
		}
		

}
