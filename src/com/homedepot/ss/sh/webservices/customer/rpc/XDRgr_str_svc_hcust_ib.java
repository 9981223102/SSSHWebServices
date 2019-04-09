package com.homedepot.ss.sh.webservices.customer.rpc;
/*--------------------------------------------
* This program is proprietary to The Home Depot and is not
* to be reproduced, used, or disclosed without permission
* of:
* 		THE HOME DEPOT
* 		2455 PACES FERRY ROAD, N.W.
* 		ATLANTA, GA  30339
* Application:  <XDRgr_str_svc_hcust_ib.java>
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
* $Date:   31 Aug 2004 13:51:48  $
* $Log:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/customer/rpc/XDRgr_str_svc_hcust_ib.java_v  $
 * 
 *    Rev 1.0   31 Aug 2004 13:51:48   rlp05
 * InitialRevision
 * 
 *    Rev 1.0   18 Aug 2004 15:02:32   rlp05
 * InitialRevision
------------------------------------------*/

import com.homedepot.ta.aa.JRPC.*;

public class XDRgr_str_svc_hcust_ib implements XDRType
{
	public int str_svc_hcust_nbr;
	public short cust_typ_cd;
	public short cust_stat_cd;
	public int cust_stat_eff_dt;
	public short cntct_meth_cd;
	public short cntct_addr_typ_cd;
	public short cntct_phn_typ_cd;
	public short cntct_email_typ_cd;
	public XDRSMUdtime cntct_wk_bgn_tm;
	public XDRSMUdtime cntct_wk_end_tm;
	public XDRSMUdtime cntct_wknd_bgn_tm;
	public XDRSMUdtime cntct_wknd_end_tm;
	public String last_upd_user_id = "";
	public XDRSMUdtime last_upd_ts;
	public short email_clt_cd;
	public int email_clt_rqst_dt;

	public void xdr_encode(XDRStream xdrs)
	{
		xdrs.xdr_encode_int(str_svc_hcust_nbr);
		xdrs.xdr_encode_short(cust_typ_cd);
		xdrs.xdr_encode_short(cust_stat_cd);
		xdrs.xdr_encode_int(cust_stat_eff_dt);
		xdrs.xdr_encode_short(cntct_meth_cd);
		xdrs.xdr_encode_short(cntct_addr_typ_cd);
		xdrs.xdr_encode_short(cntct_phn_typ_cd);
		xdrs.xdr_encode_short(cntct_email_typ_cd);
		cntct_wk_bgn_tm.xdr_encode(xdrs);
		cntct_wk_end_tm.xdr_encode(xdrs);
		cntct_wknd_bgn_tm.xdr_encode(xdrs);
		cntct_wknd_end_tm.xdr_encode(xdrs);
		xdrs.xdr_encode_SMUstring(last_upd_user_id, 9);
		last_upd_ts.xdr_encode(xdrs);
		xdrs.xdr_encode_short(email_clt_cd);
		xdrs.xdr_encode_int(email_clt_rqst_dt);
	}

	public void xdr_decode(XDRStream xdrs) throws RPCError
	{
		str_svc_hcust_nbr = xdrs.xdr_decode_int();
		cust_typ_cd = xdrs.xdr_decode_short();
		cust_stat_cd = xdrs.xdr_decode_short();
		cust_stat_eff_dt = xdrs.xdr_decode_int();
		cntct_meth_cd = xdrs.xdr_decode_short();
		cntct_addr_typ_cd = xdrs.xdr_decode_short();
		cntct_phn_typ_cd = xdrs.xdr_decode_short();
		cntct_email_typ_cd = xdrs.xdr_decode_short();
		cntct_wk_bgn_tm = new XDRSMUdtime();
		cntct_wk_bgn_tm.xdr_decode(xdrs);
		cntct_wk_end_tm = new XDRSMUdtime();
		cntct_wk_end_tm.xdr_decode(xdrs);
		cntct_wknd_bgn_tm = new XDRSMUdtime();
		cntct_wknd_bgn_tm.xdr_decode(xdrs);
		cntct_wknd_end_tm = new XDRSMUdtime();
		cntct_wknd_end_tm.xdr_decode(xdrs);
		last_upd_user_id = xdrs.xdr_decode_SMUstring(9);
		last_upd_ts = new XDRSMUdtime();
		last_upd_ts.xdr_decode(xdrs);
		email_clt_cd = xdrs.xdr_decode_short();
		email_clt_rqst_dt = xdrs.xdr_decode_int();
	}

}
