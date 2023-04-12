import json
import random
import serverM


# using flask_restful
from flask import Flask
from flask_restful import Api

app = Flask(__name__)
# creating an API object
api = Api(app)



auswahl = ["stein", "papier", "schere", "spock", "echse"]   #elemente die man auswählen kann (liste)

countValues = {"spieler": 0, "pc": 0, "unentschieden": 0, "stein": 0, "papier": 0, "schere": 0, "spock": 0, "echse": 0}     #dic.

dataFile = {}   #dic.

groese = [0, 0, 0, 0, 0]    #liste




#Methoden
def checkWinner(spieler, pc):  #In dieser Methode wird gecheckt wer gewonnen hat das Ergebnis kann auch Unentschieden ausgehn
    indexSpieler = auswahl.index(spieler)
    indexPC = auswahl.index(pc)
    if (indexSpieler + 2) > 4:
        indexSpieler = indexSpieler - 5
    if (auswahl[indexSpieler + 2] == auswahl[indexPC]) or (auswahl[indexSpieler - 1] == auswahl[indexPC]):
        gewinner = "Der Spieler hat gewonnen!"
        countValues["spieler"] += 1     #wenn spieler gewonnen hat wird hochgezählt
    elif (auswahl[indexSpieler - 2] == auswahl[indexPC]) or (auswahl[indexSpieler + 1] == auswahl[indexPC]):
        gewinner = "PC hat gewonnen LOOSER!"
        countValues["pc"] += 1          #wenn pc gewonnen hat wird hochgezählt
    else:
        gewinner = "UNENTSCHIEDEN!"
        countValues["unentschieden"] += 1       #wenn beide das gleiche haben dann wird unentschieden hochgezählt
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
    #hart Modus
    move = groese[len(groese) - 1]
    groese.remove(groese[len(groese) - 1])
    groese.insert(0, move)
    choice = random.choices(auswahl, k=1, weights=groese)
    return choice[0]




def aktualisieren():                    #Die Daten werden aktualisiert nach der Runde mit dem Befehlen
    f = open("ergebnisse.txt", "r")
    saved = f.read()
    if saved:
        save_json = json.loads(saved)
        combine(countValues, save_json)
    f.close()
    f = open("ergebnisse.txt", "w")
    json.dump(dataFile, f)
    f.close()




def loschen():                  #Die Daten die gespeicherten wurden werden alle auf 0 gesetzt
    dataFile = {"spieler": 0, "pc": 0, "unentschieden": 0, "stein": 0, "papier": 0, "schere": 0, "spock": 0, "echse": 0}
    countValues = dataFile
    groese = [0, 0, 0, 0, 0]
    f = open("ergebnisse.txt", "w")
    json.dump(dataFile, f) # kannst du die Daten direkt in einen Filestream schreiben, diesen musst du natürlich erst öffnen
    f.close()





def combine(a, b):
    for key in a:
        dataFile[key] = a[key] + b[key]
    return a






def spiel():                    #Das Spiel
    aktualisieren()

    gameStatus = 1
    while gameStatus == 1:
        print("Was wollen Sie auswählen? (Stein/Papier/Schere/Spock/Echse)")
        auswahlSpieler = str(input().lower())
        if auswahl.count(auswahlSpieler) == 0:
            print("Bitte wählen sie etwas was existiert!")
        else:
            countValues[auswahlSpieler] += 1
            auswahlPC = pickPC()
            print("\n Du hast gewählt: ", auswahlSpieler)
            print("PC hat gewählt: ",auswahlPC )
            win = checkWinner(auswahlSpieler, auswahlPC)
            print("\n Das Ergebnis lautet:  ", win)
            cont = 1
            while cont == 1:
                print("\nWillst du noch ein Spiel spielen? (ja/nein)")      #wird abgefragt ob noch ein Spiel
                ergebnis = input().lower()
                if ergebnis == "ja":            #falls ja dann gamestatus 1 noch ein spiel
                    gameStatus = 1
                    cont = 0
                elif ergebnis == "nein":        #falls nein dann gamestatus 0 kein spiel
                    cont = 0
                    gameStatus = 0
                else:
                    cont = 1
                    gameStatus = 0





def menu():  #Menu hier wird alles angezeigt was man wählen kann
    schluss = False
    print("Menu:")

    while schluss == False:
        wahlen = input("Auswählen: spiel, stats, speichern, loschen oder exit: ")
        if wahlen == "spiel":
           spiel()
        elif wahlen == "stats":
            print(dataFile)
            print()
        elif wahlen == "speichern":
            aktualisieren()
            print("Die Ergebnisse sind auf den aktuellsten Stand\n")
        elif wahlen == "loschen":
            loschen()
            print("Die gespeicherten Daten wurden alle auf 0 gesetzt!\n")
        elif wahlen == "exit":
            print("Bis zum nächsten mal du GAUNER!")
            schluss = True






if __name__ == '__main__':
    aktualisieren()
    menu()

