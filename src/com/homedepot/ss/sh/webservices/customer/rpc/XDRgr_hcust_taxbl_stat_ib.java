package com.homedepot.ss.sh.webservices.customer.rpc;
/*--------------------------------------------
* This program is proprietary to The Home Depot and is not
* to be reproduced, used, or disclosed without permission
* of:
* 		THE HOME DEPOT
* 		2455 PACES FERRY ROAD, N.W.
* 		ATLANTA, GA  30339
* Application:  <XDRgr_hcust_taxbl_stat_ib.java>
* Description:
* Client/Server Language:	JAVA CLIENT
* Date Created:	Thu, Jul 22, 2004 11:12:05 AM
* Updated by:	mcs02
* Version:	6
* Tools Used:  <SMUDGE>
* Data Files:
* $Source$
* $Revision:   1.0  $
* $Author:   rlp05  $
* $Date:   31 Aug 2004 13:51:10  $
* $Log:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/customer/rpc/XDRgr_hcust_taxbl_stat_ib.java_v  $
 * 
 *    Rev 1.0   31 Aug 2004 13:51:10   rlp05
 * InitialRevision
 * 
 *    Rev 1.0   18 Aug 2004 15:01:52   rlp05
 * InitialRevision
------------------------------------------*/

import com.homedepot.ta.aa.JRPC.*;

public class XDRgr_hcust_taxbl_stat_ib implements XDRType
{
	public int str_svc_hcust_nbr;
	public short taxbl_stat_cd;
	public int tax_pay_agree_cd;
	public String last_upd_user_id = "";
	public XDRSMUdtime last_upd_ts;

	public void xdr_encode(XDRStream xdrs)
	{
		xdrs.xdr_encode_int(str_svc_hcust_nbr);
		xdrs.xdr_encode_short(taxbl_stat_cd);
		xdrs.xdr_encode_int(tax_pay_agree_cd);
		xdrs.xdr_encode_SMUstring(last_upd_user_id, 9);
		last_upd_ts.xdr_encode(xdrs);
	}

	public void xdr_decode(XDRStream xdrs) throws RPCError
	{
		str_svc_hcust_nbr = xdrs.xdr_decode_int();
		taxbl_stat_cd = xdrs.xdr_decode_short();
		tax_pay_agree_cd = xdrs.xdr_decode_int();
		last_upd_user_id = xdrs.xdr_decode_SMUstring(9);
		last_upd_ts = new XDRSMUdtime();
		last_upd_ts.xdr_decode(xdrs);
	}

}
