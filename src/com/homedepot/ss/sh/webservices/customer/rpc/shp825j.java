package com.homedepot.ss.sh.webservices.customer.rpc;

/*--------------------------------------------
* This program is proprietary to The Home Depot and is not
* to be reproduced, used, or disclosed without permission
* of:
* 		THE HOME DEPOT
* 		2455 PACES FERRY ROAD, N.W.
* 		ATLANTA, GA  30339
* Application:  <shp825j.java>
* Description:
* Client/Server Language:	JAVA CLIENT
* Date Created:	Thu, Jul 22, 2004 11:11:57 AM
* Updated by:	mcs02
* Version:	6
* Tools Used:  <SMUDGE>
* Data Files:
* $Source$
* $Revision:   1.0  $
* $Author:   rlp05  $
* $Date:   31 Aug 2004 13:52:30  $
* $Log:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/customer/rpc/shp825j.java_v  $
 * 
 *    Rev 1.0   31 Aug 2004 13:52:30   rlp05
 * InitialRevision
 * 
 *    Rev 1.0   18 Aug 2004 14:59:36   rlp05
 * InitialRevision
------------------------------------------*/

import com.homedepot.ta.aa.JRPC.*;
import java.io.IOException;
import java.net.InetAddress;

public class shp825j extends ClientTCP
{
	/** Program ID of the interface. */
	public static final int PGM = 536882721;

	/** Version of the interface. */
	public static final int VSN = 1;

	/**
	* Creates and connects an RPC client for a server that implements
	* the "shp825j" interface.
	* Calls the remote Portmapper in order to get the port of the server.
	* @param host   The host on which the server lives.
	* @exception	JRPC.RPCError when the calls fails for any reason.
	*/
	public shp825j(InetAddress host) throws RPCError, IOException
	{
		super(host, PGM, VSN);
	}

	/**
	* Creates and connects an RPC client for a server that implements
	* the "shp825j" interface.
	* Calls the remote Portmapper in order to get the port of the server.
	* @param host   The host on which the server lives.
	* @param offset The RPC server number offset.
	* @exception	JRPC.RPCError when the calls fails for any reason.
	*/
	public shp825j(InetAddress host, int offset) throws RPCError, IOException
	{
		super(host, PGM + offset, VSN);
	}

	/**
	* rpc_ins_thd_hcust_arg is the inner class for the server function rpc_ins_thd_hcust.
	* All the input classes of rpc_ins_thd_hcust are members of this inner class.
	*/

	public class rpc_ins_thd_hcust_arg implements XDRType
	{
		public XDRgr_cc_appl_cb gr_cc_appl_cb;
		public XDRgr_hcust_list_ib gr_hcust_list_ib;
		public XDRga_hcust_cntct_ib ga_hcust_cntct_ib[] =
			new XDRga_hcust_cntct_ib[100];
		public short ga_hcust_cntct_ib_nrec;
		public XDRga_hcust_email_addr_ib ga_hcust_email_addr_ib[] =
			new XDRga_hcust_email_addr_ib[100];
		public short ga_hcust_email_addr_ib_nrec;
		public XDRga_hcust_tax_rul_ib ga_hcust_tax_rul_ib[] =
			new XDRga_hcust_tax_rul_ib[100];
		public short ga_hcust_tax_rul_ib_nrec;
		public XDRga_hcust_unfvr_ractvy_ib ga_hcust_unfvr_ractvy_ib[] =
			new XDRga_hcust_unfvr_ractvy_ib[100];
		public short ga_hcust_unfvr_ractvy_ib_nrec;
		public XDRga_org_hcust_agnt_ib ga_org_hcust_agnt_ib[] =
			new XDRga_org_hcust_agnt_ib[100];
		public short ga_org_hcust_agnt_ib_nrec;
		public XDRga_str_svc_hcust_addr_ib ga_str_svc_hcust_addr_ib[] =
			new XDRga_str_svc_hcust_addr_ib[100];
		public short ga_str_svc_hcust_addr_ib_nrec;
		public XDRga_str_svc_hcust_id_ib ga_str_svc_hcust_id_ib[] =
			new XDRga_str_svc_hcust_id_ib[100];
		public short ga_str_svc_hcust_id_ib_nrec;
		public XDRga_str_svc_hcust_phn_ib ga_str_svc_hcust_phn_ib[] =
			new XDRga_str_svc_hcust_phn_ib[100];
		public short ga_str_svc_hcust_phn_ib_nrec;
		public XDRgr_hcust_taxbl_stat_ib gr_hcust_taxbl_stat_ib;
		public XDRgr_hcust_vhcl_insr_ib gr_hcust_vhcl_insr_ib;
		public XDRgr_rntl_hcust_dtl_ib gr_rntl_hcust_dtl_ib;
		public XDRgr_str_svc_hcust_ib gr_str_svc_hcust_ib;
		public XDRgr_str_svc_indv_hcust_ib gr_str_svc_indv_hcust_ib;
		public XDRgr_str_svc_org_hcust_ib gr_str_svc_org_hcust_ib;

		public void xdr_encode(XDRStream xdrs) throws RPCError
		{
			gr_cc_appl_cb.xdr_encode(xdrs);
			gr_hcust_list_ib.xdr_encode(xdrs);
			if (ga_hcust_cntct_ib_nrec < 0)
				throw new RPCError("XDR ga_hcust_cntct_ib_nrec < 0");
			if (ga_hcust_cntct_ib_nrec > 100)
				throw new RPCError("XDR ga_hcust_cntct_ib_nrec > 100");

			xdrs.xdr_encode_short(ga_hcust_cntct_ib_nrec);
			for (int i = 0; i < ga_hcust_cntct_ib_nrec; i++)
			{
				xdrs.xdr_encode_int(1);
				ga_hcust_cntct_ib[i].xdr_encode(xdrs);
			} //for
			if (ga_hcust_email_addr_ib_nrec < 0)
				throw new RPCError("XDR ga_hcust_email_addr_ib_nrec < 0");
			if (ga_hcust_email_addr_ib_nrec > 100)
				throw new RPCError("XDR ga_hcust_email_addr_ib_nrec > 100");

			xdrs.xdr_encode_short(ga_hcust_email_addr_ib_nrec);
			for (int i = 0; i < ga_hcust_email_addr_ib_nrec; i++)
			{
				xdrs.xdr_encode_int(1);
				ga_hcust_email_addr_ib[i].xdr_encode(xdrs);
			} //for
			if (ga_hcust_tax_rul_ib_nrec < 0)
				throw new RPCError("XDR ga_hcust_tax_rul_ib_nrec < 0");
			if (ga_hcust_tax_rul_ib_nrec > 100)
				throw new RPCError("XDR ga_hcust_tax_rul_ib_nrec > 100");

			xdrs.xdr_encode_short(ga_hcust_tax_rul_ib_nrec);
			for (int i = 0; i < ga_hcust_tax_rul_ib_nrec; i++)
			{
				xdrs.xdr_encode_int(1);
				ga_hcust_tax_rul_ib[i].xdr_encode(xdrs);
			} //for
			if (ga_hcust_unfvr_ractvy_ib_nrec < 0)
				throw new RPCError("XDR ga_hcust_unfvr_ractvy_ib_nrec < 0");
			if (ga_hcust_unfvr_ractvy_ib_nrec > 100)
				throw new RPCError("XDR ga_hcust_unfvr_ractvy_ib_nrec > 100");

			xdrs.xdr_encode_short(ga_hcust_unfvr_ractvy_ib_nrec);
			for (int i = 0; i < ga_hcust_unfvr_ractvy_ib_nrec; i++)
			{
				xdrs.xdr_encode_int(1);
				ga_hcust_unfvr_ractvy_ib[i].xdr_encode(xdrs);
			} //for
			if (ga_org_hcust_agnt_ib_nrec < 0)
				throw new RPCError("XDR ga_org_hcust_agnt_ib_nrec < 0");
			if (ga_org_hcust_agnt_ib_nrec > 100)
				throw new RPCError("XDR ga_org_hcust_agnt_ib_nrec > 100");

			xdrs.xdr_encode_short(ga_org_hcust_agnt_ib_nrec);
			for (int i = 0; i < ga_org_hcust_agnt_ib_nrec; i++)
			{
				xdrs.xdr_encode_int(1);
				ga_org_hcust_agnt_ib[i].xdr_encode(xdrs);
			} //for
			if (ga_str_svc_hcust_addr_ib_nrec < 0)
				throw new RPCError("XDR ga_str_svc_hcust_addr_ib_nrec < 0");
			if (ga_str_svc_hcust_addr_ib_nrec > 100)
				throw new RPCError("XDR ga_str_svc_hcust_addr_ib_nrec > 100");

			xdrs.xdr_encode_short(ga_str_svc_hcust_addr_ib_nrec);
			for (int i = 0; i < ga_str_svc_hcust_addr_ib_nrec; i++)
			{
				xdrs.xdr_encode_int(1);
				ga_str_svc_hcust_addr_ib[i].xdr_encode(xdrs);
			} //for
			if (ga_str_svc_hcust_id_ib_nrec < 0)
				throw new RPCError("XDR ga_str_svc_hcust_id_ib_nrec < 0");
			if (ga_str_svc_hcust_id_ib_nrec > 100)
				throw new RPCError("XDR ga_str_svc_hcust_id_ib_nrec > 100");

			xdrs.xdr_encode_short(ga_str_svc_hcust_id_ib_nrec);
			for (int i = 0; i < ga_str_svc_hcust_id_ib_nrec; i++)
			{
				xdrs.xdr_encode_int(1);
				ga_str_svc_hcust_id_ib[i].xdr_encode(xdrs);
			} //for
			if (ga_str_svc_hcust_phn_ib_nrec < 0)
				throw new RPCError("XDR ga_str_svc_hcust_phn_ib_nrec < 0");
			if (ga_str_svc_hcust_phn_ib_nrec > 100)
				throw new RPCError("XDR ga_str_svc_hcust_phn_ib_nrec > 100");

			xdrs.xdr_encode_short(ga_str_svc_hcust_phn_ib_nrec);
			for (int i = 0; i < ga_str_svc_hcust_phn_ib_nrec; i++)
			{
				xdrs.xdr_encode_int(1);
				ga_str_svc_hcust_phn_ib[i].xdr_encode(xdrs);
			} //for
			gr_hcust_taxbl_stat_ib.xdr_encode(xdrs);
			gr_hcust_vhcl_insr_ib.xdr_encode(xdrs);
			gr_rntl_hcust_dtl_ib.xdr_encode(xdrs);
			gr_str_svc_hcust_ib.xdr_encode(xdrs);
			gr_str_svc_indv_hcust_ib.xdr_encode(xdrs);
			gr_str_svc_org_hcust_ib.xdr_encode(xdrs);
		} //xdr_encode

		public void xdr_decode(XDRStream xdrs)
		{
		}
	}
	/**
	* rpc_ins_thd_hcust_rtn is the inner class for the server function rpc_ins_thd_hcust.
	* All the output classes of rpc_ins_thd_hcust are members of this inner class.
	*/

	public class rpc_ins_thd_hcust_rtn implements XDRType
	{
		public XDRgr_cc_appl_cb gr_cc_appl_cb;
		public XDRgr_hcust_list_ib gr_hcust_list_ib;

		public void xdr_encode(XDRStream xdrs)
		{
		}

		public void xdr_decode(XDRStream xdrs) throws RPCError
		{
			gr_cc_appl_cb = new XDRgr_cc_appl_cb();
			gr_cc_appl_cb.xdr_decode(xdrs);
			gr_hcust_list_ib = new XDRgr_hcust_list_ib();
			gr_hcust_list_ib.xdr_decode(xdrs);
		}
	}
	/** 
	 * This variable holds rpc function number for SMUDGE server function.
	 */

	public static final int RPC_INS_THD_HCUST_NBR = 1;
	public rpc_ins_thd_hcust_arg rpc_ins_thd_hcust_arg =
		new rpc_ins_thd_hcust_arg();
	public rpc_ins_thd_hcust_rtn rpc_ins_thd_hcust_rtn =
		new rpc_ins_thd_hcust_rtn();

	public void rpc_ins_thd_hcust() throws RPCError, IOException
	{

		Call(
			RPC_INS_THD_HCUST_NBR,
			rpc_ins_thd_hcust_arg,
			rpc_ins_thd_hcust_rtn);
	}

	/**
	* rpc_upd_thd_hcust_arg is the inner class for the server function rpc_upd_thd_hcust.
	* All the input classes of rpc_upd_thd_hcust are members of this inner class.
	*/

	public class rpc_upd_thd_hcust_arg implements XDRType
	{
		public XDRgr_cc_appl_cb gr_cc_appl_cb;
		public XDRgr_hcust_list_ib gr_hcust_list_ib;
		public XDRga_hcust_cntct_ib ga_hcust_cntct_ib[] =
			new XDRga_hcust_cntct_ib[100];
		public short ga_hcust_cntct_ib_nrec;
		public XDRga_hcust_email_addr_ib ga_hcust_email_addr_ib[] =
			new XDRga_hcust_email_addr_ib[100];
		public short ga_hcust_email_addr_ib_nrec;
		public XDRga_hcust_tax_rul_ib ga_hcust_tax_rul_ib[] =
			new XDRga_hcust_tax_rul_ib[100];
		public short ga_hcust_tax_rul_ib_nrec;
		public XDRga_hcust_unfvr_ractvy_ib ga_hcust_unfvr_ractvy_ib[] =
			new XDRga_hcust_unfvr_ractvy_ib[100];
		public short ga_hcust_unfvr_ractvy_ib_nrec;
		public XDRga_org_hcust_agnt_ib ga_org_hcust_agnt_ib[] =
			new XDRga_org_hcust_agnt_ib[100];
		public short ga_org_hcust_agnt_ib_nrec;
		public XDRga_str_svc_hcust_addr_ib ga_str_svc_hcust_addr_ib[] =
			new XDRga_str_svc_hcust_addr_ib[100];
		public short ga_str_svc_hcust_addr_ib_nrec;
		public XDRga_str_svc_hcust_id_ib ga_str_svc_hcust_id_ib[] =
			new XDRga_str_svc_hcust_id_ib[100];
		public short ga_str_svc_hcust_id_ib_nrec;
		public XDRga_str_svc_hcust_phn_ib ga_str_svc_hcust_phn_ib[] =
			new XDRga_str_svc_hcust_phn_ib[100];
		public short ga_str_svc_hcust_phn_ib_nrec;
		public XDRgr_hcust_taxbl_stat_ib gr_hcust_taxbl_stat_ib;
		public XDRgr_hcust_vhcl_insr_ib gr_hcust_vhcl_insr_ib;
		public XDRgr_rntl_hcust_dtl_ib gr_rntl_hcust_dtl_ib;
		public XDRgr_str_svc_hcust_ib gr_str_svc_hcust_ib;
		public XDRgr_str_svc_indv_hcust_ib gr_str_svc_indv_hcust_ib;
		public XDRgr_str_svc_org_hcust_ib gr_str_svc_org_hcust_ib;

		public void xdr_encode(XDRStream xdrs) throws RPCError
		{
			gr_cc_appl_cb.xdr_encode(xdrs);
			gr_hcust_list_ib.xdr_encode(xdrs);
			if (ga_hcust_cntct_ib_nrec < 0)
				throw new RPCError("XDR ga_hcust_cntct_ib_nrec < 0");
			if (ga_hcust_cntct_ib_nrec > 100)
				throw new RPCError("XDR ga_hcust_cntct_ib_nrec > 100");

			xdrs.xdr_encode_short(ga_hcust_cntct_ib_nrec);
			for (int i = 0; i < ga_hcust_cntct_ib_nrec; i++)
			{
				xdrs.xdr_encode_int(1);
				ga_hcust_cntct_ib[i].xdr_encode(xdrs);
			} //for
			if (ga_hcust_email_addr_ib_nrec < 0)
				throw new RPCError("XDR ga_hcust_email_addr_ib_nrec < 0");
			if (ga_hcust_email_addr_ib_nrec > 100)
				throw new RPCError("XDR ga_hcust_email_addr_ib_nrec > 100");

			xdrs.xdr_encode_short(ga_hcust_email_addr_ib_nrec);
			for (int i = 0; i < ga_hcust_email_addr_ib_nrec; i++)
			{
				xdrs.xdr_encode_int(1);
				ga_hcust_email_addr_ib[i].xdr_encode(xdrs);
			} //for
			if (ga_hcust_tax_rul_ib_nrec < 0)
				throw new RPCError("XDR ga_hcust_tax_rul_ib_nrec < 0");
			if (ga_hcust_tax_rul_ib_nrec > 100)
				throw new RPCError("XDR ga_hcust_tax_rul_ib_nrec > 100");

			xdrs.xdr_encode_short(ga_hcust_tax_rul_ib_nrec);
			for (int i = 0; i < ga_hcust_tax_rul_ib_nrec; i++)
			{
				xdrs.xdr_encode_int(1);
				ga_hcust_tax_rul_ib[i].xdr_encode(xdrs);
			} //for
			if (ga_hcust_unfvr_ractvy_ib_nrec < 0)
				throw new RPCError("XDR ga_hcust_unfvr_ractvy_ib_nrec < 0");
			if (ga_hcust_unfvr_ractvy_ib_nrec > 100)
				throw new RPCError("XDR ga_hcust_unfvr_ractvy_ib_nrec > 100");

			xdrs.xdr_encode_short(ga_hcust_unfvr_ractvy_ib_nrec);
			for (int i = 0; i < ga_hcust_unfvr_ractvy_ib_nrec; i++)
			{
				xdrs.xdr_encode_int(1);
				ga_hcust_unfvr_ractvy_ib[i].xdr_encode(xdrs);
			} //for
			if (ga_org_hcust_agnt_ib_nrec < 0)
				throw new RPCError("XDR ga_org_hcust_agnt_ib_nrec < 0");
			if (ga_org_hcust_agnt_ib_nrec > 100)
				throw new RPCError("XDR ga_org_hcust_agnt_ib_nrec > 100");

			xdrs.xdr_encode_short(ga_org_hcust_agnt_ib_nrec);
			for (int i = 0; i < ga_org_hcust_agnt_ib_nrec; i++)
			{
				xdrs.xdr_encode_int(1);
				ga_org_hcust_agnt_ib[i].xdr_encode(xdrs);
			} //for
			if (ga_str_svc_hcust_addr_ib_nrec < 0)
				throw new RPCError("XDR ga_str_svc_hcust_addr_ib_nrec < 0");
			if (ga_str_svc_hcust_addr_ib_nrec > 100)
				throw new RPCError("XDR ga_str_svc_hcust_addr_ib_nrec > 100");

			xdrs.xdr_encode_short(ga_str_svc_hcust_addr_ib_nrec);
			for (int i = 0; i < ga_str_svc_hcust_addr_ib_nrec; i++)
			{
				xdrs.xdr_encode_int(1);
				ga_str_svc_hcust_addr_ib[i].xdr_encode(xdrs);
			} //for
			if (ga_str_svc_hcust_id_ib_nrec < 0)
				throw new RPCError("XDR ga_str_svc_hcust_id_ib_nrec < 0");
			if (ga_str_svc_hcust_id_ib_nrec > 100)
				throw new RPCError("XDR ga_str_svc_hcust_id_ib_nrec > 100");

			xdrs.xdr_encode_short(ga_str_svc_hcust_id_ib_nrec);
			for (int i = 0; i < ga_str_svc_hcust_id_ib_nrec; i++)
			{
				xdrs.xdr_encode_int(1);
				ga_str_svc_hcust_id_ib[i].xdr_encode(xdrs);
			} //for
			if (ga_str_svc_hcust_phn_ib_nrec < 0)
				throw new RPCError("XDR ga_str_svc_hcust_phn_ib_nrec < 0");
			if (ga_str_svc_hcust_phn_ib_nrec > 100)
				throw new RPCError("XDR ga_str_svc_hcust_phn_ib_nrec > 100");

			xdrs.xdr_encode_short(ga_str_svc_hcust_phn_ib_nrec);
			for (int i = 0; i < ga_str_svc_hcust_phn_ib_nrec; i++)
			{
				xdrs.xdr_encode_int(1);
				ga_str_svc_hcust_phn_ib[i].xdr_encode(xdrs);
			} //for
			gr_hcust_taxbl_stat_ib.xdr_encode(xdrs);
			gr_hcust_vhcl_insr_ib.xdr_encode(xdrs);
			gr_rntl_hcust_dtl_ib.xdr_encode(xdrs);
			gr_str_svc_hcust_ib.xdr_encode(xdrs);
			gr_str_svc_indv_hcust_ib.xdr_encode(xdrs);
			gr_str_svc_org_hcust_ib.xdr_encode(xdrs);
		} //xdr_encode

		public void xdr_decode(XDRStream xdrs)
		{
		}
	}
	/**
	* rpc_upd_thd_hcust_rtn is the inner class for the server function rpc_upd_thd_hcust.
	* All the output classes of rpc_upd_thd_hcust are members of this inner class.
	*/

	public class rpc_upd_thd_hcust_rtn implements XDRType
	{
		public XDRgr_cc_appl_cb gr_cc_appl_cb;
		public XDRgr_hcust_list_ib gr_hcust_list_ib;

		public void xdr_encode(XDRStream xdrs)
		{
		}

		public void xdr_decode(XDRStream xdrs) throws RPCError
		{
			gr_cc_appl_cb = new XDRgr_cc_appl_cb();
			gr_cc_appl_cb.xdr_decode(xdrs);
			gr_hcust_list_ib = new XDRgr_hcust_list_ib();
			gr_hcust_list_ib.xdr_decode(xdrs);
		}
	}
	/** 
	 * This variable holds rpc function number for SMUDGE server function.
	 */

	public static final int RPC_UPD_THD_HCUST_NBR = 2;
	public rpc_upd_thd_hcust_arg rpc_upd_thd_hcust_arg =
		new rpc_upd_thd_hcust_arg();
	public rpc_upd_thd_hcust_rtn rpc_upd_thd_hcust_rtn =
		new rpc_upd_thd_hcust_rtn();

	public void rpc_upd_thd_hcust() throws RPCError, IOException
	{

		Call(
			RPC_UPD_THD_HCUST_NBR,
			rpc_upd_thd_hcust_arg,
			rpc_upd_thd_hcust_rtn);
	}

}
