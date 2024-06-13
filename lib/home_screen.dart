import 'package:flutter/material.dart';

class HomeScreen extends StatelessWidget {
  const HomeScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            const SizedBox(height: 20), // Space between app bar and game title
            const Text(
              'ORBITO',
              style: TextStyle(
                fontSize: 28,
                fontWeight: FontWeight.bold,
                fontFamily: 'ARCADE'
              ),
            ),
            const SizedBox(height: 40), // Space between title and buttons
            // Player name input field
            TextFormField(
              decoration: const InputDecoration(
                labelText: 'Enter your name',
                border: OutlineInputBorder(),
              ),
              // Implement logic to store player name
            ),
            const SizedBox(height: 20),
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
            const SizedBox(height: 10),
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
