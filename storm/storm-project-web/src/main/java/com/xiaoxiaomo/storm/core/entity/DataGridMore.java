package com.xiaoxiaomo.storm.core.entity;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ��̬��ʵ���ࣨ��Զ��
 * @author xiaoxiaomo
 *
 */
@Entity
@Table(name="data_grid_more")
public class DataGridMore implements Idable,Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * id ����
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	/**
	 * �洢����ѯ��sql select a.name ,b.value from a ,b where a.id=b.id
	 */
	@Column
	private String sqlstr;

	/**
	 * ���� ��sql��ѯ�����������
	 */
	private String name;
	/**
	 * ��Ӧ���ֶ�����
	 */
	private String fieldname;

	/**
	 * ��Ӧ���ֶε����ݼ�
	 */
	private String fieldsql;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSqlstr() {
		return sqlstr;
	}
	public void setSqlstr(String sqlstr) {
		this.sqlstr = sqlstr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFieldname() {
		return fieldname;
	}
	public void setFieldname(String fieldname) {
		this.fieldname = fieldname;
	}
	public String getFieldsql() {
		return fieldsql;
	}
	public void setFieldsql(String fieldsql) {
		this.fieldsql = fieldsql;
	}
	@Override
	public String toString() {
		return "DataGridMore [id=" + id + ", sqlstr=" + sqlstr + ", name="
				+ name + ", fieldname=" + fieldname + ", fieldsql=" + fieldsql
				+ "]";
	}
	
}
