package com.spring.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.swing.tree.RowMapper;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.bean.EmpBean;

public class EmpDao {
	JdbcTemplate template;    
    
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}    
	public int save(EmpBean p){    
	    String sql="insert into Emp99(name,salary,designation) values('"+p.getName()+"',"+p.getSalary()+",'"+p.getDesignation()+"')";    
	    return template.update(sql);    
	}    
	public int update(EmpBean p){    
	    String sql="update Emp99 set name='"+p.getName()+"', salary="+p.getSalary()+",designation='"+p.getDesignation()+"' where id="+p.getId()+"";    
	    return template.update(sql);    
	}    
	public int delete(int id){    
	    String sql="delete from Emp99 where id="+id+"";    
	    return template.update(sql);    
	}    
	public EmpDao getEmpById(int id){    
	    String sql="select * from Emp99 where id=?";    
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<EmpDao>(EmpDao.class));    
	}    
	public List<EmpDao> getEmployees(){    
	    return template.query("select * from Emp99",new RowMapper<EmpDao>(){    
	        public EmpDao mapRow(ResultSet rs, int row) throws SQLException {    
	            EmpDao e=new EmpDao();    
	            e.setId(rs.getInt(1));    
	            e.setName(rs.getString(2));    
	            e.setSalary(rs.getFloat(3));    
	            e.setDesignation(rs.getString(4));    
	            return e;    
	        }    
	    });    
	}    
	}   

