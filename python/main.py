import Game

def print_hi(name):

    pc = Game.player("pedro",1,2)
    print(Game.player.showStats(pc))

    Game.player.addWinner(pc)

    print(Game.player.showStats(pc))


if __name__ == '__main__':
    print_hi('1,2,3,4...')

