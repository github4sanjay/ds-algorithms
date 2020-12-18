package dynamic.category8;

/**
 * 1. You are given a number n, representing the number of upstrokes / and number of downstrokes .
 * 2. You are required to find the number of valleys and mountains you can create using strokes.
 *
 * Note -> At no point should we go below the sea-level. (number of downstrokes should never be more than number of upstrokes).
 */
public class CountOfValleysAndMountains {

    public static void main(String[] args) {
        System.out.println(CountOfValleysAndMountains.count(5));
    }

    /**
     *______________________________________________________________________________
     * At any moment number of downstrokes cannot be greater than number of strokes |
     *         _/\  ( this wrong as went below see level                            |
     *            \_                                                                |
     *______________________________________________________________________________|
     * when n equal to
     * 0 ----> 1
     * 1 ----> 1   /\
     *
     *           |''''''''''''''''''''''''''''''''''''''''''''''''''''|
     * 2 ---->   |          / \            ------>        /\          |
     *           |          /\                           /  \         |
     *           |        inside  outside         count(1) count(0)   |
     *           |                                                    |
     *           |         / \             ------>     /\/\           |
     *           |                /\              count(0) count(1)   |
     *           |      outside inside                                |
     *           |____________________________________________________|
     *
     *           ______________________________________________________
     * 3 ---->  |   / \ 1 pair        |    / \          |   / \        |
     *          |    2 pair inside    |    1    1       |        2     |
     *          |                     | inside outside  |      outside |
     *          |_____________________|_______________  |______________|
     *          |     /\              |  /\             |    /\        |
     *          |    /  \             | /  \/\          | /\/  \       |
     *          |   /    \            |                 |              |
     *          |                     |                 |              |
     *          |  /\/\               |                 |              |
     *          | /    \              |                 |   /\/\/\     |
     *          |_____________________|________________ |______________|
     *
     *  C(3) = C2.C0 + C1.C1 + C0.C2
     *
     * 4 ---->     / \      / \     / \     / \
     *              3  0     2  1    1  2    0  3
     *  C(4) = C3.C0 + C2.C1 + C1.C2 + C0.C3
     *
     *  So catalan number
     */
    public static int count(int n) {
        return CatalanNumber.find(n);
    }
}
