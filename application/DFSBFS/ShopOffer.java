package OJSolution.application.DFSBFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 现给定每个物品的价格，每个大礼包包含物品的清单，以及待购物品清单。请输出确切完成待购清单的最低花费。
 * <p>
 * 每个大礼包的由一个数组中的一组数据描述，最后一个数字代表大礼包的价格，其他数字分别表示内含的其他种类物品的数量。
 * <p>
 * 任意大礼包可无限次购买。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shopping-offers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ShopOffer {
    public static void main(String[] args) {
        List<Integer> price = new ArrayList<>();
        price.add(2);
        price.add(3);
        price.add(4);
        List<List<Integer>> pks = new ArrayList<>();
        List<Integer> pk1 = new ArrayList<>();
        pk1.add(1);
        pk1.add(1);
        pk1.add(0);
        pk1.add(4);
        pks.add(pk1);
        List<Integer> pk2 = new ArrayList<>();
        pk2.add(2);
        pk2.add(2);
        pk2.add(1);
        pk2.add(9);
        pks.add(pk2);
        List<Integer> need = new ArrayList<>();
        need.add(1);
        need.add(2);
        need.add(1);
        ShopOffer shopOffer = new ShopOffer();
        int pcount = shopOffer.shoppingOffers(price, pks, need);
        System.out.println(pcount);
    }

    public static void test1() {
        List<Integer> price = new ArrayList<>();
        price.add(2);
        price.add(5);
        List<List<Integer>> pks = new ArrayList<>();
        List<Integer> pk1 = new ArrayList<>();
        pk1.add(3);
        pk1.add(0);
        pk1.add(5);
        pks.add(pk1);
        List<Integer> pk2 = new ArrayList<>();
        pk2.add(1);
        pk2.add(2);
        pk2.add(10);
        pks.add(pk2);
        List<Integer> need = new ArrayList<>();
        need.add(3);
        need.add(2);
        ShopOffer shopOffer = new ShopOffer();
        int pcount = shopOffer.shoppingOffers(price, pks, need);
        System.out.println(pcount);
    }

    /**
     * 最多6种物品， 100种大礼包。
     * 每种物品，你最多只需要购买6个。
     * 你不可以购买超出待购清单的物品，即使更便宜。
     *
     * @param price
     * @param special
     * @param needs
     * @return
     */
    private int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int noDiscont = 0;
        for (int i = 0; i < needs.size(); i++) {
            noDiscont += price.get(i) * needs.get(i);
        }
        List<List<Integer>> validSpecial = new ArrayList<>();
        validSpecial.addAll(special);
        for (List<Integer> offer : special) {
            for (int j = 0; j < needs.size(); j++) {
                if (offer.get(j) > needs.get(j)) {
                    validSpecial.remove(offer);
                }
            }
        }
        for (List<Integer> offer : special) {
            int disc = 0;
            int size = offer.size();
            for (int j = 0; j < size - 1; j++) {
                disc += offer.get(j) * price.get(j);
            }
            if (disc <= offer.get(size - 1)) {
                validSpecial.remove(offer);
            } else {
                offer.set(size - 1, disc - offer.get(size - 1));
            }
        }
        Stack<List<Integer>> buys = new Stack<>();
        int min = DFS(buys, noDiscont, validSpecial, needs);
        return min;
    }

    private int DFS(Stack<List<Integer>> buys, int cur, List<List<Integer>> validSpecial, List<Integer> needs) {
        int minP = cur;
        for (List<Integer> offer : validSpecial) {
            boolean noflag = false;
            for (int j = 0; j < needs.size(); j++) {
                if (offer.get(j) > needs.get(j)) {
                    noflag = true;
                    break;
                }
            }
            if (noflag) {
                continue;
            }
            List<Integer> left = new ArrayList<>();
            for (int j = 0; j < needs.size(); j++) {
                left.add(needs.get(j) - offer.get(j));
            }
            buys.push(offer);
            minP = Math.min(minP, DFS(buys, cur - offer.get(offer.size() - 1), validSpecial, left));
            buys.pop();
        }
        return minP;
    }
}
