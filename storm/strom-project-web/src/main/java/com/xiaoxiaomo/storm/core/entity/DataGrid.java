package com.xiaoxiaomo.storm.core.entity;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ��̬��ʵ����
 * @author xiaoxiaomo
 *
 */
@Entity
@Table(name="data_grid")
public class DataGrid implements Idable,Serializable  {

	private static final long serialVersionUID = 1L;
	/**
	 * id ����
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/**
	 * ��������
	 */
	@Column
	private String name;
	/**
	 * �洢������ json����
	 * �洢��ʽ�����磺[{field:'',title:''},{field:'',title:''}]
	 */
	@Column
	private String colums;
	/**
	 * ��Ӧ�����ݿ����
	 */
	@Column
	private String tablename;


	/**
	 * ѡ�е�ֵ �洢��ʽΪ
	 */
	@Column
	private String checkvalues;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getColums() {
		return colums;
	}
	public void setColums(String colums) {
		this.colums = colums;
	}
	public String getTablename() {
		return tablename;
	}
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCheckvalues() {
		return checkvalues;
	}
	public void setCheckvalues(String checkvalues) {
		this.checkvalues = checkvalues;
	}
	
	@Override
	public String toString() {
		return "DataGrid [id=" + id + ", name=" + name + ", colums=" + colums
				+ ", tablename=" + tablename + ", checkvalues=" + checkvalues
				+ "]";
	}
}
