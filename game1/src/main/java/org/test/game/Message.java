package org.test.game;

class Message{
	
	private Player receiver;
	private Player sender;
	private String message;
	private int msgCouter;

	public Player getReceiver() {
		return receiver;
	}
	public void setReceiver(Player receiver) {
		this.receiver = receiver;
	}
	public Player getSender() {
		return sender;
	}
	public void setSender(Player sender) {
		this.sender = sender;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getMsgCouter() {
		return msgCouter;
	}
	public void setMsgCouter(int msgCouter) {
		this.msgCouter = msgCouter;
	}
	
	
}