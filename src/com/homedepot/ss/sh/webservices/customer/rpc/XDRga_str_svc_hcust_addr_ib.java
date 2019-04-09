package com.homedepot.ss.sh.webservices.customer.rpc;
/*--------------------------------------------
* This program is proprietary to The Home Depot and is not
* to be reproduced, used, or disclosed without permission
* of:
* 		THE HOME DEPOT
* 		2455 PACES FERRY ROAD, N.W.
* 		ATLANTA, GA  30339
* Application:  <XDRga_str_svc_hcust_addr_ib.java>
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
* $Date:   31 Aug 2004 13:49:16  $
* $Log:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/customer/rpc/XDRga_str_svc_hcust_addr_ib.java_v  $
 * 
 *    Rev 1.0   31 Aug 2004 13:49:16   rlp05
 * InitialRevision
 * 
 *    Rev 1.0   18 Aug 2004 15:01:04   rlp05
 * InitialRevision
------------------------------------------*/

import com.homedepot.ta.aa.JRPC.*;

public class XDRga_str_svc_hcust_addr_ib implements XDRType, RPCData
{
	public int str_svc_hcust_nbr;
	public short cust_addr_typ_cd;
	public String addr_line1_txt = "";
	public String addr_line2_txt = "";
	public String addr_line3_txt = "";
	public String addr_line4_txt = "";
	public String addr_line5_txt = "";
	public String city_nm = "";
	public String st_cd = "";
	public String pstl_cd = "";
	public String cnty_nm = "";
	public String cntry_cd = "";
	public String prim_addr_tax_flg = "";
	public String last_upd_user_id = "";
	public XDRSMUdtime last_upd_ts;
	public String ax_geo_cd = "";

	private static SMUData mData = new SMUData();

	public void xdr_encode(XDRStream xdrs)
	{
		xdrs.xdr_encode_int(str_svc_hcust_nbr);
		xdrs.xdr_encode_short(cust_addr_typ_cd);
		xdrs.xdr_encode_SMUstring(addr_line1_txt, 61);
		xdrs.xdr_encode_SMUstring(addr_line2_txt, 61);
		xdrs.xdr_encode_SMUstring(addr_line3_txt, 61);
		xdrs.xdr_encode_SMUstring(addr_line4_txt, 61);
		xdrs.xdr_encode_SMUstring(addr_line5_txt, 61);
		xdrs.xdr_encode_SMUstring(city_nm, 61);
		xdrs.xdr_encode_SMUstring(st_cd, 3);
		xdrs.xdr_encode_SMUstring(pstl_cd, 11);
		xdrs.xdr_encode_SMUstring(cnty_nm, 61);
		xdrs.xdr_encode_SMUstring(cntry_cd, 3);
		xdrs.xdr_encode_SMUstring(prim_addr_tax_flg, 2);
		xdrs.xdr_encode_SMUstring(last_upd_user_id, 9);
		last_upd_ts.xdr_encode(xdrs);
		xdrs.xdr_encode_SMUstring(ax_geo_cd, 3);
	}

	public void xdr_decode(XDRStream xdrs) throws RPCError
	{
		str_svc_hcust_nbr = xdrs.xdr_decode_int();
		cust_addr_typ_cd = xdrs.xdr_decode_short();
		addr_line1_txt = xdrs.xdr_decode_SMUstring(61);
		addr_line2_txt = xdrs.xdr_decode_SMUstring(61);
		addr_line3_txt = xdrs.xdr_decode_SMUstring(61);
		addr_line4_txt = xdrs.xdr_decode_SMUstring(61);
		addr_line5_txt = xdrs.xdr_decode_SMUstring(61);
		city_nm = xdrs.xdr_decode_SMUstring(61);
		st_cd = xdrs.xdr_decode_SMUstring(3);
		pstl_cd = xdrs.xdr_decode_SMUstring(11);
		cnty_nm = xdrs.xdr_decode_SMUstring(61);
		cntry_cd = xdrs.xdr_decode_SMUstring(3);
		prim_addr_tax_flg = xdrs.xdr_decode_SMUstring(2);
		last_upd_user_id = xdrs.xdr_decode_SMUstring(9);
		last_upd_ts = new XDRSMUdtime();
		last_upd_ts.xdr_decode(xdrs);
		ax_geo_cd = xdrs.xdr_decode_SMUstring(3);
	}

	public SMUData getData(int colNbr)
	{
		switch (colNbr)
		{
			case 0 :
				mData.set(str_svc_hcust_nbr);
				break;
			case 1 :
				mData.set(cust_addr_typ_cd);
				break;
			case 2 :
				mData.set(addr_line1_txt);
				break;
			case 3 :
				mData.set(addr_line2_txt);
				break;
			case 4 :
				mData.set(addr_line3_txt);
				break;
			case 5 :
				mData.set(addr_line4_txt);
				break;
			case 6 :
				mData.set(addr_line5_txt);
				break;
			case 7 :
				mData.set(city_nm);
				break;
			case 8 :
				mData.set(st_cd);
				break;
			case 9 :
				mData.set(pstl_cd);
				break;
			case 10 :
				mData.set(cnty_nm);
				break;
			case 11 :
				mData.set(cntry_cd);
				break;
			case 12 :
				mData.set(prim_addr_tax_flg);
				break;
			case 13 :
				mData.set(last_upd_user_id);
				break;
			case 14 :
				mData.set(last_upd_ts);
				break;
			case 15 :
				mData.set(ax_geo_cd);
				break;
			default :
				return null;
		} //switch

		return mData;
	}
}
