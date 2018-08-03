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
import in.com.prestige.dto.ShareBugDTO;
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
						MilestonDTO milestone = (MilestonDTO) user.getMilestone();
						System.out.println(milestone.getMilestoneName());
						Set usergroup = user.getProjectGroup();
						Iterator it6 = usergroup.iterator();
						while (it.hasNext()) {
							ProjectGroupDTO pg = (ProjectGroupDTO) it6.next();
							System.out.println(pg.getProjectgroupId() + "..." + pg.getGroupName());
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

					ClietDTO client = (ClietDTO) project.getClient();
					System.out.println(client.getClientName());
					Set clientUser = client.getUsers();
					Iterator it7 = clientUser.iterator();
					while (it7.hasNext()) {
						UserDTO user = (UserDTO) it7.next();
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

	// GetRecords From UserdTo in DashBoard
	public static void getDashBoardResult() throws Exception {
		Session session = null;
		Transaction txn = null;
		try {
			session = getSession();
			txn = session.beginTransaction();
			Criteria crit = session.createCriteria(UserDTO.class);
			crit.add(Restrictions.eq("userId", 888));
			List list = crit.list();
			Iterator it = list.iterator();
			while (it.hasNext()) {
				UserDTO user = (UserDTO) it.next();
				System.out.println(user.getUserId());
				System.out.println(user.getRole());
				System.out.println(user.getEmail());
				System.out.println("................");
				Set bugSet = user.getBugs();
				Iterator it2 = bugSet.iterator();
				while (it2.hasNext()) {
					BugDTO bug = (BugDTO) it2.next();
					System.out.println(bug.getBugTitle());
					System.out.println(bug.getDescription());
					System.out.println(bug.getDueDate());
					System.out.println("................");
					Set userSet = bug.getUsers();
					Iterator it3 = userSet.iterator();
					while (it3.hasNext()) {
						UserDTO u = (UserDTO) it3.next();
						System.out.println(u.getUserName());
						MilestonDTO milestone = (MilestonDTO) u.getMilestone();
						System.out.println(milestone.getMilestoneName());
						System.out.println(milestone.getEndDate());
					}
				}
				Set shareSet = user.getShareBug();
				Iterator it4 = shareSet.iterator();
				while (it4.hasNext()) {
					ShareBugDTO share = (ShareBugDTO) it4.next();
					System.out.println(share.getShareBugId());
					System.out.println(share.getShareBugName());
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

	// Getting Milestone Data
	public static void getMilestonePerUser() throws Exception {
		Session session = null;
		Transaction txn = null;
		try {
			session = getSession();
			txn = session.beginTransaction();
			Criteria crit = session.createCriteria(UserDTO.class);
			crit.add(Restrictions.eq("userId", 888));
			List list = crit.list();
			Iterator it = list.iterator();
			while (it.hasNext()) {
				UserDTO user = (UserDTO) it.next();
				Set userSet = user.getBugs();
				Iterator it2 = userSet.iterator();
				while (it2.hasNext()) {
					BugDTO bug = (BugDTO) it2.next();
					System.out.println(bug.getDescription());
				}
				System.out.println(user.getUserName());
				MilestonDTO mile = (MilestonDTO) user.getMilestone();
				System.out.println(mile.getMilestoneName());
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

	// Get All Data in DashBoard
	public static void getAllDashBoardData() throws Exception {
		Session session = null;
		Transaction txn = null;
		try {
			session = getSession();
			txn = session.beginTransaction();

			Criteria crit1 = session.createCriteria(BugDTO.class);
			List list = crit1.list();
			Iterator it1 = list.iterator();
			while (it1.hasNext()) {
				BugDTO bugs = (BugDTO) it1.next();
				System.out.println("BugTitie : " + bugs.getBugTitle());
				System.out.println("Bug Descrption : " + bugs.getDescription());
				System.out.println("Open :" + bugs.getOpen());
				System.out.println("Closed :" + bugs.getClosed());
			}
			System.out.println("--------------MileStone Details In Project-----------------");
			Criteria crit2 = session.createCriteria(ProjectDTO.class);
			List list2 = crit2.list();
			Iterator it2 = list2.iterator();
			while (it2.hasNext()) {
				ProjectDTO proj = (ProjectDTO) it2.next();
				System.out.println("Project Name  :" + proj.getProjectName());
				Set mileSet = proj.getMilestone();
				Iterator it3 = mileSet.iterator();
				while (it3.hasNext()) {
					MilestonDTO miles = (MilestonDTO) it3.next();
					System.out.println("Milestone Name : " + miles.getMilestoneName());
					System.out.println("MileStone Starting Date : " + miles.getEndDate());

					Set BugsSet = miles.getBugs();
					Iterator it4 = BugsSet.iterator();
					while (it4.hasNext()) {
						BugDTO bug = (BugDTO) it4.next();
						System.out.println(bug.getDescription()+"...."+bug.getDescription());
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
		// getListRecordsCompany();
		// getDashBoardResult();
		// getMilestonePerUser();
		getAllDashBoardData();
	}
}
