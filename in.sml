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
        return i;
    }

    def method3(): int {
        var b: boolean;
        b = true;
        i = 20;
        variable = 20;
        if(a == 2) then
            b = true;
        else
            b = false;

        while(a <> 0) {
            a = a - 1;
        }

        writeln("Hello kiki!");
        return 0;
    }

    def method4(): int {
        var arr : int[];
        var man: int;
        var test1: Test1;
        test1 = new Test1();
        arr = new int[666];
        writeln(arr.length);
        this.method5();
        return 0;
    }
}