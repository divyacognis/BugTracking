package com.rclgroup.dolphin.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.rclgroup.dolphin.web.common.RrcApplicationContextWS;
import com.rclgroup.dolphin.web.dao.MasterDao;
import com.rclgroup.dolphin.web.model.ComboBoxMod;
import com.rclgroup.dolphin.web.scheduler.HQSycReadMail;
import com.rclgroup.dolphin.web.scheduler.SchedulerJob;
import com.rclgroup.dolphin.web.utils.Constants;

/**
 * Servlet implementation class ConfigServelet
 */
public class ConfigServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final MasterDao masterDao = (MasterDao) RrcApplicationContextWS.getBean("masterDao");
	 
	
	private static Map<String,String> statusMap = new HashMap<>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConfigServlet() {
		super();
		statusMap.put(String.valueOf(Constants.STATUS_CANCEL), "Cancel");
		statusMap.put(String.valueOf(Constants.STATUS_COMPLETED), "Completed");
		statusMap.put(String.valueOf(Constants.STATUS_NEW), "New");
		statusMap.put(String.valueOf(Constants.STATUS_REJECTED), "Rejected");
		statusMap.put(String.valueOf(Constants.STATUS_WAIT_TO_VERIFY), "Wait to Verify");
		statusMap.put(String.valueOf(Constants.STATUS_WAIT_TO_SUMBIT), "Wait for Submission");
		statusMap.put(String.valueOf(Constants.STATUS_VERIFFED), "Verified");
		statusMap.put(String.valueOf(Constants.STATUS_EXISTING), "Existing");
		statusMap.put(String.valueOf(Constants.STATUS_APPROVED), "Approved");
		
		

	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		masterDao.allVesselData();
		masterDao.allCompanyData();
		masterDao.allRank();
		masterDao.allRelation();
		masterDao.allBankLocation();
		masterDao.allConfigData();
		masterDao.userRole();
		
		JobDetail job = JobBuilder.newJob(SchedulerJob.class).withIdentity("Schedule Job For HQ").build();

		// specify the running period of the job
		CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("crontrigger", "BASS")
			.withSchedule(CronScheduleBuilder.cronSchedule("0 1/2 * * * ?")).build(); 
		
		/*CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("crontrigger", "BASS")
				.withSchedule(CronScheduleBuilder.cronSchedule("0 10,44 14 ? 5 FRI")).build(); 
		
		//cronTrigger = TriggerBuilder.newTrigger().withIdentity("crontrigger", "EDI_FILE")
	 		//	.withSchedule(CronScheduleBuilder.cronSchedule("0/1 * * * * ?")).build();
	 	*/
	// schedule the job
			SchedulerFactory schFactory = new StdSchedulerFactory();
			Scheduler sch;
			try {
				sch = schFactory.getScheduler();
				//sch.start();
				//sch.scheduleJob(job, cronTrigger);
			} catch (Exception e) {				
				e.printStackTrace();
			}
			
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getParameter("action");
		if(action.equals("excel")) {
			masterDao.allConfigData();		
			HQSycReadMail hqSycReadMail = new HQSycReadMail();
			try {
				hqSycReadMail.readMailForSync();
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		} 

	}
	public static String getStatus(String code) {
		if(code == null) {
			return  "";
		}
		return statusMap.get(code);
	}

	
	public static String getVesselName(String code) {
		if(code == null) {
			return "";
		}else if(MasterDao.vesselMap.get(code)== null) {
			return code;
		}
		return MasterDao.vesselMap.get(code);
	}

	public static List<ComboBoxMod> getAllVessel() {
		List<ComboBoxMod> list = new ArrayList<ComboBoxMod>();

		for (Entry<String, String> entry : MasterDao.vesselMap.entrySet()) {
			list.add(new ComboBoxMod(entry.getValue(), entry.getKey()));
		}
		return list;
	}

	public static String getCompanyName(String code) {
		if(code == null) {
			return  "";
		}
		return MasterDao.compnayMap.get(code);
	}

	public static List<ComboBoxMod> getAllCompany() {
		List<ComboBoxMod> list = new ArrayList<ComboBoxMod>();

		for (Entry<String, String> entry : MasterDao.compnayMap.entrySet()) {
			list.add(new ComboBoxMod(entry.getValue(), entry.getKey()));
		}
		return list;
	}

	// For rank
	public static String getRank(String code) {
		if(code == null) {
			return  "";
		}
		return MasterDao.rankMap.get(code);

	}

	public static List<ComboBoxMod> getALlRank() {
		List<ComboBoxMod> list = new ArrayList<>();
		for (Entry<String, String> entry : MasterDao.rankMap.entrySet()) {
			list.add(new ComboBoxMod(entry.getValue(), entry.getKey()));
		}
		 
		return list;
	}
	
	// For relation
	public static String getRelation(String code) {
		if(code == null) {
			return  "";
		}
		return MasterDao.rankMap.get(code);
		
	}
	
	public static List<ComboBoxMod> getALlRelation() {
		List<ComboBoxMod> list = new ArrayList<>();
		
		for (Entry<String, String> entry : MasterDao.relationMap.entrySet()) {
			list.add(new ComboBoxMod(entry.getValue(), entry.getKey()));
		}
		System.out.println(list);
		return list;
	}
	
	
//	For User Role
	
	public static String getUserROle(String code) {
		if(code == null) {
			return "";
		}
		return MasterDao.userRoleMap.get(code);
	}
	
	public static List<ComboBoxMod> getAllUserRole(){
		List<ComboBoxMod> list = new ArrayList<>();
		for(Entry<String, String>entry : MasterDao.userRoleMap.entrySet()) {
			list.add(new ComboBoxMod(entry.getValue(), entry.getKey()));
		}
		return list;
	}
	
	
	
	
	
	
	
	
	
	// For bank location
	public static String getBankLocation(String code) {
		if(code == null) {
			return  "";
		}
		return MasterDao.bankLocMap.get(code);
		
	}
	
	public static Map getBankLocationMap() {
		
		return MasterDao.bankLocMap;
		
	}
	
	
	public static List<ComboBoxMod> getAllBanLoc() {
		List<ComboBoxMod> list = new ArrayList<>();
		
		for (Entry<String, String> entry : MasterDao.bankLocMap.entrySet()) {
			list.add(new ComboBoxMod(entry.getValue(), entry.getKey()));
		}
		System.out.println(list);
		return list;
	}
	
	public static String getConfigValue(String code) {
		return MasterDao.configMap.get(code);
	}

}
