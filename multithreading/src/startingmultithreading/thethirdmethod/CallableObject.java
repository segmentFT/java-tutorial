package startingmultithreading.thethirdmethod;

import java.util.concurrent.Callable;

/*
Callable 接口是一个泛型接口, 其中该泛型表示 Callable 接口中抽象方法 call 的返回值的类型
 */
class CallableObject implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int answer = 0;

        for (int i = 1; i <= 10; i++)
            answer += i;

        return answer;
    }
}
