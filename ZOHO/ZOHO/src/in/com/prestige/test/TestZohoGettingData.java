package in.com.prestige.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import in.com.prestige.dto.ActivityDTO;
import in.com.prestige.dto.BugDTO;
import in.com.prestige.dto.ClietDTO;
import in.com.prestige.dto.CompanyDTO;
import in.com.prestige.dto.MilestonDTO;
import in.com.prestige.dto.ProjectDTO;
import in.com.prestige.dto.ProjectGroupDTO;
import in.com.prestige.dto.ProjectMangagerDTO;
import in.com.prestige.dto.UserDTO;
import in.com.prestige.util.HibernateUtil;

public class TestZohoGettingData {
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

	// getting All records
	public static void getListRecordsCompany() throws Exception {
		Session session = null;
		Transaction txn = null;
		try {
			session = getSession();
			txn = session.beginTransaction();
			Criteria crit = session.createCriteria(CompanyDTO.class);

			List list = crit.list();
			Iterator it = list.iterator();
			while (it.hasNext()) {
				CompanyDTO com = (CompanyDTO) it.next();
				System.out.print(com.getRegistrationNo() + ".." + com.getCompanyName() + "..." + com.getCompanyType()
						+ "..." + com.getAddress() + "..." + com.getContactNo() + "..." + com.getStartUpDate());
				System.out.println();
				System.out.println("Getting Project ManagerS details of Comapny");
				Set projectManagerSet = com.getProjectManager();
				Iterator it2 = projectManagerSet.iterator();
				while (it2.hasNext()) {
					ProjectMangagerDTO projectManager = (ProjectMangagerDTO) it2.next();
					System.out.println(projectManager.getProjectManagerId() + "..."
							+ projectManager.getProjectManagerName() + "..." + projectManager.getContactNo());

					ProjectDTO project = (ProjectDTO) projectManager.getProjects();
					System.out.println(
							project.getProjectId() + "..." + project.getProjectName() + "..." + project.getOverview()
									+ "...." + project.getBugdetBasedOnHour() + "..." + project.getStatusActive()
									+ "....." + project.getStartDate() + "..." + project.getEndDate());

					ActivityDTO activity = (ActivityDTO) project.getActivity();
					System.out.println(
							activity.getActivityId() + "..." + activity.getActivityName() + "..." + activity.getTime());
					// Getting Bud Details
					Set bugSet = project.getBugs();
					Iterator it3 = bugSet.iterator();
					while (it3.hasNext()) {
						BugDTO bugs = (BugDTO) it3.next();
						System.out.println(bugs.getBugId() + "..." + bugs.getBugTitle() + "..." + bugs.getDescription()
								+ ".." + bugs.getOpen() + "..." + bugs.getClosed() + "..." + bugs.getDueDate());
					}
					// Getting Users Work In CurrentProject
					Set userSet = project.getUsers();
					Iterator it4 = userSet.iterator();
					while (it4.hasNext()) {
						UserDTO user = (UserDTO) it4.next();
						System.out.println(user.getUserId() + "..." + user.getUserName() + ".." + user.getEmail()
								+ "..." + user.getRole());
						MilestonDTO milestone = (MilestonDTO)user.getMilestone();
						System.out.println(milestone.getMilestoneName());
						Set usergroup = user.getProjectGroup();
						Iterator it6 = usergroup.iterator();
						while(it.hasNext()){
							ProjectGroupDTO pg = (ProjectGroupDTO)it6.next();
							System.out.println(pg.getProjectgroupId()+"..."+pg.getGroupName());
						}
					}
					// Getting All milestones For project
					Set mileStoneSet = project.getMilestone();
					Iterator it5 = mileStoneSet.iterator();
					while (it5.hasNext()) {
						MilestonDTO milstone = (MilestonDTO) it5.next();
						System.out.println(milstone.getMilstoneId() + "..." + milstone.getMilestoneName() + "..."
								+ milstone.getStartDate() + "..." + milstone.getEndDate());
					}
					
					ClietDTO client = (ClietDTO)project.getClient();
					System.out.println(client.getClientName());
					Set clientUser = client.getUsers();
					Iterator it7 = clientUser.iterator();
					while(it7.hasNext()){
						UserDTO user = (UserDTO)it7.next();
						System.out.println(user.getUserName());
					}
					

				}

			}

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
		getListRecordsCompany();
	}
}
