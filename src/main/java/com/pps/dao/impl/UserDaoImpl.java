package com.pps.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.pps.dao.UserDao;
import com.pps.model.User;

@Repository
public class UserDaoImpl extends JdbcDaoSupport implements UserDao{
	
	@Autowired 
	DataSource dataSource;
	
	@PersistenceContext
	private EntityManager entityManager;

	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	@Override
	public void insertEmployee(User emp) {
		String sql = "INSERT INTO employee " +
				"(empId, empName) VALUES (?, ?)" ;
		getJdbcTemplate().update(sql, new Object[]{
				emp.getUserId(), emp.getUserName()
		});
	}
	
	@Override
	public void insertEmployees(final List<User> users) {
		String sql = "INSERT INTO employee " + "(UserId, empName) VALUES (?, ?)";
		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				User user = users.get(i);
				ps.setString(1, String.valueOf(user.getUserId()));
				ps.setString(2, user.getUserName());
			}
			
			public int getBatchSize() {
				return users.size();
			}
		});

	}
	@Override
	public List<User> getAllEmployees(){
		String sql = "SELECT * FROM employee";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<User> result = new ArrayList<User>();
		for(Map<String, Object> row:rows){
			User emp = new User();
			emp.setUserId((Integer) row.get("UserId"));
			emp.setUserName((String)row.get("empName"));
			result.add(emp);
		}
		
		return result;
	}

	@Override
	public User getEmployeeById(String empId) {
		String sql = "SELECT * FROM employee WHERE empId = ?";
		return (User)getJdbcTemplate().queryForObject(sql, new Object[]{empId}, new RowMapper<User>(){
			@Override
			public User mapRow(ResultSet rs, int rwNumber) throws SQLException {
				User emp = new User();
				emp.setUserId(rs.getInt("UserId"));
				emp.setUserName(rs.getString("empName"));
				return emp;
			}
		});
	}
	
	public synchronized Integer getNextUserId(String seqName) throws DataAccessException{
		Integer outCode = 0;
		try {
			StoredProcedureQuery query = entityManager.createStoredProcedureQuery("GET_SEQ_VALUE"); 
			query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter(2, Integer.class, ParameterMode.OUT);
			query.setParameter(1, seqName);
			query.execute();
			outCode = (Integer) query.getOutputParameterValue(2);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw  e;
		}
        return outCode; 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsersSelectedColums(User user) {
		String query = "select ";
		List<User> userList = new ArrayList<>();
		String userFlds = user.getUserSelectedFields().stream().collect(Collectors.joining(",")).toString();
		query+=userFlds+" from User";
		userList = entityManager.createQuery(query).getResultList();
		return userList;
	}
}