package com.homedepot.ss.sh.webservices.customer.rpc;
/*--------------------------------------------
* This program is proprietary to The Home Depot and is not
* to be reproduced, used, or disclosed without permission
* of:
* 		THE HOME DEPOT
* 		2455 PACES FERRY ROAD, N.W.
* 		ATLANTA, GA  30339
* Application:  <XDRgr_str_svc_org_hcust_ib.java>
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
* $Date:   31 Aug 2004 13:52:20  $
* $Log:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/customer/rpc/XDRgr_str_svc_org_hcust_ib.java_v  $
 * 
 *    Rev 1.0   31 Aug 2004 13:52:20   rlp05
 * InitialRevision
 * 
 *    Rev 1.0   18 Aug 2004 15:02:50   rlp05
 * InitialRevision
------------------------------------------*/

import com.homedepot.ta.aa.JRPC.*;

public class XDRgr_str_svc_org_hcust_ib implements XDRType
{
	public int str_svc_hcust_nbr;
	public String org_cust_nm = "";
	public String sic_cd = "";
	public String tax_exmpt_flg = "";
	public int tax_exmpt_upd_dt;
	public String fed_tax_id = "";
	public String last_upd_user_id = "";
	public XDRSMUdtime last_upd_ts;

	public void xdr_encode(XDRStream xdrs)
	{
		xdrs.xdr_encode_int(str_svc_hcust_nbr);
		xdrs.xdr_encode_SMUstring(org_cust_nm, 101);
		xdrs.xdr_encode_SMUstring(sic_cd, 5);
		xdrs.xdr_encode_SMUstring(tax_exmpt_flg, 2);
		xdrs.xdr_encode_int(tax_exmpt_upd_dt);
		xdrs.xdr_encode_SMUstring(fed_tax_id, 26);
		xdrs.xdr_encode_SMUstring(last_upd_user_id, 9);
		last_upd_ts.xdr_encode(xdrs);
	}

	public void xdr_decode(XDRStream xdrs) throws RPCError
	{
		str_svc_hcust_nbr = xdrs.xdr_decode_int();
		org_cust_nm = xdrs.xdr_decode_SMUstring(101);
		sic_cd = xdrs.xdr_decode_SMUstring(5);
		tax_exmpt_flg = xdrs.xdr_decode_SMUstring(2);
		tax_exmpt_upd_dt = xdrs.xdr_decode_int();
		fed_tax_id = xdrs.xdr_decode_SMUstring(26);
		last_upd_user_id = xdrs.xdr_decode_SMUstring(9);
		last_upd_ts = new XDRSMUdtime();
		last_upd_ts.xdr_decode(xdrs);
	}

}
