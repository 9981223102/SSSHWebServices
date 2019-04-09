package com.homedepot.ss.sh.webservices.customer.rpc;
/*--------------------------------------------
* This program is proprietary to The Home Depot and is not
* to be reproduced, used, or disclosed without permission
* of:
* 		THE HOME DEPOT
* 		2455 PACES FERRY ROAD, N.W.
* 		ATLANTA, GA  30339
* Application:  <XDRga_str_svc_hcust_phn_ib.java>
* Description:
* Client/Server Language:	JAVA CLIENT
* Date Created:	Thu, Jul 22, 2004 11:12:04 AM
* Updated by:	mcs02
* Version:	6
* Tools Used:  <SMUDGE>
* Data Files:
* $Source$
* $Revision:   1.0  $
* $Author:   rlp05  $
* $Date:   31 Aug 2004 13:49:40  $
* $Log:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/customer/rpc/XDRga_str_svc_hcust_phn_ib.java_v  $
 * 
 *    Rev 1.0   31 Aug 2004 13:49:40   rlp05
 * InitialRevision
 * 
 *    Rev 1.0   18 Aug 2004 15:01:24   rlp05
 * InitialRevision
------------------------------------------*/

import com.homedepot.ta.aa.JRPC.*;

public class XDRga_str_svc_hcust_phn_ib implements XDRType, RPCData
{
	public int str_svc_hcust_nbr;
	public short phn_nbr_typ_cd;
	public String phn_area_city_cd = "";
	public String phn_locl_nbr = "";
	public String phn_ext_nbr = "";
	public String cntry_cd = "";
	public String pref_phn_flg = "";
	public String phn_pin_nbr = "";
	public String last_upd_user_id = "";
	public XDRSMUdtime last_upd_ts;

	private static SMUData mData = new SMUData();

	public void xdr_encode(XDRStream xdrs)
	{
		xdrs.xdr_encode_int(str_svc_hcust_nbr);
		xdrs.xdr_encode_short(phn_nbr_typ_cd);
		xdrs.xdr_encode_SMUstring(phn_area_city_cd, 6);
		xdrs.xdr_encode_SMUstring(phn_locl_nbr, 10);
		xdrs.xdr_encode_SMUstring(phn_ext_nbr, 6);
		xdrs.xdr_encode_SMUstring(cntry_cd, 3);
		xdrs.xdr_encode_SMUstring(pref_phn_flg, 2);
		xdrs.xdr_encode_SMUstring(phn_pin_nbr, 21);
		xdrs.xdr_encode_SMUstring(last_upd_user_id, 9);
		last_upd_ts.xdr_encode(xdrs);
	}

	public void xdr_decode(XDRStream xdrs) throws RPCError
	{
		str_svc_hcust_nbr = xdrs.xdr_decode_int();
		phn_nbr_typ_cd = xdrs.xdr_decode_short();
		phn_area_city_cd = xdrs.xdr_decode_SMUstring(6);
		phn_locl_nbr = xdrs.xdr_decode_SMUstring(10);
		phn_ext_nbr = xdrs.xdr_decode_SMUstring(6);
		cntry_cd = xdrs.xdr_decode_SMUstring(3);
		pref_phn_flg = xdrs.xdr_decode_SMUstring(2);
		phn_pin_nbr = xdrs.xdr_decode_SMUstring(21);
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
				mData.set(phn_nbr_typ_cd);
				break;
			case 2 :
				mData.set(phn_area_city_cd);
				break;
			case 3 :
				mData.set(phn_locl_nbr);
				break;
			case 4 :
				mData.set(phn_ext_nbr);
				break;
			case 5 :
				mData.set(cntry_cd);
				break;
			case 6 :
				mData.set(pref_phn_flg);
				break;
			case 7 :
				mData.set(phn_pin_nbr);
				break;
			case 8 :
				mData.set(last_upd_user_id);
				break;
			case 9 :
				mData.set(last_upd_ts);
				break;
			default :
				return null;
		} //switch

		return mData;
	}
}
