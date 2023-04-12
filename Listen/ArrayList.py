import random
import copy

class ArrayList:
    def __init__(self):
        self.platz = 10
        self.len = 0
        self.data = [None] * self.platz

    def add(self, element):
        self.mache_platz()
        print(self.len)
        print(str(self.data))
        self.data[self.len] = element
        self.len += 1

    def remove(self, index):
        self.data.remove(index)
        self.len -= 1

    def __getitem__(self, index):
        return self.data[index]

    def length(self):
        return self.len



    def mache_platz(self):
        if self.len == self.platz:
            neuer_platz = self.platz * 2
            neue_data = copy.deepcopy(self.data)
            for i in range(self.platz):
                neue_data.append(None)
            self.data = neue_data
            self.platz = neuer_platz

    def __str__(self):
        return str(self.data)

if __name__ == "__main__":
    arraylist = ArrayList()
    for i in range(10):
        arraylist.add(random.randint(1, 100))
    print("Liste:", arraylist)
    print("Arraylist:", arraylist.length())
    print("Zahl Index ", 4, "ist", arraylist[4])
    entf_index = int(input("Zahl aus der Liste loschen? "))
    arraylist.add(2)
    print("Liste:", arraylist)
