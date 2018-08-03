package in.com.prestige.test;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import in.com.prestige.dto.ActivityDTO;
import in.com.prestige.util.HibernateUtil;

public class TestZohoUpdate {
	// Getting Session Object
	public static Session getSession() throws Exception {
		SessionFactory factory = null;
		Session session = null;
		try {
			factory = HibernateUtil.getSessionFactory();
			session = factory.openSession();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return session;
	}
	
	//Update records
	public static void upateRecordAcitivity()throws Exception{
		Session session = null;
		Transaction txn = null;
		try {
			Date d = new Date();
			long t = d.getTime();
			Timestamp time = new Timestamp(t);
			session = getSession();
			txn = session.beginTransaction();
			ActivityDTO activity = (ActivityDTO)session.get(ActivityDTO.class, new Integer(555));
			activity.setActivityName("Second Time testing Is to be Done");
			activity.setTime(time);
			session.update(activity);
			txn.commit();
			System.out.println(("Record updated"));
			
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	// Main Method
	public static void main(String[] args) throws Exception {
          upateRecordAcitivity();
	}
}
