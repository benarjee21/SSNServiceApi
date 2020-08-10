package com.example.demo.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomSSNIdGenerator implements IdentifierGenerator {

	private Long SSN_FIXED_VALUE= (long) 987560000;
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		Connection connection = session.connection();
		try {
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("select max(seral_id) from ssn_master");
			if(rs.next())
            {
                int id=rs.getInt(1);
                Long generatedId = id+SSN_FIXED_VALUE;
                return generatedId;
            }
		}catch (SQLException e) {
            e.printStackTrace();
        }
		return null;
	}

}
