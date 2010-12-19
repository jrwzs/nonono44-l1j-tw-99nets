/**
 *                            License
 * THE WORK (AS DEFINED BELOW) IS PROVIDED UNDER THE TERMS OF THIS  
 * CREATIVE COMMONS PUBLIC LICENSE ("CCPL" OR "LICENSE"). 
 * THE WORK IS PROTECTED BY COPYRIGHT AND/OR OTHER APPLICABLE LAW.  
 * ANY USE OF THE WORK OTHER THAN AS AUTHORIZED UNDER THIS LICENSE OR  
 * COPYRIGHT LAW IS PROHIBITED.
 * 
 * BY EXERCISING ANY RIGHTS TO THE WORK PROVIDED HERE, YOU ACCEPT AND  
 * AGREE TO BE BOUND BY THE TERMS OF THIS LICENSE. TO THE EXTENT THIS LICENSE  
 * MAY BE CONSIDERED TO BE A CONTRACT, THE LICENSOR GRANTS YOU THE RIGHTS CONTAINED 
 * HERE IN CONSIDERATION OF YOUR ACCEPTANCE OF SUCH TERMS AND CONDITIONS.
 * 
 */
package l1j.server.server.clientpackets;

import java.util.logging.Logger;

import l1j.server.server.ClientThread;
import l1j.server.server.model.Instance.L1PcInstance;

// Referenced classes of package l1j.server.server.clientpackets:
// ClientBasePacket

/**
 * 處理收到由客戶端傳來離開組隊的封包
 */
public class C_LeaveParty extends ClientBasePacket {

	private static final String C_LEAVE_PARTY = "[C] C_LeaveParty";
	private static Logger _log = Logger.getLogger(C_LeaveParty.class.getName());

	public C_LeaveParty(byte decrypt[], ClientThread client)
			throws Exception {
		super(decrypt);

		L1PcInstance player = client.getActiveChar();
		if (player.isInParty()) // 組隊中
		{
			player.getParty().leaveMember(player);
		}
	}

	@Override
	public String getType() {
		return C_LEAVE_PARTY;
	}

}
