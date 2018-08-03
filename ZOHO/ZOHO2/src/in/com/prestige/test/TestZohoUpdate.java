package in.com.prestige.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import in.com.prestige.dto.ActivityDTO;
import in.com.prestige.dto.BugDTO;
import in.com.prestige.dto.ProjectDTO;
import in.com.prestige.dto.UserDTO;
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

	// Update records
	public static void upateRecordAcitivity() throws Exception {
		Session session = null;
		Transaction txn = null;
		try {
			Date d = new Date();
			long t = d.getTime();
			Timestamp time = new Timestamp(t);
			session = getSession();
			txn = session.beginTransaction();
			ActivityDTO activity = (ActivityDTO) session.get(ActivityDTO.class, new Integer(555));
			activity.setActivityName("Third Time testing Is to be Done");
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

	// UpdateProject Reports
	public static void updateProjectRecord() throws Exception {
		Session session = null;
		Transaction txn = null;
		try {
			session = getSession();
			txn = session.beginTransaction();
			ProjectDTO project = (ProjectDTO) session.get(ProjectDTO.class, new Integer(444));
			UserDTO user = (UserDTO) session.get(UserDTO.class, new Integer(888));
			project.getMilestone();
			project.getActivity();
			project.getBugs();
			project.getDocs();
			project.getProjectGroup();
			Set userSet = project.getUsers();
			project.getStatus();
			user.getBugs();
			user.getFeeds();
			user.getMilestone();
			user.getProjectGroup();
			user.getShareBug();

			project.setProjectName("Reliance Jio");
			user.setUserName("Rishbah Chaudhari");
			userSet.add(user);
            project.setUsers(userSet);
			//session.update(user);
			session.update(project);
			txn.commit();
			System.out.println("Record Updated");

		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	//Update Bugs
	public static void updateBug()throws Exception{
		Session session = null;
		Transaction txn = null;
		try {
			session = getSession();
			txn = session.beginTransaction();
			BugDTO bug = (BugDTO)session.get(BugDTO.class, new Integer(666));
			bug.getActivity();
			bug.getUsers();
			bug.setDueDate(new Date());
			bug.setOpen(0);
			bug.setClosed(2);
			bug.setBugTitle("Reliance Jio");
			bug.setDescription("Bug During Payment");
			session.update(bug);
			
			txn.commit();
			System.out.println("Record Updated");
			
			
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
		// upateRecordAcitivity();
		updateProjectRecord();
		//updateBug();
	}
}
