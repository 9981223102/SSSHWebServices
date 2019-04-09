package com.homedepot.ss.sh.webservices.customer.rpc;
/*--------------------------------------------
* This program is proprietary to The Home Depot and is not
* to be reproduced, used, or disclosed without permission
* of:
* 		THE HOME DEPOT
* 		2455 PACES FERRY ROAD, N.W.
* 		ATLANTA, GA  30339
* Application:  <XDRgr_cc_appl_cb.java>
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
* $Date:   31 Aug 2004 13:50:06  $
* $Log:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/customer/rpc/XDRgr_cc_appl_cb.java_v  $
 * 
 *    Rev 1.0   31 Aug 2004 13:50:06   rlp05
 * InitialRevision
 * 
 *    Rev 1.0   18 Aug 2004 15:01:34   rlp05
 * InitialRevision
------------------------------------------*/

import com.homedepot.ta.aa.JRPC.*;

public class XDRgr_cc_appl_cb implements XDRType
{
	public int appl_rtn_cd;
	public int sqlcode;
	public int sqlerrd1;
	public int sqlerrd2;
	public int sqlerrd3;
	public int sqlerrd4;
	public int sqlerrd5;
	public int sqlerrd6;
	public String sqlawarn = "";
	public short ntry_rtnd;
	public String more_ntry_flg = "";
	public int row_nbr;
	public String srvr_nm = "";
	public String database_nm = "";
	public String tbconfig_nm = "";
	public short num_array_elem;

	public void xdr_encode(XDRStream xdrs)
	{
		xdrs.xdr_encode_int(appl_rtn_cd);
		xdrs.xdr_encode_int(sqlcode);
		xdrs.xdr_encode_int(sqlerrd1);
		xdrs.xdr_encode_int(sqlerrd2);
		xdrs.xdr_encode_int(sqlerrd3);
		xdrs.xdr_encode_int(sqlerrd4);
		xdrs.xdr_encode_int(sqlerrd5);
		xdrs.xdr_encode_int(sqlerrd6);
		xdrs.xdr_encode_SMUstring(sqlawarn, 9);
		xdrs.xdr_encode_short(ntry_rtnd);
		xdrs.xdr_encode_SMUstring(more_ntry_flg, 2);
		xdrs.xdr_encode_int(row_nbr);
		xdrs.xdr_encode_SMUstring(srvr_nm, 25);
		xdrs.xdr_encode_SMUstring(database_nm, 19);
		xdrs.xdr_encode_SMUstring(tbconfig_nm, 19);
		xdrs.xdr_encode_short(num_array_elem);
	}

	public void xdr_decode(XDRStream xdrs) throws RPCError
	{
		appl_rtn_cd = xdrs.xdr_decode_int();
		sqlcode = xdrs.xdr_decode_int();
		sqlerrd1 = xdrs.xdr_decode_int();
		sqlerrd2 = xdrs.xdr_decode_int();
		sqlerrd3 = xdrs.xdr_decode_int();
		sqlerrd4 = xdrs.xdr_decode_int();
		sqlerrd5 = xdrs.xdr_decode_int();
		sqlerrd6 = xdrs.xdr_decode_int();
		sqlawarn = xdrs.xdr_decode_SMUstring(9);
		ntry_rtnd = xdrs.xdr_decode_short();
		more_ntry_flg = xdrs.xdr_decode_SMUstring(2);
		row_nbr = xdrs.xdr_decode_int();
		srvr_nm = xdrs.xdr_decode_SMUstring(25);
		database_nm = xdrs.xdr_decode_SMUstring(19);
		tbconfig_nm = xdrs.xdr_decode_SMUstring(19);
		num_array_elem = xdrs.xdr_decode_short();
	}

}
