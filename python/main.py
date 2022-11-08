import game


def print_hi(name):
    # Use a breakpoint in the code line below to debug your script.
    print(f'Hi, {name}')  # Press Ctrl+F8 to toggle the breakpoint.

    pc = game.Player(
        "pc",
        10,
        3
    )

    print(pc.name, pc.points, pc.score)

    pc.showScore()


if __name__ == '__main__':
    print_hi('PyCharm')
