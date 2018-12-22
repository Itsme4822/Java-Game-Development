# Java-Game-Development
---Key Terms---

GameState - These are specific states/scenes in the game.

GameStateManager - Controls all the game states. 

GameObject - Any object in the game can be considered a game object.

ObjectHandler - Can store many objects and updates and renders each of them from 
				just one object.
				
---How to use the game engine---

GameStates:
GameStates will be like the 'scenes' in our game. For example, the menu and level1
would be considered two different GameStates. Every GameState has a reference to
the 'Game' class as well as a reference to the 'GameStateManager'. GameStates 
have, at this moment, four required functions. init() will be used to define any
variables and is run every time we enter the GameState. tick() is used to handle
logic updates in the GameState. For example, we could run GameObject tick()'s in
here. The render(Graphics2D g) function is used to draw anything to the screen. The 
last function is keyInput(). This is where we will handle the keyboard input for the
GameState.

GameStateManager:
The GameStateManager will be used to control which GameState we are currently in.
When we create a new GameState we must add it to the GameStateManager. To do this
we must change 'NUMGAMESTATES' to match the number of GameStates we have in the 
game. We must then create a new integer id for the GameState. These ids are unique
for each GameState. The last thing to do is in the loadState(int state) function, we
must add the case for the new GameState (example is in the code). Other than that,
we can switch GameStates by calling 'gsm.setState(state)'. This should only be done
inside GameStates.

GameObjects:
Game objects are the basis for this game engine. To make a GameObject just make a 
new class that extends the 'GameObject' abstract class and implement the required 
functions and create the proper constructor. Each GameObject has 'x' and 'y' 
variables which is its position and 'width' and 'height' for drawing the object. 
GameObjects also have 'velX' and 'velY' variables which represent the object's 
velocity. The ObjectId is just a id that can be used to identify each object. Every
GameObject is required to have two functions, 'tick()' and 'render(Graphics2D)'.
The tick method handles the game logic of the object while the render function
handles the graphics of the object. There is also two different constructors for
GameObjects. Both take x and y positions but one of them also takes an ObjectId.
No matter what constructor you choose to use, you should still define the width 
and height of the object in the constructor. In the constructor you should define
any required variables that the object might need. If the GameObject class does 
not have  something we need, we can talk about implementing it in.

ObjectHandler:
The ObjectHandler was made to make handling large amounts of GameObjects easier.
What it does is puts GameObjects in a list and can call the tick() and render() 
functions for all of them.

Java Docs:
https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics2D.html





