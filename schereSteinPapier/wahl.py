import random
import json



auswahl = ["stein", "papier", "schere", "spock", "echse"]

countValues = {"spieler": 0, "pc": 0, "unentschieden": 0, "stein": 0, "papier": 0, "schere": 0, "spock": 0, "echse": 0}

dataFile = {}

groese = [0, 0, 0, 0, 0]


#Methoden
def checkWinner(spieler, pc):
    indexSpieler = auswahl.index(spieler)
    indexPC = auswahl.index(pc)
    if (indexSpieler + 2) > 4:
        indexSpieler = indexSpieler - 5
    if (auswahl[indexSpieler + 2] == auswahl[indexPC]) or (auswahl[indexSpieler - 1] == auswahl[indexPC]):
        gewinner = "Der Spieler hat gewonnen!"
        countValues["spieler"] += 1
    elif (auswahl[indexSpieler - 2] == auswahl[indexPC]) or (auswahl[indexSpieler + 1] == auswahl[indexPC]):
        gewinner = "PC hat gewonnen LOOSER!"
        countValues["pc"] += 1
    else:
        gewinner = "UNENTSCHIEDEN!"
        countValues["unentschieden"] += 1
    return gewinner


def pickPC():
    zaehle = 0

    for key in dataFile:

        if "spieler" not in key and "pc" not in key and "unentschieden" not in key:

            if dataFile[key] == 0:
                groese[zaehle] = dataFile[key] + 0.01

            else:
                groese[zaehle] = dataFile[key]
            zaehle += 1


    move = groese[len(groese) - 1]

    groese.remove(groese[len(groese) - 1])

    groese.insert(0, move)

    choice = random.choices(auswahl, k=1, weights=groese)

    return choice[0]




def aktualisieren():
    f = open("ergebnisse.txt", "r")
    saved = f.read()
    if saved:
        save_json = json.loads(saved)
        combine(countValues, save_json)
    f.close()
    f = open("ergebnisse.txt", "w")
    json.dump(dataFile, f)
    f.close()


def loschen():
    dataFile = {"spieler": 0, "pc": 0, "unentschieden": 0, "stein": 0, "papier": 0, "schere": 0, "spock": 0, "echse": 0}
    countValues = dataFile
    groese = [0, 0, 0, 0, 0]
    f = open("ergebnisse.txt", "w")
    json.dump(dataFile, f)
    f.close()

def combine(a, b):
    for key in a:
        dataFile[key] = a[key] + b[key]
    return a



def spiel():
    aktualisieren()

    gameStatus = 1
    while gameStatus == 1:
        print("Was wollen Sie auswählen? (Stein/Papier/Schere/Spock/Echse)")
        auswahlSpieler = str(input().lower())
        if auswahl.count(auswahlSpieler) == 0:
            print("Please choose an existing shape!")
        else:
            countValues[auswahlSpieler] += 1
            auswahlPC = pickPC()
            print("\n Du hast gewählt: ", auswahlSpieler)
            print("PC hat gewählt: ",auswahlPC )
            win = checkWinner(auswahlSpieler, auswahlPC)
            print("\n Das Ergebnis lautet:  ", win)
            cont = 1
            while cont == 1:
                print("\nWillst du noch ein Spiel spielen? (ja/nein)")
                ergebnis = input().lower()
                if ergebnis == "ja":
                    gameStatus = 1
                    cont = 0
                elif ergebnis == "nein":
                    cont = 0
                    gameStatus = 0
                else:
                    cont = 1
                    gameStatus = 0

def menu():
    exit = False
    print()
    print("Menu:")

    while exit == False:
        todo = input("Auswählen: spiel, stats, aktualisieren, loschen oder exit: ")
        if todo == "spiel":
           spiel()
        elif todo == "stats":
            print(dataFile)
            print()
        elif todo == "aktualisieren":
            aktualisieren()
            print("Die Ergebnisse sind auf den aktuellsten Stand\n")
        elif todo == "loschen":
            loschen()
            print("Die gespeicherten Daten wurden alle gelöscht!\n")
        elif todo == "exit":
            print("Bis zum nächsten mal!")
            exit = True




if __name__ == '__main__':
    aktualisieren()
    menu()

