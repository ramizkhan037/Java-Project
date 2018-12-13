package com.amazon.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Supplier
{
  @Id
  @GeneratedValue
  int supplierId;
  String supplierName;
  String SupplierAddr;
  public int getSupplierId() 
  {
	return supplierId;
  }
  public void setSupplierId(int supplierId) 
  {
	this.supplierId = supplierId;
  }
   public String getSupplierName() 
   {
	return supplierName;
   }
   public void setSupplierName(String supplierName) 
   {
	this.supplierName = supplierName;
   }
   public String getSupplierAddr() 
   {
	return SupplierAddr;
   }
   public void setSupplierAddr(String supplierAddr) 
   {
	SupplierAddr = supplierAddr;
    }

}
