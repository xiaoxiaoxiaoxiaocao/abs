package org.androidpn.server.xmpp.handler;

import org.androidpn.server.xmpp.UnauthorizedException;
import org.androidpn.server.xmpp.session.ClientSession;
import org.androidpn.server.xmpp.session.Session;
import org.androidpn.server.xmpp.session.SessionManager;
import org.dom4j.Element;
import org.xmpp.packet.IQ;
import org.xmpp.packet.PacketError;
/**
 * 自定义的处理tag的handler
 * @author meiaomei
 *
 */

public class IQSetTagsHandler extends IQHandler {

	private static final String NAMESPACE = "androidpn:iq:settags";

	private SessionManager sessionManager;

	public IQSetTagsHandler() {
		sessionManager = sessionManager.getInstance();
	}

	@Override
	public IQ handleIQ(IQ packet) throws UnauthorizedException {
		IQ reply = null;
		ClientSession session = sessionManager.getSession(packet.getFrom());
		if (session == null) {
			log.error("Session not found for key " + packet.getFrom());
			reply = IQ.createResultIQ(packet);
			reply.setChildElement(packet.getChildElement().createCopy());
			reply.setError(PacketError.Condition.internal_server_error);
			return reply;
		}
		if (session.getStatus() == Session.STATUS_AUTHENTICATED) {// 登陆成功
			if (IQ.Type.set.equals(packet.getType())) {
				Element element = packet.getChildElement();
				String username = element.elementText("username");
				String tagsStr = element.elementText("tags");
				String[] tagsArragy = tagsStr.split(",");
				if (tagsArragy != null && tagsArragy.length > 0) {
					for (String tag : tagsArragy) {
						sessionManager.setUserTag(username, tag);
					}
					System.out.println("set username tags successfully");
				}
			}
		}
		return null;
	}

	@Override
	public String getNamespace() {
		return NAMESPACE;
	}

}
