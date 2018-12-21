package ca.jam.gameobject;

import java.awt.Graphics2D;
import java.util.LinkedList;

public class ObjectHandler {

	/*
	 * This is going to handle a group of objects in a gamestate. This should make
	 * it easier to work with many objects.
	 */

	// This is a linked list that will hold the objects
	public LinkedList<GameObject> objects = new LinkedList<GameObject>();

	private GameObject tempObject;

	public void tick() {
		for (int i = 0; i < objects.size(); i++) {
			tempObject = objects.get(i);
			tempObject.tick();
		}
	}

	public void render(Graphics2D g) {
		for (int i = 0; i < objects.size(); i++) {
			tempObject = objects.get(i);
			tempObject.render(g);
		}
	}

	
	public void addHandler(ObjectHandler handler) {
		for (int i = 0; i < handler.objects.size(); i++) {
			GameObject tempObject = handler.objects.get(i);
			addObject(tempObject);
		}
	}

	
	public void addObject(GameObject object) {
		this.objects.add(object);
	}

	public void removeObject(GameObject object) {
		this.objects.remove(object);
	}

}
