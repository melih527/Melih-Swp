import random
import sys

shapes = ["stein", "papier", "schere", "spock", "echse"]
winCount = {"spieler": 0, "pc": 0, "unentschieden": 0}


def pickCPU():
    return shapes[random.randint(0, 4)]


def checkWinner(spieler, pc):
    indexSpieler = shapes.index(spieler)
    indexPC = shapes.index(pc)

    if (shapes[:indexSpieler + 2] == shapes[:indexPC]) or (shapes[:indexSpieler - 1] == shapes[:indexPC]):
        gewinner = "Der Spieler hat gewonnen!"
        winCount["spieler"] += 1


    elif indexSpieler == indexPC:
        gewinner = "UNENTSCHIEDEN!"
        winCount["pc"] += 1

    else:
        gewinner = "Der PC hat gewonnen du LOOSSSEERR!"
        winCount["unentschieden"] += 1

    return gewinner


def spiel():

    gameStatus = 1

    print("Willkommen auf Stein-Papier-Schere-Spock-Exe!\n")

    while gameStatus == 1:
        print("Was moechten Sie waehlen? (Stein/Papier/Schere/Spock/Echse)")
        shapeSpieler = str(input())

        if shapes.count(shapeSpieler) == 0:
            print("Bitte waehlen Sie etwas das existiert!")
        else:
            shapePC = pickCPU()

            print("\nDu hast das gewaehlt: ", shapeSpieler)

            print("PC hat gewaehlt: ", shapePC)

            win = checkWinner(shapeSpieler, shapePC)

            print("\nDas Ergebnis ist: ", win)

            print("\nWillst du noch eine Runde spielen (ja/nein)")

            jaNein = input()

            if jaNein == "ja":
                gameStatus = 1

            elif jaNein == "nein":
                print(winCount)
                gameStatus = 0

            else:
                gameStatus = 0



if __name__ == '__main__':
    spiel()