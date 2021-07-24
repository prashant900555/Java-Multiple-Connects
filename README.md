<h1 align="center">
         MULTIPLE CONNECTS
</h1>

<p align="center">
  <img src="https://user-images.githubusercontent.com/47216809/108625462-0591bc80-7443-11eb-8a0d-49ce516be99d.png">
</p>

<h2>
          Abstract:
</h2>

<p align="justify"> This report demonstrates the whole activity which was involved in making the “Multiple Connects” 2-D JavaFX Computer Game. The name in itself is self-explanatory, which reveals that it is an improvised version of the fundamental Connect 4 game. It is a multiplayer game. 2 players can play concurrently (chance by chance). The report mainly gives the gist of how the game was made and how its subordinating elements are disjoint, but coupled together in an Object-Oriented way. </p>

<p align="justify"> The motivation behind implementing this game was just to put forth an enhanced version of the usual Connect 4 game, therein taking user-friendliness and intuitiveness into consideration. I feel a gamer should have his own choices to play in a game. So, I implemented additional functionalities in the game, which I will be discussing in the further part of the report. Elements such as, menu to see the previous results of the game, user input of various fields, functionality to go back and forth, which makes the game user-friendly and a vibrant graphical user interface, making it playable and in turn making it representable as a game should be.
The Tile Pane of the game was inspired from many other connect 4 games available in plethora on the internet. But, my games’ capability to adapt to various user changes in the game, makes it totally original and it sets apart from all the other connect 4 games. This is not only in accordance to the graphical user interface of the game, but also considering the additional functionalities, code logic, differentiation of classes, interfaces, functions, and so on. Even though, I haven’t used FXML, I was able to establish an MVC architecture for my game, which is evident from the code logic and the generated Javadoc, which explains the distribution of the classes and its implementing functions from interfaces. </p>

<p align="justify"> This individual project was implemented in around 2-3 weeks of time, considering the complex modifications evident in the gameplay. It was implemented using Java 1.8 and JavaFX open-source client application platform for Desktop applications. The project in the end inferences with the overall evaluation of the methods and tools which were used for the implementation of this project. </p>

<h2>
          Problem Description:
</h2>
<p align="justify"> Implemented a multiplayer game which consists of 2 players playing concurrently (chance by chance). The name of the game project is, as discussed earlier, “Multiple Connects”, which is a 2D GUI game implemented from scratch using JavaFX open-source desktop application software platform. Even though the game is basic and intuitive, it has multiple additional functionalities in it making it an enhanced version of Connect 4. </p>

<p align="justify"> The game basically works on the notion of connecting “N” blocks (tiles) to win the game, and the players have the motivation of not letting the other player to have the N tiles in a row, whether it be horizontal, vertical or diagonal in line. The player who has all the “N” tiles aligned (connected) in a row (horizontal, vertical, diagonal) wins the game. The results of the game are dynamically written to a .csv file, which is created on run time if it does not exist. The results are in a tabular form, consisting of various fields ranging from the player names, winners, dimensions of the boards to other aspects such as the no. of tiles remaining at the end of the board, date and time. </p>

<h2>
          Implementation Details:
</h2>

<p align="justify"> The game begins with a main menu GUI interface which consists of a “mainMenuVBox”, in which the main logo, 6 Hboxes and the creator label is present. The 6 HBoxes are the Connect, FirstPlayer, Second Player, Height of the Board and Width of the Board Textfields and Labels and lastly the 2 buttons, namely; Start and Previous Results. So, the user is restricted to enter the connect value between 3 to 9. The First Player, Second Player textfields should contain only Letters and the user is restricted for the same. The dimensions of the board should be between 4 to 12, and be less than 1.5 times the connect field value, so that the game becomes a bit complex and not easily meeting the win or draw condition. The buttons are basically used to open the previous results and Start the game. The rest is self-explanatory! </p>

<p align="center">
  <img src="https://user-images.githubusercontent.com/47216809/108625740-6a014b80-7444-11eb-8c6e-afab322f33f1.JPG">
</p>

<p align="justify"> When we click on the Start Button, the game starts, and the players take their turns. As we can see below, I have implemented the minimum functionality to display whose turn it is. A more enhanced thing which I added here is to change the color of the right screen where depending upon the users turn, the screen is turned red/blue along with their Name. </p>

<p align="center">
  <img src="https://user-images.githubusercontent.com/47216809/108625755-81d8cf80-7444-11eb-8f2f-ccc7d2954101.JPG">
</p>

<p align="justify"> When the win condition is met, a victory sound will be heard along with the following image and victory alert pop-up. On clicking Ok, we will return back to the main menu scene and the user can either change the names, board size, connect size, etc. and the game will adhere to it accordingly. But the user needs to adhere to the board sizes and input restrictions which are visible when you hover on the text field in disguise of a tool tip text. </p>


<p float="left" align="center">
  <img src="https://user-images.githubusercontent.com/47216809/108625775-9e750780-7444-11eb-9df8-41c19d3c67b4.JPG" width="400" />
  <img src="https://user-images.githubusercontent.com/47216809/108625786-a6cd4280-7444-11eb-806f-4a705871ba79.JPG" width="600" /> 
</p>

<p align="justify"> Now, talking about the Previous Results button! When the game is executed on a new machine for the first time, it will not contain a csv file, since the csv file is created dynamically when a game is played. So, I have kept a pop-up alert to specify to play a game, and the following scene will be represented on the click of Previous Results Button. Here I used a perfect replica of the CSV File in the disguise of using Observable List inside a Table View inside a VBox which is again inside a border pane. And that’s how I have basically got the logic sorted for the GUI without using fxml/scene builder. As we can see, I’m displaying the PlayerOneName, PlayerTwoName, WinnerName, No. of Connects, Dimension of the Board, No. of Tiles filled after a victory condition is met, Date and Time of the game, which is written in a csv file on run time and read simultaneously from the csv file as we click on the Previous Results Button. Herein, I managed to attain one more minimum functionality & maybe an additional functionality of using a higher level of file structure along with dynamic read/write inputs/outputs of the game conditions and scenarios. </p>

<h2>
          Class Diagram:
</h2>

<p align="center">
  <img src="https://user-images.githubusercontent.com/47216809/108626225-04fb2500-7447-11eb-80d9-23d5635d3601.jpg">
</p>

<p align="justify"> So, above is the comprehensive class diagram of the whole package which demonstrates the business layers and its associations. As evident from the above Diagram, the MultipleConnects class is the main class which has the main function which launches the stage and the whole crux of the system is defined by this class. This class extends the JavaFX Application Class and implements the set blueprint of functions from the MultipleConnectsInterface. So, firstly I laid out the functions to be implemented as I wanted to work around those functions and implement them in my class. </p>

<a href="https://www.youtube.com/watch?v=BFmdwLfh3rU&ab_channel=EazyWays"> Basic Board Logic of the Traditional Connect 4 </a>
<p> The basic board logic was inspired from the above YouTube tutorial. This tutorial just has a board logic, which was not even object oriented or meeting a win condition. I improvised drastically on the base logic board. Firstly, creating a main menu, as discussed in the implementation. Further I thought about taking input from the user for the Connects, where I got the idea of Multiple Connects. That’s how the game was named Multiple Connects. Wherein I implemented the first vital additional functionality of my game. </p>

<p align="justify"> The MultipleConnects class has the said instance variables; noOfBlocks, connectField, FirstPlayer, SecondPlayer, HeightBoard, WidthBoard, which are thoroughly used in the class. It also has the implemented methods from the Interface. There is a MultipleConnectsData Class which I created to specify the instance variables for the GUI components. The TableColumns Class is used to define the previous results table columns, which is further added to the ObservableList. </p>

<p align="justify"> The BlocksClass is a standalone class which specifies the color and the rows and columns of the board. It is fully tested in the Test Cases strategy. Even though I did not use fxml, I was able to implement the concepts of Object Oriented and thereby having a clear idea of the whole game logic. My comments are also well sorted and anyone who will have a glance through my code will get an idea of what is happening, as I have used good naming conventions for my methods, variables and classnames. </p>

<p align="justify"> Talking about comments, the JavaDoc has a comprehensive understanding of the whole Classes, which is appropriately commented using the @author, @param, @return, @throws, and so on features. I also used HTML tags in specifying the comments in the JavaDoc style commenting document.
Talking about one more additional functionality; I added one more vital thing in my game, wherein the user can enter the dimensions of the board which lies in the range of 4 to 12, considering both the height and width of the board. Another functionality which I added is to display the previous results in the game as discussed above in the implementation. </p>

<p align="justify"> In order to see the explanation of each and every variable and method, I have commented it appropriately using normal commenting and Javadoc commenting too. Even though my Multiple Connects Class seems cluttered, it is up to the mark in accordance to my way of implementing the game logic and the sequential process of adding things into the Classes and for the Game. I also implemented the habbit of keeping multiple versions of the game at each and every step. Wherein, I have in total 9-10 versions of my game, hence, the incremental progress of my game is evident in the form of these versions which I have in disguise of Java Project folders. </p>

<h2>
          Testing Strategy:
</h2>

<p align="justify"> Firstly, I was keen on implementing the GUI Testing using the TestFX tool, but there were dependency issues and I couldn’t import the jar files for the specific UI Testing code which I had written and made a plan to execute accordingly. But still I managed to write some vital test cases which covers around 50% of my code. And I’m very sure that around 60+% of my code is UI-based. So, even in around 12-13 cases, I was able to cover maximum amount of code coverage, as evident from the snapshot below. </p>

<p align="center">
  <img src="https://user-images.githubusercontent.com/47216809/108626370-ab472a80-7447-11eb-9827-a43ed1faf6d0.jpg">
</p>

<p align="justify"> The test cases which I wrote were prominently for testing important parts of my game. The test case names are explanatory in accordance to the testing logic inside it. I even took some references from the test cases which were given in the examinations. </p>

<p align="justify"> I have tested for the Red and Blue Victory test case using the instances of the MultipleConnects Class and the MultipleConnectsData Class. I also created a separate TableFieldsforTest Class, wherein I’m testing the csvfile columns and data values successfully. The purpose of this Class was to save the data values of the game instances (data values of the game) into the instance of the Class object and to also use the Arraylist for the same. Hence, this was not just created for the testing purpose, but was also taken from something which I learnt by attempting the previous examinations and the Labs from the Java Lectures.I also therefore implemented the code coverage testing as seen in the image above, which covers around 50% of the code, and I’m pretty sure that over 60% code is UI Based, as I’m not using FXML. Therefore, the code coverage is not high, since the GUI and the Controllers are not tested using JavaFX. </p>


<p align="center"> \\\\\\\\\\ THANK - YOU ////////// </p>

          PROJECT CREATED BY - Prashant Wakchaure
          Email ID - prashant900555@gmail.com
          Contact No. - +373 892276183
