Episode 1 Readme:

TutorialMain:
  - Main class for the mod
  - Where most of the registering goes
  - has the command registering methods (at the bottom)

CommandInit:
  - common point of custom command registering
    (is not necessary, but helps organization)
  - calls each register methods for each command

TestCommand:
  - shows the basic structure of a command
  - command does not have arguments
  - shows basic structure of the execute method
    (the execute method can have any name)
  - shows how to send a client message to player
    command source (who ran the command)
  - shows basic error handling, using the mods LOGGER
