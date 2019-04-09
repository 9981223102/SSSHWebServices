package com.homedepot.ss.sh.webservices.customer.rpc;
/*--------------------------------------------
* This program is proprietary to The Home Depot and is not
* to be reproduced, used, or disclosed without permission
* of:
* 		THE HOME DEPOT
* 		2455 PACES FERRY ROAD, N.W.
* 		ATLANTA, GA  30339
* Application:  <XDRga_hcust_cntct_ib.java>
* Description:
* Client/Server Language:	JAVA CLIENT
* Date Created:	Thu, Jul 22, 2004 11:12:00 AM
* Updated by:	mcs02
* Version:	6
* Tools Used:  <SMUDGE>
* Data Files:
* $Source$
* $Revision:   1.0  $
* $Author:   rlp05  $
* $Date:   31 Aug 2004 13:48:04  $
* $Log:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/customer/rpc/XDRga_hcust_cntct_ib.java_v  $
 * 
 *    Rev 1.0   31 Aug 2004 13:48:04   rlp05
 * InitialRevision
 * 
 *    Rev 1.0   18 Aug 2004 15:00:00   rlp05
 * InitialRevision
------------------------------------------*/

import com.homedepot.ta.aa.JRPC.*;

public class XDRga_hcust_cntct_ib implements XDRType, RPCData
{
	public int str_svc_hcust_nbr;
	public int cntct_hcust_nbr;
	public String loc_typ_cd = "";
	public String loc_nbr = "";
	public int seq_nbr;
	public String actv_flg = "";
	public String agnt_loc_typ_cd = "";
	public String agnt_loc_nbr = "";
	public int agnt_seq_nbr;
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

	private static SMUData mData = new SMUData();

	public void xdr_encode(XDRStream xdrs)
	{
		xdrs.xdr_encode_int(str_svc_hcust_nbr);
		xdrs.xdr_encode_int(cntct_hcust_nbr);
		xdrs.xdr_encode_SMUstring(loc_typ_cd, 5);
		xdrs.xdr_encode_SMUstring(loc_nbr, 5);
		xdrs.xdr_encode_int(seq_nbr);
		xdrs.xdr_encode_SMUstring(actv_flg, 2);
		xdrs.xdr_encode_SMUstring(agnt_loc_typ_cd, 5);
		xdrs.xdr_encode_SMUstring(agnt_loc_nbr, 5);
		xdrs.xdr_encode_int(agnt_seq_nbr);
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
	}

	public void xdr_decode(XDRStream xdrs) throws RPCError
	{
		str_svc_hcust_nbr = xdrs.xdr_decode_int();
		cntct_hcust_nbr = xdrs.xdr_decode_int();
		loc_typ_cd = xdrs.xdr_decode_SMUstring(5);
		loc_nbr = xdrs.xdr_decode_SMUstring(5);
		seq_nbr = xdrs.xdr_decode_int();
		actv_flg = xdrs.xdr_decode_SMUstring(2);
		agnt_loc_typ_cd = xdrs.xdr_decode_SMUstring(5);
		agnt_loc_nbr = xdrs.xdr_decode_SMUstring(5);
		agnt_seq_nbr = xdrs.xdr_decode_int();
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
	}

	public SMUData getData(int colNbr)
	{
		switch (colNbr)
		{
			case 0 :
				mData.set(str_svc_hcust_nbr);
				break;
			case 1 :
				mData.set(cntct_hcust_nbr);
				break;
			case 2 :
				mData.set(loc_typ_cd);
				break;
			case 3 :
				mData.set(loc_nbr);
				break;
			case 4 :
				mData.set(seq_nbr);
				break;
			case 5 :
				mData.set(actv_flg);
				break;
			case 6 :
				mData.set(agnt_loc_typ_cd);
				break;
			case 7 :
				mData.set(agnt_loc_nbr);
				break;
			case 8 :
				mData.set(agnt_seq_nbr);
				break;
			case 9 :
				mData.set(cntct_meth_cd);
				break;
			case 10 :
				mData.set(cntct_addr_typ_cd);
				break;
			case 11 :
				mData.set(cntct_phn_typ_cd);
				break;
			case 12 :
				mData.set(cntct_email_typ_cd);
				break;
			case 13 :
				mData.set(cntct_wk_bgn_tm);
				break;
			case 14 :
				mData.set(cntct_wk_end_tm);
				break;
			case 15 :
				mData.set(cntct_wknd_bgn_tm);
				break;
			case 16 :
				mData.set(cntct_wknd_end_tm);
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
