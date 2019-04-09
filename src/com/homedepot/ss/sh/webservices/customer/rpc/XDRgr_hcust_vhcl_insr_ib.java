package com.homedepot.ss.sh.webservices.customer.rpc;
/*--------------------------------------------
* This program is proprietary to The Home Depot and is not
* to be reproduced, used, or disclosed without permission
* of:
* 		THE HOME DEPOT
* 		2455 PACES FERRY ROAD, N.W.
* 		ATLANTA, GA  30339
* Application:  <XDRgr_hcust_vhcl_insr_ib.java>
* Description:
* Client/Server Language:	JAVA CLIENT
* Date Created:	Thu, Jul 22, 2004 11:12:06 AM
* Updated by:	mcs02
* Version:	6
* Tools Used:  <SMUDGE>
* Data Files:
* $Source$
* $Revision:   1.0  $
* $Author:   rlp05  $
* $Date:   31 Aug 2004 13:51:22  $
* $Log:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/customer/rpc/XDRgr_hcust_vhcl_insr_ib.java_v  $
 * 
 *    Rev 1.0   31 Aug 2004 13:51:22   rlp05
 * InitialRevision
 * 
 *    Rev 1.0   18 Aug 2004 15:02:02   rlp05
 * InitialRevision
------------------------------------------*/

import com.homedepot.ta.aa.JRPC.*;

public class XDRgr_hcust_vhcl_insr_ib implements XDRType
{
	public int str_svc_hcust_nbr;
	public String insr_plcy_nbr = "";
	public String insr_prvdr_nm = "";
	public int insr_plcy_expir_dt;
	public String phn_area_city_cd = "";
	public String phn_locl_nbr = "";
	public String phn_ext_nbr = "";
	public String last_upd_user_id = "";
	public XDRSMUdtime last_upd_ts;

	public void xdr_encode(XDRStream xdrs)
	{
		xdrs.xdr_encode_int(str_svc_hcust_nbr);
		xdrs.xdr_encode_SMUstring(insr_plcy_nbr, 21);
		xdrs.xdr_encode_SMUstring(insr_prvdr_nm, 101);
		xdrs.xdr_encode_int(insr_plcy_expir_dt);
		xdrs.xdr_encode_SMUstring(phn_area_city_cd, 6);
		xdrs.xdr_encode_SMUstring(phn_locl_nbr, 10);
		xdrs.xdr_encode_SMUstring(phn_ext_nbr, 6);
		xdrs.xdr_encode_SMUstring(last_upd_user_id, 9);
		last_upd_ts.xdr_encode(xdrs);
	}

	public void xdr_decode(XDRStream xdrs) throws RPCError
	{
		str_svc_hcust_nbr = xdrs.xdr_decode_int();
		insr_plcy_nbr = xdrs.xdr_decode_SMUstring(21);
		insr_prvdr_nm = xdrs.xdr_decode_SMUstring(101);
		insr_plcy_expir_dt = xdrs.xdr_decode_int();
		phn_area_city_cd = xdrs.xdr_decode_SMUstring(6);
		phn_locl_nbr = xdrs.xdr_decode_SMUstring(10);
		phn_ext_nbr = xdrs.xdr_decode_SMUstring(6);
		last_upd_user_id = xdrs.xdr_decode_SMUstring(9);
		last_upd_ts = new XDRSMUdtime();
		last_upd_ts.xdr_decode(xdrs);
	}

}
