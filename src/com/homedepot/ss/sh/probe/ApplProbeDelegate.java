/**
 * This class is used to invoke the DAO class for Application Probe
 */
package com.homedepot.ss.sh.probe;


public class ApplProbeDelegate {

	private static ApplProbeDelegate applProbeDelegate = null;

	public static ApplProbeDelegate getInstance() {
		if (applProbeDelegate == null) {

			synchronized (ApplProbeDelegate.class) {
				if (applProbeDelegate == null) {
					applProbeDelegate = new ApplProbeDelegate();
				}
			}
		}

		return applProbeDelegate;
	}

	/**
	 *
	 *
	 * @param None
	 *
	 * @return String Probe Data
	 *
	 */
	public String getProbeResult() {
		String probeData = null;
		String interimResult = "";
		StringBuffer sbString = new StringBuffer();

		try {

			sbString.append(interimResult);

		} catch (Exception e) {
			sbString.append(e.getMessage());
		}

		probeData = sbString.toString().trim();

		if ("".equals(probeData))
			probeData = null;

		return probeData;
	}

}
