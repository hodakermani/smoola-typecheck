class MainClass {
    def main(): int {
        return new Test2().method2();
    }
}

class Test1 {
    var i : int;
    def method1() : int {
        var j : int;
        j = 10;
        return j;
    }
}

class Test2 extends Test1 {
    var variable : int[];

    def method2(): int {
        i = 10;
        variable = new int[10];
        return i;
    }

    def method3(): int {
        var b: boolean;
        b = true;
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
        arr = new int[666];
        writeln(arr.length);
        return 0;
    }
}