import 'dart:collection';

void main() {
  checkVoter("tom");
  checkVoter("mike");
  checkVoter("mike");
}

HashMap<String, bool> voted = HashMap<String, bool>();

void checkVoter(String name) {
  if (!voted.containsKey(name)) {
    voted[name] = true;
    print("let them vote!");
  } else {
    print("kick them out!");
  }
}
