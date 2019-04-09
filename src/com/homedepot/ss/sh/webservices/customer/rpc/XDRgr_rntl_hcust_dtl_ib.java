package com.homedepot.ss.sh.webservices.customer.rpc;
/*--------------------------------------------
* This program is proprietary to The Home Depot and is not
* to be reproduced, used, or disclosed without permission
* of:
* 		THE HOME DEPOT
* 		2455 PACES FERRY ROAD, N.W.
* 		ATLANTA, GA  30339
* Application:  <XDRgr_rntl_hcust_dtl_ib.java>
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
* $Date:   31 Aug 2004 13:51:32  $
* $Log:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/customer/rpc/XDRgr_rntl_hcust_dtl_ib.java_v  $
 * 
 *    Rev 1.0   31 Aug 2004 13:51:32   rlp05
 * InitialRevision
 * 
 *    Rev 1.0   18 Aug 2004 15:02:12   rlp05
 * InitialRevision
------------------------------------------*/

import com.homedepot.ta.aa.JRPC.*;

public class XDRgr_rntl_hcust_dtl_ib implements XDRType
{
	public int str_svc_hcust_nbr;
	public short cust_stat_cd;
	public String dflt_depst_meth_cd = "";
	public String dmg_wvr_reqd_flg = "";
	public String cust_po_reqd_flg = "";
	public String job_site_reqd_flg = "";
	public short ltd_rntl_cnt;
	public XDRSMUdec ltd_rntl_amt;
	public int cust_last_rntl_dt;
	public int tax_exmpt_upd_dt;
	public String fed_tax_id = "";
	public String last_upd_user_id = "";
	public XDRSMUdtime last_upd_ts;

	public void xdr_encode(XDRStream xdrs)
	{
		xdrs.xdr_encode_int(str_svc_hcust_nbr);
		xdrs.xdr_encode_short(cust_stat_cd);
		xdrs.xdr_encode_SMUstring(dflt_depst_meth_cd, 3);
		xdrs.xdr_encode_SMUstring(dmg_wvr_reqd_flg, 2);
		xdrs.xdr_encode_SMUstring(cust_po_reqd_flg, 2);
		xdrs.xdr_encode_SMUstring(job_site_reqd_flg, 2);
		xdrs.xdr_encode_short(ltd_rntl_cnt);
		ltd_rntl_amt.xdr_encode(xdrs);
		xdrs.xdr_encode_int(cust_last_rntl_dt);
		xdrs.xdr_encode_int(tax_exmpt_upd_dt);
		xdrs.xdr_encode_SMUstring(fed_tax_id, 26);
		xdrs.xdr_encode_SMUstring(last_upd_user_id, 9);
		last_upd_ts.xdr_encode(xdrs);
	}

	public void xdr_decode(XDRStream xdrs) throws RPCError
	{
		str_svc_hcust_nbr = xdrs.xdr_decode_int();
		cust_stat_cd = xdrs.xdr_decode_short();
		dflt_depst_meth_cd = xdrs.xdr_decode_SMUstring(3);
		dmg_wvr_reqd_flg = xdrs.xdr_decode_SMUstring(2);
		cust_po_reqd_flg = xdrs.xdr_decode_SMUstring(2);
		job_site_reqd_flg = xdrs.xdr_decode_SMUstring(2);
		ltd_rntl_cnt = xdrs.xdr_decode_short();
		ltd_rntl_amt = new XDRSMUdec();
		ltd_rntl_amt.xdr_decode(xdrs);
		cust_last_rntl_dt = xdrs.xdr_decode_int();
		tax_exmpt_upd_dt = xdrs.xdr_decode_int();
		fed_tax_id = xdrs.xdr_decode_SMUstring(26);
		last_upd_user_id = xdrs.xdr_decode_SMUstring(9);
		last_upd_ts = new XDRSMUdtime();
		last_upd_ts.xdr_decode(xdrs);
	}

}
