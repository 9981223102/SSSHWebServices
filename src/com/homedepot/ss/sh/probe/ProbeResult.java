/**
* This class is used to return Probe Result (UP / DOWN) for Application Probe
*/
package com.homedepot.ss.sh.probe;

import java.util.ArrayList;

/**
 * Checks the major components of an application and saves the result here. This
 * class is accessed by the ApplicationProbe,jsp to display the monitoring
 * results,
 *
 * Application teams need to customize portions of this class for application
 * specific monitoring.
 *
 */

public class ProbeResult {

	/* User defined constants */

	// *************************************************************************************
	/*
	 * Application teams, please modify the following three constant values for
	 * your specific application
	 */
	// *************************************************************************************
	private static final String APPLICATION_NAME = "SSSHWebServices";
	private static final String SYSTEM = "ss";
	private static final String SUBSYSTEM = "sh";

	// *************************************************************************************

	private static final String UP = "<font size='+4'  face='Arial, sans-serif' color='green'>Up </font>";
	private static final String DOWN = "<font size='+4'  face='Arial, sans-serif' color='Red'>Down </font>";

	/* member variables */
	private String _result;
	private String _applicationName;
	private String _system;
	private String _subSystem;
	private ArrayList<String> _messages = new ArrayList<String>();

	/*
	 * Constructor
	 */
	public ProbeResult() {
		_applicationName = APPLICATION_NAME;
		_system = SYSTEM;
		_subSystem = SUBSYSTEM;
	}

	public String getApplicationName() {
		return _applicationName;
	}

	public ArrayList<String> getMessages() {
		return _messages;
	}

	/**
	 * Checks if the application components are working fine.
	 *
	 * @param
	 * @return String "UP" if everything is fine, or "DOWN" if any application
	 *         component returned failure.
	 */
	public String getResult() {
		String errMsg = null;

		_messages.clear();

		ApplProbeDelegate applProbeDelegate = null;

		// Get instance of ApplProbeDelegate
		applProbeDelegate = ApplProbeDelegate.getInstance();

		/*
		 * Check if Database is up. Call should return an appropriate error
		 * message if database is down, or null if everything is fine.
		 */
		errMsg = applProbeDelegate.getProbeResult();

		if (errMsg != null) {
			// Add error message to Array List for display on Application Probe
			// jsp page.
			_messages.add(errMsg);
		}

		// *********************************************************
		/* Add calls for monitoring other components, as necessary */

		// *********************************************************
		/*
		 * If error messages are returned by any component, return DOWN as the
		 * result of monitoring
		 */
		if (_messages.size() == 0) {
			_result = UP;
		} else {
			_result = DOWN;
		}

		return _result;
	}

	public String getSubSystem() {
		return _subSystem;
	}

	public String getSystem() {
		return _system;
	}

}
