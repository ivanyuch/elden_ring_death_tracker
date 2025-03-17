import json

DATA_FILE = "deaths.json"

def load_data():
    try:
        with open(DATA_FILE, "r") as f:
            return json.load(f)
    except FileNotFoundError:
        return {}
    
def save_data(data):
    with open(DATA_FILE, "w") as f:
        json.dump(data, f)

def add_death(boss, data):
    data[boss] = data.get(boss, 0) + 1
    save_data(data)
    print("")
    print(f"Death recorded for {boss}. Total: {data[boss]}")

def show_stats(data):
    for boss, deaths in data.items():
        print("")
        print(f"{boss}: {deaths} deaths")

def main():
    data = load_data()
    print("")
    current_boss = input("Enter current boss name: ")

    while True:
        print("")
        command = input("Enter a command (add, switch, show, quit): ").strip().lower()

        if command == "add":
            add_death(current_boss, data)
        elif command == "switch":
            print("")
            current_boss = input("Enter new boss name: ")
        elif command == "show":
            show_stats(data)
        elif command == "quit":
            break
        else:
            print("Invalid command")

if __name__ == "__main__":
    main()