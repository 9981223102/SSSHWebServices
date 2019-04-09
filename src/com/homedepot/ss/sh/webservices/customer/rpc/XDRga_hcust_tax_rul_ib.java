package com.homedepot.ss.sh.webservices.customer.rpc;
/*--------------------------------------------
* This program is proprietary to The Home Depot and is not
* to be reproduced, used, or disclosed without permission
* of:
* 		THE HOME DEPOT
* 		2455 PACES FERRY ROAD, N.W.
* 		ATLANTA, GA  30339
* Application:  <XDRga_hcust_tax_rul_ib.java>
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
* $Date:   31 Aug 2004 13:48:36  $
* $Log:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/customer/rpc/XDRga_hcust_tax_rul_ib.java_v  $
 * 
 *    Rev 1.0   31 Aug 2004 13:48:36   rlp05
 * InitialRevision
 * 
 *    Rev 1.0   18 Aug 2004 15:00:30   rlp05
 * InitialRevision
------------------------------------------*/

import com.homedepot.ta.aa.JRPC.*;

public class XDRga_hcust_tax_rul_ib implements XDRType, RPCData
{
	public int str_svc_hcust_nbr;
	public String loc_typ_cd = "";
	public String loc_nbr = "";
	public int seq_nbr;
	public short jursd_typ_cd;
	public short jursd_lvl_cd;
	public int jursd_cd;
	public short tax_typ_cd;
	public short tax_cd;
	public String tax_exmpt_actv_flg = "";
	public int eff_bgn_dt;
	public int eff_end_dt;
	public String tax_paymt_auth_flg = "";
	public XDRSMUdec tax_exmpt_amt;
	public XDRSMUdec tax_exmpt_pct;
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
		xdrs.xdr_encode_short(tax_typ_cd);
		xdrs.xdr_encode_short(tax_cd);
		xdrs.xdr_encode_SMUstring(tax_exmpt_actv_flg, 2);
		xdrs.xdr_encode_int(eff_bgn_dt);
		xdrs.xdr_encode_int(eff_end_dt);
		xdrs.xdr_encode_SMUstring(tax_paymt_auth_flg, 2);
		tax_exmpt_amt.xdr_encode(xdrs);
		tax_exmpt_pct.xdr_encode(xdrs);
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
		tax_typ_cd = xdrs.xdr_decode_short();
		tax_cd = xdrs.xdr_decode_short();
		tax_exmpt_actv_flg = xdrs.xdr_decode_SMUstring(2);
		eff_bgn_dt = xdrs.xdr_decode_int();
		eff_end_dt = xdrs.xdr_decode_int();
		tax_paymt_auth_flg = xdrs.xdr_decode_SMUstring(2);
		tax_exmpt_amt = new XDRSMUdec();
		tax_exmpt_amt.xdr_decode(xdrs);
		tax_exmpt_pct = new XDRSMUdec();
		tax_exmpt_pct.xdr_decode(xdrs);
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
				mData.set(tax_typ_cd);
				break;
			case 8 :
				mData.set(tax_cd);
				break;
			case 9 :
				mData.set(tax_exmpt_actv_flg);
				break;
			case 10 :
				mData.set(eff_bgn_dt);
				break;
			case 11 :
				mData.set(eff_end_dt);
				break;
			case 12 :
				mData.set(tax_paymt_auth_flg);
				break;
			case 13 :
				mData.set(tax_exmpt_amt);
				break;
			case 14 :
				mData.set(tax_exmpt_pct);
				break;
			case 15 :
				mData.set(last_upd_user_id);
				break;
			case 16 :
				mData.set(last_upd_ts);
				break;
			default :
				return null;
		} //switch

		return mData;
	}
}
