package com.homedepot.ss.sh.webservices.customer.rpc;
/*--------------------------------------------
* This program is proprietary to The Home Depot and is not
* to be reproduced, used, or disclosed without permission
* of:
* 		THE HOME DEPOT
* 		2455 PACES FERRY ROAD, N.W.
* 		ATLANTA, GA  30339
* Application:  <XDRga_str_svc_hcust_id_ib.java>
* Description:
* Client/Server Language:	JAVA CLIENT
* Date Created:	Thu, Jul 22, 2004 11:12:03 AM
* Updated by:	mcs02
* Version:	6
* Tools Used:  <SMUDGE>
* Data Files:
* $Source$
* $Revision:   1.0  $
* $Author:   rlp05  $
* $Date:   31 Aug 2004 13:49:30  $
* $Log:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/customer/rpc/XDRga_str_svc_hcust_id_ib.java_v  $
 * 
 *    Rev 1.0   31 Aug 2004 13:49:30   rlp05
 * InitialRevision
 * 
 *    Rev 1.0   18 Aug 2004 15:01:14   rlp05
 * InitialRevision
------------------------------------------*/

import com.homedepot.ta.aa.JRPC.*;

public class XDRga_str_svc_hcust_id_ib implements XDRType, RPCData
{
	public int str_svc_hcust_nbr;
	public String loc_typ_cd = "";
	public String loc_nbr = "";
	public int seq_nbr;
	public short jursd_typ_cd;
	public short jursd_lvl_cd;
	public int jursd_cd;
	public short cust_id_typ_cd;
	public String cust_id_nbr = "";
	public int cust_id_expir_dt;
	public String last_upd_user_id = "";
	public XDRSMUdtime last_upd_ts;

	private static SMUData mData = new SMUData();

	public void xdr_encode(XDRStream xdrs)
	{
		xdrs.xdr_encode_int(str_svc_hcust_nbr);
		xdrs.xdr_encode_SMUstring(loc_typ_cd, 5);
		xdrs.xdr_encode_SMUstring(loc_nbr, 5);
		xdrs.xdr_encode_int(seq_nbr);
		xdrs.xdr_encode_short(jursd_typ_cd);
		xdrs.xdr_encode_short(jursd_lvl_cd);
		xdrs.xdr_encode_int(jursd_cd);
		xdrs.xdr_encode_short(cust_id_typ_cd);
		xdrs.xdr_encode_SMUstring(cust_id_nbr, 26);
		xdrs.xdr_encode_int(cust_id_expir_dt);
		xdrs.xdr_encode_SMUstring(last_upd_user_id, 9);
		last_upd_ts.xdr_encode(xdrs);
	}

	public void xdr_decode(XDRStream xdrs) throws RPCError
	{
		str_svc_hcust_nbr = xdrs.xdr_decode_int();
		loc_typ_cd = xdrs.xdr_decode_SMUstring(5);
		loc_nbr = xdrs.xdr_decode_SMUstring(5);
		seq_nbr = xdrs.xdr_decode_int();
		jursd_typ_cd = xdrs.xdr_decode_short();
		jursd_lvl_cd = xdrs.xdr_decode_short();
		jursd_cd = xdrs.xdr_decode_int();
		cust_id_typ_cd = xdrs.xdr_decode_short();
		cust_id_nbr = xdrs.xdr_decode_SMUstring(26);
		cust_id_expir_dt = xdrs.xdr_decode_int();
		last_upd_user_id = xdrs.xdr_decode_SMUstring(9);
		last_upd_ts = new XDRSMUdtime();
		last_upd_ts.xdr_decode(xdrs);
	}

	public SMUData getData(int colNbr)
	{
		switch (colNbr)
		{
			case 0 :
				mData.set(str_svc_hcust_nbr);
				break;
			case 1 :
				mData.set(loc_typ_cd);
				break;
			case 2 :
				mData.set(loc_nbr);
				break;
			case 3 :
				mData.set(seq_nbr);
				break;
			case 4 :
				mData.set(jursd_typ_cd);
				break;
			case 5 :
				mData.set(jursd_lvl_cd);
				break;
			case 6 :
				mData.set(jursd_cd);
				break;
			case 7 :
				mData.set(cust_id_typ_cd);
				break;
			case 8 :
				mData.set(cust_id_nbr);
				break;
			case 9 :
				mData.set(cust_id_expir_dt);
				break;
			case 10 :
				mData.set(last_upd_user_id);
				break;
			case 11 :
				mData.set(last_upd_ts);
				break;
			default :
				return null;
		} //switch

		return mData;
	}
}
