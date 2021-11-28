void main() {
  greet("Artur");
}

void greet2(String name) {
  print("How are you, $name?");
}

void bye() {
  print("Ok bye!");
}

void greet(String name) {
  print("Hello, $name");
  greet2(name);
  print("Getting ready to say bye...");
  bye();
}
