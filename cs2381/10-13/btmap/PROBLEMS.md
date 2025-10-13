For this assignment, complete the following tasks:


## Task 1: Linked List Iterator

Complete the Iterator object in ConsList.java so that you can correctly iterate through
a ConsList with a ```for (var xx : xs)``` loop.


## Task 2: Bounce off the ground

Make the balls bounce off the bottom of the window by completing the Ball#bounce method.


## Task 3: Delete OOB balls.

Since you're only bouncing on the bottom, balls can go out of bounds on the left and right.
Delete any balls each tick (in App#onTick) that are beyond the left or right edge of the window.

Check the Java documentation for [JPanel](
https://docs.oracle.com/en/java/javase/17/docs/api/java.desktop/javax/swing/JPanel.html)
to get the current window width, even if it's been resized.


## Task 4: Make the balls square.

Add a Square record in SimpleShape.java that implements the SimpleShape interface.

Start at the documentation for [Rectangle2D](
https://docs.oracle.com/en/java/javase/17/docs/api/java.desktop/java/awt/geom/Rectangle2D.html) 
and modify the code as needed to make the balls draw as Squares.