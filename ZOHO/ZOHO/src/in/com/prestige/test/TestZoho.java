package in.com.prestige.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import in.com.prestige.dto.ActivityDTO;
import in.com.prestige.dto.BugDTO;
import in.com.prestige.dto.ClietDTO;
import in.com.prestige.dto.CompanyDTO;
import in.com.prestige.dto.DocumentDTO;
import in.com.prestige.dto.FeedDTO;
import in.com.prestige.dto.MilestonDTO;
import in.com.prestige.dto.ProjectDTO;
import in.com.prestige.dto.ProjectGroupDTO;
import in.com.prestige.dto.ProjectMangagerDTO;
import in.com.prestige.dto.ShareBugDTO;
import in.com.prestige.dto.StatusDTO;
import in.com.prestige.dto.UserDTO;
import in.com.prestige.util.HibernateUtil;

public class TestZoho {
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

	// Add Records
	public static void addRecords() throws Exception {
		Session session = null;
		Transaction txn = null;
		try {
			session = getSession();
			txn = session.beginTransaction();
			System.out.println("SessionObjectCeated");
			// for time
			Date d = new Date();
			long t = d.getTime();
			Timestamp time = new Timestamp(t);

			// ComapanyDTO
			CompanyDTO company = new CompanyDTO();
			company.setRegistrationNo(789456);
			company.setCompanyName("ArihantSoftech");
			company.setAddress("Palasiya,Indore");
			company.setCompanyType("Software Company");
			company.setContactNo("0731-451245");
			company.setStartUpDate(new Date());
			// company.setProjectManager(projectManager);// enter
			// ProjectManagerDTO
			// details of SET Type

			// ProjectManager-1
			ProjectMangagerDTO manager1 = new ProjectMangagerDTO();
			manager1.setProjectManagerId(101);
			manager1.setProjectManagerName("Nishant Jain");
			manager1.setContactNo("8754125487");
			// manager1.setFeeds(feeds);//Enter FeedDTO Details
			// manager1.setProjects(projects);//Enter ProjectDTO Details

			// ProjectManager-2
			ProjectMangagerDTO manager2 = new ProjectMangagerDTO();
			manager2.setProjectManagerId(102);
			manager2.setProjectManagerName("Rahul Athnere");
			manager2.setContactNo("7845126568");
			// manager2.setFeeds(feeds);//Enter FeedDTO Details SET Type
			// manager2.setProjects(projects);//Enter ProjectDTO Details
			// ProjectDTO type

			// FeedsDTo
			FeedDTO feed1 = new FeedDTO();
			feed1.setFeedId(333);
			feed1.setPost("Post-feed -1");
			FeedDTO feed2 = new FeedDTO();
			feed2.setFeedId(334);
			feed2.setPost("Post-feed -2");

			// ProjectDTO
			ProjectDTO project = new ProjectDTO();
			project.setProjectId(444);
			// project.setActivity(activity); //ActivityDTO activity type
			project.setBillingMethod("Paytm");
			project.setBugdetBasedOnHour(600.0);
			// project.setBugs(bugs); //BugDTo Set type
			// project.setClient(client);//ClientDTO ClientDTO type
			// project.setDocs(docs);//documnetDTO documnetDTO type
			project.setEndDate(new Date());
			// project.setMilestone(milestone);//MileStoneDTO milestone SET type
			project.setOverview("E-commerce Application");
			// project.setProjectGroup(projectGroup); // ProjectGroupDTO SET
			// type
			project.setProjectName("Spencer");
			project.setStartDate(new Date());
			// project.setStatus(status); // StatusDTO SET Type
			project.setStatusActive("Active");
			// project.setUsers(users); //UserDTO SET type

			// ActivityDTO
			ActivityDTO activity = new ActivityDTO();
			activity.setActivityId(555);
			activity.setTime(time);
			activity.setActivityName("Testing Done In Spnecer project");
			project.setActivity(activity); // ActivityDTO activity type

			// BugDTO-1
			BugDTO bug1 = new BugDTO();
			bug1.setBugId(666);
			bug1.setActivity(activity);// Activity type ActivityDTO
			bug1.setBugTitle("Bug In Spencer");
			bug1.setClosed(0);
			bug1.setOpen(1);
			bug1.setDescription("While Saving generate error");
			bug1.setDueDate(new Date());
			// BugDTO-2
			BugDTO bug2 = new BugDTO();
			bug2.setBugId(667);
			bug2.setActivity(activity);// Activity type ActivityDTO
			bug2.setBugTitle("Bug In Spencer");
			bug2.setClosed(0);
			bug2.setOpen(2);
			bug2.setDescription("While Updating generate error");
			bug2.setDueDate(new Date());

			// ClietDTO-onetoone
			ClietDTO client = new ClietDTO();
			client.setClientId(777);
			client.setClientName("Reliance");

			// client.setUsers(users); //UserDTO Set Type

			// UserDTO for Client And Project - 1
			UserDTO user1 = new UserDTO();
			user1.setUserId(888);
			user1.setUserName("Deependra");
			user1.setRole("Employee");
			user1.setEmail("Deep@gmail.com");
			// user1.setMilestone(milestone); //MileStoneDTO type
			// user1.setProjectGroup(projectGroup); // Project group Set Type
			// user1.setShareBug(shareBug); // ShareBugDTO SET Type

			// UserDTO for Client And Project - 2
			UserDTO user2 = new UserDTO();
			user2.setUserId(889);
			user2.setUserName("Rahul");
			user2.setRole("Employee");
			user2.setEmail("rahul@gmail.com");
			// user2.setMilestone(milestone);
			// user2.setProjectGroup(projectGroup);
			// user2.setShareBug(shareBug);

			// DocumentDTO for ProjectDTO
			DocumentDTO docu = new DocumentDTO();
			docu.setDocId(999);
			docu.setDocName("All requireMents Related to projects");
			project.setDocs(docu);

			// MilestoneDTo milestone for userDTo and milestone SET for
			// ProjectDTO
			MilestonDTO milestone1 = new MilestonDTO();
			milestone1.setMilstoneId(1111);
			milestone1.setStartDate(new Date());
			milestone1.setEndDate(new Date());
			milestone1.setActivity(activity);
			milestone1.setMilestoneName("Completed Before 28 may");

			// MilestoneDTo milestone for userDTo and milestone SET for
			// ProjectDTO
			MilestonDTO milestone2 = new MilestonDTO();
			milestone2.setMilstoneId(1112);
			milestone2.setStartDate(new Date());
			milestone2.setEndDate(new Date());
			milestone2.setActivity(activity);
			milestone2.setMilestoneName("Last Date for Complet 2 june");

			// ProjectgroupDTO for Set the value for ProjectDTO and UserDTO SET
			// type
			ProjectGroupDTO pgroup1 = new ProjectGroupDTO();
			pgroup1.setProjectgroupId(2222);
			pgroup1.setGroupName("Proxy");

			// ProjectgroupDTO for Set the value for ProjectDTO and UserDTO SET
			// type
			ProjectGroupDTO pgroup2 = new ProjectGroupDTO();
			pgroup2.setProjectgroupId(2223);
			pgroup2.setGroupName("Proxy-2");

			// StatusDTO for ProjectDTO
			StatusDTO status1 = new StatusDTO();
			status1.setStatusId(3333);
			status1.setStatusCompletedPercent("56%");
			// StatusDTO for ProjectDTO
			StatusDTO status2 = new StatusDTO();
			status2.setStatusId(3334);
			status2.setStatusCompletedPercent("57%");

			// ShareBugDTO for UserDTO manyToMany-1
			ShareBugDTO shareBug1 = new ShareBugDTO();
			shareBug1.setShareBugId(4444);
			shareBug1.setDate(new Date());
			// ShareBugDTO for UserDTO manyToMany-1
			ShareBugDTO shareBug2 = new ShareBugDTO();
			shareBug2.setShareBugId(4445);
			shareBug2.setDate(new Date());

			// All SetValues
			// Set For ProjectManager Save with CompanyDTO
			Set companySet = new HashSet();
			companySet.add(manager1);
			companySet.add(manager2);
			company.setProjectManager(companySet);
			// Set For FeedDTO
			Set feedSet = new HashSet();
			feedSet.add(feed2);
			feedSet.add(feed1);
			manager1.setFeeds(feedSet);
			manager2.setFeeds(feedSet);
			user1.setFeeds(feedSet); // FeedSetDTo for UserDTO

			// Set For Project one to one
			manager1.setProjects(project);// Enter ProjectDTO Details
			manager2.setProjects(project);

			// Set for BugDTO Set type
			Set bugSet = new HashSet();
			bugSet.add(bug1);
			bugSet.add(bug2);
			project.setBugs(bugSet); // BugDTo Set type in projectDTO
			
			// SET For milstone For ProjectDTO
			Set milestoneSet = new HashSet();
			milestoneSet.add(milestone1);
			milestoneSet.add(milestone2);

			project.setMilestone(milestoneSet);// SET For ProjectMilestone

			// SET for ProjectGroupDTO for userDTO and ProjectDTo
			Set projectGroupSet = new HashSet();
			projectGroupSet.add(pgroup1);
			projectGroupSet.add(pgroup2);

			project.setProjectGroup(projectGroupSet);
			user1.setProjectGroup(projectGroupSet);
			user2.setProjectGroup(projectGroupSet);

			// SET For StatusDTO For ProjectDTO
			Set statusSet = new HashSet();
			statusSet.add(status1);
			statusSet.add(status2);

			project.setStatus(statusSet);

			// SET for ShareBug
			Set sharBugSet = new HashSet();
			sharBugSet.add(shareBug1);
			sharBugSet.add(shareBug2);

			user1.setShareBug(sharBugSet);
			user2.setShareBug(sharBugSet);
			
			user1.setBugs(bugSet); // UserDTO Set Type Bug
            user2.setBugs(bugSet);
			// Set For UseDTO
			Set userSet = new HashSet();
			user1.setMilestone(milestone1);
			user2.setMilestone(milestone2);
			userSet.add(user1);
			userSet.add(user2);
			client.setUsers(userSet);

			project.setClient(client);

			project.setUsers(userSet);
			// Saving Details
			session.save(company);
			session.save(manager1);
			session.save(manager2);
			session.save(activity);
			session.save(project);
			session.save(user1);
			session.save(user2);
			session.save(client);
			session.save(shareBug1);
			session.save(shareBug2);

			txn.commit();
			System.out.println("Records Saved");
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
		addRecords();
	}
}
