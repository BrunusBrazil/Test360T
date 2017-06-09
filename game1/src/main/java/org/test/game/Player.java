package org.test.game;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *  Communication between two instances of the player class
 * 
 * */

public class Player {

	private Integer code;
	private int msgReveceivedCounter =1;
	private int msgSentCounter =1;
	
	public Player(int code) {
		this.code  = code;
	}
	
	private List<Player> players = new ArrayList<>();
	
	public void addPlayer(Player player){
		players.add(player);		
	}		
	
	public void read(Message message){
		System.out.println("reading message ... from: "+message.getSender().getCode()+" "+	this);
		System.out.println("message: " + message.getMessage());
		System.out.println("============================================================");

		//3- Receives the messages and send it back with the counter
		message.setMessage("Coffe and Java :" + message.getMsgCouter());
		msgReveceivedCounter++;
   	    changeSender(message);
		write(message);
	}

	public void write(Message message){

		if(msgReveceivedCounter == 11 && msgSentCounter == 11){
			//4- Finalize the program when after exchanging 10 messages
			System.exit(0);
		}
		
		if(message.getReceiver().getCode().equals(this.code)){
			changeSender(message);
		}
		
		System.out.println("sending message ... to: "+message.getReceiver().getCode()+" "+	this);
		for(Player p : players){			
          if(message.getReceiver().getCode().equals(p.getCode())){
        	  message.setMsgCouter(msgSentCounter++);
        	  p.read(message);
          }	
          
		}
	}	
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public int getMsgReveceivedCounter() {
		return msgReveceivedCounter;
	}

	public void setMsgReveceivedCounter(int msgReveceivedCounter) {
		this.msgReveceivedCounter = msgReveceivedCounter;
	}

	public int getMsgSentCounter() {
		return msgSentCounter;
	}

	public void setMsgSentCounter(int msgSentCounter) {
		this.msgSentCounter = msgSentCounter;
	}

	private void changeSender(Message message){
	  Player temp = message.getSender();
	  message.setSender(message.getReceiver());
	  message.setReceiver(temp);
	}
	
	public static void main(String ...args){
	
		//1- two players
		Player initiator = new Player(1);
		Player neymar = new Player(2);
		
	
		initiator.addPlayer(neymar);
	
		neymar.addPlayer(initiator);
		
		
		Message msg = new Message();
		msg.setSender(initiator);
		msg.setReceiver(neymar);
		msg.setMessage("test");

		//2-initiator starts the iteration
		initiator.write(msg);
	}
}
