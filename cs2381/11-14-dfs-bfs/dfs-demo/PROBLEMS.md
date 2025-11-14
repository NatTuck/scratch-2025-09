# Lab 12: Priority Queue + Graph

In this lab, you will:

 - Fix a MinHeap-based Priority Queue
 - Complete a graph traversal algorithm

For this assignment the App#main method is used to start the GUI, and
should be left intact in your solution. Keep in mind that you can
temporarily rename it to create a test main method as long as you switch
back before packing up your solution.

## Graph UI Usage

 - Start the UI with: ```mvn compile exec:java -q```
 - The console output matters, so make sure you're running it in some
   way that lets you see that output.
 - When you first click a city, that will set the pathfinding source.
 - When you click a second city, that will set the destination and
   run pathfinding.
 - If you click the background, that will clear the source.
 - This is worth playing with a bit while watching the console output.
 

## Problems

**Problem 1. MinHeap**

Complete the code in MinHeap.java to implement a min heap / priority queue.

https://en.wikipedia.org/wiki/Binary_heap


**Problem 2. Euclidian Distance**

Complete the ```dist``` method in RoadMap.java to calculate the
Euclidian distance between two cities on the map given the names of the
cities.

https://en.wikipedia.org/wiki/Euclidean_distance


**Problem 3. Dijkstra's Algorithm**

Complete the code in FindPath.java to find the shortest path
between two cities on the map.

https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm


