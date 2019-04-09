package com.homedepot.ss.sh.webservices.customer.rpc;
/*--------------------------------------------
* This program is proprietary to The Home Depot and is not
* to be reproduced, used, or disclosed without permission
* of:
* 		THE HOME DEPOT
* 		2455 PACES FERRY ROAD, N.W.
* 		ATLANTA, GA  30339
* Application:  <XDRga_hcust_unfvr_ractvy_ib.java>
* Description:
* Client/Server Language:	JAVA CLIENT
* Date Created:	Thu, Jul 22, 2004 11:12:02 AM
* Updated by:	mcs02
* Version:	6
* Tools Used:  <SMUDGE>
* Data Files:
* $Source$
* $Revision:   1.0  $
* $Author:   rlp05  $
* $Date:   31 Aug 2004 13:48:48  $
* $Log:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/customer/rpc/XDRga_hcust_unfvr_ractvy_ib.java_v  $
 * 
 *    Rev 1.0   31 Aug 2004 13:48:48   rlp05
 * InitialRevision
 * 
 *    Rev 1.0   18 Aug 2004 15:00:46   rlp05
 * InitialRevision
------------------------------------------*/

import com.homedepot.ta.aa.JRPC.*;

public class XDRga_hcust_unfvr_ractvy_ib implements XDRType, RPCData
{
	public int str_svc_hcust_nbr;
	public String loc_nbr = "";
	public String loc_typ_cd = "";
	public int ragree_nbr;
	public String loc_nm = "";
	public String rpgm_phn_acty_cd = "";
	public String rpgm_phn_locl_nbr = "";
	public String rpgm_phn_ext_nbr = "";
	public short unfvr_ractvy_cd;
	public XDRSMUdec unfvr_ractvy_amt;
	public int rsltn_dt;
	public int ragree_cls_dt;
	public String last_upd_user_id = "";
	public XDRSMUdtime last_upd_ts;

	private static SMUData mData = new SMUData();

	public void xdr_encode(XDRStream xdrs)
	{
		xdrs.xdr_encode_int(str_svc_hcust_nbr);
		xdrs.xdr_encode_SMUstring(loc_nbr, 5);
		xdrs.xdr_encode_SMUstring(loc_typ_cd, 5);
		xdrs.xdr_encode_int(ragree_nbr);
		xdrs.xdr_encode_SMUstring(loc_nm, 101);
		xdrs.xdr_encode_SMUstring(rpgm_phn_acty_cd, 6);
		xdrs.xdr_encode_SMUstring(rpgm_phn_locl_nbr, 10);
		xdrs.xdr_encode_SMUstring(rpgm_phn_ext_nbr, 6);
		xdrs.xdr_encode_short(unfvr_ractvy_cd);
		unfvr_ractvy_amt.xdr_encode(xdrs);
		xdrs.xdr_encode_int(rsltn_dt);
		xdrs.xdr_encode_int(ragree_cls_dt);
		xdrs.xdr_encode_SMUstring(last_upd_user_id, 9);
		last_upd_ts.xdr_encode(xdrs);
	}

	public void xdr_decode(XDRStream xdrs) throws RPCError
	{
		str_svc_hcust_nbr = xdrs.xdr_decode_int();
		loc_nbr = xdrs.xdr_decode_SMUstring(5);
		loc_typ_cd = xdrs.xdr_decode_SMUstring(5);
		ragree_nbr = xdrs.xdr_decode_int();
		loc_nm = xdrs.xdr_decode_SMUstring(101);
		rpgm_phn_acty_cd = xdrs.xdr_decode_SMUstring(6);
		rpgm_phn_locl_nbr = xdrs.xdr_decode_SMUstring(10);
		rpgm_phn_ext_nbr = xdrs.xdr_decode_SMUstring(6);
		unfvr_ractvy_cd = xdrs.xdr_decode_short();
		unfvr_ractvy_amt = new XDRSMUdec();
		unfvr_ractvy_amt.xdr_decode(xdrs);
		rsltn_dt = xdrs.xdr_decode_int();
		ragree_cls_dt = xdrs.xdr_decode_int();
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
				mData.set(loc_nbr);
				break;
			case 2 :
				mData.set(loc_typ_cd);
				break;
			case 3 :
				mData.set(ragree_nbr);
				break;
			case 4 :
				mData.set(loc_nm);
				break;
			case 5 :
				mData.set(rpgm_phn_acty_cd);
				break;
			case 6 :
				mData.set(rpgm_phn_locl_nbr);
				break;
			case 7 :
				mData.set(rpgm_phn_ext_nbr);
				break;
			case 8 :
				mData.set(unfvr_ractvy_cd);
				break;
			case 9 :
				mData.set(unfvr_ractvy_amt);
				break;
			case 10 :
				mData.set(rsltn_dt);
				break;
			case 11 :
				mData.set(ragree_cls_dt);
				break;
			case 12 :
				mData.set(last_upd_user_id);
				break;
			case 13 :
				mData.set(last_upd_ts);
				break;
			default :
				return null;
		} //switch

		return mData;
	}
}
