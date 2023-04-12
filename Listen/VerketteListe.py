import random

class VerketteteList:
    def __init__(self):
        self.head = None
        self.tail = None
        self.length = 0

    def add_last(self, value):
        new_item = Item(value)
        if self.head is None:
            self.head = new_item
            self.tail = new_item
        else:
            self.tail.next = new_item
            self.tail = new_item
        self.length += 1

    def find_index(self, value):
        current = self.head
        index = 0
        while current:
            if current.value == value:
                return index
            index += 1
            current = current.next
        return None

    def __getitem__(self, index):
        if index >= self.length or index < 0:
            return None
        current = self.head
        for i in range(index):
            current = current.next
        return current.value


    def __len__(self):
        return self.length


    def __str__(self):
        current = self.head
        value_str = ""
        while current:
            value_str += str(current.value) + " "
            current = current.next
        return value_str



class Item:
    def __init__(self, value):
        self.value = value
        self.next = None



if __name__ == "__main__":
    mlist = VerketteteList()
    for _ in range(10):
        mlist.add_last(random.randint(1, 50))
    mlist.add_last(10)
    print("Liste:", mlist)
    search_value = int(input("Zahl um Index zu finden: "))
    print("Index ", search_value, "ist", mlist.find_index(search_value))
    search_index = int(input("Index um Zahl zu finden"))
    print("Index ", search_index, "ist", mlist[search_index])
    print("Liste:", len(mlist))