package com.homedepot.ss.sh.webservices.customer.rpc;
/*--------------------------------------------
* This program is proprietary to The Home Depot and is not
* to be reproduced, used, or disclosed without permission
* of:
* 		THE HOME DEPOT
* 		2455 PACES FERRY ROAD, N.W.
* 		ATLANTA, GA  30339
* Application:  <XDRgr_hcust_list_ib.java>
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
* $Date:   31 Aug 2004 13:50:14  $
* $Log:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/customer/rpc/XDRgr_hcust_list_ib.java_v  $
 * 
 *    Rev 1.0   31 Aug 2004 13:50:14   rlp05
 * InitialRevision
 * 
 *    Rev 1.0   18 Aug 2004 15:01:44   rlp05
 * InitialRevision
------------------------------------------*/

import com.homedepot.ta.aa.JRPC.*;

public class XDRgr_hcust_list_ib implements XDRType
{
	public String str_nbr = "";
	public String loc_typ_cd = "";
	public int str_svc_hcust_nbr;
	public int str_svc_lcust_nbr;
	public int seq_nbr;
	public short cust_typ_cd;
	public String last_nm = "";
	public String frst_nm = "";
	public String org_cust_nm = "";
	public String phn_area_city_cd = "";
	public String phn_locl_nbr = "";
	public String pstl_cd = "";
	public String cntry_cd = "";
	public short sql_select;
	public String cust_id_nbr = "";
	public short cust_id_typ_cd;

	public void xdr_encode(XDRStream xdrs)
	{
		xdrs.xdr_encode_SMUstring(str_nbr, 5);
		xdrs.xdr_encode_SMUstring(loc_typ_cd, 5);
		xdrs.xdr_encode_int(str_svc_hcust_nbr);
		xdrs.xdr_encode_int(str_svc_lcust_nbr);
		xdrs.xdr_encode_int(seq_nbr);
		xdrs.xdr_encode_short(cust_typ_cd);
		xdrs.xdr_encode_SMUstring(last_nm, 61);
		xdrs.xdr_encode_SMUstring(frst_nm, 41);
		xdrs.xdr_encode_SMUstring(org_cust_nm, 101);
		xdrs.xdr_encode_SMUstring(phn_area_city_cd, 6);
		xdrs.xdr_encode_SMUstring(phn_locl_nbr, 10);
		xdrs.xdr_encode_SMUstring(pstl_cd, 11);
		xdrs.xdr_encode_SMUstring(cntry_cd, 3);
		xdrs.xdr_encode_short(sql_select);
		xdrs.xdr_encode_SMUstring(cust_id_nbr, 26);
		xdrs.xdr_encode_short(cust_id_typ_cd);
	}

	public void xdr_decode(XDRStream xdrs) throws RPCError
	{
		str_nbr = xdrs.xdr_decode_SMUstring(5);
		loc_typ_cd = xdrs.xdr_decode_SMUstring(5);
		str_svc_hcust_nbr = xdrs.xdr_decode_int();
		str_svc_lcust_nbr = xdrs.xdr_decode_int();
		seq_nbr = xdrs.xdr_decode_int();
		cust_typ_cd = xdrs.xdr_decode_short();
		last_nm = xdrs.xdr_decode_SMUstring(61);
		frst_nm = xdrs.xdr_decode_SMUstring(41);
		org_cust_nm = xdrs.xdr_decode_SMUstring(101);
		phn_area_city_cd = xdrs.xdr_decode_SMUstring(6);
		phn_locl_nbr = xdrs.xdr_decode_SMUstring(10);
		pstl_cd = xdrs.xdr_decode_SMUstring(11);
		cntry_cd = xdrs.xdr_decode_SMUstring(3);
		sql_select = xdrs.xdr_decode_short();
		cust_id_nbr = xdrs.xdr_decode_SMUstring(26);
		cust_id_typ_cd = xdrs.xdr_decode_short();
	}

}
