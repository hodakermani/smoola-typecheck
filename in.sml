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
        variable = new int[10];
        heh = variable[true];
        return "hi";
    }

    def method3(): int {
        var b: boolean;
        var a: int;
        a = 2;
        b = true;
        i = 20;
        variable = 20;
        if(a == 2) then
            b = true;
        else
            b = false;

        while(a <> 0) {
            a = b - 1;
        }

        writeln("Hello kiki!");
        return 0;
    }
    def salam(): string {
        return "salam";
    }

    def method4(): int {
        var arr : int[];
        var arr2: int[];
        var man: int;
        var test1: Test1;
        test1 = new Test1();
        arr = new int[666];
        arr2 = new int[700];
        writeln(this.method2());
        this.method5();
        return 0;
    }
}