/* Copyright (c) 2022 RCL| All Rights Reserved*/
package com.rclgroup.dolphin.web.ws;

/* -------------------------- Change Log ----------------------------------------
##   DD/MM/YY       -User-                          -TaskRef-            -ShortDescription-
1    19/03/20       Chandrabhan harode               Initial Version
---------------------------------------------------------------------------------
*/
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

/**
 * This class is extends of {@code Application}
 * @author Cognis Solution
 */
public class VesselApplication extends Application {
	public Set<Class<?>> getClasses() {
		Set<Class<?>> setOfService = new HashSet<Class<?>>();
		setOfService.add(VesselLoginService.class);
		setOfService.add(CrewService.class);
		setOfService.add(FAService.class);
		setOfService.add(HQService.class);
		setOfService.add(CrewMasterService.class);
		setOfService.add(ComanyVesselService.class);
		setOfService.add(SummaryService.class);
		setOfService.add(HQUserService.class);
		return setOfService;
	}
}