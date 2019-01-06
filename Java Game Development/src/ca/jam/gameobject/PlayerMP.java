package ca.jam.gameobject;

import java.net.InetAddress;

public class PlayerMP extends Player{

	public InetAddress ipAddress;
	public int port;
	public boolean isLocal;
	
	public PlayerMP(float x, float y, String username, boolean isLocal, InetAddress ipAddress, int port) {
		super(x, y, username);
		this.isLocal = isLocal;
		this.ipAddress = ipAddress;
		this.port = port;
	}
	
	@Override
	public void tick() {
		super.tick();
		if (isLocal) {
			keyInput();
		}
	}

}
