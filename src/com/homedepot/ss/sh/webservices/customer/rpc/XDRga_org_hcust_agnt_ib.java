package com.homedepot.ss.sh.webservices.customer.rpc;
/*--------------------------------------------
* This program is proprietary to The Home Depot and is not
* to be reproduced, used, or disclosed without permission
* of:
* 		THE HOME DEPOT
* 		2455 PACES FERRY ROAD, N.W.
* 		ATLANTA, GA  30339
* Application:  <XDRga_org_hcust_agnt_ib.java>
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
* $Date:   31 Aug 2004 13:49:02  $
* $Log:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/customer/rpc/XDRga_org_hcust_agnt_ib.java_v  $
 * 
 *    Rev 1.0   31 Aug 2004 13:49:02   rlp05
 * InitialRevision
 * 
 *    Rev 1.0   18 Aug 2004 15:00:54   rlp05
 * InitialRevision
------------------------------------------*/

import com.homedepot.ta.aa.JRPC.*;

public class XDRga_org_hcust_agnt_ib implements XDRType, RPCData
{
	public int str_svc_hcust_nbr;
	public String loc_typ_cd = "";
	public String loc_nbr = "";
	public int seq_nbr;
	public XDRSMUdtime crt_ts;
	public short jursd_typ_cd;
	public short jursd_lvl_cd;
	public int jursd_cd;
	public short cust_id_typ_cd;
	public String cust_id_nbr = "";
	public int cust_id_expir_dt;
	public String frst_nm = "";
	public String mid_nm = "";
	public String last_nm = "";
	public String sfx_nm = "";
	public String ttl_nm = "";
	public String actv_flg = "";
	public String last_upd_user_id = "";
	public XDRSMUdtime last_upd_ts;

	private static SMUData mData = new SMUData();

	public void xdr_encode(XDRStream xdrs)
	{
		xdrs.xdr_encode_int(str_svc_hcust_nbr);
		xdrs.xdr_encode_SMUstring(loc_typ_cd, 5);
		xdrs.xdr_encode_SMUstring(loc_nbr, 5);
		xdrs.xdr_encode_int(seq_nbr);
		crt_ts.xdr_encode(xdrs);
		xdrs.xdr_encode_short(jursd_typ_cd);
		xdrs.xdr_encode_short(jursd_lvl_cd);
		xdrs.xdr_encode_int(jursd_cd);
		xdrs.xdr_encode_short(cust_id_typ_cd);
		xdrs.xdr_encode_SMUstring(cust_id_nbr, 26);
		xdrs.xdr_encode_int(cust_id_expir_dt);
		xdrs.xdr_encode_SMUstring(frst_nm, 41);
		xdrs.xdr_encode_SMUstring(mid_nm, 61);
		xdrs.xdr_encode_SMUstring(last_nm, 61);
		xdrs.xdr_encode_SMUstring(sfx_nm, 11);
		xdrs.xdr_encode_SMUstring(ttl_nm, 21);
		xdrs.xdr_encode_SMUstring(actv_flg, 2);
		xdrs.xdr_encode_SMUstring(last_upd_user_id, 9);
		last_upd_ts.xdr_encode(xdrs);
	}

	public void xdr_decode(XDRStream xdrs) throws RPCError
	{
		str_svc_hcust_nbr = xdrs.xdr_decode_int();
		loc_typ_cd = xdrs.xdr_decode_SMUstring(5);
		loc_nbr = xdrs.xdr_decode_SMUstring(5);
		seq_nbr = xdrs.xdr_decode_int();
		crt_ts = new XDRSMUdtime();
		crt_ts.xdr_decode(xdrs);
		jursd_typ_cd = xdrs.xdr_decode_short();
		jursd_lvl_cd = xdrs.xdr_decode_short();
		jursd_cd = xdrs.xdr_decode_int();
		cust_id_typ_cd = xdrs.xdr_decode_short();
		cust_id_nbr = xdrs.xdr_decode_SMUstring(26);
		cust_id_expir_dt = xdrs.xdr_decode_int();
		frst_nm = xdrs.xdr_decode_SMUstring(41);
		mid_nm = xdrs.xdr_decode_SMUstring(61);
		last_nm = xdrs.xdr_decode_SMUstring(61);
		sfx_nm = xdrs.xdr_decode_SMUstring(11);
		ttl_nm = xdrs.xdr_decode_SMUstring(21);
		actv_flg = xdrs.xdr_decode_SMUstring(2);
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
				mData.set(crt_ts);
				break;
			case 5 :
				mData.set(jursd_typ_cd);
				break;
			case 6 :
				mData.set(jursd_lvl_cd);
				break;
			case 7 :
				mData.set(jursd_cd);
				break;
			case 8 :
				mData.set(cust_id_typ_cd);
				break;
			case 9 :
				mData.set(cust_id_nbr);
				break;
			case 10 :
				mData.set(cust_id_expir_dt);
				break;
			case 11 :
				mData.set(frst_nm);
				break;
			case 12 :
				mData.set(mid_nm);
				break;
			case 13 :
				mData.set(last_nm);
				break;
			case 14 :
				mData.set(sfx_nm);
				break;
			case 15 :
				mData.set(ttl_nm);
				break;
			case 16 :
				mData.set(actv_flg);
				break;
			case 17 :
				mData.set(last_upd_user_id);
				break;
			case 18 :
				mData.set(last_upd_ts);
				break;
			default :
				return null;
		} //switch

		return mData;
	}
}
