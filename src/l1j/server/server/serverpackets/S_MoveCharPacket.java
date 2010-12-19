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
package l1j.server.server.serverpackets;

import java.util.logging.Logger;

import l1j.server.server.Opcodes;
import l1j.server.server.model.L1Character;

// Referenced classes of package l1j.server.server.serverpackets:
// ServerBasePacket

public class S_MoveCharPacket extends ServerBasePacket {

	private static final String _S__1F_MOVECHARPACKET = "[S] S_MoveCharPacket";

	private static Logger _log = Logger.getLogger(S_MoveCharPacket.class
			.getName());

	private byte[] _byte = null;

	public S_MoveCharPacket(L1Character cha) {
		int x = cha.getX();
		int y = cha.getY();
		// if(cha instanceof L1PcInstance)
		// {

		switch (cha.getHeading()) {
		case 1: // '\001'
			x--;
			y++;
			break;

		case 2: // '\002'
			x--;
			break;

		case 3: // '\003'
			x--;
			y--;
			break;

		case 4: // '\004'
			y--;
			break;

		case 5: // '\005'
			x++;
			y--;
			break;

		case 6: // '\006'
			x++;
			break;

		case 7: // '\007'
			x++;
			y++;
			break;

		case 0: // '\0'
			y++;
			break;
		}

		writeC(Opcodes.S_OPCODE_MOVEOBJECT);
		writeD(cha.getId());
		writeH(x);
		writeH(y);
		writeC(cha.getHeading());
		writeC(129);
		writeD(0);
	}

	@Override
	public byte[] getContent() {
		if (_byte == null) {
			_byte = getBytes();
		}
		return _byte;
	}

	@Override
	public String getType() {
		return _S__1F_MOVECHARPACKET;
	}
}