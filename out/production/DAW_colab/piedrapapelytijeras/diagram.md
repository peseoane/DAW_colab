classDiagram
direction BT
class CommonRules {
  + CommonRules() 
  # int action
  # int globalScore
  # Scanner input
  # String name
  # int localScore
  + getAction() int
  + setLocalScore(int) void
  + addGlobalScore() void
  + getName() String
  + setAction(int) void
  + getGlobalScore() int
  + getLocalScore() int
  + addWin() void
}
class Game {
  + Game() 
  + calculateWinner(Player, Npc) void
  + showStats(Player, Npc) void
  + showElection(Player, Npc) void
  + showCheatStatus(Npc) void
}
class Main {
  + Main() 
  + main(String[]) void
}
class Npc {
  + Npc() 
  - boolean godMode
  + isGodMode() boolean
  + calculateAction(Player) void
  + createGodMode() boolean
}
class Player {
  + Player() 
  + playerChoice() void
  + playerName() String
}
class TerminalAux {
  + TerminalAux() 
  + String GREEN
  + String ASK_NEXT_ROUND
  + String HI
  + String RED
  + String EASTER_EGG1
  + String NEW_GAME
  + String EXIT_GAME
  + String DIALOG
  + String EASTER_EGG0
  + String RESET
  + String PURPLE
  + String ENCODING
  + String KEY_TO_EXIT
  - secret0(String) String
}

Main  ..>  Npc : «create»
Main  ..>  Player : «create»
Npc  -->  CommonRules 
Player  -->  CommonRules 
