class player:

    id = int(0)

    def __init__(self, name: str) -> None:

        if not isinstance(name,str):
            raise TypeError("Debe ser una cadena")

        self.name = name
        self.points = int(0)
        self.score = int(0)
        self.id += int(1)
        self.action = False


    def showStats(self: object) -> dict:

        return {
            "ID: ": self.id,
            "NAME": self.name,
            "POINTS": self.points,
            "SCORE": self.score,
        }

    def addWinner(self: object) -> object:
        self.score += 1

        return self

        # return [self.id,self.name, self.points,self.score]

    def judge(player: object, npc: object, godMode: bool) -> object:
        
        winTable = [
            [1, 2, 0],
            [0, 1, 2],
            [2, 0, 1]
        ]

        if winTable[player.selecion][npc.selection] == 0:
            player.score += 1
            return player, npc
        elif winTable[player.selecion][npc.selection] == 1:
            return player, npc
        else:
            npc.score += 1
            return player, npc
