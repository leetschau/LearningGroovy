package chapter7

class Chemistry {
  static void exec(Closure block) {
    block.delegate = new Chemistry()
    block()
  }

  def propertyMissing(String name) {
    def comp = new Compound(name)
    (comp.elements.size() == 1 && comp.elements.values()[0] == 1) ? comp.elements.keySet()[0] : comp.name
  }

  class Compound {
    String name
    Map elements = [mykey: 1, k2: 2]

    Compound(name) {
      this.name = "my name: $name"
    }
  }
}

def c = new Chemistry()
def water = c.H2O
println(water)
