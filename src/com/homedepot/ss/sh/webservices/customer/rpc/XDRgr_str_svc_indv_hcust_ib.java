package com.homedepot.ss.sh.webservices.customer.rpc;
/*--------------------------------------------
* This program is proprietary to The Home Depot and is not
* to be reproduced, used, or disclosed without permission
* of:
* 		THE HOME DEPOT
* 		2455 PACES FERRY ROAD, N.W.
* 		ATLANTA, GA  30339
* Application:  <XDRgr_str_svc_indv_hcust_ib.java>
* Description:
* Client/Server Language:	JAVA CLIENT
* Date Created:	Thu, Jul 22, 2004 11:12:07 AM
* Updated by:	mcs02
* Version:	6
* Tools Used:  <SMUDGE>
* Data Files:
* $Source$
* $Revision:   1.0  $
* $Author:   rlp05  $
* $Date:   31 Aug 2004 13:51:58  $
* $Log:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/customer/rpc/XDRgr_str_svc_indv_hcust_ib.java_v  $
 * 
 *    Rev 1.0   31 Aug 2004 13:51:58   rlp05
 * InitialRevision
 * 
 *    Rev 1.0   18 Aug 2004 15:02:40   rlp05
 * InitialRevision
------------------------------------------*/

import com.homedepot.ta.aa.JRPC.*;

public class XDRgr_str_svc_indv_hcust_ib implements XDRType
{
	public int str_svc_hcust_nbr;
	public String frst_nm = "";
	public String mid_nm = "";
	public String last_nm = "";
	public String sfx_nm = "";
	public String ttl_nm = "";
	public int brth_dt;
	public String last_upd_user_id = "";
	public XDRSMUdtime last_upd_ts;

	public void xdr_encode(XDRStream xdrs)
	{
		xdrs.xdr_encode_int(str_svc_hcust_nbr);
		xdrs.xdr_encode_SMUstring(frst_nm, 41);
		xdrs.xdr_encode_SMUstring(mid_nm, 61);
		xdrs.xdr_encode_SMUstring(last_nm, 61);
		xdrs.xdr_encode_SMUstring(sfx_nm, 11);
		xdrs.xdr_encode_SMUstring(ttl_nm, 21);
		xdrs.xdr_encode_int(brth_dt);
		xdrs.xdr_encode_SMUstring(last_upd_user_id, 9);
		last_upd_ts.xdr_encode(xdrs);
	}

	public void xdr_decode(XDRStream xdrs) throws RPCError
	{
		str_svc_hcust_nbr = xdrs.xdr_decode_int();
		frst_nm = xdrs.xdr_decode_SMUstring(41);
		mid_nm = xdrs.xdr_decode_SMUstring(61);
		last_nm = xdrs.xdr_decode_SMUstring(61);
		sfx_nm = xdrs.xdr_decode_SMUstring(11);
		ttl_nm = xdrs.xdr_decode_SMUstring(21);
		brth_dt = xdrs.xdr_decode_int();
		last_upd_user_id = xdrs.xdr_decode_SMUstring(9);
		last_upd_ts = new XDRSMUdtime();
		last_upd_ts.xdr_decode(xdrs);
	}

}
