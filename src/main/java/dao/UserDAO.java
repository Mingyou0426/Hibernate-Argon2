package dao;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import model.Appuser;
import util.*;

public class UserDAO {
	
	Session session = HibernateUtil.getSessionFactory().openSession();
	
	public boolean validateUsername(String username) {
		String hql = "select username from Appuser user where username = :uname";
		Query query = session.createQuery(hql);
		query.setString("uname", username);
		Object results = query.uniqueResult();
	
		if (results != null) {
			return true;
		}
		else return false;
	}
	
	//TODO
	
	public boolean saveUser(Appuser user) {
		Transaction tx = session.beginTransaction();
		
		// String md5Hex = DigestUtils.md5Hex(user.getPassword()).toUpperCase();
		// user.setPassword(md5Hex);
		
		Argon2 argon2 = Argon2Factory.create();
	    String hash = argon2.hash(10, 65536, 1, user.getPassword());
	    if (argon2.verify(hash, user.getPassword())) {
	    	user.setPassword(hash);
	    }
	    
		session.save(user);
		if ( !tx.wasCommitted() )
			tx.commit();
		session.flush();
		return true;
	}
}