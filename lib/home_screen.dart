import 'package:flutter/material.dart';

//stateful because we can change the name
class HomeScreen extends StatefulWidget {
  const HomeScreen({super.key});

  @override
  HomeScreenState createState() => HomeScreenState();
}

class HomeScreenState extends State<HomeScreen> {
  bool isEditing = false; //tracks whether user is currently editing or not
  String playerName = "User1"; //contains the player name
  late TextEditingController
      _controller; //It allows you to manipulate the text, listen to changes, and manage the focus of the TextField.
  //late means a non nullable variable will definitely be initialized later (assurance to compiler)

  @override
  void initState() {
    super.initState();
    _controller = TextEditingController(text: playerName);
  }

  @override
  void dispose() {
    _controller.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    // Get screen size
    final Size screenSize = MediaQuery.of(context).size;

    return Scaffold(
      backgroundColor: Colors.black,
      body: Center(
        child: Column(
          // mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Align(
                alignment: Alignment.topCenter,
                child: Padding(
                  padding: EdgeInsets.only(left :  screenSize.width * 0.1 , right: screenSize.width * 0.1 , top: screenSize.height * 0.15),
                  child: const Text(
                    'ORBITO',
                    style: TextStyle(
                        color: Color.fromARGB(255, 231, 45, 123),
                        fontSize: 45,
                        fontWeight: FontWeight.bold,
                        fontFamily: 'ARCADE'),
                  ),
                )),
            SizedBox(height: screenSize.height * 0.1), // Space between title and buttons
            // Player name input field
            Padding(
              padding: EdgeInsets.only(left: screenSize.width * 0.2, right: screenSize.width * 0.1),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Expanded(
                    //boolean ? return value 1  : return value 2;
                    child: isEditing
                        ? TextField(
                            controller: _controller,
                            onSubmitted: (value) {
                              //when i press enter , it should also update
                              setState(() {
                                playerName = value;
                                isEditing = false;
                              });
                            },
                            decoration: InputDecoration(
                              border: OutlineInputBorder(
                                borderRadius: BorderRadius.circular(10),
                                borderSide: const BorderSide(
                                  width: 1,
                                  color: Colors.white, // Border color
                                ),
                              ),
                              fillColor: Colors.white,
                              filled: true,
                            ),
                          )
                        : Text(
                            playerName,
                            style: const TextStyle(
                              fontSize: 28,
                              fontFamily: 'ARCADE',
                              fontStyle: FontStyle.italic,
                              color: Color.fromARGB(255, 139, 238, 25),
                            ),
                          ),
                  ),
                  SizedBox(width: screenSize.width * 0.05),
                  GestureDetector(
                    onTap: () {
                      setState(() {
                        if (isEditing) {
                          // When leaving editing mode, update player name with controller's text
                          playerName = _controller.text;
                        } else {
                          // When entering editing mode, set the controller's text to player name
                          _controller.text = playerName;
                        }
                        isEditing = !isEditing; // Toggle editing mode
                      });
                    },
                    child: Icon(
                      isEditing ? Icons.done : Icons.edit,
                      color: const Color.fromARGB(255, 139, 238, 25),
                    ),
                  ),
                ],
              ),
            ),
            SizedBox(height: screenSize.height * 0.1),
            // Single Player button
            ElevatedButton(
              onPressed: () {
                // Navigator.push(
                //   context,
                //   MaterialPageRoute(builder: (context) => SinglePlayerScreen()),
                // );
              },
              child: const Text('Single Player'),
            ),
            SizedBox(height: screenSize.height * 0.05),
            // Multiplayer button
            ElevatedButton(
              onPressed: () {
                // Navigator.push(
                //   context,
                //   MaterialPageRoute(builder: (context) => MultiplayerScreen()),
                // );
              },
              child: const Text('Multiplayer'),
            ),
          ],
        ),
      ),
    );
  }
}
