class MainClass {
    def main(): int {
        return 1;
    }
}

class Test1 {
    var i : int;
    def method1() : string {
        var j : string;
        j = "hello world!";
        return j;
    }
}

class Test2 extends Test1 {
    var variable : int;

    def method2(hoda: int, s: MainClass): int {
        var heh: int;
        i = 10;
        variable = 3;
        return "hi";
    }

    def salam(): string {
        return "salam";
    }
}