package com.homedepot.ss.sh.webservices.customer.rpc;
/*--------------------------------------------
* This program is proprietary to The Home Depot and is not
* to be reproduced, used, or disclosed without permission
* of:
* 		THE HOME DEPOT
* 		2455 PACES FERRY ROAD, N.W.
* 		ATLANTA, GA  30339
* Application:  <XDRga_hcust_email_addr_ib.java>
* Description:
* Client/Server Language:	JAVA CLIENT
* Date Created:	Thu, Jul 22, 2004 11:12:01 AM
* Updated by:	mcs02
* Version:	6
* Tools Used:  <SMUDGE>
* Data Files:
* $Source$
* $Revision:   1.0  $
* $Author:   rlp05  $
* $Date:   31 Aug 2004 13:48:22  $
* $Log:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/customer/rpc/XDRga_hcust_email_addr_ib.java_v  $
 * 
 *    Rev 1.0   31 Aug 2004 13:48:22   rlp05
 * InitialRevision
 * 
 *    Rev 1.0   18 Aug 2004 15:00:20   rlp05
 * InitialRevision
------------------------------------------*/

import com.homedepot.ta.aa.JRPC.*;

public class XDRga_hcust_email_addr_ib implements XDRType, RPCData
{
	public int str_svc_hcust_nbr;
	public short email_addr_typ_cd;
	public String email_addr_txt = "";
	public String last_upd_user_id = "";
	public XDRSMUdtime last_upd_ts;
	public String solct_flg = "";

	private static SMUData mData = new SMUData();

	public void xdr_encode(XDRStream xdrs)
	{
		xdrs.xdr_encode_int(str_svc_hcust_nbr);
		xdrs.xdr_encode_short(email_addr_typ_cd);
		xdrs.xdr_encode_SMUstring(email_addr_txt, 151);
		xdrs.xdr_encode_SMUstring(last_upd_user_id, 9);
		last_upd_ts.xdr_encode(xdrs);
		xdrs.xdr_encode_SMUstring(solct_flg, 2);
	}

	public void xdr_decode(XDRStream xdrs) throws RPCError
	{
		str_svc_hcust_nbr = xdrs.xdr_decode_int();
		email_addr_typ_cd = xdrs.xdr_decode_short();
		email_addr_txt = xdrs.xdr_decode_SMUstring(151);
		last_upd_user_id = xdrs.xdr_decode_SMUstring(9);
		last_upd_ts = new XDRSMUdtime();
		last_upd_ts.xdr_decode(xdrs);
		solct_flg = xdrs.xdr_decode_SMUstring(2);
	}

	public SMUData getData(int colNbr)
	{
		switch (colNbr)
		{
			case 0 :
				mData.set(str_svc_hcust_nbr);
				break;
			case 1 :
				mData.set(email_addr_typ_cd);
				break;
			case 2 :
				mData.set(email_addr_txt);
				break;
			case 3 :
				mData.set(last_upd_user_id);
				break;
			case 4 :
				mData.set(last_upd_ts);
				break;
			case 5 :
				mData.set(solct_flg);
				break;
			default :
				return null;
		} //switch

		return mData;
	}
}
