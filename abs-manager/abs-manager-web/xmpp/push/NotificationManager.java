/*
 * Copyright (C) 2010 Moduad Co., Ltd.
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */
package org.androidpn.server.xmpp.push;

import java.util.List;
import java.util.Random;
import java.util.Set;

import org.androidpn.server.model.Notification;
import org.androidpn.server.model.User;
import org.androidpn.server.service.NotificationService;
import org.androidpn.server.service.ServiceLocator;
import org.androidpn.server.service.UserNotFoundException;
import org.androidpn.server.service.UserService;
import org.androidpn.server.xmpp.session.ClientSession;
import org.androidpn.server.xmpp.session.SessionManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.QName;
import org.xmpp.packet.IQ;

/**
 * This class is to manage sending the notifcations to the users.
 * org.androidpn.server.xmpp.push包里面的NotificationManager类包含有向client发送消息的接口。
 * 
 * @author Sehwan Noh (devnoh@gmail.com)
 */
public class NotificationManager {

	private static final String NOTIFICATION_NAMESPACE = "androidpn:iq:notification";

	private final Log log = LogFactory.getLog(getClass());

	private SessionManager sessionManager;

	private NotificationService notificationService;

	private UserService userService;

	/**
	 * Constructor.
	 */
	public NotificationManager() {
		sessionManager = SessionManager.getInstance();
		notificationService = ServiceLocator.getNotificationService();
		userService = ServiceLocator.getUserService();
	}

	/**
	 * Broadcasts a newly created notification message to all connected users.
	 * 全部发送
	 * 
	 * @param apiKey
	 *            the API key
	 * @param title
	 *            the title
	 * @param message
	 *            the message details
	 * @param uri
	 *            the uri
	 */
	public void sendBroadcast(String apiKey, String title, String message, String uri,String imageUrl) {
		log.debug("sendBroadcast()...");
		List<User> users = userService.getUsers();
		for (User user : users) {
			Random random = new Random();
			String id = Integer.toHexString(random.nextInt());
			//不管在不在线都存入数据库，先存入数据库在推送给客户端 （否则出现的问题是推完删除的时候还没有入库）
			saveNotification(apiKey, user.getUsername(), title, message, uri, id);

			IQ notificationIQ = createNotificationIQ(id, apiKey, title, message, uri,imageUrl);
			ClientSession session = sessionManager.getSession(user.getUsername());
			if (session != null && session.getPresence().isAvailable()) {
				notificationIQ.setTo(session.getAddress());
				session.deliver(notificationIQ);// deliver 释放
			}
		}
	}

	/**
	 * Sends a newly created notification message to the specific user.
	 * 通过用户名发送通知
	 * 
	 * @param apiKey the API key
	 * @param title the title
	 * @param message the message details
	 * @param uri the uri
	 */
	public void sendNotifcationToUser(String apiKey, String username, String title, String message, String uri,
			boolean shouldsave,String imageUrl) {
		log.debug("sendNotifcationToUser()...");
		Random random = new Random();
		String id = Integer.toHexString(random.nextInt());
		IQ notificationIQ = createNotificationIQ(id, apiKey, title, message, uri,imageUrl);
		ClientSession session = sessionManager.getSession(username);
		if (session != null) {
			if (session.getPresence().isAvailable()) {
				notificationIQ.setTo(session.getAddress());
				session.deliver(notificationIQ);
			}
		}
		//不管在不在线  只要用户存在就存入数据库
		try {
			User user = userService.getUserByUsername(username);
			if (user != null && shouldsave) {// 不知道 user是否真实有效
				saveNotification(apiKey, username, title, message, uri, id);
			}
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 通过别名发送通知
	public void sendNotificatoionByalias(String alias, String apiKey, String title, String message, String uri,
			boolean shouldsave,String imageUrl) {
		String username = sessionManager.getUsernameByAlias(alias);
		if (username != null) {
			sendNotifcationToUser(apiKey, username, title, message, uri, shouldsave,imageUrl);
		}
	}

	//通过标签推送
	public void sendNotificationByTag(String tag, String apiKey, String title, String message, String uri,
			boolean shouldsave,String imageUrl) {
		Set<String> usernameSet = sessionManager.getUsernamesBytag(tag);
		if (usernameSet != null && usernameSet.size() > 0) {
			for (String username : usernameSet) {
				sendNotifcationToUser(apiKey, username, title, message, uri, shouldsave,imageUrl);
			}
		}
	}

	// 保存离线消息 优化的
	public void saveNotification(String apiKey, String username, String title, String message, String uri,
			String uuid) {
		Notification notification = new Notification();
		notification.setApiKey(apiKey);
		notification.setUri(uri);
		notification.setMessage(message);
		notification.setUsername(username);
		notification.setTitle(title);
		notification.setUuid(uuid);// 消息的uuid 存入数据库 并推送出去
		notificationService.saveNotification(notification);
	}

	/**
	 * Creates a new notification IQ and returns it.
	 */
	private IQ createNotificationIQ(String id, String apiKey, String title, String message, 
			String uri,String imageUrl) {
		// String id = String.valueOf(System.currentTimeMillis());

		Element notification = DocumentHelper.createElement(QName.get("notification", NOTIFICATION_NAMESPACE));
		notification.addElement("id").setText(id);
		notification.addElement("apiKey").setText(apiKey);
		notification.addElement("title").setText(title);
		notification.addElement("message").setText(message);
		notification.addElement("uri").setText(uri);
		notification.addElement("imageUrl").setText(imageUrl);

		IQ iq = new IQ();
		iq.setType(IQ.Type.set);
		iq.setChildElement(notification);

		return iq;
	}
}
